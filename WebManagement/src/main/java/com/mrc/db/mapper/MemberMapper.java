/**
 * 
 */
package com.mrc.db.mapper;

import java.util.List;

import com.mrc.db.dto.T_MEMBER;
import com.mrc.db.dto.T_MEMBER_COND;

/**
 * @author jsh
 *
 */
public interface MemberMapper {
	String memberSave(List<T_MEMBER> list);
	List<T_MEMBER> getMemberList(T_MEMBER_COND Cond);
	
}
