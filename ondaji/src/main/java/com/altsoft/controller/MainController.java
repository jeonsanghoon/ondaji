/**
 * 
 */
package com.altsoft.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jsh
 *
 */
@Controller
public class MainController {
    static final Logger logger = LoggerFactory.getLogger(MainController.class);
	@RequestMapping("/")
	public String index() {
		logger.debug("test");
		return "index";
	}
	
	@RequestMapping("joinpage")
	public String JoinPage() {
		
		return "join";
	}
	
	@RequestMapping("loginpage")
	public String LoginPage() {
		
		return "login";
	}
}
