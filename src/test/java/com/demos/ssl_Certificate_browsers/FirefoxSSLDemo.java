package com.demos.ssl_Certificate_browsers;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxSSLDemo {

  public static void main(String[] args) {

    FirefoxOptions options = new FirefoxOptions();
    options.setAcceptInsecureCerts(true);
    FirefoxDriver driver = new FirefoxDriver(options);
    driver.get("https://expired.badssl.com/");
  }
}
