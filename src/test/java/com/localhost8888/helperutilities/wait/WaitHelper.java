package com.localhost8888.helperutilities.wait;

import com.localhost8888.helperutilities.GlobalVarsHelper;
import com.localhost8888.helperutilities.logger.LoggerHelper;
import com.localhost8888.webdriverutilities.WebDrv;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

  private final Logger log = LoggerHelper.getLogger(WaitHelper.class);
  private WebDriver driver;

  public void setImplicitWait() {
    log.info("Implicit Wait has been set to 10 seconds");
    WebDrv.getInstance()
        .getWebDriver()
        .manage()
        .timeouts()
        .implicitlyWait(Duration.ofSeconds(GlobalVarsHelper.getImplicitTimeout()));
  }

  private WebDriverWait getWait() {
    WebDriverWait wait =
        new WebDriverWait(
            WebDrv.getInstance().getWebDriver(),
            Duration.ofSeconds(GlobalVarsHelper.getExplicitWait()));
    wait.pollingEvery(Duration.ofMillis(250));
    wait.ignoring(NoSuchElementException.class);
    wait.ignoring(StaleElementReferenceException.class);
    wait.ignoring(NoSuchFrameException.class);
    return wait;
  }

  public void WaitForElementVisibleWithPollingTime(WebElement element) {
    log.info("waiting for :" + element.toString());
    WebDriverWait wait = getWait();
    wait.until(ExpectedConditions.visibilityOf(element));
    log.info("element is visible now");
  }

  public void WaitForElementClickable(WebElement element) {
    log.info("waiting for :" + element.toString());
    WebDriverWait wait =
        new WebDriverWait(
            WebDrv.getInstance().getWebDriver(),
            Duration.ofSeconds(GlobalVarsHelper.getExplicitWait()));
    wait.until(ExpectedConditions.elementToBeClickable(element));
    log.info("element is clickable now");
  }

  public boolean waitForElementNotPresent(WebElement element, long timeOutInSeconds) {
    log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
    WebDriverWait wait =
        new WebDriverWait(
            WebDrv.getInstance().getWebDriver(),
            Duration.ofSeconds(GlobalVarsHelper.getExplicitWait()));
    boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
    log.info("element is invisible now");
    return status;
  }

  public void waitForFrameToBeAvailableAndSwitchToIt(WebElement element, long timeOutInSeconds) {
    log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
    WebDriverWait wait =
        new WebDriverWait(
            WebDrv.getInstance().getWebDriver(),
            Duration.ofSeconds(GlobalVarsHelper.getExplicitWait()));
    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    log.info("frame is available and switched");
  }

  private Wait<WebDriver> getfluentWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
    return new FluentWait<WebDriver>(WebDrv.getInstance().getWebDriver())
        .withTimeout(Duration.ofSeconds(timeOutInSeconds))
        .pollingEvery(Duration.ofMillis(pollingEveryInMiliSec))
        .ignoring(NoSuchElementException.class);
  }

  public WebElement waitForElement(
      WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec) {
    Wait<WebDriver> fwait = getfluentWait(timeOutInSeconds, pollingEveryInMiliSec);
    fwait.until(ExpectedConditions.visibilityOf(element));
    return element;
  }

  public void pageLoadTime(long timeout, TimeUnit unit) {
    log.info("waiting for page to load for : " + unit + " seconds");
    WebDrv.getInstance()
        .getWebDriver()
        .manage()
        .timeouts()
        .pageLoadTimeout(Duration.ofSeconds(GlobalVarsHelper.getExplicitWait()));
    log.info("page is loaded");
  }

  public void waitForElement(WebElement element, int timeOutInSeconds) {
    log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
    WebDriverWait wait =
        new WebDriverWait(
            WebDrv.getInstance().getWebDriver(),
            Duration.ofSeconds(GlobalVarsHelper.getExplicitWait()));
    wait.until(ExpectedConditions.visibilityOf(element));
    log.info("element is visible now");
  }
}
