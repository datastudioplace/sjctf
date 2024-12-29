package com.localhost8888.helperutilities.assertion;

import com.localhost8888.webdriverutilities.WebDrv;
import java.io.File;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerificationHelper {

  private final static Logger log = LogManager.getLogger(VerificationHelper.class);
  private final WebDriver driver;

  public VerificationHelper() {
    this.driver = WebDrv.getInstance().getWebDriver();
  }

  public boolean isDisplayed(WebElement element) {
    try {
      boolean displayed = element.isDisplayed();
      log.info("Element is Displayed: " + element.getText());
      return displayed;
    } catch (Exception e) {
      log.error("Element is not Displayed: " + element, e);
      return false;
    }
  }

  public boolean assertItemDisplayedFromList(List<WebElement> listElements, String item) {
    return listElements.stream().parallel().anyMatch(s -> s.getText().equalsIgnoreCase(item));
  }

  public static boolean isSelected(WebElement element) {
    try {
      boolean selected = element.isSelected();
      log.info("Element is selected: " + element);
      return selected;
    } catch (Exception e) {
      log.error("Element is not Selected: " + element, e);
      return false;
    }
  }

  public boolean isDisplayedAndEnabled(WebElement element) {
    try {
      boolean displayed = element.isDisplayed();
      boolean enabled = element.isEnabled();
      log.info("Element is displayed and enabled: " + element.getText());
      return displayed && enabled;
    } catch (Exception e) {
      log.error("Element is not displayed and enabled: " + element, e);
      return false;
    }
  }

  public boolean isEnabled(WebElement element) {
    try {
      boolean enabled = element.isEnabled();
      log.info("Element is enabled: " + element.getText());
      return enabled;
    } catch (Exception e) {
      log.error("Element is not enabled: " + element, e);
      return false;
    }
  }

  public boolean isNotDisplayed(WebElement element) {
    try {
      boolean displayed = element.isDisplayed();
      log.info("Element is displayed: " + element.getText());
      return !displayed;
    } catch (Exception e) {
      log.info("Element is not displayed: " + element);
      return true;
    }
  }

  public String readValueFromElement(WebElement element) {
    if (element == null) {
      log.info("WebElement is null.");
      return null;
    }
    if (isDisplayed(element)) {
      String text = element.getText();
      log.info("Element text is: " + text);
      return text;
    } else {
      return null;
    }
  }

  public String getText(WebElement element) {
    if (element == null) {
      log.info("WebElement is null.");
      return null;
    }
    if (isDisplayed(element)) {
      String text = element.getText().trim();
      log.info("Element text is displayed: " + text);
      return text;
    } else {
      return null;
    }
  }

  public String getAttributeValue(WebElement element, String attribute) {
    if (element == null) {
      log.info("WebElement is null.");
      return null;
    }
    if (isDisplayed(element)) {
      String value = element.getDomAttribute(attribute).trim();
      log.info("Element attribute value is: " + value);
      return value;
    } else {
      return null;
    }
  }

  public String getTitle() {
    String title = driver.getTitle();
    log.info("Current page title is: " + title);
    return title;
  }

  public String getCurrentPageTitle() {
    String title = driver.getTitle();
    log.info("Current page title is: " + title);
    return title;
  }

  public String getCurrentPageUrl() {
    String url = driver.getCurrentUrl();
    log.info("Current page URL is: " + url);
    return url;
  }

  // Corrected method to check if an element is near another element using relative locators
  public boolean isElementNear(WebElement baseElement, WebElement targetElement, RelativeLocator.RelativeBy relativeBy) {
    try {
      WebElement element = driver.findElement(relativeBy);
      boolean isNear = element.equals(targetElement);
      log.info("Element is near the base element: " + isNear);
      return isNear;
    } catch (Exception e) {
      log.error("Element is not near the base element: " + baseElement, e);
      return false;
    }
  }

  // New method to switch to a new window or tab
  public void switchToNewWindowOrTab() {
    try {
      String originalWindow = driver.getWindowHandle();
      for (String windowHandle : driver.getWindowHandles()) {
        if (!windowHandle.equals(originalWindow)) {
          driver.switchTo().window(windowHandle);
          break;
        }
      }
      log.info("Switched to new window or tab.");
    } catch (Exception e) {
      log.error("Failed to switch to new window or tab.", e);
    }
  }

  // New method to close the current window or tab and switch back to the original window
  public void closeCurrentWindowAndSwitchBack() {
    try {
      String originalWindow = driver.getWindowHandle();
      driver.close();
      for (String windowHandle : driver.getWindowHandles()) {
        if (!windowHandle.equals(originalWindow)) {
          driver.switchTo().window(windowHandle);
          break;
        }
      }
      log.info("Closed current window and switched back to the original window.");
    } catch (Exception e) {
      log.error("Failed to close current window and switch back to the original window.", e);
    }
  }

  // New method to capture a screenshot of an element
  public void captureElementScreenshot(WebElement element, String filePath) {
    try {
      File screenshot = element.getScreenshotAs(OutputType.FILE);
      File destinationFile = new File(filePath);
      FileUtils.copyFile(screenshot, destinationFile);
      log.info("Screenshot captured for element: " + element);
    } catch (Exception e) {
      log.error("Failed to capture screenshot for element: " + element, e);
    }
  }

  // New method to capture a full-page screenshot
  public void captureFullPageScreenshot(String filePath) {
    try {
      File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      File destinationFile = new File(filePath);
      FileUtils.copyFile(screenshot, destinationFile);
      log.info("Full-page screenshot captured.");
    } catch (Exception e) {
      log.error("Failed to capture full-page screenshot.", e);
    }
  }

  // New method to check if an element is within the viewport
  public boolean isElementInViewport(WebElement element) {
    try {
      JavascriptExecutor js = (JavascriptExecutor) driver;
      boolean isInViewport = (Boolean) js.executeScript(
              "var elem = arguments[0],                 " +
                      "  box = elem.getBoundingClientRect(),    " +
                      "  cx = box.left + box.width / 2,         " +
                      "  cy = box.top + box.height / 2,         " +
                      "  e = document.elementFromPoint(cx, cy); " +
                      "for (; e; e = e.parentElement) {         " +
                      "  if (e === elem)                        " +
                      "    return true;                         " +
                      "}                                        " +
                      "return false;                            ",
              element);
      log.info("Element is in viewport: " + isInViewport);
      return isInViewport;
    } catch (Exception e) {
      log.error("Failed to check if element is in viewport: " + element, e);
      return false;
    }
  }

  // New method to verify CSS property of an element
  public boolean verifyCssProperty(WebElement element, String property, String expectedValue) {
    try {
      String actualValue = element.getCssValue(property);
      boolean isMatching = actualValue.equals(expectedValue);
      log.info("CSS property " + property + " is " + actualValue + " and matches expected value: " + isMatching);
      return isMatching;
    } catch (Exception e) {
      log.error("Failed to verify CSS property " + property + " for element: " + element, e);
      return false;
    }
  }

  // New method to handle alerts
  public boolean isAlertPresent() {
    try {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      wait.until(ExpectedConditions.alertIsPresent());
      log.info("Alert is present.");
      return true;
    } catch (Exception e) {
      log.error("No alert present.", e);
      return false;
    }
  }

  public void acceptAlert() {
    try {
      Alert alert = driver.switchTo().alert();
      alert.accept();
      log.info("Alert accepted.");
    } catch (Exception e) {
      log.error("Failed to accept alert.", e);
    }
  }

  public void dismissAlert() {
    try {
      Alert alert = driver.switchTo().alert();
      alert.dismiss();
      log.info("Alert dismissed.");
    } catch (Exception e) {
      log.error("Failed to dismiss alert.", e);
    }
  }

  public String getAlertText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      log.info("Alert text: " + alertText);
      return alertText;
    } catch (Exception e) {
      log.error("Failed to get alert text.", e);
      return null;
    }
  }

  // New method to scroll to an element
  public void scrollToElement(WebElement element) {
    try {
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("arguments[0].scrollIntoView(true);", element);
      log.info("Scrolled to element: " + element);
    } catch (Exception e) {
      log.error("Failed to scroll to element: " + element, e);
    }
  }

  // New method to highlight an element
  public void highlightElement(WebElement element) {
    try {
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("arguments[0].style.border='3px solid red'", element);
      log.info("Element highlighted: " + element);
    } catch (Exception e) {
      log.error("Failed to highlight element: " + element, e);
    }
  }

  // New method to check if an element contains specific text
  public boolean doesElementContainText(WebElement element, String text) {
    try {
      String elementText = element.getText();
      boolean containsText = elementText.contains(text);
      log.info("Element contains text '" + text + "': " + containsText);
      return containsText;
    } catch (Exception e) {
      log.error("Failed to check if element contains text '" + text + "': " + element, e);
      return false;
    }
  }

  // New method to check if an element is clickable
  public boolean isElementClickable(WebElement element) {
    try {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      wait.until(ExpectedConditions.elementToBeClickable(element));
      log.info("Element is clickable: " + element);
      return true;
    } catch (Exception e) {
      log.error("Element is not clickable: " + element, e);
      return false;
    }
  }

  // New method to verify the count of elements
  public boolean verifyElementCount(By locator, int expectedCount) {
    try {
      List<WebElement> elements = driver.findElements(locator);
      boolean isCountMatching = elements.size() == expectedCount;
      log.info("Element count is " + elements.size() + " and matches expected count: " + isCountMatching);
      return isCountMatching;
    } catch (Exception e) {
      log.error("Failed to verify element count for locator: " + locator, e);
      return false;
    }
  }

  // New method to select a value from a dropdown by visible text
  public void selectDropdownByVisibleText(WebElement dropdownElement, String visibleText) {
    try {
      Select dropdown = new Select(dropdownElement);
      dropdown.selectByVisibleText(visibleText);
      log.info("Selected '" + visibleText + "' from dropdown: " + dropdownElement);
    } catch (Exception e) {
      log.error("Failed to select '" + visibleText + "' from dropdown: " + dropdownElement, e);
    }
  }

  // New method to select a value from a dropdown by value
  public void selectDropdownByValue(WebElement dropdownElement, String value) {
    try {
      Select dropdown = new Select(dropdownElement);
      dropdown.selectByValue(value);
      log.info("Selected value '" + value + "' from dropdown: " + dropdownElement);
    } catch (Exception e) {
      log.error("Failed to select value '" + value + "' from dropdown: " + dropdownElement, e);
    }
  }

  // New method to select a value from a dropdown by index
  public void selectDropdownByIndex(WebElement dropdownElement, int index) {
    try {
      Select dropdown = new Select(dropdownElement);
      dropdown.selectByIndex(index);
      log.info("Selected index '" + index + "' from dropdown: " + dropdownElement);
    } catch (Exception e) {
      log.error("Failed to select index '" + index + "' from dropdown: " + dropdownElement, e);
    }
  }

  // New method to get all options from a dropdown
  public List<WebElement> getAllDropdownOptions(WebElement dropdownElement) {
    try {
      Select dropdown = new Select(dropdownElement);
      List<WebElement> options = dropdown.getOptions();
      log.info("Retrieved all options from dropdown: " + dropdownElement);
      return options;
    } catch (Exception e) {
      log.error("Failed to retrieve options from dropdown: " + dropdownElement, e);
      return null;
    }
  }

  // New method to get selected option from a dropdown
  public WebElement getSelectedDropdownOption(WebElement dropdownElement) {
    try {
      Select dropdown = new Select(dropdownElement);
      WebElement selectedOption = dropdown.getFirstSelectedOption();
      log.info("Retrieved selected option from dropdown: " + dropdownElement);
      return selectedOption;
    } catch (Exception e) {
      log.error("Failed to retrieve selected option from dropdown: " + dropdownElement, e);
      return null;
    }
  }

  // New method to check if a checkbox is checked
  public boolean isCheckboxChecked(WebElement checkboxElement) {
    try {
      boolean isChecked = checkboxElement.isSelected();
      log.info("Checkbox is checked: " + isChecked);
      return isChecked;
    } catch (Exception e) {
      log.error("Failed to check if checkbox is checked: " + checkboxElement, e);
      return false;
    }
  }

  // New method to check if a radio button is selected
  public boolean isRadioButtonSelected(WebElement radioButtonElement) {
    try {
      boolean isSelected = radioButtonElement.isSelected();
      log.info("Radio button is selected: " + isSelected);
      return isSelected;
    } catch (Exception e) {
      log.error("Failed to check if radio button is selected: " + radioButtonElement, e);
      return false;
    }
  }

  // New method to get the value of a CSS property
  public String getCssPropertyValue(WebElement element, String property) {
    try {
      String value = element.getCssValue(property);
      log.info("CSS property " + property + " value is: " + value);
      return value;
    } catch (Exception e) {
      log.error("Failed to get CSS property " + property + " value for element: " + element, e);
      return null;
    }
  }

  // New method to check if an element is enabled
  public boolean isElementEnabled(WebElement element) {
    try {
      boolean isEnabled = element.isEnabled();
      log.info("Element is enabled: " + isEnabled);
      return isEnabled;
    } catch (Exception e) {
      log.error("Failed to check if element is enabled: " + element, e);
      return false;
    }
  }

  // New method to check if an element is disabled
  public boolean isElementDisabled(WebElement element) {
    try {
      boolean isDisabled = !element.isEnabled();
      log.info("Element is disabled: " + isDisabled);
      return isDisabled;
    } catch (Exception e) {
      log.error("Failed to check if element is disabled: " + element, e);
      return false;
    }
  }

  // New method to check if an element is read-only
  public boolean isElementReadOnly(WebElement element) {
    try {
      String readOnly = element.getDomAttribute("readonly");
      boolean isReadOnly = readOnly != null && readOnly.equals("true");
      log.info("Element is read-only: " + isReadOnly);
      return isReadOnly;
    } catch (Exception e) {
      log.error("Failed to check if element is read-only: " + element, e);
      return false;
    }
  }

  // New method to check if an element is editable
  public boolean isElementEditable(WebElement element) {
    try {
      boolean isEditable = element.isEnabled() && !Objects.equals(element.getDomAttribute("readonly"), "true");
      log.info("Element is editable: " + isEditable);
      return isEditable;
    } catch (Exception e) {
      log.error("Failed to check if element is editable: " + element, e);
      return false;
    }
  }

  // New method to wait for an element to be visible
  public WebElement waitForElementToBeVisible(By locator) {
    try {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
      log.info("Element is visible: " + locator);
      return element;
    } catch (Exception e) {
      log.error("Failed to wait for element to be visible: " + locator, e);
      return null;
    }
  }

  // New method to wait for an element to be clickable
  public WebElement waitForElementToBeClickable(By locator) {
    try {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
      log.info("Element is clickable: " + locator);
      return element;
    } catch (Exception e) {
      log.error("Failed to wait for element to be clickable: " + locator, e);
      return null;
    }
  }

  // New method to wait for an element to be present
  public WebElement waitForElementToBePresent(By locator) {
    try {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
      log.info("Element is present: " + locator);
      return element;
    } catch (Exception e) {
      log.error("Failed to wait for element to be present: " + locator, e);
      return null;
    }
  }

  // New method to wait for an element to be invisible
  public boolean waitForElementToBeInvisible(By locator) {
    try {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      boolean isInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
      log.info("Element is invisible: " + locator);
      return isInvisible;
    } catch (Exception e) {
      log.error("Failed to wait for element to be invisible: " + locator, e);
      return false;
    }
  }

  // New method to wait for text to be present in an element
  public boolean waitForTextToBePresentInElement(WebElement element, String text) {
    try {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      boolean isTextPresent = wait.until(ExpectedConditions.textToBePresentInElement(element, text));
      log.info("Text '" + text + "' is present in element: " + element);
      return isTextPresent;
    } catch (Exception e) {
      log.error("Failed to wait for text to be present in element: " + element, e);
      return false;
    }
  }

  // New method to wait for an element to contain a specific attribute value
  public boolean waitForElementToContainAttributeValue(WebElement element, String attribute, String value) {
    try {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      boolean isAttributeValuePresent = wait.until(ExpectedConditions.attributeToBe(element, attribute, value));
      log.info("Attribute '" + attribute + "' has value '" + value + "' in element: " + element);
      return isAttributeValuePresent;
    } catch (Exception e) {
      log.error("Failed to wait for attribute '" + attribute + "' to have value '" + value + "' in element: " + element, e);
      return false;
    }
  }

  // New method to wait for an element to be selected
  public boolean waitForElementToBeSelected(WebElement element) {
    try {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      boolean isSelected = wait.until(ExpectedConditions.elementToBeSelected(element));
      log.info("Element is selected: " + element);
      return isSelected;
    } catch (Exception e) {
      log.error("Failed to wait for element to be selected: " + element, e);
      return false;
    }
  }

  // New method to wait for an element to be deselected
  public boolean waitForElementToBeDeselected(WebElement element) {
    try {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      boolean isDeselected = wait.until(ExpectedConditions.elementSelectionStateToBe(element, false));
      log.info("Element is deselected: " + element);
      return isDeselected;
    } catch (Exception e) {
      log.error("Failed to wait for element to be deselected: " + element, e);
      return false;
    }
  }

  // New method to wait for a frame to be available and switch to it
  public WebDriver waitForFrameToBeAvailableAndSwitchToIt(By locator, int timeoutInSeconds) {
    try {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      WebDriver frameDriver = wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
      log.info("Switched to frame: " + locator);
      return frameDriver;
    } catch (Exception e) {
      log.error("Failed to wait for frame to be available and switch to it: " + locator, e);
      return null;
    }
  }

  // New method to wait for a window to be available and switch to it
  public Boolean waitForWindowToBeAvailableAndSwitchToIt(String windowName, int timeoutInSeconds) {
    try {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      Boolean windowDriver = wait.until(ExpectedConditions.numberOfWindowsToBe(2));
      driver.switchTo().window(windowName);
      log.info("Switched to window: " + windowName);
      return windowDriver;
    } catch (Exception e) {
      log.error("Failed to wait for window to be available and switch to it: " + windowName, e);
      return null;
    }
  }

  // New method to wait for a URL to be a specific value
  public boolean waitForUrlToBe(String url) {
    try {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      boolean isUrl = wait.until(ExpectedConditions.urlToBe(url));
      log.info("URL is: " + url);
      return isUrl;
    } catch (Exception e) {
      log.error("Failed to wait for URL to be: " + url, e);
      return false;
    }
  }

  // New method to wait for a URL to contain a specific value
  public boolean waitForUrlToContain(String urlFragment) {
    try {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      boolean isUrlContaining = wait.until(ExpectedConditions.urlContains(urlFragment));
      log.info("URL contains: " + urlFragment);
      return isUrlContaining;
    } catch (Exception e) {
      log.error("Failed to wait for URL to contain: " + urlFragment, e);
      return false;
    }
  }

  // New method to wait for a URL to match a specific regex
  public boolean waitForUrlToMatch(String regex) {
    try {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      boolean isUrlMatching = wait.until(ExpectedConditions.urlMatches(regex));
      log.info("URL matches regex: " + regex);
      return isUrlMatching;
    } catch (Exception e) {
      log.error("Failed to wait for URL to match regex: " + regex, e);
      return false;
    }
  }

  /**
   * Verifies if a specific WebElement is at the expected position in a list of WebElements.
   *
   * @param elements the list of WebElements
   * @param element the WebElement to verify
   * @param expectedPosition the expected position (0-based index) of the element in the list
   * @return true if the element is at the expected position, false otherwise
   */
  public boolean verifyElementPosition(List<WebElement> elements, WebElement element, int expectedPosition) {
    try {
      if (elements == null || element == null || expectedPosition < 0 || expectedPosition >= elements.size()) {
        log.error("Invalid input parameters for verifying element position.");
        return false;
      }
      boolean isAtPosition = elements.get(expectedPosition).equals(element);
      log.info("Element is at the expected position: " + isAtPosition);
      return isAtPosition;
    } catch (Exception e) {
      log.error("Failed to verify element position in the list.", e);
      return false;
    }
  }

  public boolean isElementPresentByText(String text) {
    try {
      List<WebElement> elements = driver.findElements(By.xpath("//*[contains(text(), '" + text + "')]"));
      boolean isPresent = !elements.isEmpty();
      log.info("Element with text '" + text + "' is present: " + isPresent);
      return isPresent;
    } catch (Exception e) {
      log.error("Failed to verify if element with text '" + text + "' is present on the page.", e);
      return false;
    }
  }

  public boolean isElementBelowHeader(WebElement header, WebElement element) {
    try {
      JavascriptExecutor js = (JavascriptExecutor) driver;
      Long headerBottom = (Long) js.executeScript("return arguments[0].getBoundingClientRect().bottom;", header);
      Long elementTop = (Long) js.executeScript("return arguments[0].getBoundingClientRect().top;", element);
      boolean isBelow = elementTop > headerBottom;
      log.info("Element is below the header: " + isBelow);
      return isBelow;
    } catch (Exception e) {
      log.error("Failed to verify if element is below the header.", e);
      return false;
    }
  }

  /**
   * Verifies if a specific WebElement is above the page header.
   *
   * @param header the WebElement representing the page header
   * @param element the WebElement to verify
   * @return true if the element is above the header, false otherwise
   */
  public boolean isElementAboveHeader(WebElement header, WebElement element) {
    try {
      JavascriptExecutor js = (JavascriptExecutor) driver;
      Long headerTop = (Long) js.executeScript("return arguments[0].getBoundingClientRect().top;", header);
      Long elementBottom = (Long) js.executeScript("return arguments[0].getBoundingClientRect().bottom;", element);
      boolean isAbove = elementBottom < headerTop;
      log.info("Element is above the header: " + isAbove);
      return isAbove;
    } catch (Exception e) {
      log.error("Failed to verify if element is above the header.", e);
      return false;
    }
  }

  /**
   * Verifies the background color of a specific WebElement.
   *
   * @param element the WebElement to verify
   * @param expectedColor the expected background color in rgba format
   * @return true if the background color matches the expected color, false otherwise
   */
  public boolean verifyElementBackgroundColor(WebElement element, String expectedColor) {
    try {
      String actualColor = element.getCssValue("background-color");
      boolean isMatching = actualColor.equals(expectedColor);
      log.info("Background color of element is " + actualColor + " and matches expected color: " + isMatching);
      return isMatching;
    } catch (Exception e) {
      log.error("Failed to verify background color for element: " + element, e);
      return false;
    }

  }

  // Verify list of elements
  public boolean verifyListOfElementsText(List<WebElement> elements, List<String> expectedTexts) {
    List<String> actualTexts = Collections.singletonList(getText((WebElement) elements));
    return actualTexts.containsAll(expectedTexts) && expectedTexts.containsAll(actualTexts);
  }

  public boolean verifyListOfElementsDisplayed(List<WebElement> elements) {
    return isDisplayed((WebElement) elements);
  }

  public boolean verifyListOfElementsEnabled(List<WebElement> elements) {
    return isEnabled((WebElement) elements);
  }

  public boolean verifyListOfElementsSelected(List<WebElement> elements) {
    return isSelected((WebElement) elements);
  }

  //=================================================

  public static List<String> getText(List<WebElement> elements) {
    return elements.stream().map(element -> new VerificationHelper().getText(element)).collect(Collectors.toList());
  }

  public static List<Boolean> isDisplayed(List<WebElement> elements) {
    return elements.stream().map(element -> new VerificationHelper().isDisplayed(element)).collect(Collectors.toList());
  }

  public List<Boolean> isEnabled(List<WebElement> elements) {
    return elements.stream().map(element -> new VerificationHelper().isEnabled(element)).collect(Collectors.toList());
  }

  public List<Boolean> isSelected(List<WebElement> elements) {
    return elements.stream().map(element -> new VerificationHelper().isSelected(element)).collect(Collectors.toList());
  }


}