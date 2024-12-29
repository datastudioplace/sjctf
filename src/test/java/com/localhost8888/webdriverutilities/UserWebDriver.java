package com.localhost8888.webdriverutilities;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

public class UserWebDriver {
  private static UserWebDriver instance = null;
  private WebDriver webDriver;

  private UserWebDriver() {}

  public static UserWebDriver getInstance() {
    if (instance == null) {
      instance = new UserWebDriver();
    }
    return instance;
  }

  public static void getScreenshot(WebElement element) throws IOException {
    File srcScreenShot = element.getScreenshotAs(OutputType.FILE);
    FileHandler.copy(
        srcScreenShot, new File(System.getProperty("user.dir") + "//screenShots/screenShot.png"));
  }

  public WebDriver openBrowser(String url) {
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
    webDriver = new ChromeDriver(chromeOptions);
    webDriver.get(url);
    return webDriver;
  }

  public WebDriver getWebDriver() {
    return webDriver;
  }
}
