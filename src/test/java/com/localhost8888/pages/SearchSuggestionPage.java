package com.localhost8888.pages;

import com.localhost8888.helperutilities.wait.WaitUtils;
import com.localhost8888.webdriverutilities.WebDrv;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchSuggestionPage {
  private static final Logger log = LogManager.getLogger(SearchSuggestionPage.class);
  private final Page page;

  @FindBy(css = "li.search-category")
  private List<WebElement> suggestions;

  public SearchSuggestionPage() {
    this.page = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), Page.class);
    PageFactory.initElements(WebDrv.getInstance().getWebDriver(), this);
  }

  public void clickSuggestionByIndex(int index) {
    WaitUtils.waitForElementsToBeVisible(suggestions)
            .ifPresent(elements -> {
              log.info("Clicking on suggestion at index: " + index);
              elements.get(index - 1).click();
            });
  }

  public void clickSuggestionByText(String text) {
    WaitUtils.waitForElementsToBeVisible(suggestions)
            .ifPresent(elements -> {
              for (WebElement suggestion : elements) {
                if (suggestion.getText().equalsIgnoreCase(text)) {
                  log.info("Clicking on suggestion with text: " + text);
                  suggestion.click();
                  return;
                }
              }
              throw new RuntimeException("Unable to find suggestion with text: " + text);
            });
  }

  public boolean isDisplayed() {
    return WaitUtils.waitForElementsToBeVisible(suggestions)
            .map(elements -> {
              boolean isDisplayed = !elements.isEmpty();
              log.info("Suggestions are displayed: " + isDisplayed);
              return isDisplayed;
            })
            .orElse(false);
  }
}