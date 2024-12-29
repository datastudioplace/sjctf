package com.localhost8888.helperutilities;

import com.localhost8888.webdriverutilities.WebDrv;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionClass {

  public static void selectFirstWord(WebElement elementName) {
    Actions action = new Actions(WebDrv.getInstance().getWebDriver());
    action
        .moveToElement(elementName, 0, 0)
        .click()
        .doubleClick()
        .build()
        .perform(); // selects first word
  }

  public static void selectLastWord(WebElement elementName) {
    Actions action = new Actions(WebDrv.getInstance().getWebDriver());
    action
        .moveToElement(elementName, elementName.getText().length(), 0)
        .click()
        .doubleClick()
        .build()
        .perform(); // selects last word
  }

  public static void selectWordAtStartOfLine(WebElement elementName) {
    Actions action = new Actions(WebDrv.getInstance().getWebDriver());
    action
        .moveToElement(elementName, 0, 0)
        .click()
        .doubleClick()
        .build()
        .perform(); // selects word at start of line
  }

  public static void selectWordAtEndOfLine(WebElement elementName) {
    Actions action = new Actions(WebDrv.getInstance().getWebDriver());
    action
        .moveToElement(elementName, elementName.getText().length(), 0)
        .click()
        .doubleClick()
        .build()
        .perform(); // selects word at end of line
  }

  public static void selectWordAtPosition(WebElement elementName, int x, int y) {
    Actions action = new Actions(WebDrv.getInstance().getWebDriver());
    action
        .moveToElement(elementName, x, y)
        .click()
        .doubleClick()
        .build()
        .perform(); // selects word at given position
  }

  public static void selectAllWords(WebElement elementName) {
    Actions action = new Actions(WebDrv.getInstance().getWebDriver());
    action
        .moveToElement(elementName, 0, 0)
        .click()
        .keyDown(Keys.SHIFT)
        .sendKeys(Keys.END)
        .keyUp(Keys.SHIFT)
        .build()
        .perform(); // selects all words
  }

  public static void selectAllText(WebElement elementName) {
    Actions action = new Actions(WebDrv.getInstance().getWebDriver());
    action
        .moveToElement(elementName, 0, 0)
        .click()
        .keyDown(Keys.CONTROL)
        .sendKeys(Keys.END)
        .keyUp(Keys.CONTROL)
        .build()
        .perform(); // selects all text
  }
}
