package com.localhost8888.webdriverutilities;

import com.localhost8888.helperutilities.GlobalVarsHelper;
import com.localhost8888.testData_admin.AdminTestData;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDrv {
  private static WebDrv instance = null;
  private WebDriver webDriver;

  private WebDrv() {

  }

  public static WebDrv getInstance() {
    if (instance == null) {
      instance = new WebDrv();
    }
    return instance;
  }

  public WebDriver openBrowser(String url) {
    if (url == null || url.isEmpty()) {
      throw new IllegalArgumentException("The URL provided is null or empty.");
    }

    HashMap<String, Object> chromePrefs = new HashMap<>();
    chromePrefs.put("profile.default_content_settings.popups", 0);
    chromePrefs.put("behavior", "allow");
    chromePrefs.put("download.prompt_for_download", false);
    chromePrefs.put("download.default_directory", AdminTestData.APPLICATIONS_DOWNLOAD_FILEPATH);
    System.out.println("Download path set to: " + AdminTestData.APPLICATIONS_DOWNLOAD_FILEPATH);
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.setExperimentalOption("prefs", chromePrefs);
    chromeOptions.addArguments("--disable-dev-shm-usage");
    chromeOptions.addArguments("--no-sandbox");
    chromeOptions.addArguments("--window-size=1920,1080");
    chromeOptions.addArguments("--disable-extensions");
    chromeOptions.addArguments("--start-maximized");
    chromeOptions.addArguments("--disable-gpu");
    chromeOptions.addArguments("--whitelisted-ips");
    chromeOptions.addArguments("--ignore-certificate-errors");
    chromeOptions.addArguments("--test-type");
    // chromeOptions.addArguments("--headless");
    webDriver = new ChromeDriver(chromeOptions);
    webDriver.get(url);
    return webDriver;
  }

  public WebDriver openBrowser(String url, DesiredCapabilities caps) {

    HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
    chromePrefs.put("profile.default_content_settings.popups", 0);
    chromePrefs.put("behavior", "allow");
    chromePrefs.put("download.prompt_for_download", false);
    chromePrefs.put("download.default_directory", AdminTestData.APPLICATIONS_DOWNLOAD_FILEPATH);
    System.out.println("Download path set to: " + AdminTestData.APPLICATIONS_DOWNLOAD_FILEPATH);

    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.setExperimentalOption("prefs", chromePrefs);
    chromeOptions.addArguments("--disable-dev-shm-usage");
    chromeOptions.addArguments("--no-sandbox");
    chromeOptions.addArguments("--window-size=1920,1080");
    chromeOptions.addArguments("--disable-extensions");
    chromeOptions.addArguments("--start-maximized");
    chromeOptions.addArguments("--disable-gpu");
    chromeOptions.addArguments("--whitelisted-ips");
    chromeOptions.addArguments("--ignore-certificate-errors");
    chromeOptions.addArguments("--test-type");
    webDriver = new ChromeDriver(chromeOptions);
    WebDriverConfig config = new WebDriverConfig(webDriver);
    config.setPageLoadTimeout(Duration.ofSeconds(GlobalVarsHelper.getExplicitTimeout()));
    return webDriver;
  }

  public WebDriver getWebDriver() {
    return webDriver;

  }

  public static void setInstance() {
    instance = null;

  }


}
