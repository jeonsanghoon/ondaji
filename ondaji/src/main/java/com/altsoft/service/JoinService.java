/**
 * 
 */
package com.altsoft.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.altsoft.model.Users;
import com.altsoft.repository.UsersRespository;


/**
 * @author jsh
 *
 */
@Service
public class JoinService {
	
	public void joinUser(HttpServletRequest request, UsersRespository usersRespository)
	{
		Users users = new Users();
		
		users.user_id = request.getParameter("user_id");
		users.user_pw = request.getParameter("user_pw");
		users.user_name = request.getParameter("user_name");
		usersRespository.save(users);
		
	}
}
