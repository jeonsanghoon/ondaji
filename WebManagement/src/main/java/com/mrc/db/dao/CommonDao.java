/**
 * 
 */
package com.mrc.db.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mrc.db.dto.common.ResultData;
import com.mrc.db.dto.common.SelectItem;
import com.mrc.db.dto.common.common_cond;
import com.mrc.db.dto.common.enResultType;
import com.mrc.db.dto.common.t_common;
import com.mrc.db.mapper.GlobalMapper;

/**
 * 공통 Dao
 * @author jsh
 *
 */
@Repository
public class CommonDao implements ICommonDao<common_cond, t_common,SelectItem> {

	@Override
	public List<t_common> GetList(common_cond Cond) {
	
		List<t_common> list = GlobalMapper.CommonMapper.getList(Cond);
		// return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		return list;
	}

	@Override
	public t_common GetData(common_cond Cond) {
		// TODO Auto-generated method stub
		List<t_common> list = GlobalMapper.CommonMapper.getList(Cond);
		return null;
	}

	@Override
	public ResultData SaveList(List<t_common> list) {
		// TODO Auto-generated method stub
		ResultData rtn = new ResultData();
		try {
			for (int i = 0; i < list.size(); i++) {
				GlobalMapper.CommonMapper.Save(list.get(i));
			}
		} catch (Exception ex) {
			rtn = rtn.builder()
					.enResultType(enResultType.Error)
					.Message(ex.getMessage()).build();
		}
		return rtn;
	}

	@Override
	public ResultData Save(t_common data) {
		ResultData rtn = ResultData.builder().enResultType(enResultType.Info).build();
		try {
			GlobalMapper.CommonMapper.Save(data);	
			 
		}catch(Exception ex) {
			rtn.builder().enResultType(enResultType.Error).Message(ex.getMessage());
		}
	
		// TODO Auto-generated method stub
		return rtn;
		
	}

	@Override
	public List<SelectItem> getSelectItemList(common_cond Cond) {
		// TODO Auto-generated method stub
		List<SelectItem> rtn = GlobalMapper.CommonMapper.getSelectItemList(Cond);
		return rtn;
	}

}
