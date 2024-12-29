package com.localhost8888.pages;

import com.localhost8888.webdriverutilities.WebDrv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class Organizations {
	
	private WebDriver driver;
	
	public Organizations() {
		driver = WebDrv.getInstance().getWebDriver();
		PageFactory.initElements(WebDrv.getInstance().getWebDriver(), this);
	}

}
