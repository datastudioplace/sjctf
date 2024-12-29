package com.localhost8888.pages;

import com.localhost8888.helperutilities.wait.WaitUtils;
import com.localhost8888.webdriverutilities.WebDrv;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class CreateNewLeadsPage {
    private static final Logger log = LogManager.getLogger(CreateNewLeadsPage.class);

    public CreateNewLeadsPage() {
    PageFactory.initElements(WebDrv.getInstance().getWebDriver(), this);
    }

    @FindBy(css = "input[accesskey='S']")
    private WebElement saveButton;

    @FindBy(css = "input[accesskey='X']")
    private WebElement cancelButton;

    @FindBy(css = "select[name='salutationtype']")
    private WebElement salutationDropdown;

    @FindBy(name = "firstname")
    private WebElement firstNameField;

    @FindBy(name = "lastname")
    private WebElement lastNameField;

    @FindBy(name = "company")
    private WebElement companyField;

    @FindBy(name = "leadsource")
    private WebElement leadSourceDropdown;

    @FindBy(name = "industry")
    private WebElement industryDropdown;

    @FindBy(name = "annualrevenue")
    private WebElement annualRevenueField;

    @FindBy(name = "leadstatus")
    private WebElement leadStatusDropdown;

    @FindBy(name = "rating")
    private WebElement ratingDropdown;

    @FindBy(name = "assigntype")
    private List<WebElement> assignTypeRadioButtons;

    @FindBy(name = "assigned_user_id")
    private WebElement assignedUserDropdown;

    @FindBy(css = "input[value='T']")
    private WebElement assignedGroupDropdown;

    @FindBy(name = "lane")
    private WebElement streetTextArea;

    @FindBy(name = "pobox")
    private WebElement poBoxField;

    @FindBy(name = "code")
    private WebElement postalCodeField;

    @FindBy(name = "city")
    private WebElement cityField;

    @FindBy(name = "country")
    private WebElement countryField;

    @FindBy(name = "state")
    private WebElement stateField;

    @FindBy(name = "description")
    private WebElement descriptionTextArea;

    @FindBy(name = "leadNo")
    private WebElement leadNoField;


    // Methods for interacting with elements

    public void clickSaveButton() {
        WaitUtils.waitForElementToBeClickable(saveButton);
        saveButton.click();
    }

    public void clickCancelButton() {
        WaitUtils.waitForElementToBeClickable(cancelButton);
        cancelButton.click();
    }

    public void selectSalutation(String salutation) {
        new Select(salutationDropdown).selectByVisibleText(salutation);
    }

    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void enterCompany(String company) {
        companyField.sendKeys(company);
    }

    public void selectLeadSource(String leadSource) {
        new Select(leadSourceDropdown).selectByVisibleText(leadSource);
    }

    public void selectIndustry(String industry) {
        new Select(industryDropdown).selectByVisibleText(industry);
    }

    public void enterAnnualRevenue(String annualRevenue) {
        annualRevenueField.sendKeys(annualRevenue);
    }

    public void selectLeadStatus(String leadStatus) {
        new Select(leadStatusDropdown).selectByVisibleText(leadStatus);
    }

    public void selectRating(String rating) {
        new Select(ratingDropdown).selectByVisibleText(rating);
    }

    public void selectAssignType(String assignType) {
        for (WebElement radioButton : assignTypeRadioButtons) {
            if (radioButton.getAttribute("value").equals(assignType)) {
                radioButton.click();
                break;
            }
        }
    }

    public void selectAssignedUser(String assignedUser) {
        new Select(assignedUserDropdown).selectByVisibleText(assignedUser);
    }

    public void selectAssignedGroup(String assignedGroup) {
        new Select(assignedGroupDropdown).selectByVisibleText(assignedGroup);
    }

    public void enterStreet(String street) {
        streetTextArea.sendKeys(street);
    }

    public void enterPoBox(String poBox) {
        poBoxField.sendKeys(poBox);
    }

    public void enterPostalCode(String postalCode) {
        postalCodeField.sendKeys(postalCode);
    }

    public void enterCity(String city) {
        cityField.sendKeys(city);
    }

    public void enterCountry(String country) {
        countryField.sendKeys(country);
    }

    public void enterState(String state) {
        stateField.sendKeys(state);
    }

    public void enterDescription(String description) {
        descriptionTextArea.sendKeys(description);
    }

    public void enterWebsite(String website){

    }

    public void enterFax(String fax) {
        log.info("enter fax as: " + fax);

    }

    public void enterEmail(String email) {
        log.info("enter email: " + email);

    }


    // Methods for getting text and checking visibility
    public String getLeadNoText() {
        return leadNoField.getAttribute("value");
    }

    public boolean isSaveButtonDisplayed() {
        return saveButton.isDisplayed();
    }

    public void enterPhone(String arg1) {
        
    }

    public void enterMobile(String arg1) {
    }

    public void enterTitle(String arg1) {

    }

    public void enterAnnualrevenue(String arg1) {
    }

    public void enterNoOfEmployees(String noOfEmployees) {
    }

    public void enterSecondaryEmail(String secondaryEmail) {
        log.info("enter secondary email: " + secondaryEmail);

    }

    public void clickSave() {
        clickSaveButton();
    }




    // ... similar methods for other elements and lists ...
}