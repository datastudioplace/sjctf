package com.localhost8888.pages;

import com.localhost8888.webdriverutilities.WebDrv;
import com.google.common.util.concurrent.Uninterruptibles;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchWidgetPage {
  private static final Logger log = LogManager.getLogger(SearchWidgetPage.class);
  Page page;

  @FindBy(id = "filter_keyword")
  private WebElement searchBox;

  @FindBy(css = ".fa.fa-search")
  private WebElement searchButton;

  @FindBy(css = ".search-category")
  private List<WebElement> searchCategoryList;

  public void enterSearchKeyword(String SearchKeyword) {
    searchBox.clear();
    searchBox.sendKeys(SearchKeyword);
    log.info("Entering search");
  }

  public SearchResultPage clickSearchButton() throws IOException {
    searchButton.click();
    log.info("Clicked search button");
    return new SearchResultPage();
  }

  public SearchResultPage searchWithValidSearchKeyword(String validProductSearchKeyword)
      throws IOException {
    enterSearchKeyword(validProductSearchKeyword);
    searchButton.click();
    return new SearchResultPage();
  }

  public SearchResultPage SearchWithInvalidKeyword(String invalidKeyword) throws IOException {
    enterSearchKeyword(invalidKeyword);
    searchButton.click();
    return new SearchResultPage();
  }

  public List<WebElement> getSearchCategoryList() {
    return new WebDriverWait(WebDrv.getInstance().getWebDriver(), Duration.ofSeconds(15))
        .until(ExpectedConditions.visibilityOfAllElements(searchCategoryList));
  }

  public void clickItemFromSearchCategoryList(String categoryName) {
    searchBox.click();
    WebElement categoryItem =
        getSearchCategoryList().stream()
            .parallel()
            .filter(s -> s.getText().equalsIgnoreCase(categoryName))
            .findFirst()
            .orElse(null);
    categoryItem.click();
    log.info(categoryItem.getText());
  }

  public void enter(String keyword) {
    this.searchBox.clear();
    for (char ch : keyword.toCharArray()) {
      Uninterruptibles.sleepUninterruptibly(20, TimeUnit.MILLISECONDS);
      this.searchBox.sendKeys(ch + "");
    }
  }
}
