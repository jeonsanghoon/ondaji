/**
 * 
 */
package com.mrc.db.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jsh
 *
 */
@Component
public class GlobalMapper {
	
	public static MemberMapper MemberMapper;
	
	public static CommonMapper CommonMapper;
	
	@Autowired
	private GlobalMapper(MemberMapper member, CommonMapper common) {
		MemberMapper = member;
		CommonMapper = common;
	}
	
}
