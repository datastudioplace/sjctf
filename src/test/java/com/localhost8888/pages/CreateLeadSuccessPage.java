package com.localhost8888.pages;

import com.localhost8888.helperutilities.assertion.AssertionHelper;
import com.localhost8888.helperutilities.assertion.VerificationHelper;
import com.localhost8888.helperutilities.wait.WaitUtils;
import com.localhost8888.webdriverutilities.WebDrv;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CreateLeadSuccessPage {
    VerificationHelper verificationHelper = new VerificationHelper();
    private static final Logger log = LogManager.getLogger(CreateNewLeadsPage.class);

    public CreateLeadSuccessPage() {
    PageFactory.initElements(WebDrv.getInstance().getWebDriver(), this);
    }

    @FindBy (css = ".dvtCellInfo")
    private List<WebElement> cellsInfo;

    @FindBy(css = "span.dvHeaderText")
    private WebElement leadHeader;

    @FindBy(css = "td.dvtSelectedCell")
    private WebElement leadInformationTab;

    @FindBy(css = "a[href*='CallRelatedList']")
    private WebElement moreInformationTab;

    @FindBy(css = "#More_Information_Modules_List a.drop_down")
    private List<WebElement> moreInformationOptions;

    @FindBy(css = "input.crmbutton.small.edit")
    private WebElement editButton;

    @FindBy(css = "input.crmbutton.small.create")
    private WebElement duplicateButton;

    @FindBy(css = "input.crmbutton.small.delete")
    private WebElement deleteButton;

    @FindBy(css = "img[title='Previous']")
    private WebElement previousButton;

    @FindBy(css = "img[title='JUMP']")
    private WebElement jumpButton;

    @FindBy(css = "img[title='Next']")
    private WebElement nextButton;

    @FindBy(css = "td.dvtCellLabel")
    private List<WebElement> fieldLabels;

    @FindBy(css = "td.dvtCellInfo")
    private List<WebElement> fieldValues;

    // ... Add more elements as needed ...


    // Clickable elements
    public void clickEditButton() {
        WaitUtils.waitForElementToBeClickable(editButton);
        editButton.click();
    }

    public void clickDuplicateButton() {
        WaitUtils.waitForElementToBeClickable(duplicateButton);
        duplicateButton.click();
    }

    public void clickDeleteButton() {
        WaitUtils.waitForElementToBeClickable(deleteButton);
        deleteButton.click();
    }

    // ... Add more click methods as needed ...


    // Getters for text and display status
    public String getLeadHeaderText() {
        WaitUtils.waitForElementToBeVisible(leadHeader);
        return leadHeader.getText();
    }

    public boolean isLeadInformationTabDisplayed() {
        WaitUtils.waitForElementToBeVisible(leadInformationTab);
        return leadInformationTab.isDisplayed();
    }

    // ... Add more getters as needed ...


    // Example of using VerificationHelper
    public void verifyLeadDetails(String expectedLeadName) {
        String actualLeadName = getLeadHeaderText();
        AssertionHelper.updateTestStatus(actualLeadName.contains(expectedLeadName));
    }

    public String getFieldValueByLabel(String labelText) {
        WaitUtils.waitForElementsToBeVisible(fieldLabels);
        WaitUtils.waitForElementsToBeVisible(fieldValues);
        for (int i = 0; i < fieldLabels.size(); i++) {
            if (fieldLabels.get(i).getText().trim().equals(labelText)) {
                return fieldValues.get(i).getText();
            }
        }
        throw new RuntimeException("Field label not found: " + labelText);
    }

    public String getLeadHeaderColor() {
        WaitUtils.waitForElementToBeVisible(leadHeader);
        return leadHeader.getCssValue("color");
    }

    public boolean verifyLeadCreationSuccessMessageByText(String leadName) {
        WaitUtils.waitForElementsToBeVisible(cellsInfo);
        log.info("Verifying lead creation success message");
        return cellsInfo.stream().parallel().anyMatch(s->s.getText().contains(leadName));
    }

    public boolean verifyLeadCreated(String leadName, String leadNo) {
        try {
            // Locate the Lead Information header element
            WebElement leadInfoHeader = WebDrv.getInstance().getWebDriver().findElement(By.xpath("//span[@class='dvHeaderText']"));

            // Extract the text content from the header
            String headerText = leadInfoHeader.getText();

            // Check if the header text contains the expected lead name and number
            return headerText.contains(leadName) && headerText.contains(leadNo);

        } catch (Exception e) {
            // Handle exceptions (e.g., element not found)
            System.err.println("Error verifying lead creation: " + e.getMessage());
            return false;
        }
    }
}
