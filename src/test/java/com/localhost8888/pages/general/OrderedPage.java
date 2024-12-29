package com.localhost8888.pages.general;

import com.localhost8888.enums.WebElements;

public interface OrderedPage {

  void assertIfElementsAreOrderedAsInTheExpectedList(WebElements[] expectedWebElements);
}
