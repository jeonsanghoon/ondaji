/**
 * 
 */
package com.mrc.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrc.db.dao.ApiDao;

/**
 * @author jsh
 *
 */
@RestController
public class ApiController {
	@Autowired
    private ApiDao apiDao;
	@GetMapping(path = "/")
	public String index() {
		return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	}
	
	@GetMapping(path = "/helloWorld")
	public String helloWorld() {
		//return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		return String.format("%s %s", apiDao.selectName(), LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
	}
}
