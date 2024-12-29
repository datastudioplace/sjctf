package com.localhost8888.constants;

public final class FrameworkConstants {

  private static final int EXPLICITWAIT = 10;
  private static final String RESOURCESPATH =
      System.getProperty("user.dir") + "/src/test/resources";
  private static final String CHROMEDRIVERPATH = RESOURCESPATH + "/executables/chromedriver.exe";
  private static final String GECKODRIVERPATH = RESOURCESPATH + "/executables/geckodriver.exe";
  private static final String CONFIGFILEPATH = RESOURCESPATH + "/config/config.properties";
  private static final String JSONCONFIGFILEPATH = RESOURCESPATH + "/config/config.json";
  private static final String EXCELPATH = RESOURCESPATH + "/excelFiles/testdata.xlsx";
  private static final String RUNMANGERSHEET = "RUNMANAGER";
  private static final String ITERATIONDATASHEET = "DATA";
  private static final String EXTENTREPORTFOLDERPATH =
      System.getProperty("user.dir") + "/extent-test-output/";
  private static String extentReportFilePath = "";

  private FrameworkConstants() {}

  public static String getGeckoDriverPath() {
    return GECKODRIVERPATH;
  }

  public static String getExcelpath() {
    return EXCELPATH;
  }

  public static String getJsonconfigfilepath() {
    return JSONCONFIGFILEPATH;
  }

  public static int getExplicitwait() {
    return EXPLICITWAIT;
  }

  public static String getRunmangerDatasheet() {
    return RUNMANGERSHEET;
  }

  public static String getIterationDatasheet() {
    return ITERATIONDATASHEET;
  }

  public static String getConfigFilePath() {
    return CONFIGFILEPATH;
  }

  public static String getChromeDriverPath() {
    return CHROMEDRIVERPATH;
  }
}
