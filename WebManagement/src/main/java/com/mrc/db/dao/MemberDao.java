/**
 * 
 */
package com.mrc.db.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mrc.db.dto.T_MEMBER;
import com.mrc.db.dto.T_MEMBER_COND;

/**
 * @author jsh
 *
 */
@Repository
public class MemberDao {
	protected static final String NAMESPACE = "com.mrc.db.dao.";

	@Autowired
	private SqlSession sqlSession;
	
	public List<T_MEMBER> getMemberList(T_MEMBER_COND Cond){
		//return "";
		return 	sqlSession.selectList(NAMESPACE + "getMemberList", Cond);
	}
}
