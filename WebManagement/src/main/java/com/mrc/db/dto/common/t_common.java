package com.mrc.db.dto.common;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class t_common implements Serializable {
	private String main_code;
	private Integer sub_code;
	private String name;
	private int order_seq;
	private String ref_data1;
	private String ref_data2;
	private String ref_data3;
	private String ref_data4;
	private Boolean hide;
	private int insert_code;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp insert_date;
	private int update_code;
	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp update_date;
}
