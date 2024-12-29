package com.localhost8888.cucumber.stepDefinitions.general;

import com.localhost8888.helperutilities.GlobalVarsHelper;
import com.localhost8888.helperutilities.assertors.HyperlinkAssertor;
import com.localhost8888.maps.PageHeadings;
import com.localhost8888.pages.Page;
import com.localhost8888.webdriverutilities.WebDrv;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NavigationSteps {

  private String determineWhetherBaseUrlIsForCandidateOrEmployer(String route) {
    String baseUrl;

    if (route.contains("?rt=account/login")) {
      baseUrl = GlobalVarsHelper.getInstance().getLoginURL();
    } else {
      baseUrl = GlobalVarsHelper.getInstance().getURL();
    }

    return baseUrl;
  }

  @Then("^I should be navigated on to the \"([^\"]*)\" candidate page$")
  public void should_be_navigated_on_to_the_candidate_page(String pageName) throws Throwable {
    Page page = new Page();
    page.assertOnHeadingText(PageHeadings.getHeadingForPage(pageName));
  }

  // this method is used in error validation scenarios to ensure that the user
  // stays on a page after receiving an error and trying to navigate away from pg
  @Then("^I should stay on the \"([^\"]*)\" candidate page$")
  public void should_stay_on_the_candidate_page(String pageName) throws Throwable {
    Assert.assertEquals(
        PageHeadings.getHeadingForPage(pageName),
        "The navigation to the next page has succeeded even though it should have remained on the current page due to the expected error.",
        WebDrv.getInstance().getWebDriver().findElement(By.id("heading")).getText());
  }

  // This method is used for checking for correct subsequent navigation to pages
  // using save+continue and
  // back button
  @Then("^I should land on to the \"([^\"]*)\" candidate page$")
  public void should_land_on_to_the_page(String pageName) throws Throwable {
    // CandidatePageCollection.getCurrentPage().assertOnHeadingText(PageHeadings.getHeadingForPage(pageName));
  }

  @Given(
      "^I have entered the following details on the \"([^\"]*)\" candidate page and click save and comeback later$")
  public void
      i_have_entered_the_following_details_on_the_candidate_page_and_click_save_and_comeback_later(
          String pageName, DataTable testdata) throws Throwable {
    List<List<String>> data = testdata.cells();

    FieldInputSteps fieldInputSteps = new FieldInputSteps();

    for (int i = 0; i < data.size(); i++) {
      Map<String, String> fieldValues = new HashMap<String, String>();
      fieldValues.put(data.get(i).get(0), data.get(i).get(1));
      fieldInputSteps.i_have_entered_the_following_details_on_the_candidate_page(
          pageName, fieldValues);

      // i_click_save_and_comeback_later_button_on_the_candidate_page(pageName);
      should_stay_on_the_candidate_page(pageName);
    }
  }

  @Then("^the page title should be \"([^\"]*)\"$")
  public void the_page_title_should_be(String pageTitle) {
    HyperlinkAssertor.assertNewTabOpenedWithExpectedTitle(pageTitle);
  }

  public void clickContinueButton() {
    Page page = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), Page.class);
    page.clickOnContinueButton();
  }
}
