package com.localhost8888.pages.general;

public interface LinkPage {

  void assertCorrectLinkTitle(String expectedLinkName);

  void clickLink(String linkName);
}
