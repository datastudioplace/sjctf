package com.localhost8888.helperutilities.resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ResourceHelper {

  public static String getResourcePath(String path) {
    System.out.println(path);
    String basePath = System.getProperty("user.dir");
    System.out.println(basePath + "/" + path);
    return basePath + "/" + path;
  }

  public static String getResource_Path(String resource) {
      return getBaseResourcePath() + resource;
  }

  public static String getBaseResourcePath() {
      return com.localhost8888.helperutilities.resource.ResourceHelper.class.getClass().getResource("/").getPath();
  }

  public static InputStream getResourcePathInputStream(String resource)
          throws FileNotFoundException {
    return new FileInputStream(com.localhost8888.helperutilities.resource.ResourceHelper.getResourcePath(resource));
  }

  public static void main(String[] args) throws Exception {
    String path =
        ResourceHelper.getResourcePath("src/test/java/config/configfile/log4j.properties");
    System.out.println(path);

    String path1 =
            ResourceHelper.getResourcePathInputStream("src/test/java/config/configfile/log4j.properties").toString();
    System.out.println(path1);
  }
}
