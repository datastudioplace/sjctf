package com.localhost8888.utils;


public final class DynamicXpathUtils {
	
	/**
	 * Private constructor to avoid external instantiation
	 */
	private DynamicXpathUtils() {}
	

	public static String getXpath(String xpath, String value) {
		return String.format(xpath, value);//a[text()='%s'] 
	}
	

	public static String getXpath(String xpath, String value1, String value2) {
		return String.format(xpath, value1,value2);
	}

	
	
}
