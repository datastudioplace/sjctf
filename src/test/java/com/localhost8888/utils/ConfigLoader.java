package com.localhost8888.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ConfigLoader {

  private static ConfigLoader instance = new ConfigLoader();
  private Logger log = LogManager.getLogger(ConfigLoader.class);
  private Properties prop;

  private ConfigLoader() {
    FileReader reader = null;
    try {
      reader = new FileReader(Constants.CONFIG_FILE_PATH);
    } catch (FileNotFoundException e) {
      log.error("Exception occured while reader config file");
    }

    prop = new Properties();

    try {
      prop.load(reader);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    // Constants.EXECUTION_ENV = getPropertyValue("environment");

  }

  public static ConfigLoader getInstnace() {
    return instance;
  }

  public String getPropertyValue(String key) {
    return prop.getProperty(key);
  }
}
