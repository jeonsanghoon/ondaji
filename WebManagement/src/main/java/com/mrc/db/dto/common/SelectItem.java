/**
 * 
 */
package com.mrc.db.dto.common;

import java.io.Serializable;

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
public class SelectItem implements Serializable {
	private int code;
	private String name;
}
