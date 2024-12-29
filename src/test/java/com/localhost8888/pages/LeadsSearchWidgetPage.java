package com.localhost8888.pages;

import com.localhost8888.helperutilities.assertion.VerificationHelper;
import com.localhost8888.helperutilities.wait.WaitUtils;
import com.localhost8888.webdriverutilities.WebDrv;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LeadsSearchWidgetPage {

    private WebDriver driver;

    public LeadsSearchWidgetPage() {
        this.driver = WebDrv.getInstance().getWebDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "img[title='Create Lead...']")
    private WebElement createLeadImage;

    @FindBy(css = "span.moduleName")
    private WebElement leadsHeader;

    @FindBy(css = "input[name='search_text']")
    private WebElement searchTextBox;

    @FindBy(css = "input[name='submit']")
    private WebElement searchNowButton;

    @FindBy(css = "select[name='search_field']")
    private WebElement searchFieldDropdown;

    @FindBy(css = "td.searchAlph")
    private List<WebElement> alphabeticSearchLinks;

    @FindBy(css = "input[name='searchtype'][value='BasicSearch']")
    private WebElement basicSearchRadioButton;

    @FindBy(css = "input[name='searchtype'][value='advance']")
    private WebElement advancedSearchRadioButton;

    @FindBy(css = "input[name='searchtype'][value='BasicSearch']")
    private WebElement searchTypeHiddenField;

    @FindBy(css = "input[name='module'][value='Leads']")
    private WebElement moduleHiddenField;

    @FindBy(css = "input[name='maxrecords']")
    private WebElement maxRecordsHiddenField;

    @FindBy(css = "input[name='parenttab'][value='Marketing']")
    private WebElement parentTabHiddenField;

    @FindBy(css = "input[name='action'][value='index']")
    private WebElement actionHiddenField;

    @FindBy(css = "input[name='query'][value='true']")
    private WebElement queryHiddenField;

    @FindBy(css = "input[name='search_cnt']")
    private WebElement searchCountHiddenField;

    @FindBy(css = "td.searchUIName")
    private WebElement searchUIName;

    @FindBy(css = "td.searchUIName a")
    private WebElement advancedSearchLink;

    @FindBy(css = "td.searchUIName img[title='Basic Search']")
    private WebElement basicSearchImage;

    @FindBy(css = "td.searchUIName img[title='Advanced Search']")
    private WebElement advancedSearchImage;

    @FindBy(css = "td.searchUIName img[title='Search']")
    private WebElement searchImage;

    @FindBy(css = "td.searchUIName img[title='Clear']")
    private WebElement clearImage;

    @FindBy(css = "td.searchUIName img[title='Save']")
    private WebElement saveImage;

    @FindBy(css = "td.searchUIName img[title='Delete']")
    private WebElement deleteImage;

    @FindBy(css = "td.searchUIName img[title='Mass Edit']")
    private WebElement massEditImage;

    @FindBy(css = "td.searchUIName img[title='Send Mail']")
    private WebElement sendMailImage;

    @FindBy(css = "td.searchUIName img[title='Send SMS']")
    private WebElement sendSMSImage;

    public void clickCreateLeadImage() {
        WaitUtils.waitForElementToBeClickable(createLeadImage).ifPresent(WebElement::click);
    }

    public String getLeadsHeaderText() {
        return new VerificationHelper().getText(leadsHeader);
    }

    public boolean isLeadsHeaderDisplayed() {
        return new VerificationHelper().isDisplayed(leadsHeader);
    }

    public void enterSearchText(String text) {
        WaitUtils.waitForElementToBeVisible(searchTextBox).ifPresent(element -> element.sendKeys(text));
    }

    public void clickSearchNowButton() {
        WaitUtils.waitForElementToBeClickable(searchNowButton).ifPresent(WebElement::click);
    }

    public void selectSearchField(String field) {
        WaitUtils.waitForElementToBeVisible(searchFieldDropdown).ifPresent(element -> {
            element.click();
            element.findElement(By.xpath("//option[@value='" + field + "']")).click();
        });
    }

    public void clickAlphabeticSearchLink(String letter) {
        alphabeticSearchLinks.stream()
                .filter(link -> link.getText().equalsIgnoreCase(letter))
                .findFirst()
                .ifPresent(WebElement::click);
    }

    public boolean isBasicSearchRadioButtonSelected() {
        return VerificationHelper.isSelected(basicSearchRadioButton);
    }

    public boolean isAdvancedSearchRadioButtonSelected() {
        return VerificationHelper.isSelected(advancedSearchRadioButton);
    }

    public boolean isSearchTypeHiddenFieldDisplayed() {
        return new VerificationHelper().isDisplayed(searchTypeHiddenField);
    }

    public boolean isModuleHiddenFieldDisplayed() {
        return new VerificationHelper().isDisplayed(moduleHiddenField);
    }

    public boolean isMaxRecordsHiddenFieldDisplayed() {
        return new VerificationHelper().isDisplayed(maxRecordsHiddenField);
    }

    public boolean isParentTabHiddenFieldDisplayed() {
        return new VerificationHelper().isDisplayed(parentTabHiddenField);
    }

    public boolean isActionHiddenFieldDisplayed() {
        return new VerificationHelper().isDisplayed(actionHiddenField);
    }

    public boolean isQueryHiddenFieldDisplayed() {
        return new VerificationHelper().isDisplayed(queryHiddenField);
    }

    public boolean isSearchCountHiddenFieldDisplayed() {
        return new VerificationHelper().isDisplayed(searchCountHiddenField);
    }

    public boolean isSearchUINameDisplayed() {
        return new VerificationHelper().isDisplayed(searchUIName);
    }

    public void clickAdvancedSearchLink() {
        WaitUtils.waitForElementToBeClickable(advancedSearchLink).ifPresent(WebElement::click);
    }

    public boolean isBasicSearchImageDisplayed() {
        return new VerificationHelper().isDisplayed(basicSearchImage);
    }

    public boolean isAdvancedSearchImageDisplayed() {
        return new VerificationHelper().isDisplayed(advancedSearchImage);
    }

    public boolean isSearchImageDisplayed() {
        return new VerificationHelper().isDisplayed(searchImage);
    }

    public boolean isClearImageDisplayed() {
        return new VerificationHelper().isDisplayed(clearImage);
    }

    public boolean isSaveImageDisplayed() {
        return new VerificationHelper().isDisplayed(saveImage);
    }

    public boolean isDeleteImageDisplayed() {
        return new VerificationHelper().isDisplayed(deleteImage);
    }

    public boolean isMassEditImageDisplayed() {
        return new VerificationHelper().isDisplayed(massEditImage);
    }

    public boolean isSendMailImageDisplayed() {
        return new VerificationHelper().isDisplayed(sendMailImage);
    }

    public boolean isSendSMSImageDisplayed() {
        return new VerificationHelper().isDisplayed(sendSMSImage);
    }
}