/**
 * 
 */
package com.altsoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jsh
 *
 */
@Controller
public class MainController {

	@RequestMapping(value="/")
	public String index() {
		
		return "index";
	}
	
	@RequestMapping(value="joinpage")
	public String JoinPage() {
		
		return "join";
	}
}
