package com.localhost8888.helperutilities;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckBoxUtils {

  public static void assertCheckBoxesAreUnTickedByDefaults(List<WebElement> checkBoxesList) {
    for (WebElement webElement : checkBoxesList) {
      Assert.assertFalse(webElement.isSelected());
    }
  }
}
