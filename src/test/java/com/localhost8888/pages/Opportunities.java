package com.localhost8888.pages;

import com.localhost8888.webdriverutilities.WebDrv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Opportunities {

	private WebDriver driver;
	
	public Opportunities() {
    driver = WebDrv.getInstance().getWebDriver();
    PageFactory.initElements(WebDrv.getInstance().getWebDriver(), this);
	}
}
