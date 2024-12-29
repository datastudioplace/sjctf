package com.localhost8888.cucumber.stepDefinitions;

import com.localhost8888.helperutilities.logger.LoggerHelper;
import com.localhost8888.pages.CreateNewLeadsPage;
import com.localhost8888.pages.LeadsPage;
import com.localhost8888.webdriverutilities.WebDrv;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;


public class LeadsPageStepDefinitions{

	CreateNewLeadsPage createLeadsPage = new CreateNewLeadsPage();
	
	Logger log = LoggerHelper.getLogger(LeadsPageStepDefinitions.class);

	@When("^I click on leads plus button$")
	public void i_click_on_leads_plus_button() throws Throwable {
    LeadsPage leadsPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), LeadsPage.class);
		leadsPage.clickCreateNewLeadButton();

	}

	@When("^I select First Name title as \"([^\"]*)\"$")
	public void i_select_First_Name_title_as(String arg1) throws Throwable {

	}

	@When("^I enter First Name \"([^\"]*)\"$")
	public void i_enter_First_Name(String arg1) throws Throwable {

	}

	@When("^I enter last name \"([^\"]*)\"$")
	public void i_enter_last_name(String arg1) throws Throwable {

	}

	@When("^I enter Company name \"([^\"]*)\"$")
	public void i_enter_Company_name(String arg1) throws Throwable {
		createLeadsPage.enterCompany(arg1);
	}

	@When("^I enter Title \"([^\"]*)\"$")
	public void i_enter_Title(String arg1) throws Throwable {
		createLeadsPage.enterTitle(arg1);
	}

	@When("^I select Lead Source \"([^\"]*)\"$")
	public void i_select_Lead_Source(String arg1) throws Throwable {
		createLeadsPage.selectLeadSource(arg1);
	}

	@When("^I select Industry \"([^\"]*)\"$")
	public void i_select_Industry(String arg1) throws Throwable {
		createLeadsPage.selectIndustry(arg1);
	}

	@When("^I enter Annual Revenue \"([^\"]*)\"$")
	public void i_enter_Annual_Revenue(String arg1) throws Throwable {
		createLeadsPage.enterAnnualrevenue(arg1);
	}

	@When("^I enter No Of Employees \"([^\"]*)\"$")
	public void i_enter_No_Of_Employees(String arg1) throws Throwable {
		createLeadsPage.enterNoOfEmployees(arg1);
	}

	@When("^I enter Secondary Email \"([^\"]*)\"$")
	public void i_enter_Secondary_Email(String arg1) throws Throwable {
		createLeadsPage.enterSecondaryEmail(arg1);
	}

	@When("^I enter Street \"([^\"]*)\"$")
	public void i_enter_Street(String arg1) throws Throwable {
		createLeadsPage.enterStreet(arg1);
	}

	@When("^I enter Postal Code \"([^\"]*)\"$")
	public void i_enter_Postal_Code(String arg1) throws Throwable {
		createLeadsPage.enterPostalCode(arg1);
	}

	@When("^I enter Country \"([^\"]*)\"$")
	public void i_enter_Country(String arg1) throws Throwable {
		createLeadsPage.enterCountry(arg1);
	}

	@When("^I enter Description \"([^\"]*)\"$")
	public void i_enter_Description(String arg1) throws Throwable {
		createLeadsPage.enterDescription(arg1);
	}

	@When("^I enter Phone \"([^\"]*)\"$")
	public void i_enter_Phone(String phone) throws Throwable {
		createLeadsPage.enterPhone(phone);
	}

	@When("^I enter Mobile \"([^\"]*)\"$")
	public void i_enter_Mobile(String mobile) throws Throwable {
		createLeadsPage.enterMobile(mobile);
	}

	@When("^I enter Fax \"([^\"]*)\"$")
	public void i_enter_Fax(String arg1) throws Throwable {
		createLeadsPage.enterFax(arg1);
	}

	@When("^I enter Email \"([^\"]*)\"$")
	public void i_enter_Email(String arg1) throws Throwable {
		createLeadsPage.enterEmail(arg1);
	}

	@When("^I enter Website \"([^\"]*)\"$")
	public void i_enter_Website(String arg1) throws Throwable {
		createLeadsPage.enterWebsite(arg1);
	}

	@When("^I select Lead Status \"([^\"]*)\"$")
	public void i_select_Lead_Status(String arg1) throws Throwable {
		createLeadsPage.selectLeadStatus(arg1);
	}

	@When("^I select Assigned To \"([^\"]*)\"$")
	public void i_select_Assigned_To(String arg1) throws Throwable {
		createLeadsPage.selectAssignedGroup(arg1);
	}

	@When("^I click on Save button$")
	public void i_click_on_Save_button() throws Throwable {
		createLeadsPage.clickSave();
	}

	@Then("^I should see lead creation success message$")
	public void i_should_see_lead_creation_success_message() throws Throwable {


	}

	@Then("^I should verify leads information$")
	public void i_should_verify_leads_information() throws Throwable {

	}

}
