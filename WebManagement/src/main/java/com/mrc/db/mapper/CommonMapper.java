package com.mrc.db.mapper;

import java.util.List;

import com.mrc.db.dto.common.SelectItem;
import com.mrc.db.dto.common.common_cond;
import com.mrc.db.dto.common.t_common;

public interface CommonMapper {
	List<t_common> getList(common_cond Cond);
	List<SelectItem> getSelectItemList(common_cond Cond);
	void commonSave(t_common data);
	void remove(t_common data);
	void update(t_common data);
}
