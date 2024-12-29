package com.localhost8888.pages;

import com.localhost8888.enums.WaitStrategy;
import com.localhost8888.helperutilities.GlobalVarsHelper;
import com.localhost8888.helperutilities.WebElementOrderChecker;
import com.localhost8888.helperutilities.WebElementOrderCheckerImpl;
import com.localhost8888.helperutilities.assertion.VerificationHelper;
import com.localhost8888.helperutilities.javaScript.JavaScriptHelper;
import com.localhost8888.helperutilities.logger.LoggerHelper;
import com.localhost8888.helperutilities.wait.WaitUtils;
import com.localhost8888.webdriverutilities.WebDrv;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lombok.Getter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Page {
  static final Logger log = LoggerHelper.getLogger(Page.class);

  @FindBy(css = ".col-md-3.col-sm-6.col-xs-12")
  public List<WebElement> allProductsList;

  @FindBy(css = ".maintext")
  public WebElement header;

  @FindBy(how = How.CSS, using = ".maintext")
  protected WebElement heading;

  TopNavigationBarPage topNavigationBarPage;
  By addToCart = By.cssSelector("[title='Add to Cart']");
  By product_names = By.cssSelector("a.prdocutname");

  @FindBy(css = "a.prdocutname")
  private WebElement productName;

  @FindBy(xpath = "/html/body/div/div[1]/div[1]/section/nav/ul/li[4]/div/ul[1]/li/a")
  private List<WebElement> items;

  @FindBy(xpath = "//*[@id='categorymenu']/nav/ul/li/a")
  private List<WebElement> categories;

  @FindBy(css = ".subnav ul li")
  private List<WebElement> categorymenuList;

  @FindBy(xpath = "/html/body/div/div/div/section/nav/ul/li/div/ul/li")
  private List<WebElement> subCategoriesDropdownList;

  @FindBy(css = "button[title='Continue']")
  private WebElement continueButton;

  @FindBy(how = How.CSS, using = "h2[class='heading2'] span")
  private WebElement subHeading;

  @FindBy(css = ".//*")
  private List<WebElement> allPageElements;

  @Getter
  @FindBy(css = "img[alt='logo']")
  private WebElement logo;

  @FindBy(css = ".small.pluginsPromotionDiv")
  private WebElement promoAdvert;

  @FindBy(css = ".poweredBy")
  private WebElement poweredTextElement;

  @FindBy(css = "a")
  private WebElement aTag;

  @Getter
  @FindBy(css = "//*[contains(text(),'$')]")
  private List<WebElement> dollarSigns;

  @FindBy(how = How.ID, using = "accept-cookies")
  private List<WebElement> acceptCookies;

  @FindBy(xpath = "/html/body/div/div[1]/div[2]/section/ul/li/a")
  private List<WebElement> allPageBreadCrumbList;

  @FindBy(xpath = "/html/body/div/div[1]/div[2]/section/ul/li/a")
  private List<WebElement> breadCrumbList;

  @FindBy(how = How.CLASS_NAME, using = "active")
  private WebElement loginButton;

  @FindBy(how = How.CSS, using = "button[title='Continue']")
  private WebElement btn_Continue;

  @FindBy(css = "label.control-label.col-sm-4")
  private List<WebElement> inputLabels;

  @FindBy(how = How.ID, using = "submit")
  private WebElement continueBtn;

  public static void isActivePage() {
    WebDrv.getInstance().getWebDriver().getCurrentUrl();
  }

  public void getApplicationUrl(String url) {
    WebDrv.getInstance().getWebDriver().get(url);
  }

  public void navigateToHome() {
    WebDrv.getInstance().getWebDriver().get(GlobalVarsHelper.getUrlHomepage());
  }

  public void assertInputLabel(int i, String labelName) {
    Assert.assertEquals(labelName, "Input label not matching", inputLabels.get(i).getText());
  }

  public void assertElementDoesNotExist(By locator) {
    try {
      getElement(locator);
      Assert.fail("This element should not exist.");
    } catch (NoSuchElementException e) {
      Assert.assertTrue(true);
    }
  }

  public List<String> getArrayListOfStringWithCommaSeparated(String fieldNames) {
    return fieldNames.contains(",") ? Arrays.asList(fieldNames.split(",")) : List.of(fieldNames);
  }

  public void assertUserProfileNameIsDisplayedInTheTopMenu(String userProfileName) {
    topNavigationBarPage =
        PageFactory.initElements(WebDrv.getInstance().getWebDriver(), TopNavigationBarPage.class);
    Assert.assertTrue(
        topNavigationBarPage.getUserNameText().contains(userProfileName),
        "User profile name did not match");
  }

  public void clickContinueButton() {
    continueButton.click();
  }

  public void clickContinueBtn() {
    continueButton.click();
  }

  public void tapOnContinueButton() {
    WaitUtils.waitForElementToBeVisibleAndScrollToIt(continueButton);
    continueButton.click();
  }

  public void clickOnContinueButton() {
    WaitUtils.waitForElementToBeVisibleAndScrollToIt(btn_Continue);
    btn_Continue.click();
  }

  private List<String> getIdListOfExpectedChildElements(List<String> elementIds) {
    return elementIds.stream().skip(1).collect(Collectors.toList());
  }

  public void waitForLoad() {
    WaitUtils.waitForPageToBeLoaded();
    WebDrv.getInstance()
        .getWebDriver()
        .manage()
        .timeouts()
        .implicitlyWait(Duration.ofSeconds(GlobalVarsHelper.DEFAULT_IMPLICIT_TIMEOUT));
  }

  public List<WebElement> getAllElements() {
    return allPageElements;
  }

  public void getRectHeightAndWidthOfAnElement(WebElement element) {
    Point p = element.getLocation();
    log.info(p.getX());
    log.info(p.getY());
    Rectangle r = element.getRect();
    log.info(r.getX());
    log.info(r.getY());
  }

  public boolean checkForTitle(WebDriver driver, String title) {
    log.info(title);
    if (title == null || title.isEmpty()) throw new IllegalArgumentException(title);
    return driver.getTitle().trim().contains(title);
  }

  public boolean assertLogoIsDisplayed() {
    return logo.isDisplayed();
  }

  public String getLogoText() {
    return logo.getText();
  }

  public void clickLogoImage() {
    logo.click();
  }

  public String generateRandomNumber(int length) {
    return RandomStringUtils.randomNumeric(length);
  }

  public String generateRandomString(int length) {
    return RandomStringUtils.randomAlphabetic(length);
  }

  public String getThisPageTitle() {
    log.info("Page title is: " + WebDrv.getInstance().getWebDriver().getTitle());
    return new VerificationHelper().getCurrentPageTitle();
  }

  public String getThisPageUrl() {
    log.info("Page url is: " + WebDrv.getInstance().getWebDriver().getCurrentUrl());
    return new VerificationHelper().getCurrentPageUrl();
  }

  public String getThisPageHeader() {
    WaitUtils.waitForElementToBeVisible(heading);
    log.info("Page Header :: " + heading.getText());
    return new VerificationHelper().getText(header);
  }

  public boolean assertCurrentPageBreadCrumbMenuIsDisplayedCorrectly(String MenuName) {
    return breadCrumbList.stream().parallel().anyMatch(s -> s.getText().trim().contains(MenuName));
  }

  public void assertNoRadioButtonSelected(List<WebElement> elements) {
    Assert.assertFalse(
        elements.stream().anyMatch(WebElement::isSelected), "No radio button should be selected");
  }

  public void assertOnElementIsDisplayed(WebElement element) {
    Assert.assertTrue(element.isDisplayed(), "Element should be displayed");
  }

  public void assertOnElementIsNotDisplayed(List<WebElement> elements) {
    Assert.assertTrue(elements.isEmpty(), "Element should not be displayed");
  }

  public void assertOnOrderOfWebElementsByListOrder(List<String> elementIds) {
    String idOfParentElement = elementIds.get(0);
    WebElement parentWebElement =
        WebDrv.getInstance().getWebDriver().findElement(By.id(idOfParentElement));
    List<WebElement> childWebElements = parentWebElement.findElements(By.xpath(".//*"));
    WebElementOrderChecker webElementOrderChecker =
        new WebElementOrderCheckerImpl(childWebElements);
    List<String> childIds = getIdListOfExpectedChildElements(elementIds);
    Assert.assertTrue(
        webElementOrderChecker.areWebElementsOrderedLikeSpecifiedListByElementId(childIds),
        "Elements are not in the expected order");
  }

  public void checkPageIsReady(int loopCount) throws Exception {
    WaitUtils.waitForPageToBeLoaded();
  }

  public void assertOnSubHeadingText(String subHeadingText) {
    WebElement subHeading = WebDrv.getInstance().getWebDriver().findElement(By.id("sub_heading"));
    Assert.assertEquals(subHeadingText, subHeading.getText(), "Subheading text did not match");
  }

  public void assertOnSubHeadingT(String subHeadingText) {
    WebElement subHeading =
        WebDrv.getInstance().getWebDriver().findElement(By.cssSelector(".subtext"));
    Assert.assertEquals(subHeadingText, subHeading.getText(), "Subheading text did not match");
  }

  public void assertTextShouldNotBeDisplayedInHeadingText(String headingText) {
    WebElement newHeading = WebDrv.getInstance().getWebDriver().findElement(By.id("heading"));
    Assert.assertNotEquals(
        headingText, newHeading.getText(), "Heading text should not be displayed");
  }

  public WebElement getElement(By locator) {
    return WebDrv.getInstance().getWebDriver().findElement(locator);

  }

  public void navigateTo(String url) {
    WebDrv.getInstance().getWebDriver().navigate().to(url);
    WebDrv.getInstance()
        .getWebDriver()
        .manage()
        .timeouts()
        .implicitlyWait(Duration.ofSeconds(GlobalVarsHelper.getImplicitWait()));
    WebDrv.getInstance().getWebDriver().manage().deleteAllCookies();
    WebDrv.getInstance().getWebDriver().manage().window().maximize();
    log.info("Navigated to :: " + url);
  }

  public void navigateToPage(String url) {
    WebDrv.getInstance().getWebDriver().navigate().to(url);
    WebDrv.getInstance()
        .getWebDriver()
        .manage()
        .timeouts()
        .implicitlyWait(Duration.ofSeconds(GlobalVarsHelper.getImplicitWait()));
    WebDrv.getInstance().getWebDriver().manage().window().maximize();
  }

  public void waitForElementToDisappear(By findBy) {
    WaitUtils.waitForElementToDisappear(findBy);
    log.info("Waiting for element to disappear....");
  }

  public void waitForElementToAppearBy(By findBy) {
    WaitUtils.waitForElementToBeVisible(findBy);
  }

  public void waitForWebElementToAppear(WebElement findBy) {
    WaitUtils.waitForElementToBeVisible(findBy);
  }

  public void waitAndSendKeys(WebElement findBy, String keysToSend) {
    findBy.clear();
    WaitUtils.waitForElementToBeVisible(findBy).ifPresent(element -> element.sendKeys(keysToSend));
    log.info("Waited and successfully sent keys to :: " + keysToSend);
  }

  public void waitAndClick(WebElement findBy) {
    log.info("Waiting for element to be clicked....");
    WaitUtils.waitForElementToBeClickable(findBy).ifPresent(WebElement::click);
    log.info("Successfully clicked");
  }

  public void switchWindowToChild() {
    Set<String> s1 = WebDrv.getInstance().getWebDriver().getWindowHandles();
    Iterator<String> i1 = s1.iterator();
    String parentWindow = i1.next();
    String childWindow = i1.next();
    WebDrv.getInstance().getWebDriver().switchTo().window(childWindow);
  }

  public void clickAnyElementMatchingText(
      List<WebElement> elements, Predicate<WebElement> predicate) {
    elements.stream().parallel().filter(predicate).findFirst().ifPresent(WebElement::click);
  }

  public void hoverOverCategoryNameAndClickMenuItem(
      List<WebElement> elements,
      Predicate<WebElement> predicate,
      Predicate<WebElement> predicate1) {
    elements.stream()
        .parallel()
        .filter(predicate)
        .map(ele -> new Actions(WebDrv.getInstance().getWebDriver()).moveToElement(ele))
        .findFirst()
        .ifPresent(Actions::perform);
    log.info("Hovered over a category item");
    subCategoriesDropdownList.stream().filter(predicate1).findFirst().ifPresent(WebElement::click);
    log.info("Clicked on an item from the dropdown");
  }

  public void clickAnyMatchingLinkText(List<WebElement> elements, String linkText) {
    elements.stream()
        .parallel()
        .filter(s -> s.getText().equalsIgnoreCase(linkText))
        .findFirst()
        .ifPresent(WebElement::click);
    log.info("Clicked on the link");
  }

  public void clickAnyMatchingElementByText(List<WebElement> elements, String text) {
    elements.stream()
        .parallel()
        .filter(s -> s.isDisplayed() && s.getText().equalsIgnoreCase(text))
        .findFirst()
        .ifPresent(WebElement::click);
  }

  public List<String> getAnyMatchingElementTextAttributeTagName(
      List<WebElement> elements, Function<WebElement, String> function) {
    return elements.stream()
        .parallel()
        .filter(WebElement::isDisplayed)
        .filter(WebElement::isEnabled)
        .map(function)
        .collect(Collectors.toList());
  }

  public boolean assertAnyLinkFromListOfElements(List<WebElement> listOfElements, String linkText) {
    return listOfElements.stream().parallel().anyMatch(s -> s.getText().equalsIgnoreCase(linkText));
  }

  public String getPageHeaderText() {
    return new VerificationHelper().getText(heading);
  }

  public String getPageSubHeaderText() {
    return new VerificationHelper().getText(subHeading);
  }

  public WebElement getPageBreadcrumbMenuList(String breadCrumbMenuName) {
    return allPageBreadCrumbList.stream()
        .parallel()
        .filter(e -> e.getText().contains(breadCrumbMenuName))
        .findFirst()
        .orElse(null);
  }

  public ArrayList<Integer> getPriceMassagedData(Iterator<WebElement> itr) {
    ArrayList<Integer> array = new ArrayList<>();
    itr.forEachRemaining(
        p -> {
          if (p.getText().contains("$")) {
            String actualData = p.getText().substring(1);
            int productPrice = (int) Double.parseDouble(actualData);
            array.add(productPrice);
          }
        });
    return array;
  }

  public boolean verifyArrayHasAscendingData(ArrayList<Integer> array) {
    for (int i = 0; i < array.size() - 1; i++) {
      if (array.get(i) <= array.get(i + 1)) {
        log.info("obj.get(i).." + array.get(i));
        log.info("obj.get(i+1).." + array.get(i + 1));
      } else {
        log.info("Price filter is not working");
        return false;
      }
    }
    return true;
  }

  public void moveToElementAndClick(WebElement element, long durationInSeconds) {
    WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
    new Actions(WebDrv.getInstance().getWebDriver())
        .moveToElement(webElement)
        .click()
        .build()
        .perform();
    log.info("Moved to element and clicked");
  }

  public void moveToElement(WebElement element) {
    WebElement webElement = waitForVisibilityOfElement(element, GlobalVarsHelper.explicitWait);
    new Actions(WebDrv.getInstance().getWebDriver()).moveToElement(webElement).build().perform();
  }

  public WebElement waitForVisibilityOfElement(WebElement element, long durationInSeconds) {
    return WaitUtils.waitForElementToBeVisible(element).orElse(null);
  }

  public void waitForElementInvisible(WebElement element) {
    WaitUtils.waitForElementToDisappear(element);
    log.info("Element is now invisible");
  }

  public void clickAnItemFromListByText(List<WebElement> elements, String itemText) {
    elements.stream()
        .parallel()
        .filter(e -> e.getText().equalsIgnoreCase(itemText))
        .findFirst()
        .ifPresent(WebElement::click);
    log.info("Clicked on the product");
  }

  public void clickAnElementMatchingText(List<WebElement> elements, String itemText) {
    elements.stream()
        .parallel()
        .filter(e -> e.getText().equalsIgnoreCase(itemText))
        .findFirst()
        .ifPresent(WebElement::click);
    log.info("Clicked on the item");
  }

  public void selectDropDownByIndexOrTextOrValue(Object o, WebElement countryDropdownBtn) {
    Select select = new Select(countryDropdownBtn);
    if (o instanceof Integer) {
      select.selectByIndex((int) o);
    } else if (o instanceof String) {
      select.selectByVisibleText((String) o);
    } else if (o instanceof WebElement) {
      select.selectByVisibleText(((WebElement) o).getText());
    } else {
      log.error("Invalid input for dropdown selection");
    }
  }

  public void selectFromTheDropdown(Consumer<Select> consumer, WebElement element) {
    consumer.accept(new Select(element));
  }

  public void click(By xpath, WaitStrategy clickable) {
    WebElement element =
        switch (clickable) {
          case CLICKABLE ->
              WaitUtils.waitForElementToBeClickable(xpath)
                  .orElseThrow(() -> new NoSuchElementException("Element not clickable: " + xpath));
          case PRESENCE ->
              WaitUtils.waitForElementToBePresent(xpath)
                  .orElseThrow(() -> new NoSuchElementException("Element not present: " + xpath));
          case VISIBLE ->
              WaitUtils.waitForElementToBeVisible(xpath)
                  .orElseThrow(() -> new NoSuchElementException("Element not visible: " + xpath));
          default -> throw new IllegalArgumentException("Invalid wait strategy: " + clickable);
        };
    element.click();
  }

  public void sendKeys(By locator, String fieldName, WaitStrategy presence) {
    WebElement element =
        switch (presence) {
          case PRESENCE ->
              WaitUtils.waitForElementToBePresent(locator)
                  .orElseThrow(() -> new NoSuchElementException("Element not present: " + locator));
          case VISIBLE ->
              WaitUtils.waitForElementToBeVisible(locator)
                  .orElseThrow(() -> new NoSuchElementException("Element not visible: " + locator));
          default -> throw new IllegalArgumentException("Invalid wait strategy: " + presence);
        };
    element.sendKeys(fieldName);
  }

  public void clickOnContinueBtn() {
    // continueBtn.click();
    WaitUtils.waitForElementToBeClickable(continueBtn)
        .orElseThrow(() -> new NoSuchElementException("Continue button not clickable"));
  }

  public void scrollToElementWaitUntilDisplayedAndClick(WebElement element) {
    try {
      new JavaScriptHelper().scrollIntoView(element);
      WaitUtils.waitForElementToBeVisible(element).ifPresent(WebElement::click);
    } catch (Exception e) {
      log.error("Error while scrolling to element and clicking: ", e);
    }
  }

  public void inputFieldValue(String fieldName, String fieldValue) {
    WebElement fieldElement = WebDrv.getInstance().getWebDriver().findElement(By.name(fieldName));
    fieldElement.clear();
    fieldElement.sendKeys(fieldValue);
  }

  public void assertOnHeadingText(String expectedHeadingText) {
    WebElement headingElement = WebDrv.getInstance().getWebDriver().findElement(By.id("heading"));
    String actualHeadingText = headingElement.getText().trim();
    Assert.assertEquals(
        actualHeadingText,
        expectedHeadingText,
        "The page heading text did not match the expected value.");
  }

  public void assertErrorMessage(String errorMessage) {
    WebElement errorMessageElement =
        WebDrv.getInstance().getWebDriver().findElement(By.cssSelector(".error-message"));
    String actualErrorMessage = errorMessageElement.getText().trim();
    Assert.assertEquals(
        actualErrorMessage, errorMessage, "The error message did not match the expected value.");
  }

  // New methods using Selenium 4 features

  public WebElement findElementUsingRelativeLocator(By baseLocator, By relativeLocator) {
    WebElement baseElement = getElement(baseLocator);
    return WebDrv.getInstance()
        .getWebDriver()
        .findElement(RelativeLocator.with(relativeLocator).below(baseElement));
  }

  public List<WebElement> findElementsUsingRelativeLocator(By baseLocator, By relativeLocator) {
    WebElement baseElement = getElement(baseLocator);
    return WebDrv.getInstance()
        .getWebDriver()
        .findElements(RelativeLocator.with(relativeLocator).below(baseElement));
  }

  public String getCssValueOfElement(WebElement element, String cssProperty) {
    return element.getCssValue(cssProperty);
  }

  public List<String> getCssValuesOfElements(List<WebElement> elements, String cssProperty) {
    return elements.stream()
        .map(element -> element.getCssValue(cssProperty))
        .collect(Collectors.toList());
  }

  public void takeScreenshot(String filePath) {
    TakesScreenshot screenshot = (TakesScreenshot) WebDrv.getInstance().getWebDriver();
    File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
    File destFile = new File(filePath);
    try {
      FileUtils.copyFile(srcFile, destFile);
    } catch (IOException e) {
      log.error("Error while taking screenshot: ", e);
    }
  }

  public void openNewTab() {
    ((JavascriptExecutor) WebDrv.getInstance().getWebDriver()).executeScript("window.open()");
    switchToNewTab();
  }

  public void switchToNewTab() {
    ArrayList<String> tabs =
        new ArrayList<>(WebDrv.getInstance().getWebDriver().getWindowHandles());
    WebDrv.getInstance().getWebDriver().switchTo().window(tabs.get(tabs.size() - 1));
  }

  public void switchToTab(int index) {
    ArrayList<String> tabs =
        new ArrayList<>(WebDrv.getInstance().getWebDriver().getWindowHandles());
    WebDrv.getInstance().getWebDriver().switchTo().window(tabs.get(index));
  }

  public void closeCurrentTab() {
    WebDrv.getInstance().getWebDriver().close();
    switchToTab(0);
  }

  public Boolean verifyElementIsDisplayed(List<WebElement> elements, String productName) {
    return elements.stream().parallel().anyMatch(el -> el.getText().equalsIgnoreCase(productName));
  }

  public Boolean verifyElementIsEnabled(List<WebElement> elements, String productName) {
    return elements.stream()
        .parallel()
        .anyMatch(el -> el.getText().equalsIgnoreCase(productName) && el.isEnabled());
  }

  public boolean doesThePageHaveValidationErrors() {
    WebElement errorMessageElement =
        WebDrv.getInstance().getWebDriver().findElement(By.cssSelector(".error-message"));
    return errorMessageElement.isDisplayed();
  }

  public void addProductToCart(String item) {
    WebElement addToCart =
        WebDrv.getInstance()
            .getWebDriver()
            .findElement(By.cssSelector(String.format("a.prdocutname[title='%s']", item)));
    addToCart.click();
  }

  public void iHoverOverCategoryNameAndClickMenuItem(
      List<WebElement> categorymenuList, Object o, Object o1) {
    if (o instanceof WebElement) {
      Actions actions = new Actions(WebDrv.getInstance().getWebDriver());
      actions.moveToElement((WebElement) o).perform();
    } else if (o instanceof String) {
      categorymenuList.stream()
          .parallel()
          .filter(el -> el.getText().equalsIgnoreCase((String) o))
          .findFirst()
          .ifPresent(WebElement::click);
    } else {
      log.error("Invalid input for hovering over category menu");
    }
  }

  public void addProductsToCart(String item) {
    WebElement addToCart =
        WebDrv.getInstance()
            .getWebDriver()
            .findElement(By.cssSelector(String.format("a.prdocutname[title='%s']", item)));
    addToCart.click();
    WebElement addToCart2 =
        WebDrv.getInstance()
            .getWebDriver()
            .findElement(By.cssSelector(String.format("a.prdocutname[title='%s']", item)));
    addToCart2.click();
  }

  public void ScrollToElementWaitUntilDisplayedAndClick(WebElement aboutUs) {
    try {
      JavascriptExecutor js = (JavascriptExecutor) WebDrv.getInstance().getWebDriver();
      js.executeScript("arguments[0].scrollIntoView(true);", aboutUs);
      WaitUtils.waitForElementToBeVisible(aboutUs).ifPresent(WebElement::click);
    } catch (Exception e) {
      log.error("Error while scrolling to element and clicking: ", e);
    }
  }

  public void iHoverOverProductCategoryMenuAndClickAMenuItem(String categoryName, String menuItem) {
    WebElement categoryMenu =
        WebDrv.getInstance()
            .getWebDriver()
            .findElement(
                By.cssSelector(
                    String.format("a.dropdown-toggle[data-target='#%s']", categoryName)));
    Actions actions = new Actions(WebDrv.getInstance().getWebDriver());
    actions.moveToElement(categoryMenu).perform();
    WebElement menuItemElement =
        WebDrv.getInstance()
            .getWebDriver()
            .findElement(By.cssSelector(String.format("a[href='#%s']", menuItem)));
    menuItemElement.click();
  }

  public void mouseOverListOfElementByText(List<WebElement> elements, String text) {
    WebElement element =
        elements.stream()
            .parallel()
            .filter(e -> e.getText().equalsIgnoreCase(text))
            .findFirst()
            .orElseThrow(
                () -> new NoSuchElementException("Element with text '" + text + "' not found"));

    Actions actions = new Actions(WebDrv.getInstance().getWebDriver());
    actions.moveToElement(element).perform();
    log.info("Mouse over performed on element with text: " + text);
  }

  public boolean isLogoPresent() {
    return new VerificationHelper().isDisplayed(logo);
  }

  public boolean isPoweredTextPresent(String poweredText) {
    return new VerificationHelper().isDisplayed(poweredTextElement);
  }


  public boolean isPromoAdvertPresent() {
    return new VerificationHelper().isDisplayed(promoAdvert);
  }

  public boolean isProductPresent(String productName) {
    return new VerificationHelper().isDisplayed((WebElement) By.cssSelector(String.format("a.prdocutname[title='%s']", productName)));
  }
}
