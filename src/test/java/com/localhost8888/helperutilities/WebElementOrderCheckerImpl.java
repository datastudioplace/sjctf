package com.localhost8888.helperutilities;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;

public class WebElementOrderCheckerImpl implements WebElementOrderChecker {

  List<WebElement> webElements;
  List<String> elementIds = new ArrayList<>();

  public WebElementOrderCheckerImpl(List<WebElement> webElements) {
    this.webElements = webElements;
  }

  @Override
  public boolean areWebElementsOrderedLikeSpecifiedListByElementId(
      List<String> expectedElementIds) {
    populateAllIdsFromActualWebElementsThatAreAlsoPresentInExpectedElementIdList(
        expectedElementIds);
    for (int i = 0; i < elementIds.size(); i++) {
      if (!elementIds.get(i).equals(expectedElementIds.get(i))) {
        return false;
      }
    }
    return true;
  }

  private void populateAllIdsFromActualWebElementsThatAreAlsoPresentInExpectedElementIdList(
      List<String> expectedElementIds) {
    for (int i = 0; i < webElements.size(); i++) {
      if (expectedElementIds.contains(webElements.get(i).getAttribute("id"))) {
        elementIds.add(webElements.get(i).getAttribute("id"));
      }
    }
  }
}
