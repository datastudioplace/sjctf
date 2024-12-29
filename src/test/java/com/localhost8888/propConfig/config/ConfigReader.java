package com.localhost8888.propConfig.config;

public interface ConfigReader {

  int getImplicitWait();

  int getExplicitWait();

  int getPageLoadTime();

  String getUrl();

  String getLoginURL();

  String getRegistrationURL();

  String getTitle();

  String getHeader();

  String getLoginName();

  String getPassword();
}
