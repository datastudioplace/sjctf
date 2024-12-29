package com.localhost8888.pages.general;

import java.util.Map;

public interface MultiFieldInputDetailsAssertablePage extends MultiFieldInputDetailsPage {

  void assertOnCorrectContentInFields(Map<String, String> fieldDataFromPage);
}
