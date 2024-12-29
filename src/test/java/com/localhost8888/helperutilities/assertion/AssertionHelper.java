package com.localhost8888.helperutilities.assertion;

import com.localhost8888.webdriverutilities.WebDrv;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AssertionHelper {
  private static final Logger log = LogManager.getLogger(AssertionHelper.class);

  public static void verifyText(String s1, String s2) {
    log.info("Verifying test: " + s1 + " with " + s2);
    Assert.assertEquals(s1, s1);
  }

  public static void markPass() {
    log.info("Making script PASS..");
    Assert.assertTrue(true);
  }

  public static void markPass(String message) {
    log.info("Making script PASS => " + message);
    Assert.assertTrue(true, message);
  }

  public static void markFail() {
    log.info("Making script FAIL..");
    Assert.fail();
  }

  public static void markFail(String message) {
    log.info("Making script FAIL.." + message);

    Assert.fail(message);
  }

  public static void verifyTrue(boolean status) {
    log.info("Verify object is True..");
    Assert.assertTrue(status);
  }

  public static void verifyFalse(boolean status) {
    log.info("Verify object is False..");
    Assert.assertFalse(status);
  }

  public static void verifyNull(String s1) {
    log.info("Verify object is null..");
    Assert.assertNull(s1);
  }

  public static void verifyNotNull(String s1) {
    log.info("Verify object is not null..");
    Assert.assertNotNull(s1);
  }

  public static void fail() {
    Assert.fail();
  }

  public static void pass() {
    Assert.assertTrue(true);
  }

  public static void updateTestStatus(boolean status) {
    if (status) {
      pass();
      log.info("UpdateTestStatus => PASSED");
    } else {
      fail();
      log.info("UpdateTestStatus => FAILED");
    }
  }

  public static void assertNewTabIsOpenedWithExpectedPage(String expectedPageName) {
    List<String> browserTabs =
        new ArrayList<String>(WebDrv.getInstance().getWebDriver().getWindowHandles());
    // switch to new tab
    WebDrv.getInstance().getWebDriver().switchTo().window(browserTabs.get(1));
    // check is it correct page opened or not (e.g. check page's title)
    Assert.assertEquals(
        expectedPageName,
        WebDrv.getInstance().getWebDriver().findElement(By.id("heading")).getText(),
        "The opened page is not what was expected");
    // then close tab and get back
    WebDrv.getInstance().getWebDriver().close();
    WebDrv.getInstance().getWebDriver().switchTo().window(browserTabs.get(0));
  }

  public static void assertNewTabOpenedWithExpectedTitle(String pageTitle) {
    List<String> browserTabs =
        new ArrayList<String>(WebDrv.getInstance().getWebDriver().getWindowHandles());
    // switch to new tab
    WebDrv.getInstance().getWebDriver().switchTo().window(browserTabs.get(1));
    // check is it correct page opened or not (check page's title)
    Assert.assertEquals(
        pageTitle,
        "The opened page title did not match",
        WebDrv.getInstance().getWebDriver().getTitle());
    // then close tab and get back
    WebDrv.getInstance().getWebDriver().close();
    WebDrv.getInstance().getWebDriver().switchTo().window(browserTabs.get(0));
  }

  public static List<String> getModifiableIdListOfExpectedChildElements(List<String> elementIds) {
    List<String> ids = new ArrayList<>();
    for (String elementId : elementIds) {
      ids.add(elementId);
    }
    return ids;
  }

  public static synchronized boolean verifyElementPresent(WebElement element) {
    boolean isDispalyed = false;
    try {
      isDispalyed = element.isDisplayed();
      log.info(element.getText() + " is dispalyed");
    } catch (Exception ex) {
      log.error("Element not found " + ex);
    }

    return isDispalyed;
  }

  public static synchronized boolean verifyElementNotPresent(WebElement element) {
    boolean isDispalyed = false;
    try {
      element.isDisplayed();
      log.info(element.getText() + " is displayed");
    } catch (Exception ex) {
      log.error("Element not found " + ex);
      isDispalyed = true;
    }

    return isDispalyed;
  }

  public static synchronized boolean verifyTextEquals(WebElement element, String expectedText) {
    boolean flag = false;
    try {
      String actualText = element.getText();
      if (actualText.equals(expectedText)) {
        log.info("actualText is :" + actualText + " expected text is: " + expectedText);
        return flag = true;
      } else {
        log.error("actualText is :" + actualText + " expected text is: " + expectedText);
        return flag;
      }
    } catch (Exception ex) {
      log.error("actualText is :" + element.getText() + " expected text is: " + expectedText);
      log.info("text not matching" + ex);
      return flag;
    }
  }
}
