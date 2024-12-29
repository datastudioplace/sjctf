package com.localhost8888.settings;

import com.localhost8888.interfaces.IconfigReader;
import java.util.LinkedHashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;

public class ObjectRepo {

  public static WebDriver driver;
  public static IconfigReader reader;
  public static Map<String, Object> data = new LinkedHashMap<String, Object>();
}
