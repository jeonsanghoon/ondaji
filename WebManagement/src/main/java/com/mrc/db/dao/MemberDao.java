/**
 * 
 */
package com.mrc.db.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mrc.db.dto.member_cond;
import com.mrc.db.dto.t_member;
import com.mrc.db.mapper.MemberMapper;
import com.mrc.framework.Global;

/**
 * @author jsh
 *
 */
@Repository
public class MemberDao {
	@Autowired
	private MemberMapper mapper;

	public List<t_member> memberlist(member_cond member) {
		if(!StringUtils.isBlank(member.getMember_pw()))
			member.setMember_pw(Global.SecurityInfo.encryptSHA256(member.getMember_pw()));
		List<t_member> list = mapper.getMemberList(member);
		// return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		return list;
	}

	public String memberSave(List<t_member> list) {
		String rtn = "";
		try {
			for (int i = 0; i < list.size(); i++) {
				mapper.memberSave(list.get(i));
			}
		} catch (Exception ex) {
			rtn = ex.getMessage();
		}
	
		return rtn;
	}

}
