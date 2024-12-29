package com.localhost8888.cucumber.stepDefinitions;

import com.localhost8888.pages.CreateLeadSuccessPage;
import com.localhost8888.pages.CreateNewLeadsPage;
import com.localhost8888.webdriverutilities.WebDrv;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

public class CreateLeadSuccessSteps {

    private CreateNewLeadsPage createNewLeadsPage;

    @Then("I should see the lead created successfully messages {string} and {string}")
    public void verifyLeadCreationSuccess(String leadName, String leadNo) {
        CreateLeadSuccessPage  createLeadSuccessPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), CreateLeadSuccessPage.class);
        createLeadSuccessPage.verifyLeadCreated(leadName,leadNo);
        //createLeadSuccessPage.verifyLeadCreationSuccessMessageByText(attributeValue);
    }

    @Then("I should see the lead created was successful as {string}")
    public void verifyLeadSuccessfullyCreated(String leadName) {
        CreateLeadSuccessPage  createLeadSuccessPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), CreateLeadSuccessPage.class);
        createLeadSuccessPage.verifyLeadCreationSuccessMessageByText(leadName);
    }


}