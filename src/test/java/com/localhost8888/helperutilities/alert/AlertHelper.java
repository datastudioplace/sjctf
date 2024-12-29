package com.localhost8888.helperutilities.alert;

import com.localhost8888.helperutilities.logger.LoggerHelper;
import com.localhost8888.webdriverutilities.WebDrv;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AlertHelper {

  private final Logger log = LoggerHelper.getLogger(AlertHelper.class);
  private Alert alert;

  public AlertHelper() {}

  public Alert getAlert() {
    log.info("alert test: " + WebDrv.getInstance().getWebDriver().switchTo().alert().getText());
    return WebDrv.getInstance().getWebDriver().switchTo().alert();
  }

  public void acceptAlert() {
    getAlert().accept();
    log.info("accept Alert is done...");
  }

  public void dismissAlert() {
    getAlert().dismiss();
    log.info("dismiss Alert is done...");
  }

  public String getAlertText() {
    String text = getAlert().getText();
    log.info("alert text: " + text);
    return text;
  }

  public boolean isAlertPresentNow() {
    try {
      WebDrv.getInstance().getWebDriver().switchTo().alert();
      log.info("alert is present");
      return true;
    } catch (NoAlertPresentException e) {
      log.info(e.getCause());
      return false;
    }
  }

  public void acceptAlertIfPresent() {
    if (isAlertPresent()) {
      acceptAlert();
    } else {
      log.info("Alert is not present..");
    }
  }

  public void dismissAlertIfPresent() {
    if (isAlertPresent()) {
      dismissAlert();
    } else {
      log.info("Alert is not present..");
    }
  }

  public void acceptPrompt(String text) {
    if (isAlertPresent()) {
      Alert alert = getAlert();
      alert.sendKeys(text);
      alert.accept();
      log.info("alert text: " + text);
    }
  }

  public void closePopups(By locator) {
    try {
      WebDriverWait wait =
          new WebDriverWait(WebDrv.getInstance().getWebDriver(), Duration.ofSeconds(30));
      List<WebElement> elements =
          wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
      for (WebElement element : elements) {
        if (element.isDisplayed()) {
          element.click();
          wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
          log.info("The popup has been closed Successfully!");
        }
      }
    } catch (Exception e) {
      log.info("Exception! - could not close the popup!, Exception: " + e);
      throw (e);
    }
  }

  public boolean checkPopupIsVisible() {
    try {
      WebDriverWait wait =
          new WebDriverWait(WebDrv.getInstance().getWebDriver(), Duration.ofSeconds(30));
      Alert alert = wait.until(ExpectedConditions.alertIsPresent());
      log.info("A popup has been found!");
      return true;
    } catch (Exception e) {
      System.err.println(
          "Error came while waiting for the alert popup to appear. " + e.getMessage());
    }
    return false;
  }

  public boolean isAlertPresent() {
    try {
      WebDrv.getInstance().getWebDriver().switchTo().alert();
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public void closeAlertPopupBox() {
    try {
      WebDriverWait wait =
          new WebDriverWait(WebDrv.getInstance().getWebDriver(), Duration.ofSeconds(30));
      Alert alert = wait.until(ExpectedConditions.alertIsPresent());
      alert.accept();
    } catch (UnhandledAlertException f) {
      Alert alert = WebDrv.getInstance().getWebDriver().switchTo().alert();
      alert.accept();
    } catch (Exception e) {
      log.info("Unable to close the popup");
      Assert.fail("Unable to close the popup, Exception: " + e.getMessage());
    }
  }

  public void checkByClickingOnTheLinkTakesToExpectedUrl(WebElement linkName, String expectedUrl) {
    linkName.click();
    String parentWindow = WebDrv.getInstance().getWebDriver().getWindowHandle();

    Set<String> windowHandles = WebDrv.getInstance().getWebDriver().getWindowHandles();
    for (String handle : windowHandles) {
      WebDrv.getInstance().getWebDriver().switchTo().window(handle);
    }
    Assert.assertEquals(
        expectedUrl,
        "Link url is not matching",
        WebDrv.getInstance().getWebDriver().getCurrentUrl());
    WebDrv.getInstance().getWebDriver().close();
    WebDrv.getInstance().getWebDriver().switchTo().window(parentWindow);
  }

  public void switchToAlert() {

    try {
      alert = WebDrv.getInstance().getWebDriver().switchTo().alert();
      log.info("Swicthed to alert.");
    } catch (NoAlertPresentException e) {
      log.error("Exception occured while swicthing to alert.");
    }
  }

  public void acceptAnAlert() {

    try {
      this.alert.accept();
      log.info("Clicked on OK button");
    } catch (Exception e) {
      log.error("Exception occurred while clicking On OK button.");
    }
  }

  public void cancelAlert() {

    try {
      this.alert.dismiss();
      log.info("Clicked on cancel button");
    } catch (Exception e) {
      log.error("Exception occurred while clicking On cancel button.");
    }
  }
}
