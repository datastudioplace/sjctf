package com.localhost8888.utils;

import com.localhost8888.webdriverutilities.WebDrv;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

public class CommonUtils {

  public static final int IMPLICIT_WAIT_TIME = 10;
  public static final int PAGE_LOAD_TIME = 15;
  public static final int EXPLICIT_WAIT_BASIC_TIME = 30;
  private static final String LOGIN_NAME = "webdriverio2";
  private static final String PASSWORD = "webdriverio2";
  private static Properties properties = new Properties();

  /** Initialize the properties file reader. */
  public static void initializeReader() {
    try (FileInputStream input =
        new FileInputStream("src/test/resources/config/configfile/config.properties")) {
      properties.load(input);
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException("Failed to load properties file.");
    }
  }

  /**
   * Open the browser with the specified URL.
   *
   * @param url The URL to open.
   */
  public static void openBrowserWithUrl(String url) {
    WebDriver driver = WebDrv.getInstance().openBrowser(url);
    driver.manage().window().maximize();
  }

  public static void navigateToLoginPage(String url) {
    WebDriver driver = WebDrv.getInstance().openBrowser(url);
    driver.manage().window().maximize();
  }

  public static void navigateToRegistrationPage(String url) {
    WebDriver driver = WebDrv.getInstance().openBrowser(url);
    driver.manage().window().maximize();
  }

  /**
   * Get a property value by key.
   *
   * @param key The key of the property.
   * @return The value of the property.
   */
  public static String getProperty(String key) {
    return properties.getProperty(key);
  }

  /**
   * Generate an email with a timestamp.
   *
   * @return The generated email.
   */
  public static String getEmailPlusTimeStamp() {
    return new CommonUtils().getEmailWithTimeStamp();
  }

  /**
   * Generate an email with a timestamp.
   *
   * @return The generated email.
   */
  public String getEmailWithTimeStamp() {
    Date date = new Date();
    return "udo" + date.toString().replace(" ", "_").replace(":", "_") + "@gmail.com";
  }
}
