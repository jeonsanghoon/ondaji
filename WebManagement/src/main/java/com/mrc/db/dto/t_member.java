/**
 * 
 */
package com.mrc.db.dto;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author jsh
 *
 */

@Getter 
@Setter
@Data
@Builder
public class t_member {
	
	private int member_code;
	private String member_id;
	private String member_name;
	private String member_pw;
	private int insert_code;
	private Date insert_date;
	private int update_code;
	private Date update_date;
}
