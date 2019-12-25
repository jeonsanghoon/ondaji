/**
 * 
 */
package com.mrc.db.service;

import java.util.List;

import com.mrc.db.dto.T_MEMBER;
import com.mrc.db.dto.T_MEMBER_COND;

/**
 * @author jsh
 *
 */
public interface IMemberService {
	String memberSave(List<T_MEMBER> list);
	List<T_MEMBER> memberList(T_MEMBER_COND Cond);
	
}
