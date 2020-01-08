/**
 * 
 */
package com.mrc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrc.db.dao.MemberDao;
import com.mrc.db.dto.member_cond;
import com.mrc.db.dto.t_member;

/**
 * @author jsh
 *
 */
@Controller
public class MemberController {
	
	// 로그인
	@Autowired
	private MemberDao memberDao;
	
	  @ResponseBody
	    @RequestMapping("/member/logindo")

    public String logindo(@RequestBody member_cond cond) {
    	//
    	List<t_member> list = memberDao.memberlist(cond);
    	if(list.size()==1)
    	{	
    	   // session.setAttribute("userInfo", list.get(0));	
    		return "redirect:/";
    	}
    	else {
    		return "redirect:/login";
    	}
    }
	    
	//@Autowired
	//private MemberDao memberDao;
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null) {
			model.addAttribute("errorMsg", "Your username and password are invalid.");
		}
		if (logout != null) {
			model.addAttribute("msg", "You have been logged out successfully");
		}
		
		model.addAttribute("name", "전상훈");

		return "./pages/home/login";
	}
	
	
    // 로그아웃
    @RequestMapping("/logout")
    public String logout( HttpSession session) {
        session.removeAttribute("userInfo");
    	return "redirect:/login";
    }
}
