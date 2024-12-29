package com.localhost8888.cucumber.stepDefinitions;

import com.localhost8888.helperutilities.logger.LoggerHelper;
import com.localhost8888.webdriverutilities.WebDrv;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Hooks {
  private static final Logger log = LoggerHelper.getLogger(Hooks.class);
  private WebDriver driver;

  @Before
  public void setUp() {
    log.info("Initializing WebDriver instance");
    this.driver = WebDrv.getInstance().getWebDriver();
    if (this.driver == null) {
      log.error("WebDriver instance is null in @Before hook");
    } else {
      log.info("WebDriver instance initialized successfully");
    }
  }

  @After
  public void endTest(Scenario scenario) {
    if (this.driver == null) {
      //log.error("WebDriver instance is null in @After hook");
      return;
    }

    if (scenario.isFailed()) {
      try {
        log.info(scenario.getName() + " is Failed");
        final byte[] screenshot = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(
            screenshot,
            "image/png",
            "Failed Scenario Screenshot"); // Attach the screenshot to the scenario
      } catch (WebDriverException e) {
        log.error("Error taking screenshot for failed scenario", e);
      }
    } else {
      try {
        log.info(scenario.getName() + " is pass");
        final byte[] screenshot = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(
            screenshot,
            "image/png",
            "Passed Scenario Screenshot"); // Attach the screenshot to the scenario
      } catch (Exception e) {
        log.error("Error taking screenshot for passed scenario", e);
      }
    }
  }
}
