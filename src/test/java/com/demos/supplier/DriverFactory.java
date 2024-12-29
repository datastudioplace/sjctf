package com.demos.supplier;

import com.google.common.base.Supplier;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

  // System.setProperty("webdriver.chrome.driver",
  // "/home/qa/.arquillian/drone/chrome/2.38/chromedriver");
  // WebDriver driver = new ChromeDriver();
  private static final Supplier<WebDriver> chromeSupplier = ChromeDriver::new;

  // System.setProperty("webdriver.gecko.driver", "/home/qa/.arquillian/drone/firefox/geckodriver");
  private static final Supplier<WebDriver> firefoxSupplier = FirefoxDriver::new;

  private static final Map<String, Supplier<WebDriver>> MAP = new HashMap<>();

  static {
    MAP.put("chrome", chromeSupplier);
    MAP.put("firefox", firefoxSupplier);
  }

  public static WebDriver getDriver(String browser) {
    return MAP.get(browser).get();
  }
}
