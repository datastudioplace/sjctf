package com.localhost8888.cucumber.stepDefinitions.general;

import com.localhost8888.pagecollections.CandidatePageCollection;
import com.localhost8888.pages.general.BreadCrumbAboveHeadingPage;
import com.localhost8888.pages.general.MessageBelowHeadingPage;
import io.cucumber.java.en.Then;
import java.util.List;

public class WebElementOrderingSteps {

  @Then("^the \"([^\"]*)\" bread Crumb should be above the heading$")
  public void the_job_title_should_be_above_the_heading(String breadCrumb) throws Throwable {
    BreadCrumbAboveHeadingPage page =
        (BreadCrumbAboveHeadingPage) CandidatePageCollection.getCurrentPage();
    page.assertBreadCrumbIsAboveHeading(breadCrumb);
  }

  @Then("^there should be content beneath the heading which says \"([^\"]*)\"$")
  public void
      there_should_be_content_beneath_the_heading_which_says_Enter_the_email_address_you_used_to_sign_up_with(
          String expectedMessage) throws Throwable {
    MessageBelowHeadingPage messageBelowHeadingPage =
        (MessageBelowHeadingPage) CandidatePageCollection.getCurrentPage();
    messageBelowHeadingPage.assertMessageBelowHeading();
    messageBelowHeadingPage.assertCorrectMessageBelowHeading(expectedMessage);
  }

  // generic check to find if elements on the page are ordered as expected

  @Then("^the elements should be ordered on the candidate page according to the following list$")
  public void the_elements_should_be_ordered_on_the_candidate_page_according_to_the_following_list(
      List<String> elementIds) throws Throwable {
    CandidatePageCollection.getCurrentPage().assertOnOrderOfWebElementsByListOrder(elementIds);
  }
}
