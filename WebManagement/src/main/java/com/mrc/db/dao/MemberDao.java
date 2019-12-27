/**
 * 
 */
package com.mrc.db.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mrc.db.dto.member_cond;
import com.mrc.db.dto.t_member;

/**
 * @author jsh
 *
 */
@Repository
public class MemberDao {
	protected static final String NAMESPACE = "com.mrc.db.dao.";

	@Autowired
	private SqlSession sqlSession;
	
	public List<t_member> getMemberList(member_cond Cond){
		//return "";
		
		return 	sqlSession.selectList(NAMESPACE + "getMemberList", Cond);
	}
}
