/**
 * 
 */
package com.altsoft.framework;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

/**
 * @author jsh
 *
 */
@Component
public class Global {

	public static CommonInfo CommonInfo;
	public static SecurityInfo SecurityInfo;
	
	@PostConstruct
	private void initialize() {
		CommonInfo = new CommonInfo();
		SecurityInfo = new SecurityInfo();
	}
}
