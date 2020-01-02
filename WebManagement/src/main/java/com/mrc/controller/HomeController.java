/**
 * 
 */
package com.mrc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jsh
 *
 */
@Controller
public class HomeController {
	  //@RequestMapping(value={"", "/index", "/error", "/*"}, method = RequestMethod.GET)
	@RequestMapping(value={"", "/index", "/error", "/*"}, method = RequestMethod.GET)
	public String index() {
	        return "index";
	}
	@RequestMapping(value = "/hellowrold", method = RequestMethod.GET)
	public void hellowrold(Model model, String error, String logout) {
		if (error != null) {
			model.addAttribute("errorMsg", "Your username and password are invalid.");
		}
		if (logout != null) {
			model.addAttribute("msg", "You have been logged out successfully");
		}
		
	}
}
