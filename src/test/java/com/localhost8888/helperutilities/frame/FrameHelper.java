package com.localhost8888.helperutilities.frame;

import com.localhost8888.helperutilities.GlobalVarsHelper;
import com.localhost8888.webdriverutilities.WebDrv;
import java.time.Duration;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameHelper {

  private final Logger log = LogManager.getLogger(this.getClass());

  public FrameHelper() {}

  public void switchToFrame(int frameIndex) {
    WebDrv.getInstance().getWebDriver().switchTo().frame(frameIndex);
    log.info("switched to :" + frameIndex + " frame");
  }

  public void switchToFrame(String frameName) {
    WebDrv.getInstance().getWebDriver().switchTo().frame(frameName);
    log.info("switched to :" + frameName + " frame");
  }

  public void switchToFrame(WebElement element) {
    WebDrv.getInstance().getWebDriver().switchTo().frame(element);
    log.info("switched to frame " + element.toString());
  }

  public void waitForIframeAndSwitch(String idOrName) {

    try {

      WebDriverWait wait =
          new WebDriverWait(
              WebDrv.getInstance().getWebDriver(),
              Duration.ofSeconds(GlobalVarsHelper.getExplicitTimeout()));
      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(idOrName));
      log.info("Switched to iframe");
    } catch (Exception e) {
      log.error("Error occurred while switching to Iframe");
    }
  }

  public void waitForIframeAndSwitch(int index) {

    try {

      WebDriverWait wait =
          new WebDriverWait(
              WebDrv.getInstance().getWebDriver(),
              Duration.ofSeconds(GlobalVarsHelper.getExplicitWait()));
      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
      log.info("Switched to iframe");

    } catch (Exception e) {
      log.error("Error occured while switching to Iframe");
    }
  }

  public void switchBackToDefaultContent() {

    try {
      WebDrv.getInstance().getWebDriver().switchTo().defaultContent();
      log.info("Switched to the default content");
    } catch (Exception e) {
      log.error("Error occured while switching to the default content");
    }
  }
}
