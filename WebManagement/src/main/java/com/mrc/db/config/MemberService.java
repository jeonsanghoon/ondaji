package com.mrc.db.configuration;

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

import com.mrc.db.dao.IMemberDao;
import com.mrc.db.dao.MemberDao;
import com.mrc.db.dto.common.ResultData;
import com.mrc.db.dto.member.member_cond;
import com.mrc.db.dto.member.t_member;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberService implements UserDetailsService {
	private IMemberDao<member_cond, t_member> memberRepository;

	@Transactional
	public ResultData joinUser(t_member member) {
		
		ResultData rtn = memberRepository.Save(member);
		return rtn;
	}

	@Override
	public UserDetails loadUserByUsername(String member_id) throws UsernameNotFoundException {

		t_member userEntity = memberRepository.GetData(member_cond.builder().member_id(member_id).build());

		List<GrantedAuthority> authorities = new ArrayList<>();

		if (("admin@altsoft.kr").equals(member_id)) {
			authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
		} else {
			authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
		}

		return new User(userEntity.getMember_id(), userEntity.getMember_pw(), authorities);
	}
}
