/**
 * 
 */
package com.mrc.db.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mrc.db.dto.common.ResultData;
import com.mrc.db.dto.common.enResultType;
import com.mrc.db.dto.member.member_cond;
import com.mrc.db.dto.member.t_member;
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

	
	

	@Override
	public List<t_member> GetList(member_cond Cond) {
		if(!StringUtils.isBlank(Cond.getMember_pw()))
			Cond.setMember_pw(Global.SecurityInfo.encryptSHA256(Cond.getMember_pw()));
		List<t_member> list = mapper.getMemberList(Cond);
		// return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		return list;
	}

	@Override
	public ResultData SaveList(List<t_member> list) {
		// TODO Auto-generated method stub
		ResultData rtn =  new ResultData();
		try {
			for (int i = 0; i < list.size(); i++) {
				mapper.memberSave(list.get(i));
			}
		} catch (Exception ex) {
			rtn = ResultData.builder().enResultType(enResultType.Error).Message(ex.getMessage()).build();
		}
	
		return rtn;
	}

	@Override
	public t_member GetData(member_cond Cond) {
		return mapper.getMember(Cond);
	}

	@Override
	public ResultData Save(t_member data) {
		ResultData rtn =  new ResultData();
		try {
			mapper.memberSave(data);
		} catch (Exception ex) {
			rtn = ResultData.builder().enResultType(enResultType.Error).Message(ex.getMessage()).build();
		}
		return rtn;
	}



	
}
