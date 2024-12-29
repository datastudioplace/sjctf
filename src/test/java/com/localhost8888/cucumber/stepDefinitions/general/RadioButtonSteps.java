package com.localhost8888.cucumber.stepDefinitions.general;

import com.localhost8888.helperutilities.UserFieldDataPageModelContainerUtils;
import com.localhost8888.pagecollections.CandidatePageCollection;
import com.localhost8888.pages.general.RadioButtonPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.HashMap;
import java.util.Map;

public class RadioButtonSteps {

  @When("^I select the \"([^\"]*)\" radio button on the candidate page$")
  public void i_select_the_radio_button_on_the_candidate_page(String radioButton, String pageName)
      throws Throwable {
    RadioButtonPage page = (RadioButtonPage) CandidatePageCollection.getCurrentPage();
    Map<String, String> radioButtonData = new HashMap<>();
    radioButtonData.put("Radio button Selection", radioButton);
    UserFieldDataPageModelContainerUtils.registerFieldDataModelForPage(pageName, radioButtonData);
    page.clickOnRadioButton(radioButton);
  }

  @When("^I select the \"([^\"]*)\" radio button on the \"([^\"]*)\" candidate page$")
  @Then("^I select \"([^\"]*)\" on the \"([^\"]*)\" candidate page$")
  public void i_select_the_radio_button_on_the_specific_candidate_page(
      String radioButton, String pageName) throws Throwable {
    i_select_the_radio_button_on_the_candidate_page(radioButton, pageName);
  }

  @When("^I do not select 'yes' or 'no'$")
  public void i_do_not_select_yes_or_no() throws Throwable {}
}
