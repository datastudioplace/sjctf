package com.localhost8888.helperutilities.alert;

import com.localhost8888.helperutilities.StringSplitter;
import com.localhost8888.webdriverutilities.WebDrv;
import java.util.List;

public class InvoiceNumberExtractor {

  public static String extractInvoiceNumberFromCurrentPageUrl() {
    String currentUrl = WebDrv.getInstance().getWebDriver().getCurrentUrl();
    List<String> urlSegments =
        StringSplitter.splitStringIntoAnArrayWithADelimiterAndReturnIt("/", currentUrl);
    String invoiceNumber = "";

    if (urlSegments.size() >= 4) {
      invoiceNumber = urlSegments.get(4);
    }

    return invoiceNumber;
  }
}
