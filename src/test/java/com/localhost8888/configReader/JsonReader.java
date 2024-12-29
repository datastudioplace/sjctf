package com.localhost8888.configReader;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonReader {

  public static NavigationMenu readNavigationMenu(String filePath) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.readValue(new File(filePath), NavigationMenu.class);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static class NavigationMenu {
    public List<Category> navigationMenu;

    public static class Category {
      public String category;
      public List<String> items;
    }
  }
}
