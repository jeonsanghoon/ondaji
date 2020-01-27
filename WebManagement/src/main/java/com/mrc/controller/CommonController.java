/**
 * 
 */
package com.mrc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrc.db.dao.ICommonDao;
import com.mrc.db.dto.common.SelectItem;
import com.mrc.db.dto.common.common_cond;
import com.mrc.db.dto.common.t_common;

/**
 * @author jsh
 *
 */
@RestController
public class CommonController {
	
	@Autowired
	private ICommonDao<common_cond, t_common, SelectItem> commonDao;
	@ResponseBody
	@PostMapping("/common/getSelectItemList")
	public List<SelectItem> getSelectItemList(@RequestBody common_cond Cond)
	{
		List<SelectItem> rtn =	commonDao.getSelectItemList(Cond);
		return rtn;
	}
}
