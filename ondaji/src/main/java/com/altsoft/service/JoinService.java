/**
 * 
 */
package com.altsoft.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altsoft.model.Users;
import com.altsoft.repository.UsersRespository;


/**
 * @author jsh
 *
 */
@Service
public class JoinService {
	@Autowired
	private UsersRespository usersRespository;
	public void joinUser(HttpServletRequest request)
	{
		Users users = new Users();
		
		/*users = request.getParameter("user_id");
		users.user_pw = Global.SecurityInfo.encryptSHA256(request.getParameter("user_pw"));
		users.user_name =  request.getParameter("user_name");
		*/
		usersRespository.save(users);
	}
}
