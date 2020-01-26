/**
 * 
 */
package com.mrc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrc.db.dao.IMemberDao;
import com.mrc.db.dao.MemberDao;
import com.mrc.db.dto.loginInfo;
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
	private IMemberDao<member_cond, t_member> memberDao;
	@Autowired
	AuthenticationManager authenticationManager;

	@ResponseBody
	@PostMapping("/member/logindo")
	public loginInfo logindo(@RequestBody member_cond cond, HttpSession session) {
		try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(cond.getMember_id(),
					cond.getMember_pw());
			Authentication authentication = authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);

			session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
					SecurityContextHolder.getContext());
			t_member rtn = memberDao.GetData(cond);

			loginInfo logininfo = new loginInfo();

			if (rtn == null) return null;
			
			session.setAttribute("userInfo", rtn);
			logininfo.setMember(rtn);
			return logininfo;

		} catch (Exception ex) {
			return null;
		}
	}

	@ResponseBody
	@PostMapping("/member/getmyinfo")
	public t_member getMyInfo(HttpSession session) {
		if (session.getAttribute("userInfo") == null) {
			return null;
		}
		return (t_member) session.getAttribute("userInfo");
	}
	
	@ResponseBody
	@PostMapping("/comp/getCompName")
	public String getCompName() {
		
		return "알트소프트";
	}


	// @Autowired
	// private MemberDao memberDao;
	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.GET) public String
	 * login(Model model, String error, String logout) { if (error != null) {
	 * model.addAttribute("errorMsg", "Your username and password are invalid."); }
	 * if (logout != null) { model.addAttribute("msg",
	 * "You have been logged out successfully"); }
	 * 
	 * model.addAttribute("name", "전상훈");
	 * 
	 * return "./pages/home/login"; }
	 */
	// 로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
		session.setAttribute("userInfo","");
		// session.removeAttribute("userInfo");
		return "";
	}
}
