package com.mrc.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mrc.db.dto.common.SelectItem;
import com.mrc.db.dto.common.common_cond;
import com.mrc.db.dto.common.t_common;

@Mapper
public interface CommonMapper {
	List<t_common> getList(common_cond Cond);
	List<SelectItem> getSelectItemList(common_cond Cond);
	void Save(t_common data);
	void remove(t_common data);
	void update(t_common data);
}
