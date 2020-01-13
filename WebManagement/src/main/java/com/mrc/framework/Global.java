/**
 * 
 */
package com.mrc.framework;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.mrc.AppProperties;



/**
 * @author jsh
 *
 */
@Component
public class Global {

	public static CommonInfo CommonInfo;
	public static SecurityInfo SecurityInfo;
	public static DataInfo DataInfo;
	public static FileInfo FileInfo;
	public static AppProperties AppProperties;
	
	@PostConstruct
	private void initialize() {
		CommonInfo = new CommonInfo();
		SecurityInfo = new SecurityInfo();
		DataInfo = new DataInfo();
		FileInfo = new FileInfo();
		AppProperties = new AppProperties();
	}
}
