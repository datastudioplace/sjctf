package com.localhost8888.helperutilities.assertors;

import com.localhost8888.webdriverutilities.WebDrv;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HyperlinkAssertor {

  public static void assertNewTabIsOpenedWithExpectedPage(String expectedPageName) {
    List<String> browserTabs =
        new ArrayList<String>(WebDrv.getInstance().getWebDriver().getWindowHandles());
    // switch to new tab
    WebDrv.getInstance().getWebDriver().switchTo().window(browserTabs.get(1));
    // check is it correct page opened or not (e.g. check page's title)
    Assert.assertEquals(
        expectedPageName,
        "The opened page is not what was expected",
        WebDrv.getInstance().getWebDriver().findElement(By.id("heading")).getText());
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
}
