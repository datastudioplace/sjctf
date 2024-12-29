package com.localhost8888.factories;

import com.localhost8888.enums.WaitStrategy;
import com.localhost8888.helperutilities.GlobalVarsHelper;
import com.localhost8888.webdriverutilities.WebDrv;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class ExplicitWaitFactory {

  private ExplicitWaitFactory() {}

  public static WebElement performExplicitWait(WaitStrategy waitstrategy, By by) {
    WebElement element = null;
    if (waitstrategy == WaitStrategy.CLICKABLE) {
      element =
          new WebDriverWait(
                  WebDrv.getInstance().getWebDriver(),
                  Duration.ofSeconds(GlobalVarsHelper.explicitWait))
              .until(ExpectedConditions.elementToBeClickable(by));
    } else if (waitstrategy == WaitStrategy.PRESENCE) {
      element =
          new WebDriverWait(
                  WebDrv.getInstance().getWebDriver(),
                  Duration.ofSeconds(GlobalVarsHelper.explicitWait))
              .until(ExpectedConditions.presenceOfElementLocated(by));
    } else if (waitstrategy == WaitStrategy.HANDLE_STALE_ELEMENT) {
      element =
          new WebDriverWait(
                  WebDrv.getInstance().getWebDriver(),
                  Duration.ofSeconds(GlobalVarsHelper.explicitWait))
              .until(
                  d -> {
                    System.out.println("Searching for the element...");
                    d.navigate().refresh();
                    return d.findElement(by);
                  });
    } else if (waitstrategy == WaitStrategy.NONE) {
      element = WebDrv.getInstance().getWebDriver().findElement(by);
    } else if (waitstrategy == WaitStrategy.VISIBLE) {
      element =
          new WebDriverWait(
                  WebDrv.getInstance().getWebDriver(),
                  Duration.ofSeconds(GlobalVarsHelper.explicitWait))
              .until(ExpectedConditions.visibilityOfElementLocated(by));
    } else if (waitstrategy == WaitStrategy.URL_CONTAINS) {
      new WebDriverWait(
              WebDrv.getInstance().getWebDriver(),
              Duration.ofSeconds(GlobalVarsHelper.explicitWait))
          .until(ExpectedConditions.urlContains("www"));
    }

    return element;
  }

  public static WebElement performExplicitWait(WaitStrategy waitStrategy, WebElement element) {
    WebDriverWait wait = new WebDriverWait(WebDrv.getInstance().getWebDriver(), Duration.ofSeconds(GlobalVarsHelper.explicitWait));

    switch (waitStrategy) {
      case CLICKABLE:
        return wait.until(ExpectedConditions.elementToBeClickable(element));
      case VISIBLE:
        return wait.until(ExpectedConditions.visibilityOf(element));
      case HANDLE_STALE_ELEMENT:
        return wait.until(d -> {
          System.out.println("Searching for the element...");
          d.navigate().refresh();
          return element;
        });
      case NONE:
        return element;
      default:
        throw new IllegalArgumentException("Invalid wait strategy: " + waitStrategy);
    }
  }

  public static List<WebElement> waitForElementsToBeVisible(List<WebElement> elements) {
    WebDriverWait wait = new WebDriverWait(WebDrv.getInstance().getWebDriver(), Duration.ofSeconds(GlobalVarsHelper.explicitWait));
    return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
  }
}
