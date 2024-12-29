package com.localhost8888.helperutilities;

import com.localhost8888.webdriverutilities.WebDrv;
import java.util.Set;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PopUpUrlCheckUtils {

  public void checkByClickingOnTheLinkTakesToExpectedUrl(WebElement linkName, String expectedUrl) {
    linkName.click();
    String parentWindow = WebDrv.getInstance().getWebDriver().getWindowHandle();

    Set<String> windowHandles = WebDrv.getInstance().getWebDriver().getWindowHandles();
    for (String handle : windowHandles) {
      WebDrv.getInstance().getWebDriver().switchTo().window(handle);
    }
    Assert.assertEquals(
        "Link url is not matching",
        expectedUrl,
        WebDrv.getInstance().getWebDriver().getCurrentUrl());
    WebDrv.getInstance().getWebDriver().close();
    WebDrv.getInstance().getWebDriver().switchTo().window(parentWindow);
  }
}
