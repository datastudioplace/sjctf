package com.localhost8888.helperutilities.assertors;

import com.localhost8888.helperutilities.WebElementFinderUtils;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;

public class WebElementOrderingAssertor {
  private String idOfParentWebElement;

  public WebElementOrderingAssertor(String idOfParentWebElement) {
    this.idOfParentWebElement = idOfParentWebElement;
  }

  public WebElementOrderingAssertor() {
    // TODO Auto-generated constructor stub
  }

  private List<String> getModifiableIdListOfExpectedChildElements(List<String> elementIds) {
    List<String> ids = new ArrayList<>();
    for (String elementId : elementIds) {
      ids.add(elementId);
    }
    return ids;
  }

  public void assertOnOrderOfWebElementsByListOrder(
      List<String> expectedOrderOfTableBodyContentIds, String idOfParentWebElement) {
    List<WebElement> childWebElementsInActualOrder =
        WebElementFinderUtils.findAllChildElementsOfParentElementInActualOrder(
            idOfParentWebElement);
    assertOnWebElementOrder(childWebElementsInActualOrder, expectedOrderOfTableBodyContentIds);
  }

  public void assertOnOrderOfWebElementsByListOrder(
      List<String> expectedOrderOfTableBodyContentIds, WebElement tableBodyRowWebElement) {
    List<WebElement> childWebElementsInActualOrder =
        WebElementFinderUtils.findAllChildElementsOfParentElementInActualOrder(
            tableBodyRowWebElement);
    assertOnWebElementOrder(childWebElementsInActualOrder, expectedOrderOfTableBodyContentIds);
  }

  private void assertOnWebElementOrder(
      List<WebElement> childWebElementsInActualOrder,
      List<String> expectedOrderOfTableBodyContentIds) {}

  public void assertOnOrderOfWebElementsByListOrder(List<String> expectedOrderOfHeaderIds) {
    List<WebElement> childWebElementsInActualOrder =
        WebElementFinderUtils.findAllChildElementsOfParentElementInActualOrder(
            idOfParentWebElement);
    assertOnWebElementOrder(childWebElementsInActualOrder, expectedOrderOfHeaderIds);
  }
}
