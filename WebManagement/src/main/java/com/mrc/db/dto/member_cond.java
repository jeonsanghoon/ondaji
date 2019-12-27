package com.mrc.db.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class member_cond {
	private Integer member_code;
	private String member_id;
	private String member_pw;
	private String member_name;
	
}
