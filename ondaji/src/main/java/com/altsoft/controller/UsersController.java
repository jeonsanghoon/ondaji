/**
 * 
 */
package com.altsoft.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.altsoft.service.JoinService;
import com.altsoft.service.LoginService;


@Controller
public class UsersController {

	@Autowired
	JoinService joinService;
	@Autowired
	LoginService loginService;
	@PostMapping("/joinRequest" )
	public String JoinRequest(HttpServletRequest request) {
		joinService.joinUser(request);
		 return "index";
	}
	
	@PostMapping("/loginRequest")
	public String logingRequest(HttpServletRequest request) {
	
		String rtn = "index"; //loginService.login(request.getParameter("user_id"), request.getParameter("user_pw"));
	   
	   return  rtn;
	}
}
