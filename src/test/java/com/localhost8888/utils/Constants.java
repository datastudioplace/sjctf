package com.localhost8888.utils;

public class Constants {

  public static final String userName = "admin";
  public static final String password = "password";

  public static final long explicitWait = 100;
  public static final long impliciteWait = 100;
  public static final String CURRENT_DIR = System.getProperty("user.dir");
  public static final String EXECUTION_REPORT_PATH = CURRENT_DIR + "/reports/execution.html";
  public static final int EXPLICIT_WAIT_TIME = 20;
  public static final String CONFIG_FILE_PATH =
      CURRENT_DIR + "/src/test/resources/execution/config.properties";
  public static final String TEST_ENV_DATA_FILE =
      CURRENT_DIR + "/src/test/java/com/localhost8888/testData/testData/test_data.properties";
  public static final String PROD_ENV_DATA_FILE =
      CURRENT_DIR + "/src/test/java/com/localhost8888/testData/testData/prod_data.properties";
  public static final int IMPLICIT_WAIT_TIME = 20;
  public static String EXECUTION_ENV;

  public static String getUsername() {
    return userName;
  }

  public static String getPassword() {
    return password;
  }

  public static long getExplicitwait() {
    return explicitWait;
  }
  ;

  public static long getImplicitewait() {
    return impliciteWait;
  }
}
