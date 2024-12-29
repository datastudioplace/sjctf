package com.localhost8888.exceptions;

import com.localhost8888.helperutilities.PageException;
import com.localhost8888.webdriverutilities.WebDrv;

public class NotOnExpectedPageException extends Exception {
  public NotOnExpectedPageException(String message) {
    super(message);
  }

  public static void checkIfOnTheCorrectPageOtherwiseThrowException(
      String pageUrl, String exceptionMessage) throws NotOnExpectedPageException, PageException {
    if (!isCurrentPageTheExpectedPage(pageUrl)) {
      throw new NotOnExpectedPageException(exceptionMessage);
    }
  }

  private static boolean isCurrentPageTheExpectedPage(String pageUrl) throws PageException {
    return WebDrv.getInstance().getWebDriver().getCurrentUrl().equals(pageUrl);
  }
}
