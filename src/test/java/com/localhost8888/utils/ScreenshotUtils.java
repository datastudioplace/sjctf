package com.localhost8888.utils;

import com.localhost8888.webdriverutilities.WebDrv;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public final class ScreenshotUtils {
	
	/**
	 * Private constructor to avoid external instantiation
	 */
	private ScreenshotUtils() {}
	
	/**
	 * Captures screenshot of the current page, constructs a base64 string from the image and return to the caller.
	 * There is no temporary screenshot image generated here. If user needs separate screenshot image, they can construct
	 * a new method. It is advisable to use this method for many reasons.
	 * 
	 * @author Amuthan Sakthivel
	 * Jan 22, 2021
	 * @return Image in the form of Base64 String which can be appended directly to report
	 */
	public static String getBase64Image() {
		return ((TakesScreenshot) WebDrv.getInstance().getWebDriver()).getScreenshotAs(OutputType.BASE64);
	}

}
