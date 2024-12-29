package com.demos.ssl_Certificate_browsers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeSSLDemo {

  public static void main(String[] args) {

    ChromeOptions options = new ChromeOptions();
    options.setAcceptInsecureCerts(true);

    ChromeDriver driver = new ChromeDriver(options);
    driver.get("https://expired.badssl.com/");
  }
}
