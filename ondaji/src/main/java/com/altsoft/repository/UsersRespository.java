/**
 * 
 */
package com.altsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.altsoft.model.Users;
/**
 * @author jsh
 *
 */

public interface UsersRespository extends JpaRepository <Users, Long>{

	
}