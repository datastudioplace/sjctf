package com.localhost8888.pages;

import com.localhost8888.helperutilities.assertion.VerificationHelper;
import com.localhost8888.helperutilities.wait.WaitUtils;
import com.localhost8888.webdriverutilities.WebDrv;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
  private static final Logger log = LogManager.getLogger(SearchPage.class);
  private final VerificationHelper verificationHelper;

  @FindBy(css = "li.search-category")
  private List<WebElement> suggestions;

  @FindBy(css = "#filter_keyword")
  private WebElement searchBox;

  @FindBy(css = "li.search-category")
  private List<WebElement> searchCategoryOptions;

  @FindBy(css = "i.fa.fa-search")
  private WebElement searchButton;

  public SearchPage() {
    this.verificationHelper = new VerificationHelper();
    PageFactory.initElements(WebDrv.getInstance().getWebDriver(), this);
  }

  public boolean isSearchButtonDisplayedAndEnabled() {
    return verificationHelper.isDisplayed(searchButton) && searchButton.isEnabled();
  }

  public void clickSuggestionByIndex(int index) {
    WaitUtils.waitForElementsToBeVisible(suggestions)
            .ifPresent(elements -> elements.get(index - 1).click());
  }

  public boolean isDisplayed() {
    return WaitUtils.waitForElementToBeVisible(searchBox)
            .map(element -> WaitUtils.waitForElementsToBeVisible(suggestions)
                    .map(elements -> elements.size() > 7)
                    .orElse(false))
            .orElse(false);
  }

  public void clickSearchButton() {
    WaitUtils.waitAndClick(searchButton);
  }

  public void clickOnSearchField() {
    WaitUtils.waitAndClick(searchBox);
  }

  public boolean isDropdownListVisible() {
    WaitUtils.waitForElementsToBeVisible(searchCategoryOptions)
            .ifPresent(elements -> elements.forEach(System.out::println));
    List<String> list =
            Collections.singletonList(
                    searchCategoryOptions.stream()
                            .map(s -> s.getText().toLowerCase())
                            .findFirst()
                            .orElse(null));
    System.out.println(list);
    return WaitUtils.waitForElementsToBeVisible(searchCategoryOptions)
            .map(elements -> elements.size() > 6)
            .orElse(false);
  }

  public long dropdownListCount() {
    return WaitUtils.waitForElementsToBeVisible(searchCategoryOptions).map(List::size).orElse(0);
  }

  public void enterSearchKeyword(String keyword) {
    WaitUtils.waitForElementToBeVisible(searchBox)
            .ifPresent(
                    element -> {
                      element.clear();
                      element.sendKeys(keyword);
                    });
  }

  public void enter(String keyword) {
    WaitUtils.waitForElementToBeVisible(searchBox)
            .ifPresent(
                    element -> {
                      element.clear();
                      for (char ch : keyword.toCharArray()) {
                        Uninterruptibles.sleepUninterruptibly(20, TimeUnit.MILLISECONDS);
                        element.sendKeys(ch + "");
                      }
                    });
  }

  public SearchResultPage navigateToSearchResultPage() {
    WaitUtils.waitAndClick(searchButton);
    return new SearchResultPage();
  }

  public boolean assertSearchBoxIsDisplayed() {
    return verificationHelper.isDisplayed(searchBox);
  }

  public boolean isSearchBoxEnabledAndVisible() {
    return WaitUtils.waitForElementToBeVisible(searchBox)
            .map(element -> element.isDisplayed() && searchBox.isEnabled())
            .orElse(false);
  }
}