/**
 * 
 */
package com.altsoft.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author jsh
 *
 */
@Data
@Entity
@Table(name="users")
public class Users {

	@Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator="user_id_seq")
	private Long id;
	private String userId;
	private String userPw;
	private String userName;
}
