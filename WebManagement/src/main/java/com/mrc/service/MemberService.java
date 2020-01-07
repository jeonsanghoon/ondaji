package com.mrc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrc.Role;
import com.mrc.db.dao.MemberDao;
import com.mrc.db.dto.member_cond;
import com.mrc.db.dto.t_member;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberService implements UserDetailsService {
	private MemberDao memberRepository;
	
	@Transactional
    public String joinUser(t_member member) {
		List<t_member> list = new ArrayList<t_member>();
		list.add(member);
		String rtn = memberRepository.memberSave(list);
      
        		
        return rtn;
    }


    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {

    	t_member userEntity = memberRepository.memberlist(member_cond.builder().member_id(userEmail).build()).get(0) ;
         

        List<GrantedAuthority> authorities = new ArrayList<>();

        if (("admin@altsoft.kr").equals(userEmail)) {
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        }

        return new User(userEntity.getMember_id(), userEntity.getMember_pw(), authorities);
    }
}
