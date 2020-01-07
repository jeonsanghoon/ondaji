package com.mrc.db.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@Data
@ToString
public class member_cond implements Serializable {
	private Integer member_code;
	private String member_id;
	private String member_pw;
	private String member_name;
	
}
