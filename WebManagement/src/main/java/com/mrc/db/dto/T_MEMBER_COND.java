/**
 * 
 */
package com.mrc.db.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author jsh
 *
 */
@Data
@Getter
@Setter
public class T_MEMBER_COND  {
	private Integer MEMBER_CODE;
	private String MEMBER_NAME;
	private String MEMBER_PW;
}
