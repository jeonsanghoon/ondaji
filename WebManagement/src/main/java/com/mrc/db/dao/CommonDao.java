/**
 * 
 */
package com.mrc.db.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mrc.db.dto.common.ResultData;
import com.mrc.db.dto.common.SelectItem;
import com.mrc.db.dto.common.common_cond;
import com.mrc.db.dto.common.t_common;
import com.mrc.db.mapper.CommonMapper;

/**
 * 공통 Dao
 * @author jsh
 *
 */
@Repository
public class CommonDao implements ICommonDao<common_cond, t_common,SelectItem> {
	@Autowired
	private CommonMapper mapper;
	@Override
	public List<t_common> GetList(common_cond Cond) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public t_common GetData(common_cond Cond) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultData SaveList(List<t_common> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultData Save(t_common data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SelectItem> getSelectItemList(common_cond Cond) {
		// TODO Auto-generated method stub
		List<SelectItem> rtn = mapper.getSelectItemList(Cond);
		return rtn;
	}

}
