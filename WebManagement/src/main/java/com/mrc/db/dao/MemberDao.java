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
import com.mrc.db.dto.common.ResultData;
import com.mrc.db.dto.common.enResultType;
import com.mrc.db.mapper.MemberMapper;
import com.mrc.framework.Global;

/**
 * @author jsh
 *
 */
@Repository
public class MemberDao implements IMemberDao<member_cond, t_member> {
	@Autowired
	private MemberMapper mapper;
/*
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
	}*/

	@Override
	public List<t_member> GetList(member_cond Cond) {
		if(!StringUtils.isBlank(Cond.getMember_pw()))
			Cond.setMember_pw(Global.SecurityInfo.encryptSHA256(Cond.getMember_pw()));
		List<t_member> list = mapper.getMemberList(Cond);
		// return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		return list;
	}

	@Override
	public t_member GetData(member_cond Cond) {
		if(!StringUtils.isBlank(Cond.getMember_pw()))
			Cond.setMember_pw(Global.SecurityInfo.encryptSHA256(Cond.getMember_pw()));
		List<t_member> list = mapper.getMemberList(Cond);
		// return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		if(list.size() == 1) return list.get(0);
		else return null;
	}

	@Override
	public ResultData SaveList(List<t_member> list) {
		ResultData rtn = new ResultData();
		try {
			for (int i = 0; i < list.size(); i++) {
				mapper.memberSave(list.get(i));
			}
		} catch (Exception ex) {
			rtn = rtn.builder()
					.enResultType(enResultType.Error)
					.Message(ex.getMessage()).build();
		}
		return rtn;
	}

	@Override
	public ResultData Save(t_member list) {
		// TODO Auto-generated method stub
		return null;
	}

}
