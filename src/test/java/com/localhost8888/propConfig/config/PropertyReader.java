package com.localhost8888.propConfig.config;

import com.localhost8888.helperutilities.resource.ResourceHelper;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader implements ConfigReader {

  private static Properties OR;

  public PropertyReader() {
    try (FileInputStream file =
        new FileInputStream(
            ResourceHelper.getResourcePath("src/test/java/config/configfile/config.properties"))) {
      OR = new Properties();
      OR.load(file);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public int getImplicitWait() {
    return Integer.parseInt(OR.getProperty("implicitwait"));
  }

  @Override
  public int getExplicitWait() {
    return Integer.parseInt(OR.getProperty("explicitwait"));
  }

  @Override
  public int getPageLoadTime() {
    return Integer.parseInt(OR.getProperty("pageloadtime"));
  }

  @Override
  public String getUrl() {
    return System.getProperty("url", OR.getProperty("applicationUrl"));
  }

  @Override
  public String getLoginURL() {
    return System.getProperty("url", OR.getProperty("loginUrl"));
  }

  @Override
  public String getRegistrationURL() {
    return System.getProperty("url", OR.getProperty("registrationUrl"));
  }

  @Override
  public String getTitle() {
    return System.getProperty("accountLogin", OR.getProperty("accountLogin"));
  }

  @Override
  public String getHeader() {
    return System.getProperty("header", OR.getProperty("loginHeader"));
  }

  @Override
  public String getLoginName() {
    return System.getProperty("loginName", OR.getProperty("loginName"));
  }

  @Override
  public String getPassword() {
    return System.getProperty("password", OR.getProperty("password"));
  }
}
