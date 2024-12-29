package com.localhost8888.helperutilities.alert;

import com.localhost8888.helperutilities.StringSplitter;
import com.localhost8888.webdriverutilities.WebDrv;
import java.util.List;

public class ProductIDExtractor {

  public static String extractProductIDFromCurrentPageUrl() {
    String currentUrl = WebDrv.getInstance().getWebDriver().getCurrentUrl();
    List<String> urlSegments =
        StringSplitter.splitStringIntoAnArrayWithADelimiterAndReturnIt("/", currentUrl);
    String ProductID = "";

    if (urlSegments.size() >= 4) {
      ProductID = urlSegments.get(4);
    }

    return ProductID;
  }
}
