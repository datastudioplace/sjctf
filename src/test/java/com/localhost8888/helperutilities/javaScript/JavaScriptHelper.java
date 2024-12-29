package com.localhost8888.helperutilities.javaScript;

import com.localhost8888.webdriverutilities.WebDrv;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptHelper {
  WebDriver driver;
  private Logger log = LogManager.getLogger(JavaScriptHelper.class);

  public JavaScriptHelper() {
    this.driver = WebDrv.getInstance().getWebDriver();
  }

  public Object executeScript(String script) {
    JavascriptExecutor exe = (JavascriptExecutor) WebDrv.getInstance().getWebDriver();
    return exe.executeScript(script);
  }

  public Object executeScript(String script, Object... args) {
    JavascriptExecutor exe = (JavascriptExecutor) WebDrv.getInstance().getWebDriver();
    return exe.executeScript(script, args);
  }

  public void scrollToElement(WebElement element) {
    log.info("scroll to <" + element.getText() + "> WebElement");
    executeScript(
        "window.scrollTo(arguments[0],arguments[1])",
        element.getLocation().x,
        element.getLocation().y);
  }

  public void scrollToElementAndClick(WebElement element) {
    scrollToElement(element);
    element.click();
    log.info("element is clicked: " + element.getText());
  }

  public void scrollIntoView(WebElement element) {
    log.info("scroll till web element :: " + element.getText());
    executeScript("arguments[0].scrollIntoView()", element);
  }

  public void scrollIntoViewAndClick(WebElement element) {
    scrollIntoView(element);
    log.info("element is clicked: " + element.getText());
    JavascriptExecutor js = (JavascriptExecutor) WebDrv.getInstance().getWebDriver();
    js.executeScript("arguments[0].click();", element);
  }

  public void scrollDownVertically() {
    log.info("scrolling down vertically...");
    executeScript("window.scrollTo(0,document.body.scrollHeight)");
  }

  public void scrollUpVertically() {
    log.info("scrolling up vertically...");
    executeScript("window.scrollTo(0,-document.body.scrollHeight)");
  }

  public void scrollDownByPixel(int pixel) {
    executeScript("window.scrollBY(0," + pixel + ")");
  }

  public void scrollUpByPixel(int pixel) {
    executeScript("window.scrollBY(0,-" + pixel + ")");
  }

  public void zoomInBy100Percentage() {
    executeScript("document.body.style.zoom='100%'");
  }

  public void zoomInBy60Percentage() {
    executeScript("document.body.style.zoom='40%'");
  }

  public void jsClickElement(WebElement element) {
    log.info("Click on the element :: " + element.getText());
    executeScript("arguments[0].click();", element);
  }

  public void click(WebElement element) {

    try {
      JavascriptExecutor js = (JavascriptExecutor) WebDrv.getInstance().getWebDriver();
      js.executeScript("arguments[0].click()", element);
      log.info("Element is clicked");
    } catch (Exception e) {
      log.error("Exception occurred while clicking on element using JS" + e.getMessage());
    }
  }

  public void sendKeys(WebElement element, String value) {

    try {
      JavascriptExecutor js = (JavascriptExecutor) WebDrv.getInstance().getWebDriver();
      js.executeScript("arguments[0].value=" + "'" + value + "'", element);
      log.info(value + " is entered");
    } catch (Exception e) {
      log.error("Exception occurred while entering value using JS" + e.getMessage());
    }
  }

  public void scrollPageToViewElement(WebElement element) {

    try {
      JavascriptExecutor js = (JavascriptExecutor) WebDrv.getInstance().getWebDriver();
      js.executeScript("arguments[0].scrollIntoView(true)", element);
      log.info("Element is visible on Screen");
    } catch (Exception e) {
      log.error("Exception occurred while scrolling the page " + e.getMessage());
    }
  }

  public void scrollTillEndOfPage() {

    try {
      JavascriptExecutor js = (JavascriptExecutor) WebDrv.getInstance().getWebDriver();
      js.executeScript("window.scrollTo(0 , document.body.scrollHeight)");
      log.info("Page is scrolled till end");

    } catch (Exception e) {
      log.error("Exception occurred while scrolling the page till end " + e.getMessage());
    }
  }
}
