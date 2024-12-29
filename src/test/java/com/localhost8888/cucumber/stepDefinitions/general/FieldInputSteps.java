package com.localhost8888.cucumber.stepDefinitions.general;

import com.localhost8888.helperutilities.FieldInputUtils;
import com.localhost8888.helperutilities.UserFieldDataPageModelContainerUtils;
import com.localhost8888.model.FieldInputModel;
import com.localhost8888.pagecollections.CandidatePageCollection;
import com.localhost8888.pages.Page;
import com.localhost8888.pages.general.*;
import com.localhost8888.webdriverutilities.WebDrv;
import com.localhost8888.webelementdata.FieldData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FieldInputSteps {

  FieldInputModel fieldInputModel;

  FieldInputPage fieldInputPage;

  public void i_have_entered_the_following_details_on_the_candidate_page(
      String pageName, Map<String, String> fieldValues) {
    Page page = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), Page.class);

    // Assuming the Page class has methods to input field values based on field names
    for (Map.Entry<String, String> entry : fieldValues.entrySet()) {
      String fieldName = entry.getKey();
      String fieldValue = entry.getValue();
      page.inputFieldValue(fieldName, fieldValue);
    }
  }

  @When("^I have entered \"([^\"]*)\" on the \"([^\"]*)\" candidate page$")
  public void i_have_entered_on_the_candidate_page(String fieldValue, String pageName)
      throws Throwable {
    FieldInputDetailsPage page = (FieldInputDetailsPage) CandidatePageCollection.getCurrentPage();
    page.inputFieldData(fieldValue);
  }

  @Given("^I have entered the following details on the candidate page$")
  public void i_have_entered_the_following_details_on_the_candidate_page(
      Map<String, String> fieldValues, String pageName) throws Throwable {
    MultiFieldInputDetailsPage page =
        (MultiFieldInputDetailsPage) CandidatePageCollection.getCurrentPage();
    UserFieldDataPageModelContainerUtils.registerFieldDataModelForPage(pageName, fieldValues);
    page.inputMultiFieldData(fieldValues);
  }

  @And("^I have entered a \"([^\"]*)\" \"([^\"]*)\" with \"([^\"]*)\" for \"([^\"]*)\"$")
  public void i_have_entered_a_value_with_characterlength_for_field(
      String caseType, String valueType, String numberOfCharacters, String fieldName) {
    int numberOfChars = 0;
    try {
      numberOfChars = Integer.parseInt(numberOfCharacters);
    } catch (NumberFormatException e) {
      throw e;
    }

    FieldDataInputPage page = (FieldDataInputPage) CandidatePageCollection.getCurrentPage();
    page.inputFieldValueData(new FieldData(fieldName, caseType, numberOfChars, valueType));
  }

  @And("^I have entered the following value \"([^\"]*)\" for \"([^\"]*)\"$")
  public void i_have_entered_the_following_value_for_field(String fieldValue, String invalidField) {
    FieldDataInputPage page = (FieldDataInputPage) CandidatePageCollection.getCurrentPage();
    page.inputFieldValueData(new FieldData(fieldValue, invalidField));
  }

  @Then("^I should be able to see \"([^\"]*)\" field value displayed on the candidate page$")
  public void i_should_be_able_to_see_displayed_on_the_candidate_page(String fieldValue)
      throws Throwable {
    EditablePage page = (EditablePage) CandidatePageCollection.getCurrentPage();
    page.assertOnCorrectFieldData(fieldValue);
  }

  @Then(
      "^I should be able to see the data I have previously inputted on the \"([^\"]*)\" candidate page$")
  public void I_should_be_able_to_see_the_data_I_have_previously_inputted(String pageName)
      throws Throwable {
    Map<String, String> fieldDataFromPage =
        UserFieldDataPageModelContainerUtils.getFieldDataFromPage(pageName);
    if (fieldDataFromPage != null) {
      MultiFieldInputDetailsAssertablePage page =
          (MultiFieldInputDetailsAssertablePage) CandidatePageCollection.getCurrentPage();
      page.assertOnCorrectContentInFields(fieldDataFromPage);
    }
  }

  @Then(
      "^I should be able to see \"([^\"]*)\" field value displayed on the \"([^\"]*)\" candidate page$")
  public void i_should_be_able_to_see_displayed_on_the_candidate_page(
      String fieldValue, String pageName) throws Throwable {
    i_should_be_able_to_see_displayed_on_the_candidate_page(fieldValue);
  }

  @Then("^I should be able to edit the fields on the candidate page$")
  public void i_should_be_able_to_edit_the_editable_fields_on_the_candidate_page()
      throws Throwable {
    EditablePage page = (EditablePage) CandidatePageCollection.getCurrentPage();
    page.assertFieldsAreEditable();
  }

  @Then("^I should be able to edit the fields on the \"([^\"]*)\" candidate page$")
  public void i_should_be_able_to_edit_the_editable_fields_on_the_candidate_page(String pageName)
      throws Throwable {
    i_should_be_able_to_edit_the_editable_fields_on_the_candidate_page();
  }

  @When("^the candidate page should be new and blank$")
  public void the_page_should_be_new_and_blank() throws Throwable {
    BlankFieldPage page = (BlankFieldPage) CandidatePageCollection.getCurrentPage();
    page.assertThatAllFieldsAreBlank();
  }

  @When("^the \"([^\"]*)\" candidate page should be new and blank$")
  public void the_page_should_be_new_and_blank(String pageName) throws Throwable {
    BlankFieldPage page = (BlankFieldPage) CandidatePageCollection.getCurrentPage();
    page.assertThatAllFieldsAreBlank();
  }

  @And("^I have entered a \"([^\"]*)\" case \"([^\"]*)\" with \"([^\"]*)\" for \"([^\"]*)\"$")
  public void i_have_entered_a_value_with_character_length_for_field(
      String caseType, String valueType, String numberOfCharacters, String fieldId) {
    Page page = CandidatePageCollection.getCurrentPage();
    int numberOfChars = 0;
    try {
      numberOfChars = Integer.parseInt(numberOfCharacters);
    } catch (NumberFormatException e) {
      throw e;
    }

    WebElement element = page.getElement(By.id(fieldId));
    element.clear();

    FieldInputUtils.inputFieldValueBasedOnValueType(valueType, numberOfChars, element, caseType);
  }

  @Then("^I should be able to edit the editable fields on the candidate page$")
  public void i_should_be_able_to_edit_the_editable_fields_on_the_page() throws Throwable {
    fieldInputPage.assertEditableFieldsCanBeEdited();
  }

  @Then("^I should be able see the correct edited details on the candidate page$")
  public void i_should_be_able_see_the_edited_values_in_the_fields_on_the_candidate_page()
      throws Throwable {
    fieldInputPage.assertOnAllInputFieldsBeingCorrectlyPopulated(fieldInputModel);
  }
}
