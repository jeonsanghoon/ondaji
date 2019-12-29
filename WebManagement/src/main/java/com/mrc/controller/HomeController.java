/**
 * 
 */
package com.mrc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jsh
 *
 */
@Controller
public class HomeController {
	  @RequestMapping(value={"", "/index", "/error", "/*"}, method = RequestMethod.GET)
	    public String index() {
	        return "index";
	    }
}
