/**
 * 
 */
package com.mrc.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrc.db.dao.ApiDao;
import com.mrc.db.dao.MemberDao;
import com.mrc.db.dto.member_cond;
import com.mrc.db.dto.t_member;
import com.mrc.framework.Global;

/**
 * @author jsh
 *
 */
@RestController
public class ApiController {
	@Autowired
	private ApiDao apiDao;

	@Autowired
	private MemberDao memberDao;

	@GetMapping(path = "/localtime")
	public String index() {
		return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	}

	@GetMapping(path = "/helloWorld")
	public String helloWorld() {
		// return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		return String.format("%s %s", apiDao.selectName(),
				LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
	}

	@GetMapping(path = "/memberlist")
	public List<t_member> memberlist() {

		

		List<t_member> list = memberDao.memberlist(member_cond.builder()
				//.member_code(1)
				//.member_id("mrc0700@gmail.com")
				.member_pw("1111")
				.build());
		
		
		// return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		return list;
	}

	@GetMapping(path = "/saveMember")
	public String saveMember() {
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
		String rtn = memberDao.memberSave(list);
		return rtn;
	}
}
