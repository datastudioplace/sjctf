package com.localhost8888.helperutilities.actionUtils;

import com.localhost8888.helperutilities.wait.WaitUtils;
import com.localhost8888.webdriverutilities.WebDrv;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Action {

  private static final WebDriver driver = WebDrv.getInstance().getWebDriver();

  public static void click(By locator) {
    WaitUtils.waitForElementToBeClickable(locator).ifPresent(WebElement::click);
  }

  public static void click(WebElement element) {
    WaitUtils.waitForElementToBeClickable(element).ifPresent(WebElement::click);
  }

  public static void sendKeys(By locator, String keysToSend) {
    WaitUtils.waitForElementToBeVisible(locator).ifPresent(element -> element.sendKeys(keysToSend));
  }

  public static void sendKeys(WebElement element, String keysToSend) {
    WaitUtils.waitForElementToBeVisible(element).ifPresent(el -> el.sendKeys(keysToSend));
  }

  public static void moveToElement(By locator) {
    WaitUtils.waitForElementToBeVisible(locator)
        .ifPresent(
            element -> {
              Actions actions = new Actions(driver);
              actions.moveToElement(element).perform();
            });
  }

  public static void moveToElement(WebElement element) {
    WaitUtils.waitForElementToBeVisible(element)
        .ifPresent(
            el -> {
              Actions actions = new Actions(driver);
              actions.moveToElement(el).perform();
            });
  }

  public static void selectByVisibleText(By locator, String text) {
    WaitUtils.waitForElementToBeVisible(locator)
        .ifPresent(
            element -> {
              Select select = new Select(element);
              select.selectByVisibleText(text);
            });
  }

  public static void selectByVisibleText(WebElement element, String text) {
    WaitUtils.waitForElementToBeVisible(element)
        .ifPresent(
            el -> {
              Select select = new Select(el);
              select.selectByVisibleText(text);
            });
  }

  public static void selectByIndex(By locator, int index) {
    WaitUtils.waitForElementToBeVisible(locator)
        .ifPresent(
            element -> {
              Select select = new Select(element);
              select.selectByIndex(index);
            });
  }

  public static void selectByIndex(WebElement element, int index) {
    WaitUtils.waitForElementToBeVisible(element)
        .ifPresent(
            el -> {
              Select select = new Select(el);
              select.selectByIndex(index);
            });
  }

  public static void tickCheckbox(By locator) {
    WaitUtils.waitForElementToBeVisible(locator)
        .ifPresent(
            element -> {
              if (!element.isSelected()) {
                element.click();
              }
            });
  }

  public static void tickCheckbox(WebElement element) {
    WaitUtils.waitForElementToBeVisible(element)
        .ifPresent(
            el -> {
              if (!el.isSelected()) {
                el.click();
              }
            });
  }

  public static void checkRadioButton(By locator) {
    WaitUtils.waitForElementToBeVisible(locator)
        .ifPresent(
            element -> {
              if (!element.isSelected()) {
                element.click();
              }
            });
  }

  public static void checkRadioButton(WebElement element) {
    WaitUtils.waitForElementToBeVisible(element)
        .ifPresent(
            el -> {
              if (!el.isSelected()) {
                el.click();
              }
            });
  }

  public static void clickAnyElementMatchingText(
      List<WebElement> elements, Predicate<WebElement> predicate) {
    elements.stream().filter(predicate).findFirst().ifPresent(WebElement::click);
  }

  public static void clickAnyMatchingElementByText(List<WebElement> elements, String text) {
    elements.stream()
        .filter(el -> el.getText().equalsIgnoreCase(text))
        .findFirst()
        .ifPresent(WebElement::click);
  }

  public static List<String> getAnyMatchingElementText(
      List<WebElement> elements, Function<WebElement, String> function) {
    return elements.stream().filter(WebElement::isDisplayed).map(function).toList();
  }

  public static boolean assertAnyLinkFromListOfElements(
      List<WebElement> listOfElements, String linkText) {
    return listOfElements.stream().anyMatch(el -> el.getText().equalsIgnoreCase(linkText));
  }
}
