/**
 * 
 */
package com.mrc.db.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jsh
 *
 */

@Getter 
@Setter

public class T_MEMBER{
	private String mode;
	private int MEMBER_CODE;
	private String MEMBER_ID;
	private String MEMBER_NAME;
	private String MEMBER_PW;
	private int INSERT_CODE;
	private Date INSERT_DATE;
}
