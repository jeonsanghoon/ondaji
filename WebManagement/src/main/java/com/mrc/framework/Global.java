/**
 * 
 */
package com.mrc.framework;

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
	public static DataInfo DataInfo;
	
	@PostConstruct
	private void initialize() {
		CommonInfo = new CommonInfo();
		SecurityInfo = new SecurityInfo();
		DataInfo = new DataInfo();
	}
}
