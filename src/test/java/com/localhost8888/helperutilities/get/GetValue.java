package com.localhost8888.helperutilities.get;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;

public class GetValue {
  public List<String> getDesiredValue(
      List<WebElement> elements, Function<WebElement, String> getValue) {
    return elements.stream()
        .parallel()
        .filter(WebElement::isDisplayed)
        .map(getValue)
        .collect(Collectors.toList());
  }
}
