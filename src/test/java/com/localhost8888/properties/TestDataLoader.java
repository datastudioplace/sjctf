package com.localhost8888.properties;

import com.localhost8888.reportFiles.report.ExtentFactory;
import com.localhost8888.utils.Constants;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestDataLoader {

  private static TestDataLoader instance = new TestDataLoader();
  private static Properties prop;

  private TestDataLoader() {

    String env = Constants.EXECUTION_ENV;

    switch (env) {
      case "test":
        loadFile(Constants.TEST_ENV_DATA_FILE);
        break;

      case "prod":
        loadFile(Constants.PROD_ENV_DATA_FILE);
        break;

      default:
        break;
    }
  }

  public static TestDataLoader getInstance() {
    return instance;
  }

  private static void loadFile(String filePath) {

    FileReader reader = null;
    try {
      reader = new FileReader(filePath);
    } catch (FileNotFoundException e) {

      ExtentFactory.falTest("Exception occurred while reading test data file");
    }

    prop = new Properties();

    try {
      prop.load(reader);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  private String getPropertyValue(String key) {

    return prop.getProperty(key);
  }

  public String getAppUrl() {
    return this.getPropertyValue("applicationUrl");
  }

  public String getLoginName() {
    return this.getPropertyValue("loginName");
  }

  public String getPassword() {
    return this.getPropertyValue("password");
  }
}
