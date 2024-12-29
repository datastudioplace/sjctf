package com.localhost8888.exceptions;

import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class NoSuchElementsException extends Exception {
  public NoSuchElementsException(String message) {
    super(message);
  }

  public static void checkIfWebElementListContainsElementOrElseThrowNoSuchElementException(
      List<WebElement> webElements, int webElementIndexToBeRetrieved) {
    if (hasListGotTheDesiredWebElement(webElements, webElementIndexToBeRetrieved))
      throw new NoSuchElementException();
  }

  private static boolean hasListGotTheDesiredWebElement(
      List<WebElement> webElements, int webElementIndexToBeRetrieved) {
    return webElements == null
        || webElements.isEmpty()
        || webElements.get(webElementIndexToBeRetrieved) == null;
  }
}
