/**
 * 
 */
package com.mrc.db.dto;

import java.io.Serializable;
import java.sql.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author jsh
 *
 */

@Getter 
@Setter
@ToString
@Builder
public class T_MEMBER implements Serializable{
	private String mode;
	private int MEMBER_CODE;
	private String MEMBER_NAME;
	private String MEMBER_PW;
	private int INSERT_CODE;
	private Date INSERT_DATE;
}
