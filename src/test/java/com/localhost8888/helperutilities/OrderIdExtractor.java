package com.localhost8888.helperutilities;

import com.localhost8888.webdriverutilities.WebDrv;
import java.util.List;

public class OrderIdExtractor {

  public static String extractOrderIdFromCurrentPageUrl() {
    String currentUrl = WebDrv.getInstance().getWebDriver().getCurrentUrl();
    List<String> urlSegments =
        StringSplitter.splitStringIntoAnArrayWithADelimiterAndReturnIt("/", currentUrl);
    String orderId = "";

    if (urlSegments.size() >= 4) {
      orderId = urlSegments.get(4);
    }

    return orderId;
  }
}
