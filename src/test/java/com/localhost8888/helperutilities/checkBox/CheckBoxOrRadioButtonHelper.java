/**
 * @author rahul.rathore
 *     <p>06-Aug-2016
 */
package com.localhost8888.helperutilities.checkBox;

import com.localhost8888.helperutilities.logger.LoggerHelper;
import com.localhost8888.interfaces.IwebComponent;
import com.localhost8888.webdriverutilities.WebDrv;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckBoxOrRadioButtonHelper implements IwebComponent {

  private final Logger log = LoggerHelper.getLogger(CheckBoxOrRadioButtonHelper.class);

  public CheckBoxOrRadioButtonHelper() {
    log.debug("CheckBoxOrRadioButtonHelper : " + WebDrv.getInstance().getWebDriver().hashCode());
  }

  public void selectCheckBox(By locator) {
    log.info(locator);
    selectCheckBox(WebDrv.getInstance().getWebDriver().findElement(locator));
  }

  public void unSelectCheckBox(By locator) {
    log.info(locator);
    unSelectCheckBox(WebDrv.getInstance().getWebDriver().findElement(locator));
  }

  public boolean isIselected(By locator) {
    log.info(locator);
    return isIselected(WebDrv.getInstance().getWebDriver().findElement(locator));
  }

  public boolean isIselected(WebElement element) {
    boolean flag = element.isSelected();
    log.info(flag);
    return flag;
  }

  public void selectCheckBox(WebElement element) {
    if (!isIselected(element)) element.click();
    log.info(element);
  }

  public void unSelectCheckBox(WebElement element) {
    if (isIselected(element)) element.click();
    log.info(element);
  }
}
