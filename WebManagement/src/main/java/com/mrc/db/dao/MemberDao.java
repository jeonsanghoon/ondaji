/**
 * 
 */
package com.mrc.db.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mrc.db.dao.impl.IMemberDao;
import com.mrc.db.dto.common.ResultData;
import com.mrc.db.dto.common.enResultType;
import com.mrc.db.dto.member.member_cond;
import com.mrc.db.dto.member.t_member;
import com.mrc.db.mapper.GlobalMapper;
import com.mrc.framework.Global;

/**
 * @author jsh
 *
 */
@Repository
public class MemberDao implements IMemberDao<member_cond, t_member> {

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public List<t_member> GetList(member_cond Cond) {
		if (!StringUtils.isBlank(Cond.getMember_pw()))
			Cond.setMember_pw(Global.SecurityInfo.encryptSHA256(Cond.getMember_pw()));
		List<t_member> list = GlobalMapper.MemberMapper.getList(Cond);
		// return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		return list;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public t_member GetData(member_cond Cond) {
		if (!StringUtils.isBlank(Cond.getMember_pw()))
			Cond.setMember_pw(Global.SecurityInfo.encryptSHA256(Cond.getMember_pw()));
		List<t_member> list = GlobalMapper.MemberMapper.getList(Cond);
		// return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		if (list.size() == 1)
			return list.get(0);
		else
			return null;
	}

	@Transactional
	@Override
	public ResultData SaveList(List<t_member> list) {

		ResultData rtn = ResultData.builder().enResultType(enResultType.Info).build();
		try {
			for (int i = 0; i < list.size(); i++) {
				GlobalMapper.MemberMapper.Save(list.get(i));
			}
		} catch (Exception ex) {
			rtn = ResultData.builder().enResultType(enResultType.Error).Message(ex.getMessage()).build();
		}
		return rtn;
	}

	@Transactional
	@Override
	public ResultData Save(t_member data) {
		ResultData rtn = ResultData.builder().enResultType(enResultType.Info).build();
		try {
			// TODO Auto-generated method stub
			GlobalMapper.MemberMapper.Save(data);
		} catch (Exception ex) {
			rtn = ResultData.builder().enResultType(enResultType.Error).Message(ex.getMessage()).build();

		}
		return rtn;
	}

}
