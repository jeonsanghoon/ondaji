package com.mrc.db.dto.member;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

 
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class member_cond implements Serializable {
	private Integer member_code;
	private String member_id;
	private String member_pw;
	private String member_name;
	
}
