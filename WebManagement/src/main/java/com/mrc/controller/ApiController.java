/**
 * 
 */
package com.mrc.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrc.db.dao.ApiDao;
import com.mrc.db.dto.T_MEMBER_EMPLOYEE;
import com.mrc.db.dto.member_cond;
import com.mrc.db.dto.t_member;
import com.mrc.db.mapper.MemberMapper;
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
	private MemberMapper mapper;

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

		T_MEMBER_EMPLOYEE abc = new T_MEMBER_EMPLOYEE();

		List<t_member> list = mapper.getMemberList(member_cond.builder()
				/*.member_code(1)
				.member_id("mrc0700@gmail.com")
				.member_pw(Global.SecurityInfo.encryptSHA256("1111"))*/
				.build());
		// return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		return list;
	}

	@GetMapping(path = "/saveMember")
	public String saveMember() {
		String rtn = "";
		try {
			for (int i = 1; i <= 10; i++) {
				t_member member = t_member.builder()
				.member_code(0)
				.member_id("a" + Global.DataInfo.LPad(Integer.toString(i), 2, "0") + "@gmail.com")
				.member_name("회원" + Global.DataInfo.LPad(Integer.toString(i) , 2, "0"))
				.member_pw(Global.SecurityInfo.encryptSHA256("1111"))
				.update_code(0).build();
				
				mapper.memberSave(member);
				
			}
		} catch (Exception ex) {
			rtn = ex.getMessage();
		}

		if (rtn.equals(""))
			rtn = "저장에 성공하였습니다.";
		return rtn;
	}
}
