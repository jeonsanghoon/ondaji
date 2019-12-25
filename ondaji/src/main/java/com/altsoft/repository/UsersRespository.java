/**
 * 
 */
package com.altsoft.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altsoft.model.Users;
/**
 * @author jsh
 *
 */
@Repository
public interface UsersRespository extends JpaRepository <Users, Long>{
	//public Users findByUser_idAndUser_pw(String user_id, String user_name);
}