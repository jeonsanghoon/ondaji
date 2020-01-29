/**
 * 
 */
package com.mrc.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mrc.db.dto.member_cond;
import com.mrc.db.dto.t_member;

/**
 * @author jsh
 *
 */
@Mapper
public interface MemberMapper {
	void Save(t_member data);
	List<t_member> getList(member_cond Cond);
	void remove(t_member data);
	void update(t_member data);
}
