/**
 * 
 */
package com.mrc.db.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mrc.db.dto.member_cond;
import com.mrc.db.dto.t_member;

/**
 * @author jsh
 *
 */
@Service
public interface MemberMapper {
	void memberSave(t_member list);
	List<t_member> getMemberList(member_cond Cond);
}
