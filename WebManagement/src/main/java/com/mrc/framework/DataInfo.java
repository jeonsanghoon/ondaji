package com.mrc.framework;

public class DataInfo {
	/*
	 * LPad 함수
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
	
	/*
	 * RPad 함수
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
}
