package com.mrc.framework;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * 데이터 클래스
 * @author jsh
 *
 */
public class DataInfo {
	/**
	 * LPad 함수
	 * @param str
	 * @param iLen
	 * @param strChar
	 * @return
	 */
	public String LPad(String str, int iLen, String strChar) {
		String strResult = "";
		StringBuilder sbAddChar = new StringBuilder();
		for (int i = str.length(); i < iLen; i++) {
			// iLen길이 만큼 strChar문자로 채운다.
			sbAddChar.append(strChar);
		}
		strResult = sbAddChar + str;
		return strResult;
	}
	
	/**
	 * RPad 함수
	 * @param str
	 * @param iLen
	 * @param strChar
	 * @return
	 */
	 
	public String RPad(String str, int iLen, String strChar) {
		String strResult = "";
		StringBuilder sbAddChar = new StringBuilder();
		for (int i = str.length(); i < iLen; i++) {
			// iLen길이 만큼 strChar문자로 채운다.
			sbAddChar.append(strChar);
		}
		strResult = str + sbAddChar;
		return strResult;
	}
	
	/**
	 * 공백 여부
	 * @param str
	 * @return
	 */
	public Boolean isNullEmpty(String str) {
		return StringUtils.isBlank(str);
	}
	
	/**
	 * 현재일자 문자로 변경
	 * @param format
	 * @return
	 */
	public String ToDayToString(String format)
	{
		return DateToString(new Date(), format);
	}
	
	/**
	 * 날짜를 문자로 변경
	 * @param date
	 * @param format
	 * @return
	 */
	public String DateToString(Date date, String format)
	{
		format = (Global.DataInfo.isNullEmpty(format))? "yyyyMMdd" : format;
		SimpleDateFormat transFormat = new SimpleDateFormat(format);

		return transFormat.format(date);
	}
}
