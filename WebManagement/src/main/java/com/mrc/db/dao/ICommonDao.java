/**
 * 
 */
package com.mrc.db.dao;

import java.util.List;

/**
 * 공통 Dao
 * @author jsh
 *
 * @param <common_cond>
 * @param <t_common>
 * @param <SelectItem>
 */
public interface ICommonDao<common_cond, t_common, SelectItem>  extends IBaseDao<common_cond, t_common>  {
	/**
	 * 공통 Selects Item정보 가져오기
	 * @param Cond
	 * @return
	 */
	public List<SelectItem> getSelectItemList(common_cond Cond);
}
