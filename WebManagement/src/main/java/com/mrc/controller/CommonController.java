/**
 * 
 */
package com.mrc.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrc.db.dao.GlobalDao;
import com.mrc.db.dto.common.SelectItem;
import com.mrc.db.dto.common.common_cond;

/**
 * @author jsh
 *
 */
@RestController
public class CommonController {
	

	@ResponseBody
	@PostMapping("/common/getSelectItemList")
	public List<SelectItem> getSelectItemList(@RequestBody common_cond Cond)
	{
		List<SelectItem> rtn = GlobalDao.CommonDao.getSelectItemList(Cond);
		return rtn;
	}
}
