package com.localhost8888.maps;

import com.localhost8888.helperutilities.GlobalVarsHelper;
import java.util.HashMap;
import java.util.Map;

public class PageObjectUrlMap {

  private static Map<String, String> pageUrlMap;

  static {
    pageUrlMap = new HashMap<>();
    pageUrlMap.put("login", GlobalVarsHelper.getInstance().getURL() + "?rt=account/login");
    pageUrlMap.put("registration", GlobalVarsHelper.getInstance().getURL() + "?rt=account/create");
  }

  public static String getUrlForPage(String pageName) {
    return pageUrlMap.get(pageName);
  }

  public static String getUrlThatIncludesJobRefForPage(String pageName, String jobReference) {
    String pageUrl = pageUrlMap.get(pageName);
    pageUrl = pageUrl.replace("JOB-REF", jobReference);
    return pageUrl;
  }

  public static String getUrlThatIncludesVacancyIdForPage(String pageName, String vacancyId) {
    String pageUrl = pageUrlMap.get(pageName);
    pageUrl = pageUrl.replace("VACANCY-ID", vacancyId);
    return pageUrl;
  }
}
