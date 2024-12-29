package com.localhost8888.helperutilities.wait;

import com.localhost8888.helperutilities.GlobalVarsHelper;
import com.localhost8888.pages.LoginPage;
import com.localhost8888.webdriverutilities.WebDrv;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WaitUtils {
  private static final Logger log = LogManager.getLogger(WaitUtils.class);
  private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(GlobalVarsHelper.getDefaultExplicitTimeout());
  private static final WebDriver driver = WebDrv.getInstance().getWebDriver();

  private WaitUtils() {
    // Utility class, prevent instantiation
  }

  // Wait for element to appear using By locator
  public static Optional<WebElement> waitForElementToAppear(By locator) {
    return waitForCondition(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  // Wait for element to appear using WebElement
  public static Optional<WebElement> waitForElementToAppear(WebElement element) {
    return waitForCondition(ExpectedConditions.visibilityOf(element));
  }

  // Wait for element to disappear using By locator
  public static Optional<Boolean> waitForElementToDisappear(By locator) {
    return waitForCondition(ExpectedConditions.invisibilityOfElementLocated(locator));
  }

  // Wait for element to disappear using WebElement
  public static Optional<Boolean> waitForElementToDisappear(WebElement element) {
    return waitForCondition(ExpectedConditions.invisibilityOf(element));
  }

  // Wait for element to be present using By locator
  public static Optional<WebElement> waitForElementToBePresent(By locator) {
    return waitForCondition(ExpectedConditions.presenceOfElementLocated(locator));
  }

  // Wait for element to be present using WebElement
  public static Optional<WebElement> waitForElementToBePresent(WebElement element) {
    return waitForCondition(
            ExpectedConditions.presenceOfNestedElementLocatedBy(element, By.xpath(".")));
  }

  // Wait for element to be visible using By locator
  public static Optional<WebElement> waitForElementToBeVisible(By locator) {
    return waitForCondition(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  // Wait for element to be visible using WebElement
  public static Optional<WebElement> waitForElementToBeVisible(WebElement element) {
    return waitForCondition(ExpectedConditions.visibilityOf(element));
  }

  // Wait for element to be clickable using By locator
  public static Optional<WebElement> waitForElementToBeClickable(By locator) {
    return waitForCondition(ExpectedConditions.elementToBeClickable(locator));
  }

  // Wait for element to be clickable using WebElement
  public static Optional<WebElement> waitForElementToBeClickable(WebElement element) {
    return waitForCondition(ExpectedConditions.elementToBeClickable(element));
  }

  // Wait for page to be loaded
  public static void waitForPageToBeLoaded() {
    try {
      new WebDriverWait(driver, DEFAULT_TIMEOUT)
              .until(
                      webDriver ->
                              Objects.equals(
                                      ((JavascriptExecutor) webDriver).executeScript("return document.readyState"),
                                      "complete"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // Wait for list of elements to be visible using By locator
  public static Optional<List<WebElement>> waitForElementsToBeVisible(By locator) {
    return waitForCondition(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
  }

  // Wait for list of elements to be visible using WebElement
  public static Optional<List<WebElement>> waitForElementsToBeVisible(List<WebElement> elements) {
    return waitForCondition(ExpectedConditions.visibilityOfAllElements(elements));
  }

  // Wait and click using By locator
  public static void waitAndClick(By locator) {
    try {
      waitForElementToBeClickable(locator).ifPresent(WebElement::click);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // Wait and click using WebElement
  public static void waitAndClick(WebElement element) {
    try {
      waitForElementToBeClickable(element).ifPresent(WebElement::click);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // Wait for element to be visible and click using By locator
  public static void waitToBeVisibleAndClick(By locator) {
    try {
      waitForElementToBeVisible(locator).ifPresent(WebElement::click);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // Wait for element to be visible and click using WebElement
  public static void waitToBeVisibleAndClick(WebElement element) {
    try {
      waitForElementToBeVisible(element).ifPresent(WebElement::click);
      log.info("clicked on the element");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // Wait for element to be visible and scroll to it using By locator
  public static void waitForElementToBeVisibleAndScrollToIt(By locator) {
    try {
      waitForElementToBeVisible(locator).ifPresent(WaitUtils::scrollToElement);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // Wait for element to be visible and scroll to it using WebElement
  public static void waitForElementToBeVisibleAndScrollToIt(WebElement element) {
    try {
      waitForElementToBeVisible(element).ifPresent(WaitUtils::scrollToElement);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // Wait for list of elements to be visible to select using By locator
  public static Optional<List<WebElement>> waitForElementsToBeVisibleToSelect(By locator) {
    return waitForElementsToBeVisible(locator);
  }

  // Wait for list of elements to be visible to select using WebElement
  public static Optional<List<WebElement>> waitForElementsToBeVisibleToSelect(
          List<WebElement> elements) {
    return waitForElementsToBeVisible(elements);
  }

  // Wait for element to be visible and enabled using By locator
  public static Optional<Boolean> waitForElementToBeVisibleAndEnabled(By locator) {
    return waitForCondition(
            ExpectedConditions.and(
                    ExpectedConditions.visibilityOfElementLocated(locator),
                    ExpectedConditions.elementToBeClickable(locator)));
  }

  // Wait for element to be visible and enabled using WebElement
  public static Optional<Boolean> waitForElementToBeVisibleAndEnabled(WebElement element) {
    return waitForCondition(
            ExpectedConditions.and(
                    ExpectedConditions.visibilityOf(element),
                    ExpectedConditions.elementToBeClickable(element)));
  }

  // Generic method to wait for a condition
  private static <T> Optional<T> waitForCondition(Function<WebDriver, T> condition) {
    try {
      WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
      return Optional.ofNullable(wait.until(condition));
    } catch (Exception e) {
      e.printStackTrace();
      return Optional.empty();
    }
  }

  // Scroll to element
  private static void scrollToElement(WebElement element) {
    try {
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // New methods combining waitForElementToBeClickable with actions

  public static void waitAndSendKeys(By locator, String keysToSend) {
    try {
      waitForElementToBeClickable(locator).ifPresent(element -> element.sendKeys(keysToSend));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void waitAndSendKeys(WebElement element, String keysToSend) {
    try {
      waitForElementToBeClickable(element).ifPresent(el -> el.sendKeys(keysToSend));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void waitAndSelect(By locator, String value) {
    try {
      waitForElementToBeClickable(locator).ifPresent(element -> new Select(element).selectByValue(value));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void waitAndSelect(WebElement element, String value) {
    try {
      waitForElementToBeClickable(element).ifPresent(el -> new Select(el).selectByValue(value));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void waitAndTick(By locator) {
    try {
      waitForElementToBeClickable(locator).ifPresent(element -> {
        if (!element.isSelected()) {
          element.click();
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void waitAndTick(WebElement element) {
    try {
      waitForElementToBeClickable(element).ifPresent(el -> {
        if (!el.isSelected()) {
          el.click();
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void waitAndUntickBy(By locator) {
    try {
      waitForElementToBeClickable(locator).ifPresent(element -> {
        if (element.isSelected()) {
          element.click();
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void waitAndUntick(WebElement element) {
    try {
      waitForElementToBeClickable(element).ifPresent(el -> {
        if (el.isSelected()) {
          el.click();
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void waitAndCheck(By locator) {
    try {
      waitForElementToBeClickable(locator).ifPresent(element -> {
        if (!element.isSelected()) {
          element.click();
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void waitAndCheck(WebElement element) {
    try {
      waitForElementToBeClickable(element).ifPresent(el -> {
        if (!el.isSelected()) {
          el.click();
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void waitAndUncheck(By locator) {
    try {
      waitForElementToBeClickable(locator).ifPresent(element -> {
        if (element.isSelected()) {
          element.click();
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void waitAndUncheck(WebElement element) {
    try {
      waitForElementToBeClickable(element).ifPresent(el -> {
        if (el.isSelected()) {
          el.click();
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // New methods combining waitForElementToBeVisible, waitForElementToBeEnabled, waitForElementToBePresent with click

  public static void waitToBeVisibleAndClickBy(By locator) {
    try {
      waitForElementToBeVisible(locator).ifPresent(WebElement::click);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void waitToClick(WebElement element) {
    try {
      waitForElementToBeVisible(element).ifPresent(WebElement::click);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void waitToBeEnabledAndThenClickBy(By locator) {
    try {
      waitForElementToBeVisibleAndEnabled(locator).ifPresent(enabled -> {
        if (enabled) {
          waitForElementToBeClickable(locator).ifPresent(WebElement::click);
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void waitToBeEnabledAndClick(WebElement element) {
    try {
      waitForElementToBeVisibleAndEnabled(element).ifPresent(enabled -> {
        if (enabled) {
          waitForElementToBeClickable(element).ifPresent(WebElement::click);
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void waitToBePresentAndClick(By locator) {
    try {
      waitForElementToBePresent(locator).ifPresent(WebElement::click);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void waitToBePresentAndClick(WebElement element) {
    try {
      waitForElementToBePresent(element).ifPresent(WebElement::click);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // New methods combining waitForElementsToBeVisible with select actions

  public static void waitForElementsToBeVisibleAndSelectByText(WebElement element, String text) {
    try {
      waitForElementsToBeVisible(element.findElements(By.tagName("option")))
              .ifPresent(options -> new Select(element).selectByVisibleText(text));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void waitForElementsToBeVisibleAndSelectByIndex(WebElement element, int index) {
    try {
      waitForElementsToBeVisible(element.findElements(By.tagName("option")))
              .ifPresent(options -> new Select(element).selectByIndex(index));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void waitForElementsToBeVisibleAndSelectByValue(WebElement element, String value) {
    try {
      waitForElementsToBeVisible(element.findElements(By.tagName("option")))
              .ifPresent(options -> new Select(element).selectByValue(value));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // New methods to wait for the current page URL and title

  public static void waitForPageUrlToContain(String urlFragment) {
    try {
      new WebDriverWait(driver, DEFAULT_TIMEOUT)
              .until(ExpectedConditions.urlContains(urlFragment));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void waitForPageTitleToContain(String titleFragment) {
    try {
      new WebDriverWait(driver, DEFAULT_TIMEOUT)
              .until(ExpectedConditions.titleContains(titleFragment));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // New method to wait for the page to be fully loaded
  public static void waitForPageToBeFullyLoaded() {
    try {
      new WebDriverWait(driver, DEFAULT_TIMEOUT)
              .until(
                      webDriver ->
                              Objects.equals(
                                      ((JavascriptExecutor) webDriver).executeScript("return document.readyState"),
                                      "complete"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // New method to wait for an element to be visible and hover over it
  public static void waitForElementToBeVisibleAndHover(WebElement element) {
    try {
      waitForElementToBeVisible(element).ifPresent(visibleElement -> {
        Actions actions = new Actions(driver);
        actions.moveToElement(visibleElement).perform();
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // New method to wait for page to fully load and verify the page title and header by text
  public static void waitForPageToFullyLoadAndVerifyTitleAndHeader(String expectedTitle, WebElement headerElement, String expectedHeaderText) {
    try {
      // Wait for the page to be fully loaded
      waitForPageToBeFullyLoaded();

      // Verify the page title
      new WebDriverWait(driver, DEFAULT_TIMEOUT)
              .until(ExpectedConditions.titleIs(expectedTitle));
      Assert.assertEquals(driver.getTitle(), expectedTitle, "Page title did not match the expected value.");

      // Verify the page header
      waitForElementToBeVisible(headerElement).ifPresent(visibleHeader -> {
        String actualHeaderText = visibleHeader.getText().trim();
        Assert.assertEquals(actualHeaderText, expectedHeaderText, "Page header did not match the expected value.");
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // New method to wait for list of elements to be visible, hover over an element by text, and click an element from the hovered element by text
  public static void waitForElementsToBeVisibleHoverAndClick(List<WebElement> elements, String hoverText, String clickText) {
    try {
      waitForElementsToBeVisible(elements).ifPresent(visibleElements -> {
        Actions actions = new Actions(driver);
        for (WebElement element : visibleElements) {
          if (element.getText().trim().equals(hoverText)) {
            actions.moveToElement(element).perform();
            WebElement clickElement = element.findElement(By.xpath(".//*[text()='" + clickText + "']"));
            waitForElementToBeClickable(clickElement).ifPresent(WebElement::click);
            break;
          }
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // New method to wait for page to be fully loaded, verify all elements to be visible, and check for broken links
  public static void waitForPageToBeFullyLoadedAndVerifyElementsAndLinks() {
    try {
      // Wait for the page to be fully loaded
      waitForPageToBeFullyLoaded();

      // Verify all elements to be visible
      List<WebElement> allElements = driver.findElements(By.cssSelector("*"));
      for (WebElement element : allElements) {
        waitForElementToBeVisible(element);
      }

      // Check for broken links and print details of <a>, <li>, <ul>, and <button> tags
      List<WebElement> links = driver.findElements(By.tagName("a"));
      List<WebElement> listItems = driver.findElements(By.tagName("li"));
      List<WebElement> unorderedLists = driver.findElements(By.tagName("ul"));
      List<WebElement> buttons = driver.findElements(By.tagName("button"));

      System.out.println("Links:");
      for (WebElement link : links) {
        String url = link.getAttribute("href");
        if (url != null && !url.isEmpty()) {
          if (isLinkBroken(url)) {
            System.out.println("Broken link: " + url);
          } else {
            System.out.println("Valid link: " + url);
          }
        }
      }

      System.out.println("\nList Items:");
      for (WebElement listItem : listItems) {
        System.out.println(listItem.getText());
      }

      System.out.println("\nUnordered Lists:");
      for (WebElement unorderedList : unorderedLists) {
        System.out.println(unorderedList.getText());
      }

      System.out.println("\nButtons:");
      for (WebElement button : buttons) {
        System.out.println(button.getText());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // Helper method to check if a link is broken
  private static boolean isLinkBroken(String url) {
    try {
      HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
      connection.setRequestMethod("HEAD");
      connection.connect();
      int responseCode = connection.getResponseCode();
      return responseCode >= 400;
    } catch (IOException e) {
      e.printStackTrace();
      return true;
    }
  }

  // New methods to wait for an element using various locators

  public static Optional<WebElement> waitForElementById(String id) {
    return waitForElementToAppear(By.id(id));
  }

  public static Optional<WebElement> waitForElementByCss(String css) {
    return waitForElementToAppear(By.cssSelector(css));
  }

  public static Optional<WebElement> waitForElementByLinkText(String linkText) {
    return waitForElementToAppear(By.linkText(linkText));
  }

  public static Optional<WebElement> waitForElementByClassName(String className) {
    return waitForElementToAppear(By.className(className));
  }

  // New methods to wait for a list of elements using various locators

  public static Optional<List<WebElement>> waitForElementsById(String id) {
    return waitForElementsToBeVisible(By.id(id));
  }

  public static Optional<List<WebElement>> waitForElementsByCss(String css) {
    return waitForElementsToBeVisible(By.cssSelector(css));
  }

  public static Optional<List<WebElement>> waitForElementsByLinkText(String linkText) {
    return waitForElementsToBeVisible(By.linkText(linkText));
  }

  public static Optional<List<WebElement>> waitForElementsByClassName(String className) {
    return waitForElementsToBeVisible(By.className(className));
  }

  // New method to wait for list of elements to be visible, hover over an element by text, and return the size of the sublist if it's greater than 1
  public static Optional<Integer> waitForElementsToBeVisibleHoverAndReturnSublistSize(List<WebElement> elements, String hoverText) {
    try {
      return waitForElementsToBeVisible(elements).map(visibleElements -> {
        Actions actions = new Actions(driver);
        for (WebElement element : visibleElements) {
          if (element.getText().trim().equals(hoverText)) {
            actions.moveToElement(element).perform();
            List<WebElement> subElements = element.findElements(By.xpath(".//*"));
            if (subElements.size() > 1) {
              return subElements.size();
            }
          }
        }
        return 0;
      });
    } catch (Exception e) {
      e.printStackTrace();
      return Optional.empty();
    }
  }

  // New method to wait for an element to be visible, enabled, and present, click and wait for the return page, and verify the page title
  public static void waitForElementAndClickAndVerifyTitle(WebElement element, String expectedTitle) {
    try {
      // Wait for the element to be visible, enabled, and present
      waitForElementToBeVisible(element);
      waitForElementToBeEnabled(element);
      waitForElementToBePresent(element);

      // Click the element
      element.click();

      // Wait for the page to be fully loaded
      waitForPageToBeFullyLoaded();

      // Verify the page title
      new WebDriverWait(driver, DEFAULT_TIMEOUT)
              .until(ExpectedConditions.titleIs(expectedTitle));
      Assert.assertEquals(driver.getTitle(), expectedTitle, "Page title did not match the expected value.");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // Helper method to wait for an element to be enabled
  private static Optional<WebElement> waitForElementToBeEnabled(WebElement element) {
    return waitForCondition(ExpectedConditions.elementToBeClickable(element));
  }

  // New method to wait for an element to be visible, verify the CSS value, print it, and click the element
  public static void waitForElementVerifyCssAndClick(WebElement element, String cssProperty, String expectedCssValue) {
    try {
      // Wait for the element to be visible
      waitForElementToBeVisible(element);

      // Verify the CSS value
      String actualCssValue = element.getCssValue(cssProperty);
      System.out.println("CSS Value of " + cssProperty + ": " + actualCssValue);
      Assert.assertEquals(actualCssValue, expectedCssValue, "CSS value did not match the expected value.");

      // Click the element
      element.click();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // New method to wait for an element to be visible, take a screenshot in PNG format, and set a path to store it in the parent directory
  public static void waitForElementToBeVisibleAndTakeScreenshot(WebElement element, String screenshotName) {
    try {
      waitForElementToBeVisible(element).ifPresent(visibleElement -> {
        // Take a screenshot of the element
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
          // Define the path to store the screenshot in the parent directory
          String parentDir = System.getProperty("user.dir");
          File screenshotLocation = new File(parentDir + File.separator + screenshotName + ".png");

          // Save the screenshot to the specified path
          FileUtils.copyFile(screenshot, screenshotLocation);
          System.out.println("Screenshot saved at: " + screenshotLocation.getAbsolutePath());
        } catch (IOException e) {
          e.printStackTrace();
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // New method to wait for a specific dimension to be visible, take a screenshot in PNG format, and set a path to store it in the parent directory
  public static void waitForDimensionToBeVisibleAndTakeScreenshot(int width, int height, String screenshotName) {
    try {
      // Wait for the page to be fully loaded
      waitForPageToBeFullyLoaded();

      // Take a screenshot of the entire page
      File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

      try {
        // Load the screenshot as an image
        BufferedImage fullImg = ImageIO.read(screenshot);

        // Create a new image with the specified dimensions
        BufferedImage croppedImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = croppedImg.createGraphics();
        g.drawImage(fullImg, 0, 0, width, height, null);
        g.dispose();

        // Define the path to store the screenshot in the parent directory
        String parentDir = System.getProperty("user.dir");
        File screenshotLocation = new File(parentDir + File.separator + screenshotName + ".png");

        // Save the cropped image to the specified path
        ImageIO.write(croppedImg, "png", screenshotLocation);
        System.out.println("Screenshot saved at: " + screenshotLocation.getAbsolutePath());
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // New method to wait for the full page to be visible, take a screenshot in PNG format, and set a path to store it in the parent directory
  public static void waitForFullPageToBeVisibleAndTakeScreenshot(String screenshotName) {
    try {
      // Wait for the page to be fully loaded
      waitForPageToBeFullyLoaded();

      // Take a screenshot of the entire page
      File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

      try {
        // Define the path to store the screenshot in the parent directory
        String parentDir = System.getProperty("user.dir");
        File screenshotLocation = new File(parentDir + File.separator + screenshotName + ".png");

        // Save the screenshot to the specified path
        FileUtils.copyFile(screenshot, screenshotLocation);
        System.out.println("Screenshot saved at: " + screenshotLocation.getAbsolutePath());
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // New method to wait for an element to be visible, enabled, and click it
  public static void waitForElementToBeVisibleEnabledAndClick(WebElement element) {
    try {
      waitForElementToBeVisible(element);
      waitForElementToBeEnabled(element);
      element.click();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // New method to wait for an element to be visible and upload a file
  public static void waitForElementToBeVisibleAndUploadFile(WebElement element, String fileName) {
    try {
      waitForElementToBeVisible(element).ifPresent(visibleElement -> {
        // Define the path to the file in the parent directory
        String parentDir = System.getProperty("user.dir");
        File file = new File(parentDir + File.separator + fileName);

        // Upload the file
        visibleElement.sendKeys(file.getAbsolutePath());
        System.out.println("File uploaded from: " + file.getAbsolutePath());
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // New method to wait for an element, click, switch to the child tab or window, and verify the child window
  public static void waitForElementClickAndSwitchToChildWindow(WebElement element, String expectedTitle) {
    try {
      // Get the current window handle
      String parentWindow = driver.getWindowHandle();

      // Wait for the element to be clickable and click it
      waitForElementToBeClickable(element).ifPresent(WebElement::click);

      // Wait for the new window or tab to open
      new WebDriverWait(driver, DEFAULT_TIMEOUT).until(ExpectedConditions.numberOfWindowsToBe(2));

      // Get all window handles
      Set<String> allWindows = driver.getWindowHandles();

      // Switch to the new window or tab
      for (String windowHandle : allWindows) {
        if (!windowHandle.equals(parentWindow)) {
          driver.switchTo().window(windowHandle);
          break;
        }
      }

      // Wait for the page to be fully loaded in the new window or tab
      waitForPageToBeFullyLoaded();

      // Verify the title of the new window or tab
      new WebDriverWait(driver, DEFAULT_TIMEOUT).until(ExpectedConditions.titleIs(expectedTitle));
      Assert.assertEquals(driver.getTitle(), expectedTitle, "Child window title did not match the expected value.");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // New method to wait for an element, verify its visibility, and return it
  public static WebElement waitForElementAndReturn(WebElement element) {
    try {
      return waitForElementToBeVisible(element)
              .orElseThrow(() -> new NoSuchElementException("Element not found or not visible"));
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException("Failed to return the element", e);
    }
  }
}