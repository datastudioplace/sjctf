/**
 * rsr
 *
 * <p>Aug 6, 2016
 */
package com.localhost8888.helperutilities.button;

import com.localhost8888.helperutilities.logger.LoggerHelper;
import com.localhost8888.interfaces.IwebComponent;
import com.localhost8888.webdriverutilities.WebDrv;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ButtonHelper implements IwebComponent {

  private final Logger log = LoggerHelper.getLogger(ButtonHelper.class);

  public ButtonHelper() {
    log.debug("button Helper : " + WebDrv.getInstance().getWebDriver().hashCode());
  }

  public void click(By locator) {
    click(WebDrv.getInstance().getWebDriver().findElement(locator));
    log.info(locator);
  }

  public void click(WebElement element) {
    element.click();
    log.info(element);
  }
}
