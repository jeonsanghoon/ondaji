/**
 * 
 */
package com.altsoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altsoft.framework.Global;
import com.altsoft.repository.UsersRespository;

/**
 * @author jsh
 *
 */
@Service
public class LoginService {
	@Autowired
	public  UsersRespository UsersRespository;
	public String login(String userid, String userpw)
	{
		if(userid.equals("") || userpw.equals(""))
		{
			return "login";
		}
		
		userpw = Global.SecurityInfo.encryptSHA256(userpw);
		/*Users users = UsersRespository.findByUser_idAndUser_pw(userid, userpw);
		
		if(users == null)
		{
			return "login";
		}*/
		
		return "index";
	}
}
