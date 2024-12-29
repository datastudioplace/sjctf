package com.localhost8888.cucumber.stepDefinitions.general;

import com.localhost8888.enums.WebElements;
import com.localhost8888.helperutilities.UserFieldDataPageModelContainerUtils;
import com.localhost8888.pagecollections.CandidatePageCollection;
import com.localhost8888.pages.Page;
import com.localhost8888.pages.general.InteractableTablePage;
import com.localhost8888.pages.general.OrderedPage;
import com.localhost8888.pages.general.TableBelowHeadingPage;
import com.localhost8888.pages.general.TablePage;
import com.localhost8888.tableutils.InteractableTableWebElementFinderAndClicker;
import io.cucumber.java.en.Given;

public class TableStepDefinitions {

  @Given(
      "^below the heading I should see a table filled with data I have entered before on the \"([^\"]*)\" candidate page$")
  public void
      below_the_heading_I_should_see_a_table_filled_with_data_I_have_entered_before_on_the_candidate_page(
          String pageName) throws Throwable {
    TableBelowHeadingPage tableBelowHeadingPage =
        (TableBelowHeadingPage) CandidatePageCollection.getCurrentPage();
    tableBelowHeadingPage.assertTableBelowHeading();
    tableBelowHeadingPage.assertCorrectTableContents(
        UserFieldDataPageModelContainerUtils.getFieldDataFromPage(pageName));
  }

  @Given("^there should be a delete link against every row in the table on the candidate page$")
  public void there_should_be_a_delete_link_against_every_row_in_the_table() throws Throwable {
    TablePage page = (TablePage) CandidatePageCollection.getCurrentPage();
    page.assertTableHasElementInEveryRow(WebElements.DELETE_LINK);
  }

  @Given(
      "^there should be a delete link against every row in the table on the \"([^\"]*)\" candidate page$")
  public void there_should_be_a_delete_link_against_every_row_in_the_table(String pageName)
      throws Throwable {
    there_should_be_a_delete_link_against_every_row_in_the_table();
  }

  @Given(
      "^there should be a sub heading below the table that says \"([^\"]*)\" on the candidate page$")
  public void
      there_should_be_a_sub_heading_below_the_table_that_says_Have_you_got_any_more_academic_qualifications(
          String subHeading) throws Throwable {
    OrderedPage page = (OrderedPage) CandidatePageCollection.getCurrentPage();
    page.assertIfElementsAreOrderedAsInTheExpectedList(
        new WebElements[] {WebElements.TABLE, WebElements.SUB_HEADING});
    ((Page) page).assertOnSubHeadingText(subHeading);
  }

  @Given(
      "^there should be a sub heading below the table that says \"([^\"]*)\" on the \"([^\"]*)\" candidate page$")
  public void
      there_should_be_a_sub_heading_below_the_table_that_says_Have_you_got_any_more_academic_qualifications(
          String subHeading, String pageName) throws Throwable {
    there_should_be_a_sub_heading_below_the_table_that_says_Have_you_got_any_more_academic_qualifications(
        subHeading);
  }

  @Given(
      "^I click edit against row number \"([^\"]*)\" of the table on the \"([^\"]*)\" candidate page$")
  public void i_click_edit_against_row_number(String rowNumber, String pageName) throws Throwable {
    InteractableTablePage page = (InteractableTablePage) CandidatePageCollection.getCurrentPage();
    page.clickTableElementOnRow(
        WebElements.TABLE_EDIT_BUTTON, Integer.parseInt(rowNumber), pageName);
  }

  @Given(
      "^I click delete against row number \"([^\"]*)\" of the table on the \"([^\"]*)\" candidate page$")
  public void i_click_delete_against_row_number(String rowNumber, String pageName)
      throws Throwable {
    int rowNo = Integer.parseInt(rowNumber);
    InteractableTablePage page = (InteractableTablePage) CandidatePageCollection.getCurrentPage();
    page.clickTableElementOnRow(WebElements.TABLE_DELETE_BUTTON, rowNo, pageName);
    registerThatARowHasBeenDeletedInTable(rowNo, pageName);
  }

  private void registerThatARowHasBeenDeletedInTable(int rowNumber, String pageName) {
    InteractableTableWebElementFinderAndClicker.deletedRowOnTablePageMap.put(pageName, rowNumber);
  }
}
