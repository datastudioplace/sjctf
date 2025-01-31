package com.localhost8888.utilities;

public class constant {

  /** Config Properties file */
  public static final String CONFIG_PROPERTIES_DIRECTORY = "properties\\config.properties";

  public static final String URL = "http://letskodeit.com";
  public static final String File_Path =
      "//Users//atomar//Documents//workspace_personal//SeleniumWD2Tutorial//src//com.localhost8888.utilities//";
  public static final String File_Name = "ExcelData.xlsx";
  public static final String PROJECTPATH = System.getProperty("user.dir");
  public static final String CHROMEDRIVERPATH =
      System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe";
  public static final String GECKODRIVERPATH =
      System.getProperty("user.dir") + "\\src\\test\\resources\\geckodriver.exe";
  public static final String RESOURCESPATH =
      System.getProperty("user.dir") + "\\src\\test\\resources";
  public static final String EXTENTCONFIGPATH =
      System.getProperty("user.dir") + "\\src\\test\\resources\\extentreport.xml";
  public static final int EXPLICITWAIT = 10;
  public static final String TESTDATASHEETNAME = "TestData";
  public static final String GECKO_DRIVER_DIRECTORY =
      System.getProperty("user.dir") + "drivers\\geckodriver.exe";

  public static final String CHROME_DRIVER_DIRECTORY =
      System.getProperty("user.dir") + "drivers\\chromedriver.exe";

  public static final String userName = "datastudioplace";
  public static final String password = "Manchester1";

  public static final int explicitWait = 100;
  public static final int implicitWait = 100;

  public static String getConfigPropertiesDirectory() {
    return CONFIG_PROPERTIES_DIRECTORY;
  }

  public static String getGeckoDriverDirectory() {
    return GECKO_DRIVER_DIRECTORY;
  }

  public static String getChromeDriverDirectory() {
    return CHROME_DRIVER_DIRECTORY;
  }

  public static String getUserName() {
    return userName;
  }

  public static String getPassword() {
    return password;
  }

  public static int getExplicitWait() {
    return explicitWait;
  }

  public static int getImplicitWait() {
    return implicitWait;
  }
}
