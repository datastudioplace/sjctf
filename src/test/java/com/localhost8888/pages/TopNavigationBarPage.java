package com.localhost8888.pages;

import com.localhost8888.helperutilities.assertion.VerificationHelper;
import com.localhost8888.helperutilities.javaScript.JavaScriptHelper;
import com.localhost8888.helperutilities.wait.WaitUtils;
import com.localhost8888.webdriverutilities.WebDrv;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

import static com.localhost8888.helperutilities.wait.WaitUtils.waitToBeVisibleAndClick;

public class TopNavigationBarPage {
  private static final Logger log = LogManager.getLogger(TopNavigationBarPage.class);
  private final WebDriver driver;

  public TopNavigationBarPage() {
    this.driver = WebDrv.getInstance().getWebDriver();
    PageFactory.initElements(driver, this);
  }

  @FindBy(css = "span.userName")
  private WebElement userName;

  @FindBy(css = "img[src='themes/softed/images/user.PNG']")
  private WebElement userImage;

  @FindBy(css = "img[src='themes/softed/images/info.PNG']")
  private WebElement helpIcon;

  @FindBy(css = "img[src='themes/softed/images/mainSettings.PNG']")
  private WebElement settingsIcon;

  @FindBy(xpath = "//a[contains(text(),'My Preferences')]")
  private WebElement myPreferences;

  @FindBy(css = "img[src='themes/softed/images/mainSettings.PNG']")
  private WebElement crmSettings;

  @FindBy(xpath = "//a[contains(text(),'Sign Out')]")
  private WebElement signOut;

  @FindBy(xpath = "//a[contains(text(),'Calendar')]")
  private WebElement calendarLink;

  @FindBy(xpath = "//a[contains(text(),'Leads')]")
  private WebElement leadsLink;

  @FindBy(xpath = "//a[contains(text(),'Organizations')]")
  private WebElement organizationsLink;

  @FindBy(xpath = "//a[contains(text(),'Contacts')]")
  private WebElement contactsLink;

  @FindBy(xpath = "//a[contains(text(),'Opportunities')]")
  private WebElement opportunitiesLink;

  @FindBy(xpath = "//a[contains(text(),'Products')]")
  private WebElement productsLink;

  @FindBy(xpath = "//a[contains(text(),'Documents')]")
  private WebElement documentsLink;

  @FindBy(xpath = "//a[contains(text(),'Email')]")
  private WebElement emailLink;

  @FindBy(xpath = "//a[contains(text(),'Trouble Tickets')]")
  private WebElement troubleTicketsLink;

  @FindBy(xpath = "//a[contains(text(),'Dashboard')]")
  private WebElement dashboardLink;

  @FindBy(xpath = "//a[contains(text(),'More')]")
  private WebElement moreLink;

  @FindBy(xpath = "//a[contains(text(),'Tools')]")
  private WebElement toolsLink;

  @FindBy(xpath = "//a[contains(text(),'Analytics')]")
  private WebElement analyticsLink;

  @FindBy(xpath = "//a[contains(text(),'Marketing')]")
  private WebElement marketingLink;

  @FindBy(xpath = "//a[contains(text(),'Support')]")
  private WebElement supportLink;

  @FindBy(xpath = "//a[contains(text(),'Inventory')]")
  private WebElement inventoryLink;

  @FindBy(xpath = "//a[contains(text(),'Sales')]")
  private WebElement salesLink;
  @FindBy(css = "img[src='themes/softed/images/btnL3Add.gif']")
  private WebElement createLead;

  @FindBy(css = "img[src='themes/softed/images/btnL3Search.gif']")
  private WebElement searchLeads;

  @FindBy(css = "img[src='themes/softed/images/btnL3Calendar.gif']")
  private WebElement openCalendar;

  @FindBy(css = "img[src='themes/softed/images/btnL3Clock.gif']")
  private WebElement showWorldClock;

  @FindBy(css = "img[src='themes/softed/images/btnL3Calc.gif']")
  private WebElement openCalculator;

  @FindBy(css = "img[src='themes/softed/images/tbarChat.gif']")
  private WebElement chat;

  @FindBy(css = "img[src='themes/softed/images/btnL3Tracker.gif']")
  private WebElement lastViewed;

  @FindBy(css = "img[src='themes/softed/images/tbarImport.gif']")
  private WebElement importLeads;

  @FindBy(css = "img[src='themes/softed/images/tbarExport.gif']")
  private WebElement exportLeads;

  @FindBy(css = "img[src='themes/images/findduplicates.gif']")
  private WebElement findDuplicates;

  @FindBy(css = "img[src='themes/softed/images/settingsBox.png']")
  private WebElement leadsSettings;

  // Click methods
  public void clickSignOut() {
    WaitUtils.waitToBeVisibleAndClick(signOut);
  }

  public void clickCalendarLink() {
    waitToBeVisibleAndClick(calendarLink);
  }

  public void clickLeadsLink() {
    waitToBeVisibleAndClick(leadsLink);
  }

  public void clickOrganizationsLink() {
    waitToBeVisibleAndClick(organizationsLink);
  }

  public void clickContactsLink() {
    waitToBeVisibleAndClick(contactsLink);
  }

  public void clickOpportunitiesLink() {
    waitToBeVisibleAndClick(opportunitiesLink);
  }

  public void clickProductsLink() {
    waitToBeVisibleAndClick(productsLink);
  }

  public void clickDocumentsLink() {
    waitToBeVisibleAndClick(documentsLink);
  }

  public void clickEmailLink() {
    waitToBeVisibleAndClick(emailLink);
  }

  public void clickTroubleTicketsLink() {
    waitToBeVisibleAndClick(troubleTicketsLink);
  }

  public void clickDashboardLink() {
    waitToBeVisibleAndClick(dashboardLink);
  }

  public void clickMoreLink() {
    waitToBeVisibleAndClick(moreLink);
  }

  public void clickToolsLink() {
    waitToBeVisibleAndClick(toolsLink);
  }

  public void clickAnalyticsLink() {
    waitToBeVisibleAndClick(analyticsLink);
  }

  public void clickMarketingLink() {
    waitToBeVisibleAndClick(marketingLink);
  }

  public void clickSupportLink() {
    waitToBeVisibleAndClick(supportLink);
  }

  public void clickInventoryLink() {
    waitToBeVisibleAndClick(inventoryLink);
  }

  public void clickSalesLink() {
    waitToBeVisibleAndClick(salesLink);
  }

  // Click methods
  public void clickCreateLead() {
    WaitUtils.waitToBeVisibleAndClick(createLead);
  }

  public void clickSearchLeads() {
    WaitUtils.waitToBeVisibleAndClick(searchLeads);
  }

  public void clickOpenCalendar() {
    WaitUtils.waitToBeVisibleAndClick(openCalendar);
  }

  public void clickShowWorldClock() {
    WaitUtils.waitToBeVisibleAndClick(showWorldClock);
  }

  public void clickOpenCalculator() {
    WaitUtils.waitToBeVisibleAndClick(openCalculator);
  }

  public void clickChat() {
    WaitUtils.waitToBeVisibleAndClick(chat);
  }

  public void clickLastViewed() {
    WaitUtils.waitToBeVisibleAndClick(lastViewed);
  }

  public void clickImportLeads() {
    WaitUtils.waitToBeVisibleAndClick(importLeads);
  }

  public void clickExportLeads() {
    WaitUtils.waitToBeVisibleAndClick(exportLeads);
  }

  public void clickFindDuplicates() {
    WaitUtils.waitToBeVisibleAndClick(findDuplicates);
  }

  public void clickLeadsSettings() {
    WaitUtils.waitToBeVisibleAndClick(leadsSettings);
  }

  // Get text methods

  // Get text methods
  public String getUserNameText() {
    return Objects.requireNonNull(new VerificationHelper().getText(userName)).trim();
  }

  public String getCalendarLinkText() {
    return new VerificationHelper().getText(calendarLink);
  }

  public String getLeadsLinkText() {
    return new VerificationHelper().getText(leadsLink);
  }

  public String getOrganizationsLinkText() {
    return new VerificationHelper().getText(organizationsLink);
  }

  public String getContactsLinkText() {
    return new VerificationHelper().getText(contactsLink);
  }

  public String getOpportunitiesLinkText() {
    return new VerificationHelper().getText(opportunitiesLink);
  }

  public String getProductsLinkText() {
    return new VerificationHelper().getText(productsLink);
  }

  public String getDocumentsLinkText() {
    return new VerificationHelper().getText(documentsLink);
  }

  public String getEmailLinkText() {
    return new VerificationHelper().getText(emailLink);
  }

  public String getTroubleTicketsLinkText() {
    return new VerificationHelper().getText(troubleTicketsLink);
  }

  public String getDashboardLinkText() {
    return new VerificationHelper().getText(dashboardLink);
  }

  public String getMoreLinkText() {
    return new VerificationHelper().getText(moreLink);
  }

  public String getToolsLinkText() {
    return new VerificationHelper().getText(toolsLink);
  }

  public String getAnalyticsLinkText() {
    return new VerificationHelper().getText(analyticsLink);
  }

  public String getMarketingLinkText() {
    return new VerificationHelper().getText(marketingLink);
  }

  public String getSupportLinkText() {
    return new VerificationHelper().getText(supportLink);
  }

  public String getInventoryLinkText() {
    return new VerificationHelper().getText(inventoryLink);
  }

  public String getSalesLinkText() {
    return new VerificationHelper().getText(salesLink);
  }

  // Is displayed methods
  public boolean isCalendarLinkDisplayed() {
    return new VerificationHelper().isDisplayed(calendarLink);
  }

  public boolean isLeadsLinkDisplayed() {
    return new VerificationHelper().isDisplayed(leadsLink);
  }

  public boolean isOrganizationsLinkDisplayed() {
    return new VerificationHelper().isDisplayed(organizationsLink);
  }

  public boolean isContactsLinkDisplayed() {
    return new VerificationHelper().isDisplayed(contactsLink);
  }

  public boolean isOpportunitiesLinkDisplayed() {
    return new VerificationHelper().isDisplayed(opportunitiesLink);
  }

  public boolean isProductsLinkDisplayed() {
    return new VerificationHelper().isDisplayed(productsLink);
  }

  public boolean isDocumentsLinkDisplayed() {
    return new VerificationHelper().isDisplayed(documentsLink);
  }

  public boolean isEmailLinkDisplayed() {
    return new VerificationHelper().isDisplayed(emailLink);
  }

  public boolean isTroubleTicketsLinkDisplayed() {
    return new VerificationHelper().isDisplayed(troubleTicketsLink);
  }

  public boolean isDashboardLinkDisplayed() {
    return new VerificationHelper().isDisplayed(dashboardLink);
  }

  public boolean isMoreLinkDisplayed() {
    return new VerificationHelper().isDisplayed(moreLink);
  }

  public boolean isToolsLinkDisplayed() {
    return new VerificationHelper().isDisplayed(toolsLink);
  }

  public boolean isAnalyticsLinkDisplayed() {
    return new VerificationHelper().isDisplayed(analyticsLink);
  }

  public boolean isMarketingLinkDisplayed() {
    return new VerificationHelper().isDisplayed(marketingLink);
  }

  public boolean isSupportLinkDisplayed() {
    return new VerificationHelper().isDisplayed(supportLink);
  }

  public boolean isInventoryLinkDisplayed() {
    return new VerificationHelper().isDisplayed(inventoryLink);
  }

  public boolean isSalesLinkDisplayed() {
    return new VerificationHelper().isDisplayed(salesLink);
  }

  public boolean isUserNameDisplayed() {
    return new VerificationHelper().isDisplayed(userName);
  }

  public boolean isUserImageDisplayed() {
    return new VerificationHelper().isDisplayed(userImage);
  }

  public boolean isHelpIconDisplayed() {
    return new VerificationHelper().isDisplayed(helpIcon);
  }

  public boolean isCreateLeadDisplayed() {
    return new VerificationHelper().isDisplayed(createLead);
  }

  public boolean isSearchLeadsDisplayed() {
    return new VerificationHelper().isDisplayed(searchLeads);
  }

  public boolean isOpenCalendarDisplayed() {
    return new VerificationHelper().isDisplayed(openCalendar);
  }

  public boolean isShowWorldClockDisplayed() {
    return new VerificationHelper().isDisplayed(showWorldClock);
  }

  public boolean isOpenCalculatorDisplayed() {
    return new VerificationHelper().isDisplayed(openCalculator);
  }

  public boolean isChatDisplayed() {
    return new VerificationHelper().isDisplayed(chat);
  }

  public boolean isLastViewedDisplayed() {
    return new VerificationHelper().isDisplayed(lastViewed);
  }

  public boolean isImportLeadsDisplayed() {
    return new VerificationHelper().isDisplayed(importLeads);
  }

  public boolean isExportLeadsDisplayed() {
    return new VerificationHelper().isDisplayed(exportLeads);
  }

  public boolean isFindDuplicatesDisplayed() {
    return new VerificationHelper().isDisplayed(findDuplicates);
  }

  public boolean isLeadsSettingsDisplayed() {
    return new VerificationHelper().isDisplayed(leadsSettings);
  }



  // Hover over "More" and verify dropdown options
  public void hoverOverMoreLink() {
    Actions actions = new Actions(driver);
    actions.moveToElement(moreLink).perform();
  }

  public boolean isMyPreferencesDisplayed() {
    return new VerificationHelper().isDisplayed(myPreferences);
  }

  public boolean isSignOutDisplayed() {
    return new VerificationHelper().isDisplayed(signOut);
  }

  public WebElement getCrmSettings() {
    return crmSettings;
  }

  public void clickCrmSettingsIcon() {
    WaitUtils.waitAndClick(crmSettings);
  }

  public boolean isCrmSettingsIconDisplayed() {
    return  new VerificationHelper().isDisplayedAndEnabled(crmSettings);
  }

  public boolean isDropdownOptionDisplayed(String optionText) {
    WebElement optionElement = driver.findElement(By.xpath("//a[contains(text(),'" + optionText + "')]"));
    return new VerificationHelper().isDisplayed(optionElement);
  }
  // Hover over "User Image" and verify dropdown options
  public void hoverOverUserImage() {
    Actions actions = new Actions(driver);
    actions.moveToElement(userImage).perform();
  }


}