/**
 * 
 */
package com.mrc.db.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.mrc.db.dao.IMemberDao;
import com.mrc.db.dao.MemberDao;
import com.mrc.db.dto.member_cond;
import com.mrc.db.dto.t_member;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jsh
 *
 */
@Component
@Slf4j
public class AuthProvider implements AuthenticationProvider {

	// 로그인
	@Autowired
	private IMemberDao<member_cond,t_member> memberDao;
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userId = authentication.getName();
		String userPw = authentication.getCredentials().toString();
		return authenticate(userId, userPw);
	}

	private Authentication authenticate(String id, String pw) throws AuthenticationException {

		List<t_member> list = memberDao.GetList(member_cond.builder().member_id(id).member_pw(pw).build());
		t_member m = t_member.builder().build();
		if (list.size() != 1) {

			log.error("{} is not exist or password is not equals", id);
			return null;
		} else
			m = list.get(0);

	
		List<GrantedAuthority> authList = new ArrayList<>();
		/**
		 * Role 처리 필요, 일단 임의로 USER Role을 부여한다.
		 **/
		
	
		
		authList.add(new SimpleGrantedAuthority("ROLE_USER"));
		return new MyAuthentication(id, pw, authList, m);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}
}