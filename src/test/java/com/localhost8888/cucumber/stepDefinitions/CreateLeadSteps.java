package com.localhost8888.cucumber.stepDefinitions;

import com.localhost8888.helperutilities.assertion.AssertionHelper;
import com.localhost8888.pages.CreateNewLeadsPage;
import com.localhost8888.pages.LeadsPage;
import com.localhost8888.pages.TopNavigationBarPage;
import com.localhost8888.webdriverutilities.WebDrv;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;


public class CreateLeadSteps {

    private CreateNewLeadsPage createNewLeadsPage = new CreateNewLeadsPage();

    @Given("I am on the create new leads page")
    public void navigateToCreateLeadsPage() {
        // Code to navigate to the create leads page
    }

    @When("I enter the following lead information")
    public void enterLeadInformation(DataTable dataTable) {
        // Initialize the CreateNewLeadsPage instance once
        CreateNewLeadsPage createNewLeadsPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), CreateNewLeadsPage.class);

        // Convert the DataTable to a list of strings, where each string represents a value
        List<String> leadData = dataTable.asList(String.class);

        // Ensure that the data table has the expected number of values
        if (leadData.size() != 9) {
            throw new IllegalArgumentException("Expected 9 values for lead information, but got " + leadData.size());
        }

        // Map each value to its corresponding field
        createNewLeadsPage.enterFirstName(leadData.get(0));
        createNewLeadsPage.enterLastName(leadData.get(1));
        createNewLeadsPage.enterCompany(leadData.get(2));
        createNewLeadsPage.selectLeadSource(leadData.get(3));
        createNewLeadsPage.enterStreet(leadData.get(4));
        createNewLeadsPage.enterCity(leadData.get(5));
        createNewLeadsPage.enterPostalCode(leadData.get(6));
        createNewLeadsPage.enterCountry(leadData.get(7));
        createNewLeadsPage.enterDescription(leadData.get(8));
    }

    @And("I enter the following address information")
    public void enterAddressInformation(DataTable dataTable) {
        // Similar to enterLeadInformation, but for address details
    }

    @And("I enter the following description")
    public void enterDescription(DataTable dataTable) {
        // Similar to enterLeadInformation, but for description
    }

    @And("I click on the save button")
    public void clickSaveButton() {
        CreateNewLeadsPage createNewLeadsPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), CreateNewLeadsPage.class);
        createNewLeadsPage.clickSaveButton();
    }

    @And("I click on the Create New Lead icon")
    public void iClickOnTheCreateNewLeadIcon() {
        LeadsPage leadsPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), LeadsPage.class);
        leadsPage.clickCreateNewLeadButton();

    }

    @And("I can see Create New Lead icon")
    public void iCanSeeCreateNewLeadIcon() {
        LeadsPage leadsPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), LeadsPage.class);
        AssertionHelper.updateTestStatus(leadsPage.isCreateNewLeadButtonDisplayed());
    }

    @And("I can see the created lead in the Leads list")
    public void iCanSeeTheCreatedLeadInTheLeadsList() {
        LeadsPage leadsPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), LeadsPage.class);

    }

    @When("I click on leads link")
    public void iClickOnLeadsLink() {
        TopNavigationBarPage topNavigationBarPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), TopNavigationBarPage.class);
        topNavigationBarPage.clickLeadsLink();
    }
}