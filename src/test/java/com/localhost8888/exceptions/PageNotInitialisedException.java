package com.localhost8888.exceptions;

import com.localhost8888.pages.Page;

public class PageNotInitialisedException extends Exception {
  public PageNotInitialisedException(String message) {
    super(message);
  }

  public static void checkIfPageIsNullOrElseThrowPageNotInitialisedException(
      String message, Page page) throws PageNotInitialisedException {
    if (page == null) {
      throw new PageNotInitialisedException(message);
    }
  }
}
