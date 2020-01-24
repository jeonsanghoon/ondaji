/**
 * 
 */
package com.mrc.db.dto.member;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jsh
 *
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class t_member implements Serializable {
	private int member_code;
	private String member_id;
	private String member_name;
	@JsonIgnore
	private String member_pw;
	private int insert_code;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp insert_date;
	private int update_code;
	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp update_date;
}
