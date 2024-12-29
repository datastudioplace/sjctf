package com.localhost8888.pages;

import static java.util.concurrent.TimeUnit.MINUTES;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

import com.localhost8888.helperutilities.assertion.VerificationHelper;
import com.localhost8888.helperutilities.select.DropDownHelper;
import com.localhost8888.helperutilities.wait.WaitUtils;
import com.localhost8888.webdriverutilities.WebDrv;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

  private static final Logger log = LogManager.getLogger(SearchResultPage.class);
  private final VerificationHelper verificationHelper;
  private final Page page;
  private final WebDriver driver;

  @FindBy(css = ".col-md-3.col-sm-6.col-xs-12")
  private List<WebElement> searchResultFound;

  @FindBy(css = ".prdocutname")
  private List<WebElement> productTitleList;

  @FindBy(id = "keyword")
  private WebElement searchBox;

  @FindBy(css = "#keyword")
  private WebElement searchCriteriaAttributeValue;

  @FindBy(xpath = "//select[@id='category_id']")
  private WebElement allCategoriesDropdown;

  @FindBy(id = "/html/body/div/div[2]/div/div/div/div/div[1]/fieldset/div[2]/div/select/option")
  private List<WebElement> allSubCategoriesDropdownList;

  @FindBy(css = "label[for='description']")
  private WebElement searchProductDescriptionsRadioButton;

  @FindBy(css = "label[for='model']")
  private WebElement searchProductModelRadioButton;

  @FindBy(css = "label[for='price']")
  private WebElement searchProductPriceRadioButton;

  @FindBy(css = "#search_button")
  private WebElement searchButton;

  @FindBy(css = "label[for='viewed']")
  private WebElement searchProductViewedRadioButton;

  @FindBy(xpath = "//h4[normalize-space()='search Criteria']")
  private WebElement searchCriteriaText;

  @FindBy(xpath = "//h4[normalize-space()='Products meeting the search criteria']")
  private WebElement productsMeetingSearchCriteriaText;

  @FindBy(css = "label[for='model']")
  private WebElement searchProductModelRadioButtonLabel;

  @FindBy(xpath = "//div[contains(text(),'There is no product that matches the search criter')]")
  private WebElement noSearchResultFoundText;

  @FindBy(css = "option[value='date_modified-ASC']")
  private WebElement dateOldNew;

  @FindBy(css = ".fa.fa-th-list.icon-white")
  private WebElement listIconWhiteIcon;

  @FindBy(css = ".fa.fa-th")
  private WebElement listGridIcon;

  @FindBy(xpath = "/html/body/div/div[2]/div/div/div/div/div[1]/form/select/option")
  private List<WebElement> sortByDropdownList;

  @FindBy(id = "sort")
  private WebElement sortByDropdown;

  @FindBy(css = "select#limit")
  private WebElement perPageDropdown;

  @FindBy(xpath = "/html/body/div/div[2]/div/div/div/div/div[5]/form/select/option")
  private List<WebElement> perPageDropdownList;

  @FindBy(xpath = "i.fa.fa-cart-plus.fa-fw")
  private List<WebElement> addToCartButtonList;

  @FindBy(xpath = "(//a[@title='Add to Cart'])")
  private WebElement addToCartButton;

  @FindBy(css = "span.nostock")
  private List<WebElement> outOfStockButtons;

  @FindBy(xpath = "/html/body/div/div[2]/div/div/div/div/div/div/div/div/div/div")
  private List<WebElement> onePriceList;

  @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[5]/form[1]")
  private WebElement perPageSearchResultCount;

  @FindBy(css = "form[class='form-inline pull-left']")
  private WebElement perPageSearchResultCountRange;

  public SearchResultPage() {
    this.verificationHelper = new VerificationHelper();
    this.page = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), Page.class);
    this.driver = WebDrv.getInstance().getWebDriver();
    PageFactory.initElements(driver, this);
  }

  public void clickPerPageDropdown() {
    WaitUtils.waitAndClick(perPageDropdown);
  }

  public List<WebElement> perPageDropdownList() {
    return WaitUtils.waitForElementsToBeVisible(perPageDropdownList)
            .orElseThrow(() -> new RuntimeException("Per page dropdown list not found"));
  }

  public void addToCart() {
    WaitUtils.waitAndClick(addToCartButton);
    log.info("Product added to cart successfully");
  }

  public boolean isProductExist(String productName) {
    return WaitUtils.waitForElementsToBeVisible(searchResultFound)
            .map(
                    elements ->
                            elements.stream()
                                    .anyMatch(product -> product.getDomAttribute("title").equals(productName)))
            .orElse(false);
  }

  public void selectProduct(String productName) {
    WaitUtils.waitForElementsToBeVisible(searchResultFound)
            .flatMap(
                    elements ->
                            elements.stream()
                                    .filter(product -> Objects.equals(product.getDomAttribute("title"), productName))
                                    .findFirst())
            .ifPresent(WebElement::click);
  }

  public void waitForTheSearchResult() {
    await()
            .atMost(15, MINUTES)
            .pollDelay(5, SECONDS)
            .pollInterval(5, SECONDS)
            .until(
                    () -> {
                      searchButton.click();
                      return searchResultFound.get(0).getText().equalsIgnoreCase("1");
                    });
  }

  public WebElement getSearchBox() {
    return searchBox;
  }

  public WebElement getAllCategoriesDropdown() {
    return allCategoriesDropdown;
  }

  public List<WebElement> getAllSubCategoriesDropdownList() {
    return allSubCategoriesDropdownList;
  }

  public void clickSearchProductDescriptionsRadioButton() {
    WaitUtils.waitAndClick(searchProductDescriptionsRadioButton);
  }

  public String getSearchProductDescriptionsRadioButtonLabel() {
    return verificationHelper.getText(searchProductDescriptionsRadioButton);
  }

  public void clickSearchProductModelRadioButton() {
    WaitUtils.waitAndClick(searchProductModelRadioButton);
  }

  public void clickSearchProductPriceRadioButton() {
    WaitUtils.waitAndClick(searchProductPriceRadioButton);
  }

  public String getSearchProductPriceRadioButton() {
    return verificationHelper.getText(searchProductPriceRadioButton);
  }

  public String getSearchButton() {
    return verificationHelper.getText(searchButton);
  }

  public void clickSearchButton() {
    WaitUtils.waitAndClick(searchButton);
  }

  public void clickSearchProductViewedRadioButton() {
    WaitUtils.waitAndClick(searchProductViewedRadioButton);
  }

  public String getSearchProductViewedRadioButtonText() {
    return verificationHelper.getText(searchProductViewedRadioButton);
  }

  public String getSearchCriteriaText() {
    return verificationHelper.getText(searchCriteriaText);
  }

  public String getSearchCriteriaAttributeValue() {
    return searchCriteriaAttributeValue.getDomAttribute("value");
  }

  public boolean assertSearchCriteriaTextIsDisplayed() {
    return verificationHelper.isDisplayed(searchCriteriaText);
  }

  public boolean assertProductsMeetingSearchCriteriaTextIsDisplayed() {
    return verificationHelper.isDisplayed(productsMeetingSearchCriteriaText);
  }

  public String getProductsMeetingSearchCriteriaText() {
    return verificationHelper.getText(productsMeetingSearchCriteriaText);
  }

  public boolean assertSearchProductModelRadioButtonLabel() {
    return verificationHelper.isDisplayed(searchProductModelRadioButtonLabel);
  }

  public String getSearchProductModelRadioButtonLabel() {
    return verificationHelper.getText(searchProductModelRadioButtonLabel);
  }

  public void clickListIconWhiteIcon() {
    WaitUtils.waitAndClick(listIconWhiteIcon);
  }

  public boolean assertListIconWhiteIconIsDisplayed() {
    return verificationHelper.isDisplayed(listIconWhiteIcon);
  }

  public boolean assertListGridIconIsDisplayed() {
    return verificationHelper.isDisplayed(listGridIcon);
  }

  public void clickListGridIcon() {
    WaitUtils.waitAndClick(listGridIcon);
    log.info("List grid icon clicked successfully");
  }

  public List<WebElement> getSortByDropdownList() {
    return sortByDropdownList;
  }

  public String getSortByDropdownDateOldNewText() {
    return verificationHelper.getText(dateOldNew);
  }

  public boolean assertSortByDropdownItemIsSelected() {
    return verificationHelper.isSelected(dateOldNew);
  }

  public boolean assertSortByDropdownDefaultItemIsSelected(String dateOldNewText) {
    new DropDownHelper().selectUsingVisibleText(sortByDropdown, dateOldNewText);
    return true;
  }

  public boolean assertSortByDropdownIsDisplayed() {
    return verificationHelper.isDisplayed(sortByDropdown);
  }

  public void clickSortByDropdownButton() {
    WaitUtils.waitAndClick(sortByDropdown);
  }

  public boolean assertPerPageDropdownIsDisplayed() {
    return verificationHelper.isDisplayed(perPageDropdown);
  }

  public WebElement getPerPageDropdown() {
    return perPageDropdown;
  }

  public List<WebElement> getPerPageDropdownList() {
    return perPageDropdownList;
  }

  public List<WebElement> getAddToCartButtonList() {
    return addToCartButtonList;
  }

  public boolean assertAddToCartButtonIsDisplayed() {
    return verificationHelper.isDisplayed(addToCartButton);
  }

  public void clickAddToCartButton() {
    WaitUtils.waitAndClick(addToCartButton);
  }

  public List<WebElement> getOutOfStockButtons() {
    return outOfStockButtons;
  }

  public List<WebElement> getOnePriceList() {
    return onePriceList;
  }

  public void assertProductName(String productTitle) {}

  public void assertProductTitle() {}

  public String getNoSearchResultFoundText() {
    return verificationHelper.getText(noSearchResultFoundText);
  }

  public List<String> getSearchResultProductFound() {
    return productTitleList.stream()
            .parallel()
            .filter(WebElement::isDisplayed)
            .map(WebElement::getText)
            .collect(Collectors.toList());
  }

  public long getSearchResultProductFoundCount() {
    return productTitleList.stream().parallel().filter(WebElement::isDisplayed).count();
  }

  public boolean assertNoSearchResultFoundTextIsDisplayed() {
    return verificationHelper.isDisplayed(noSearchResultFoundText);
  }

  public int getProductResultCount() {
    return searchResultFound.size();
  }

  public void selectSortByDropdownItems(String sortBy) {
    new DropDownHelper().selectUsingVisibleText(sortByDropdown, sortBy);
  }

  public void selectItemsFromAllCategories() {
    WaitUtils.waitAndClick(allCategoriesDropdown);
    new DropDownHelper().selectUsingVisibleText(sortByDropdown, "All Categories");
  }

  public void selectSearchCriteriaAllCategoriesByText(String categoryText) {
    new DropDownHelper().selectUsingVisibleText(allCategoriesDropdown, categoryText);
  }

  public String getSearchResultProductFoundCountInPagination() {
    return verificationHelper.getText(perPageSearchResultCount);
  }

  public boolean isProductInSearchResultsRelevantToTheSearchKeyword(String searchKeyword) {
    return productTitleList.stream()
            .anyMatch(product -> product.getText().toLowerCase().contains(searchKeyword.toLowerCase()));
  }

  public boolean verifySearchResultsContainKeyword(String keyword) {
    return productTitleList.stream()
            .anyMatch(product -> product.getText().toLowerCase().contains(keyword.toLowerCase()));
  }
}