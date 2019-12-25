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
import com.mrc.db.dto.T_MEMBER;
import com.mrc.db.dto.T_MEMBER_COND;
import com.mrc.db.mapper.MemberMapper;

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

	@GetMapping(path = "/")
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
	public List<T_MEMBER> memberlist() {

		T_MEMBER_COND cond = new T_MEMBER_COND();
		//cond.setMEMBER_NAME("전상훈");
		List<T_MEMBER> list =mapper.getMemberList(cond);
		// return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		return list;
	}
}
