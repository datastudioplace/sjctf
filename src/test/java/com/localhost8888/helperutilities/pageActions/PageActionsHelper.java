package com.localhost8888.helperutilities.pageActions;

import com.localhost8888.webdriverutilities.WebDrv;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.Select;

public class PageActionsHelper {

  private PageActionsHelper() {}

  public static void waitAndClick(By by) {
    // wait strategy
    WebDrv.getInstance().getWebDriver().findElement(by).click();
  }

  public static void waitAndClick(By androidBy, By iosBy) {
    // wait strategy
    By byBasedOnMobilePlatform = getByBasedOnMobilePlatform(androidBy, iosBy);
    WebDrv.getInstance().getWebDriver().findElement(byBasedOnMobilePlatform).click();
  }

  public static void waitAndSendKeys(By by, String value) {
    // wait strategy
    WebDrv.getInstance().getWebDriver().findElement(by).sendKeys(value);
  }

  public static void select(By by, Consumer<Select> consumer) {
    consumer.accept(new Select(WebDrv.getInstance().getWebDriver().findElement(by)));
  }

  public static String getAttribute(By by, Function<WebElement, String> attributeFunction) {
    return attributeFunction.apply(WebDrv.getInstance().getWebDriver().findElement(by));
  }

  public static boolean isPresent(By by, Predicate<WebElement> elementPredicate) {
    return elementPredicate.test(WebDrv.getInstance().getWebDriver().findElement(by));
  }

  private static By getByBasedOnMobilePlatform(By androidBy, By iosBy) {
    return isAndroid() ? androidBy : iosBy;
  }

  private static boolean isAndroid() {
    return WebDrv.getInstance().getWebDriver() instanceof AndroidDriver;
  }

  public static void scrollForMobile(By by) {
    String previousPageSource = "";
    while (isElementNotEnabled(by) && isNotEndOfPage(previousPageSource)) {
      previousPageSource = WebDrv.getInstance().getWebDriver().getPageSource();
      performScroll();
    }
  }

  public static void scrollForMobile(WebElement element) {
    String previousPageSource = "";
    while (isElementNotEnabled(element) && isNotEndOfPage(previousPageSource)) {
      previousPageSource = WebDrv.getInstance().getWebDriver().getPageSource();
      performScroll();
    }
  }

  private static boolean isNotEndOfPage(String previousPageSource) {
    return !previousPageSource.equals(WebDrv.getInstance().getWebDriver().getPageSource());
  }

  private static boolean isElementNotEnabled(WebElement element) {
    try {
      return !element.isDisplayed();
    } catch (NoSuchElementException e) {
      return true;
    }
  }

  private static boolean isElementNotEnabled(By by) {
    List<WebElement> elements = WebDrv.getInstance().getWebDriver().findElements(by);
    if (isAndroid()) {
      return elements.isEmpty();
    }
    if (!elements.isEmpty()) {
      return elements.get(0).getAttribute("visible").equalsIgnoreCase("false");
    }
    return true;
  }

  private static void performScroll() {
    Dimension size = WebDrv.getInstance().getWebDriver().manage().window().getSize();
    int startX = size.getWidth() / 2;
    int endX = size.getWidth() / 2;
    int startY = size.getHeight() / 2;
    int endY = (int) (size.getHeight() * 0.25);

    performScrollUsingSequence(startX, startY, endX, endY);
  }

  private static void performScrollUsingSequence(int startX, int startY, int endX, int endY) {
    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "first-finger");
    Sequence sequence =
        new Sequence(finger, 0)
            .addAction(
                finger.createPointerMove(
                    Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
            .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
            .addAction(
                finger.createPointerMove(
                    Duration.ofMillis(300), PointerInput.Origin.viewport(), endX, endY))
            .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    ((AppiumDriver) (WebDrv.getInstance().getWebDriver()))
        .perform(Collections.singletonList(sequence));
  }
}
