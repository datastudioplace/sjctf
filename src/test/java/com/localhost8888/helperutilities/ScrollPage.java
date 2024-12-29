package com.localhost8888.helperutilities;

import com.localhost8888.webdriverutilities.WebDrv;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ScrollPage {

  private static final Logger log = LogManager.getLogger(ScrollPage.class);

  @FindBy(css = "button[title='Continue']")
  private static WebElement continueButton;

  public static void scrollToView(WebElement elementName) throws Exception {
    ((JavascriptExecutor) WebDrv.getInstance().getWebDriver())
        .executeScript("arguments[0].scrollIntoView(true);", elementName);
    Thread.sleep(500);
  }

  public static void scrollToViewAndClickContinue() {
    try {
      scrollToView(continueButton);
      continueButton.click();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static void scrollToViewContinue(WebDriver driver) {
    try {
      scrollToView(driver.findElement(By.cssSelector("button[title='Continue']")));
    } catch (Exception e) {
      log.error("e: ", e);
    }
  }

  public static void scrollToViewElement(WebDriver driver, String elementID) {
    try {
      scrollToView(driver.findElement(By.id(elementID)));
    } catch (Exception e) {
      log.error("e: ", e);
    }
  }

  public static void scrollToBottomOfThePage() {
    JavascriptExecutor js = (JavascriptExecutor) WebDrv.getInstance().getWebDriver();
    js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
  }
}
