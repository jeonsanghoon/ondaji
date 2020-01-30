/**
 * 
 */
package com.mrc.db.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mrc.db.dto.common.ResultData;
import com.mrc.db.dto.common.SelectItem;
import com.mrc.db.dto.common.common_cond;
import com.mrc.db.dto.common.enResultType;
import com.mrc.db.dto.common.t_common;
import com.mrc.db.mapper.GlobalMapper;

/**
 * 공통 Dao
 * 
 * @author jsh
 *
 */
@Repository
public class CommonDao implements ICommonDao<common_cond, t_common, SelectItem> {

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public List<t_common> GetList(common_cond Cond) {

		List<t_common> list = GlobalMapper.CommonMapper.getList(Cond);
		// return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		return list;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public t_common GetData(common_cond Cond) {
		// TODO Auto-generated method stub
		List<t_common> list = GlobalMapper.CommonMapper.getList(Cond);
		if (list.size() == 1)
			return list.get(0);
		else
			return null;
	}

	@Transactional
	@Override
	public ResultData SaveList(List<t_common> list) {
		// TODO Auto-generated method stub
		ResultData rtn = ResultData.builder().enResultType(enResultType.Info).build();
		try {
			for (int i = 0; i < list.size(); i++) {
				GlobalMapper.CommonMapper.Save(list.get(i));
			}
		} catch (Exception ex) {
			rtn = ResultData.builder().enResultType(enResultType.Error).Message(ex.getMessage()).build();
		}
		return rtn;
	}

	@Transactional
	@Override
	public ResultData Save(t_common data) {
		ResultData rtn = ResultData.builder().enResultType(enResultType.Info).build();
		try {
			GlobalMapper.CommonMapper.Save(data);
		} catch (Exception ex) {
			rtn = ResultData.builder().enResultType(enResultType.Error).Message(ex.getMessage()).build();
		}
		return rtn;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public List<SelectItem> getSelectItemList(common_cond Cond) {
		// TODO Auto-generated method stub
		List<SelectItem> rtn = GlobalMapper.CommonMapper.getSelectItemList(Cond);
		return rtn;
	}

}
