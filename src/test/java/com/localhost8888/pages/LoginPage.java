package com.localhost8888.pages;

import com.localhost8888.helperutilities.GlobalVarsHelper;
import com.localhost8888.helperutilities.assertion.VerificationHelper;
import com.localhost8888.helperutilities.javaScript.JavaScriptHelper;
import com.localhost8888.helperutilities.wait.WaitUtils;
import com.localhost8888.model.LoginModel;
import com.localhost8888.webdriverutilities.WebDrv;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import io.cucumber.java.DataTableType;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage {
  Page page;
  private static final Logger log = LogManager.getLogger(LoginPage.class);
  private final WebDriver driver;
  private final VerificationHelper verificationHelper;
  final JavaScriptHelper javaScriptHelper;

  public LoginPage() {
    this.driver = WebDrv.getInstance().getWebDriver();
    this.javaScriptHelper = new JavaScriptHelper();
    this.verificationHelper = new VerificationHelper();
  }

  @FindBy(css = "#header-logo > div > nav")
  private WebElement menuItemsLink;

  @FindBy(css = ".loginForm")
  private WebElement loginForm;

  @FindBy(css = "input[name='user_name']")
  private WebElement userNameField;

  @FindBy(css = "input[name='user_password']")
  private WebElement passwordField;

  @FindBy(css = "#submitButton")
  private WebElement loginButton;

  @FindBy(css = "[type='submit'][title='Continue']")
  private WebElement continueButton;

  @FindBy(css = ".alert.alert-success")
  private WebElement alertAlertSuccessMsg;


  @FindBy(css = ".errorMessage")
  private WebElement errorAlertDangerLoginMessage;

  @FindBy(css = "img[alt='logo']")
  private WebElement logoImage;

  @FindBy(css = "a[target='_blank'][href='http://www.vtiger.com']")
  private WebElement vtigerLink;

  @FindBy(css = ".small.pluginsPromotionDiv")
  private WebElement pluginsPromotionDiv;

  @FindBy(css = ".small.pluginsPromotionDiv img[alt='Outlook Plugin']")
  private WebElement outlookPluginImage;

  @FindBy(css = ".small.pluginsPromotionDiv img[alt='Exchange Connector']")
  private WebElement exchangeConnectorImage;

  @FindBy(css = ".small.pluginsPromotionDiv img[alt='vtiger iPhone Application']")
  private WebElement vtigerIphoneAppImage;

  @FindBy(css = ".small.pluginsPromotionDiv img[alt='vtiger Android Application']")
  private WebElement vtigerAndroidAppImage;

  @FindBy(css = ".poweredBy")
  private WebElement poweredByText;

  @FindBy(css = ".importantLinks a[href='javascript:mypopup()']")
  private WebElement readLicenseLink;

  @FindBy(css = ".importantLinks a[href='http://www.vtiger.com/products/crm/privacy_policy.html']")
  private WebElement privacyPolicyLink;

  @FindBy(css = ".importantLinks")
  private WebElement importantLinks;

  @FindBy(css = ".communityLinks")
  private WebElement communityLinks;

  @FindBy(css = ".communityLinks a[target='_blank']")
  private List<WebElement> communityLinksIcons;

  public WebElement getLogoImage() {
    return logoImage;
  }

  public WebElement getVtigerLink() {
    return vtigerLink;
  }

  public WebElement getPluginsPromotionDiv() {
    return pluginsPromotionDiv;
  }

  public WebElement getOutlookPluginImage() {
    return outlookPluginImage;
  }

  public WebElement getExchangeConnectorImage() {
    return exchangeConnectorImage;
  }

  public WebElement getVtigerIphoneAppImage() {
    return vtigerIphoneAppImage;
  }

  public WebElement getVtigerAndroidAppImage() {
    return vtigerAndroidAppImage;
  }

  public WebElement getLoginForm() {
    return loginForm;
  }

  public WebElement getPoweredByText() {
    return poweredByText;
  }

  public WebElement getUserNameField() {
    return userNameField;
  }

  public WebElement getPasswordField() {
    return passwordField;
  }

  public WebElement getLoginButton() {
    return loginButton;
  }

  public WebElement getReadLicenseLink() {
    return readLicenseLink;
  }

  public WebElement getPrivacyPolicyLink() {
    return privacyPolicyLink;
  }

  public WebElement getImportantLinks() {
    return importantLinks;
  }

  public WebElement getCommunityLinks() {
    return communityLinks;
  }

  public List<WebElement> getCommunityLinksIcons() {
    return communityLinksIcons;
  }

  // Clickable elements
  public void clickVtigerLink() {
    WaitUtils.waitForElementToBeClickable(vtigerLink).ifPresent(WebElement::click);
  }

  public void clickOutlookPluginImage() {
    WaitUtils.waitForElementToBeClickable(outlookPluginImage).ifPresent(WebElement::click);
  }

  public void clickExchangeConnectorImage() {
    WaitUtils.waitForElementToBeClickable(exchangeConnectorImage).ifPresent(WebElement::click);
  }

  public void clickVtigerIphoneAppImage() {
    WaitUtils.waitForElementToBeClickable(vtigerIphoneAppImage).ifPresent(WebElement::click);
  }

  public void clickVtigerAndroidAppImage() {
    WaitUtils.waitForElementToBeClickable(vtigerAndroidAppImage).ifPresent(WebElement::click);
  }


  public void clickReadLicenseLink() {
    WaitUtils.waitForElementToBeClickable(readLicenseLink).ifPresent(WebElement::click);
  }

  public void clickPrivacyPolicyLink() {
    WaitUtils.waitForElementToBeClickable(privacyPolicyLink).ifPresent(WebElement::click);
  }

  // Get text methods
  public String getLogoImageAltText() {
    return new VerificationHelper().getText(logoImage);
  }

  public String getVtigerLinkText() {
    return new VerificationHelper().getText(vtigerLink);
  }

  public String getReadLicenseLinkText() {
    return new VerificationHelper().getText(readLicenseLink);
  }

  public String getPrivacyPolicyLinkText() {
    return new VerificationHelper().getText(privacyPolicyLink);
  }

  public String getCommunityLinksText() {
    return new VerificationHelper().getText(communityLinks);
  }

  public List<String> getCommunityLinksIconsText() {
    return new VerificationHelper().getText(communityLinksIcons);
  }

  // Is displayed methods
  public boolean isLogoImageDisplayed() {
    return new VerificationHelper().isDisplayed(logoImage);
  }

  public boolean isVtigerLinkDisplayed() {
    return new VerificationHelper().isDisplayed(vtigerLink);
  }

  public boolean isPluginsPromotionDivDisplayed() {
    return new VerificationHelper().isDisplayed(pluginsPromotionDiv);
  }

  public boolean isOutlookPluginImageDisplayed() {
    return new VerificationHelper().isDisplayed(outlookPluginImage);
  }

  public boolean isExchangeConnectorImageDisplayed() {
    return new VerificationHelper().isDisplayed(exchangeConnectorImage);
  }

  public boolean isVtigerIphoneAppImageDisplayed() {
    return new VerificationHelper().isDisplayed(vtigerIphoneAppImage);
  }

  public boolean isVtigerAndroidAppImageDisplayed() {
    return new VerificationHelper().isDisplayed(vtigerAndroidAppImage);
  }

  public boolean isPoweredByTextDisplayed() {
    return new VerificationHelper().isDisplayed(poweredByText);
  }

  public boolean isUserNameFieldDisplayed() {
    return new VerificationHelper().isDisplayed(userNameField);
  }

  public boolean isPasswordFieldDisplayed() {
    return new VerificationHelper().isDisplayed(passwordField);
  }

  public boolean isLoginButtonDisplayed() {
    return new VerificationHelper().isDisplayed(loginButton);
  }

  public boolean isReadLicenseLinkDisplayed() {
    return new VerificationHelper().isDisplayed(readLicenseLink);
  }

  public boolean isPrivacyPolicyLinkDisplayed() {
    return new VerificationHelper().isDisplayed(privacyPolicyLink);
  }

  public boolean isImportantLinksDisplayed() {
    return new VerificationHelper().isDisplayed(importantLinks);
  }

  public boolean isCommunityLinksDisplayed() {
    return new VerificationHelper().isDisplayed(communityLinks);
  }

  public List<Boolean> areCommunityLinksIconsDisplayed() {
    return new VerificationHelper().isDisplayed(communityLinksIcons);
  }

  @DataTableType
  public LoginModel convertLoginModel(Map<String, String> entry) {
    return LoginModel.createLoginModel(entry);
  }

  public void assertPageIsLoginPage() {
    boolean loginPage = Objects.requireNonNull(this.driver.getCurrentUrl()).contains(GlobalVarsHelper.getLoginPageUrl());
    Assert.assertTrue(loginPage, "The active page is not the login page");
    Assert.assertEquals("The heading for the login page is not 'Account login'", " Account login", this.page.getThisPageHeader());
  }

  public void inputPassword(String password) {
    passwordField.clear();
    passwordField.sendKeys(password);
    log.info("Entered password: " + password);
  }


  public AccountPage clickOnLoginButtonInLoginPage() {
    //WaitUtils.waitToBeVisibleAndClick(loginButton);
    loginButton.click();
    return new AccountPage();
  }

  public void clickLoginButtonInLoginPage() {
    //WaitUtils.waitToBeVisibleAndClick(loginButton);
    loginButton.click();
    log.info("Clicked on Login button");
  }


  public String getLoginBtnText() {
    return new VerificationHelper().getText(loginButton);

  }

  public AccountPage tapOnLoginButton() throws IOException {
    loginButton.click();
    return new AccountPage();
  }

  public void clickOnLogin() {
    loginButton.click();
  }

  public AccountPage loginApplication(String loginName, String password) {
    inputUserName(loginName);
    inputPassword(password);
    clickOnLoginButtonInLoginPage();
    return new AccountPage();
  }



  public String getErrorIncorrectLoginPasswordProvidedConfirmationMessage() {
    return new VerificationHelper().getText(errorAlertDangerLoginMessage);
  }

  public String getErrorAlertDangerLoginMessage() {
    return new VerificationHelper().getText(errorAlertDangerLoginMessage);
  }


  public void createLoginModel(String loginName, String password) {
    userNameField.sendKeys(loginName);
    passwordField.sendKeys(password);
  }

  public void createLoginModel(LoginModel loginModel) {
    userNameField.sendKeys(loginModel.getLoginname());
    passwordField.sendKeys(loginModel.getPassword());
  }

  public void loginWithInvalidCredentials(String login_name, String pass) {
    userNameField.sendKeys(login_name);
    passwordField.sendKeys(pass);
    loginButton.click();
    log.info("Clicked on: " + login_name + " button");
  }

  public AccountPage logon(String loginname, String passWord) {
    WaitUtils.waitForElementToBeVisible(userNameField);
    userNameField.sendKeys(loginname);
    WaitUtils.waitForElementToBeVisible(passwordField);
    passwordField.sendKeys(passWord);
    WaitUtils.waitForElementToBeVisible(loginButton);
    loginButton.click();
    return new AccountPage();
  }

  public void inputUserName(String username) {
    userNameField.clear();
    userNameField.sendKeys(username);
    log.info("Entered user name: " + username);
  }

  public void clickOnLoginButton() {
    loginButton.click();
  }

  public void assertMenuItemExists(String name) {
    List<WebElement> menuName = menuItemsLink.findElements(By.tagName("li"));
    for (WebElement li : menuName) {
      if (li.getText().contains(name)) {
        Assert.assertEquals(li.getText(), name);
        System.out.println(li.getText());
      }
    }
  }

  public String getErrorMessageIsPresent() {
    WaitUtils.waitForElementToBeVisible(errorAlertDangerLoginMessage);
    return new VerificationHelper().getText(errorAlertDangerLoginMessage);
  }

  public void navigateTo(String url) {
    WebDrv.getInstance().getWebDriver().navigate().to(url);
    WebDrv.getInstance().getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalVarsHelper.getImplicitWait()));
    WebDrv.getInstance().getWebDriver().manage().deleteAllCookies();
    WebDrv.getInstance().getWebDriver().manage().window().maximize();
    log.info("Navigated to :: " + url);
  }

  public boolean isErrorWaringMessageDisplayed() {
    return new VerificationHelper().isDisplayed(errorAlertDangerLoginMessage);
  }

  public void enterLoginNameAndPassword(String loginName, String password) {
    userNameField.clear();
    userNameField.sendKeys(loginName);
    log.info("Entered login name: " + loginName);
    passwordField.clear();
    passwordField.sendKeys(password);
    log.info("Entered login name: " + password);
  }


  public boolean isLoginFormDisplayed() {
    return new VerificationHelper().isDisplayed(loginForm);
  }


}