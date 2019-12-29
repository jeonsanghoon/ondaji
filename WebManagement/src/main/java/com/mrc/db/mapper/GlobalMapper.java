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
	@Autowired
	public static  MemberMapper MemberMapper;
}
