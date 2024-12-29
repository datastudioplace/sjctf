package com.localhost8888.webdriverutilities;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverConfig {

  private WebDriver webDriver;

  public WebDriverConfig(WebDriver webDriver) {
    this.webDriver = webDriver;

  }

  public static WebDriver configureAndOpenBrowser(String url) {
    WebDriver webDriver = new ChromeDriver(createChromeOptions());
    webDriver.get(url);
    return webDriver;
  }

  private static ChromeOptions createChromeOptions() {
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--disable-dev-shm-usage");
    chromeOptions.addArguments("--no-sandbox");
    chromeOptions.addArguments("--window-size=1920,1080");
    chromeOptions.addArguments("--disable-extensions");
    chromeOptions.addArguments("--start-maximized");
    chromeOptions.addArguments("--disable-gpu");
    chromeOptions.addArguments("--whitelisted-ips");
    chromeOptions.addArguments("--ignore-certificate-errors");
    chromeOptions.addArguments("--headless");
    return chromeOptions;
  }

  public WebDriverConfig maximiseWindow() {
    webDriver.manage().window().maximize();
    return this;
  }

  public WebDriverConfig setPageLoadTimeout(Duration pageLoadTime) {
    webDriver.manage().timeouts().pageLoadTimeout(pageLoadTime);
    return this;
  }
}
