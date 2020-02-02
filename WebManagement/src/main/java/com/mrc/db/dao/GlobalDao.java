/**
 * 
 */
package com.mrc.db.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mrc.db.dao.impl.ICommonDao;
import com.mrc.db.dao.impl.IMemberDao;
import com.mrc.db.dto.common.SelectItem;
import com.mrc.db.dto.common.common_cond;
import com.mrc.db.dto.common.t_common;
import com.mrc.db.dto.member.member_cond;
import com.mrc.db.dto.member.t_member;

/**
 * @author jsh
 *
 */
@Component
public class GlobalDao {
	
	public static IMemberDao<member_cond, t_member> MemberDao;
	public static ICommonDao<common_cond, t_common, SelectItem> CommonDao;
	public static ApiDao ApiDao;
	
	@Autowired
	private GlobalDao(IMemberDao<member_cond, t_member> member, ICommonDao<common_cond, t_common, SelectItem> common,  ApiDao api) {
		MemberDao = member;
		CommonDao = common;
		ApiDao = api;
	}
	
}
