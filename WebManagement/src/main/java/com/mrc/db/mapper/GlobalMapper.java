/**
 * 
 */
package com.mrc.db.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jsh
 * 글로벌 맵퍼
 */
@Component
public class GlobalMapper {
	
	public static IMemberMapper MemberMapper;
	public static ICommonMapper CommonMapper;
	
	@Autowired
	private GlobalMapper(IMemberMapper member, ICommonMapper common) {
		MemberMapper = member;
		CommonMapper = common;
	}
	
}
