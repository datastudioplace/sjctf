package com.localhost8888.helperutilities.radioButton;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class RadioButtonHelper {

  public RadioButtonHelper() {}

  public void assertRadioButtonsAreUnTickedByDefaults(List<WebElement> radioButtons) {
    for (int i = 0; i < radioButtons.size(); i++) {
      Assert.assertFalse(radioButtons.get(i).isSelected(), "Radio button Is Ticked By Default");
    }
  }

  public void assertRadioButtonsAreDisplayed(List<WebElement> radioButtons) {
    for (int i = 0; i < radioButtons.size(); i++) {
      Assert.assertTrue(radioButtons.get(i).isDisplayed(), "Radio button Is Not Displayed");
    }
  }

  public void selectRadioButtons(List<WebElement> radioButtons, int i) {
    for (i = 0; i < radioButtons.size(); i++) {
      radioButtons.get(i).click();
    }
  }

  public void assertRadioButtonsAreMutuallyExclusive(List<WebElement> radioList) {
    for (int i = 0; i < radioList.size(); i++) {
      WebElement selected = radioList.get(i);
      selected.click();
      for (int j = 0; j < radioList.size(); j++) {
        if (!(radioList.get(j).equals(selected))) {
          Assert.assertFalse(radioList.get(j).isSelected());
        }
      }
    }
  }
}