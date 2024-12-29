package com.localhost8888.cucumber.stepDefinitions;

import com.localhost8888.helperutilities.GlobalVarsHelper;
import com.localhost8888.propConfig.config.ObjectReader;
import com.localhost8888.propConfig.config.PropertyReader;
import com.localhost8888.webdriverutilities.WebDrv;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Properties;
import org.json.JSONException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

public class TestSetup {
  private Properties properties = new Properties();

  @Before
  public void loadPropertiesForTestRun() throws IOException, SQLException, JSONException {
    ObjectReader.reader = new PropertyReader();
    properties = loadProperties();
    GlobalVarsHelper.getInstance().setURL(properties.getProperty("url"));
    GlobalVarsHelper.getInstance().setURL(properties.getProperty("applicationUrl"));
    GlobalVarsHelper.getInstance().setURL(properties.getProperty("candidateuitesting.url"));
    GlobalVarsHelper.getInstance().setURL(properties.getProperty("login.url"));
    GlobalVarsHelper.getInstance().setURL(properties.getProperty("registrationUrl"));
  }

  private Properties loadProperties() throws IOException {
    String propertiesFileName = "config/configfile/config.properties";
    try (InputStream inputStream =
        getClass().getClassLoader().getResourceAsStream(propertiesFileName)) {
      if (inputStream == null) {
        throw new IOException("Properties file not found: " + propertiesFileName);
      }
      properties.load(inputStream);
    }
    return properties;
  }

  @After
  public void exitInstance(Scenario scenario) throws IOException {
    if (scenario.isFailed()) {
      try {
        byte[] screenshot =
            ((TakesScreenshot) WebDrv.getInstance().getWebDriver())
                .getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
      } catch (WebDriverException e) {
        e.printStackTrace();
      }
    }

    if (WebDrv.getInstance().getWebDriver() != null) {
      WebDrv.getInstance().getWebDriver().quit();
      WebDrv.setInstance();
    }
  }

  @After
  public void endOfScenarioStatus(Scenario scenario) {
    String featureName = "Feature :";
    String rawFeatureName = scenario.getId().split(";")[0].replace("-", " ");
    featureName =
        featureName + rawFeatureName.substring(0, 1).toUpperCase() + rawFeatureName.substring(1);
    System.out.println(featureName);
    System.out.println(
        "Scenario name : "
            + scenario.getName()
            + " Status: "
            + scenario.getStatus()
            + " Date and Time : "
            + LocalDateTime.now());
  }
}
