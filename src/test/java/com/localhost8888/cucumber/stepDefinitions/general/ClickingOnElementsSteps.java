package com.localhost8888.cucumber.stepDefinitions.general;

import com.localhost8888.pagecollections.CandidatePageCollection;
import com.localhost8888.pages.general.ClickableElementPage;
import com.localhost8888.pages.general.LinkPage;
import com.localhost8888.pages.general.LoginPage;
import com.localhost8888.pages.general.SelectableElementPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClickingOnElementsSteps {
  public static void selectElement(String elementName) throws Throwable {
    ClickingOnElementsSteps clickingOnElementsSteps = new ClickingOnElementsSteps();
    clickingOnElementsSteps.i_click_on_the(elementName);
  }

  @Given("^I click on Forgot your password$")
  public void i_click_on_forgotten_your_password() throws Throwable {
    LoginPage signInPage = (LoginPage) CandidatePageCollection.getCurrentPage();
    signInPage.clickForgotPasswordLink();
  }

  @When("^I click the \"([^\"]*)\" link on the candidate page$")
  public void i_click_the_link(String linkName) throws Throwable {
    LinkPage linkPage = (LinkPage) CandidatePageCollection.getCurrentPage();
    linkPage.clickLink(linkName);
  }

  @When("^I click the \"([^\"]*)\" link on the \"([^\"]*)\" candidate page$")
  public void i_click_the_link(String linkName, String pageName) throws Throwable {
    i_click_the_link(linkName);
  }

  @Then("^I click on the \"([^\"]*)\"$")
  public void i_click_on_the(String elementName) throws Throwable {
    ClickableElementPage clickableElementPage =
        (ClickableElementPage) CandidatePageCollection.getCurrentPage();
    clickableElementPage.click(elementName);
  }

  // helper method

  @When("^I do not select \"([^\"]*)\"$")
  public void i_do_not_select(String elementName) throws Throwable {
    SelectableElementPage selectableElementPage =
        (SelectableElementPage) CandidatePageCollection.getCurrentPage();
    selectableElementPage.assertIfElementIsNotSelected(elementName);
  }
}
