/**
 * 
 */
package com.altsoft.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.altsoft.repository.UsersRespository;
import com.altsoft.service.JoinService;


@Controller
public class UsersController {
	@Autowired
	private UsersRespository usersRespository;
	@Autowired
	JoinService joinService;
	@PostMapping("/joinRequest" )
	public String JoinRequest(HttpServletRequest request) {
		
		 
		joinService.joinUser(request,usersRespository);
		 return "index";
	}
	
	@PostMapping("/loginRequest")
	public String logingRequest() {
		return "index";
	}
}
