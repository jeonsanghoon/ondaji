package com.mrc.db.dto;

import com.mrc.db.dto.member.t_member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class loginInfo  {
	private t_member member;
}
