package com.localhost8888.cucumber.stepDefinitions.general;

import com.localhost8888.pagecollections.CandidatePageCollection;
import com.localhost8888.pages.Page;
import com.localhost8888.pages.general.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Map;

public class ContentCorrectnessSteps {

  @When("^there should be hint text against the fields as described in the table below$")
  public void there_should_be_hint_text_against_the_fields_as_described_in_the_table_below(
      Map<String, String> fieldValues) throws Throwable {
    TextualContentPage page = (TextualContentPage) CandidatePageCollection.getCurrentPage();
    page.assertCorrectTextualContentOnFields(fieldValues);
  }

  @Then("^I should view my name \"([^\"]*)\" at the top right hand side of the candidate page$")
  public void i_should_view_my_name_at_the_top_right_hand_side_of_the_page(String username)
      throws Throwable {
    TopRightNamePage topRightNamePage = (TopRightNamePage) CandidatePageCollection.getCurrentPage();
    topRightNamePage.assertOnUserName(username);
  }

  @Then("^there should be a button that says \"([^\"]*)\"$")
  public void there_should_be_a_button_that_says(String expectedButtonTitle) throws Throwable {
    ButtonPage buttonPage = (ButtonPage) CandidatePageCollection.getCurrentPage();
    buttonPage.assertCorrectButtonTitle(expectedButtonTitle);
  }

  @When("^there should be an expandable link called \"([^\"]*)\"$")
  public void there_should_be_an_expandable_link_called(String expectedLinkName) throws Throwable {
    LinkPage linkPage = (LinkPage) CandidatePageCollection.getCurrentPage();
    linkPage.assertCorrectLinkTitle(expectedLinkName);
  }

  @Then(
      "^the link should expand on the candidate page and I should see the following content \"([^\"]*)\"$")
  public void the_link_should_expand_on_the_candidate_page_and_I_should_see_the_following_content(
      String expectedExpandedContent) throws Throwable {
    ExpandableLinkPage linkPage = (ExpandableLinkPage) CandidatePageCollection.getCurrentPage();
    linkPage.assertCorrectExpandedContent(expectedExpandedContent);
  }

  @Then(
      "^the link should expand on the \"([^\"]*)\" candidate page and I should see the following content \"([^\"]*)\"$")
  public void the_link_should_expand_on_the_candidate_page_and_I_should_see_the_following_content(
      String pageName, String expectedExpandedContent) throws Throwable {
    the_link_should_expand_on_the_candidate_page_and_I_should_see_the_following_content(
        expectedExpandedContent);
  }

  @Then("^I should see a \"([^\"]*)\"$")
  public void i_should_see_a(String elementName) throws Throwable {
    ElementPage elementPage = (ElementPage) CandidatePageCollection.getCurrentPage();
    elementPage.assertElementIsDisplayed(elementName, true);
  }

  @Then("^I should not see a \"([^\"]*)\"$")
  public void i_should_not_see_a(String elementName) throws Throwable {
    ElementPage elementPage = (ElementPage) CandidatePageCollection.getCurrentPage();
    elementPage.assertElementIsDisplayed(elementName, false);
  }

  @Then("^I should see the heading \"([^\"]*)\"$")
  public void i_should_see_the_heading(String heading) throws Throwable {
    Page page = CandidatePageCollection.getCurrentPage();
    page.assertOnHeadingText(heading);
  }

  @Then("^I should be signed in with my name \"([^\"]*)\" on the top right hand of the page$")
  public void i_should_be_signed_in_with_my_name_on_the_top_right_hand_of_the_page(String name)
      throws Throwable {
    UserNamePage usernamePage = (UserNamePage) CandidatePageCollection.getCurrentPage();
    usernamePage.assertCorrectUsername(name);
  }
}
