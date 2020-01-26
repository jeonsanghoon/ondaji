package com.mrc.db.mapper;

import java.util.List;

import com.mrc.db.dto.common_cond;
import com.mrc.db.dto.t_common;
import com.mrc.db.dto.t_member;

public interface CommonMapper {
	List<t_common> getList(common_cond Cond);
	void commonSave(t_common data);
	void remove(t_common data);
	void update(t_common data);
}
