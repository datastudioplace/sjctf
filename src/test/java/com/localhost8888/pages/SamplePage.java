package com.localhost8888.pages;

import com.localhost8888.helperutilities.wait.WaitUtils;
import com.localhost8888.webdriverutilities.WebDrv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SamplePage {

    WebDriver driver;

    public SamplePage() {
        this.driver = WebDrv.getInstance().getWebDriver();
        PageFactory.initElements(driver, this);
    }

    // Define elements using @FindBy
    @FindBy(id = "elementId1")
    private WebElement element1;

    @FindBy(css = ".elementClass")
    private WebElement element2;

    @FindBy(xpath = "//div[@class='elementClass']")
    private WebElement element3;

    @FindBy(name = "elementName")
    private WebElement element4;

    @FindBy(linkText = "Element Link Text")
    private WebElement element5;

    // Other elements...

    // Method to wait for the page to be fully loaded
    public void waitForPageToBeFullyLoaded() {
        WaitUtils.waitForPageToBeLoaded();
    }

    // Methods to return each element
    public WebElement getElement1() {
        return element1;
    }

    public WebElement getElement2() {
        return element2;
    }

    public WebElement getElement3() {
        return element3;
    }

    public WebElement getElement4() {
        return element4;
    }

    public WebElement getElement5() {
        return element5;
    }

    // Other methods to return elements...
}