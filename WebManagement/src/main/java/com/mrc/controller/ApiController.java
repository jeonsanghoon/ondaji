/**
 * 
 */
package com.mrc.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrc.db.dao.GlobalDao;
import com.mrc.db.dto.member_cond;
import com.mrc.db.dto.t_member;
import com.mrc.db.dto.common.ResultData;
import com.mrc.framework.Global;

/**
 * @author jsh
 *
 */

@RestController

public class ApiController {



	@GetMapping(path = "/localtime")
	public String localtime() {
		return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	}

	@GetMapping(path = "/api/helloWorld")
	public String helloWorld() {
		// return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		return String.format("%s %s", GlobalDao.ApiDao.selectName(),
				LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
	}

	@GetMapping(path = "/member/memberlist")
	
	public List<t_member> memberlist() {
		List<t_member> list = GlobalDao.MemberDao.GetList(member_cond.builder()
				//.member_code(1)
				//.member_id("mrc0700@gmail.com")
				//.member_pw("1111")
				.build());
	
		
		// return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		return list;
	}

	@GetMapping(path = "/member/saveMember")
	public ResultData saveMember() {
		/*임의 param start*/
		List<t_member> list = new ArrayList();
		
			for (int i = 1; i <= 10; i++) {
				list.add(t_member.builder()
				.member_code(0)
				.member_id("a" + Global.DataInfo.LPad(Integer.toString(i), 2, "0") + "@gmail.com")
				.member_name("회원" + Global.DataInfo.LPad("a", 2, "0"))
				.member_pw(Global.SecurityInfo.encryptSHA256("1111"))
				.update_code(0).build());
			}
		/*임의 param end*/
		ResultData rtn = GlobalDao.MemberDao.SaveList(list);
		return rtn;
	}
	
	// 로그인
     
	@RequestMapping(value="/member/login", method = RequestMethod.POST) 
    public String dologin(@RequestBody member_cond cond) {
    	//
    	List<t_member> list = GlobalDao.MemberDao.GetList(cond);
    	if(list.size()==1)
    	{	
    	   // session.setAttribute("userInfo", list.get(0));	
    		return "redirect:/";
    	}
    	else {
    		return "redirect:/member/login";
    	}
    }
    
	
    @PostMapping(path="/getPost")
    public String getPost( String val)
    {
    	return val;
    }
    
    
    @ResponseBody
    @PostMapping("/test2")
    public String test2(@RequestBody HashMap<String, Object> map) {
    
    	return map.toString();
    	// {name=kim, age=30} 출력
    }
    
    @ResponseBody
    @RequestMapping("/test1")
    public String test1(@RequestBody HashMap<String, Object> map) {
    
    	return map.toString();
    	// {name=kim, age=30} 출력
    }
    
    @ResponseBody
    @RequestMapping(value ="/memdata", method = RequestMethod.POST)
    public String memdata(@RequestBody t_member member ) {
    
    	return member.toString();
    	// {name=kim, age=30} 출력
    }
    
    @ResponseBody
    @PostMapping(value="/memdata2")
    public t_member memdata2(@RequestBody t_member member) {
    
    	return member;
    	// {name=kim, age=30} 출력
    }
    
    
    
}
