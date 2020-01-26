package com.mrc.db.dao;

import java.util.List;

import com.mrc.db.dto.common.ResultData;

/**
 * 기본 Base Dao 인터페이스
 * @author jsh
 *
 * @param <TCond> 제너릭 조건
 * @param <TResult> 제너릭 결과
 */
public interface IBaseDao<TCond,TData> {
	/**
	 * 리스트 조회
	 * @param Cond
	 * @return
	 */
	public List<TData> GetList(TCond Cond);
	/**
	 * 데이터조회
	 * @param Cond
	 * @return
	 */
	public TData GetData(TCond Cond);
	/**
	 * 리스트저장
	 * @param list
	 * @return
	 */
	public ResultData SaveList(List<TData> list);
	/**
	 * 데이터저장
	 * @param list
	 * @return
	 */
	public ResultData Save(TData data);
}
