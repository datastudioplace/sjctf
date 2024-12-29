package com.localhost8888.cucumber.stepDefinitions;

import com.localhost8888.helperutilities.GlobalVarsHelper;
import com.localhost8888.helperutilities.alert.AlertHelper;
import com.localhost8888.helperutilities.assertion.AssertionHelper;
import com.localhost8888.model.LoginModel;
import com.localhost8888.pages.*;
import com.localhost8888.testData_customer.LoginPageTestData;
import com.localhost8888.webdriverutilities.WebDrv;
import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginSteps {
  private AccountPage accountPage;
  private LogoutPage logoutPage;
  private IndexPage indexPage;
  private AlertHelper alertHelper;
  private Faker faker;
  private TopNavigationBarPage topNavigationBarPage;
  private Page page;
  private LoginPage loginPage;
  private String uRL;
  private WebDriver driver = WebDrv.getInstance().getWebDriver();

  public LoginSteps() {
    this.loginPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), LoginPage.class);
    this.page = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), Page.class);

  }

  @And("I should see the login form")
  public void iShouldSeeTheLoginForm() {
    Assert.assertTrue(loginPage.isLoginFormDisplayed(), "Login form is not displayed");
  }

  @And("I login valid with credentials")
  public void iLoginValidWithCredentials() {
    loginPage.inputUserName("admin");
    loginPage.inputPassword("admin");
    accountPage = loginPage.clickOnLoginButtonInLoginPage();
  }

  @And("I login with username {string} and password {string}")
  public void iLoginWithUsernameAndPassword(String username, String password) {
    loginPage.inputUserName(username);
    loginPage.inputPassword(password);
    accountPage = loginPage.clickOnLoginButtonInLoginPage();
  }


  @Then("I should be in the login page")
  public void i_should_be_in_the_login_page() {
    String expectedTitle = "Account login";
    Assert.assertTrue(this.page.getThisPageHeader().equalsIgnoreCase(expectedTitle), "The login page is not displayed.");
  }

  @When("I should see in the login page as follows:")
  public void i_should_see_in_page_in_the_login_page(DataTable dataTable) {
    AssertionHelper.updateTestStatus(this.page.getThisPageUrl().contains(dataTable.cell(1, 0)));
    AssertionHelper.updateTestStatus(this.page.getThisPageTitle().contains(dataTable.cell(1, 1)));
    AssertionHelper.updateTestStatus(this.page.getPageHeaderText().contains(dataTable.cell(1, 2)));
  }


  @Given("I login application with loginname {string} and password {string}")
  public void i_login_application_with_loginname_and_password(String loginname, String password) throws IOException, InterruptedException {
    this.loginPage.inputUserName(loginname);
    this.loginPage.inputPassword(password);
    accountPage = this.loginPage.clickOnLoginButtonInLoginPage();
  }

  @And("login with valid credentials")
  public void loginWithValidCredentials() {
    this.loginPage.inputUserName("webdriverio2");
    this.loginPage.inputPassword("webdriverio2");
    this.loginPage.clickLoginButtonInLoginPage();
  }

  @Given("I enter invalid userName {string} and password {string}")
  public void i_enter_invalid_loginname_and_password(String userName, String password) {
    this.loginPage.inputUserName(userName);
    this.loginPage.inputPassword(password);
  }

  @When("I click on login button in login page")
  public void i_click_on_login_button_in_login_page() {
    this.loginPage.clickLoginButtonInLoginPage();
  }

  @And("I login as returning customer")
  public void i_login_as_returning_customer(DataTable data) throws Throwable {
    List<List<String>> customerDetails = data.cells();
    this.loginPage.enterLoginNameAndPassword(customerDetails.get(0).get(0), customerDetails.get(0).get(1));
    this.loginPage.clickLoginButtonInLoginPage();
    Thread.sleep(1000);
  }

  @When("I click on {string} button in login page")
  public void i_click_on_loginButton_in_login_page(String loginBtn) {
    Assert.assertEquals(this.loginPage.getLoginBtnText(), loginBtn);
    this.loginPage.clickLoginButtonInLoginPage();
  }

  @When("I click on the {string} button")
  public void i_click_on_the_login_Button(String loginBtn) {
    Assert.assertEquals(this.loginPage.getLoginBtnText(), loginBtn);
    this.loginPage.clickLoginButtonInLoginPage();
  }

  @When("I submit login button")
  public void i_submit_login_Button() {
    this.loginPage.clickOnLogin();
  }

  @When("I login with the following credentials:")
  public void i_fill_in_the_following_login_credentials(DataTable dataTable) throws InterruptedException {
    this.loginPage.inputUserName(dataTable.cell(1, 0));
    this.loginPage.inputPassword(dataTable.cell(1, 1));
    accountPage = this.loginPage.clickOnLoginButtonInLoginPage();
  }

  @When("I login with valid credentials")
  public void i_login_with_valid_login_credentials(List<LoginModel> loginModelList) throws InterruptedException {
    Optional<LoginModel> loginModel = loginModelList.stream().findFirst();
    loginModel.ifPresent(model -> this.loginPage.createLoginModel(model));
    accountPage = this.loginPage.clickOnLoginButtonInLoginPage();
  }

  @When("I login with valid credentials:")
  public void i_login_with_credentials(DataTable dataTable) throws InterruptedException {
    accountPage = this.loginPage.clickOnLoginButtonInLoginPage();
  }

  @When("I login in login page as a returning customer")
  public void i_login_in_login_page_as_a_returning_customer(DataTable dataTable) {
    this.loginPage.inputUserName(dataTable.cell(1, 0));
    this.loginPage.inputPassword(dataTable.cell(1, 1));
  }

  @When("I login in login page")
  public void i_login_in_login_page(DataTable dataTable) {
    this.loginPage.inputUserName(dataTable.cell(1, 0));
    this.loginPage.inputPassword(dataTable.cell(1, 1));
  }

/*  @When("I login valid with credentials")
  public void i_login_valid_credentials() {
    this.loginPage.inputUserName("admin");
    this.loginPage.inputPassword("admin");
    accountPage = this.loginPage.clickOnLoginButtonInLoginPage();
    //WebElement ele = WebDrv.getInstance().getWebDriver().findElement(By.cssSelector("[class='btn btn-orange pull-right'][title='Login']"));
    //new JavaScriptHelper().scrollToElementAndClick(ele);
    //ele.click();

  }*/

  @And("I should see basePage url and title in the My account page:")
  public void iShouldSeeUrlAndTitleInMyAccountPage(DataTable dataTable) {
    AssertionHelper.updateTestStatus(this.page.getThisPageUrl().contains(dataTable.cell(1, 0)));
    AssertionHelper.updateTestStatus(this.page.getThisPageTitle().contains(dataTable.cell(1, 1)));
    AssertionHelper.updateTestStatus(this.page.getPageHeaderText().contains(dataTable.cell(1, 2)));
  }

  @Given("I navigate to Account login page {string}")
  public void iNavigateToLoginPage() throws Throwable {
    if (WebDrv.getInstance().getWebDriver() == null) {
      this.page.navigateTo(getFulUrl());
    } else {
      WebDrv.getInstance().getWebDriver().manage().deleteAllCookies();
      this.page.navigateTo(getFulUrl());
    }
  }

  private String getFulUrl() {
    return GlobalVarsHelper.getUrlHomepage();
  }

  @And("I click on the login button")
  public void iClickOnTheLoginButton() throws Throwable {
    accountPage = this.loginPage.clickOnLoginButtonInLoginPage();
  }

  @When("I enter the login name {string}")
  public void iEnterTheLoginName(String loginname) {
    this.loginPage.inputUserName(loginname);
  }

  @And("I enter the password {string}")
  public void iEnterThePassword(String password) {
    this.loginPage.inputPassword(password);
  }

  @Then("I entered {string} in password field")
  public void enterPassword(String password) {
    this.loginPage.inputPassword(password);
  }

  @And("I tap on login button")
  public void clickOnSigInButton() throws Throwable {
    this.loginPage.clickOnLoginButton();
  }


  @Given("I navigate to the page {string}")
  public void iNavigateToThePage(String arg0) throws Throwable {
    uRL = arg0;
    this.loginPage = PageFactory.initElements(WebDrv.getInstance().openBrowser(""), LoginPage.class);
    this.page.navigateTo(GlobalVarsHelper.getInstance().getURL() + uRL);
  }

  @Given("I open the page {string}")
  public void iOpenThePage(String arg0) throws Throwable {
    uRL = arg0;
    this.loginPage = PageFactory.initElements(WebDrv.getInstance().openBrowser(""), LoginPage.class);
    this.page.navigateTo(GlobalVarsHelper.getInstance().getURL() + uRL);
  }

  @Then("I navigate to Account login page and login as a returning customer")
  public void iNavigateToLoginIntoLoginPageAndLoginAsAReturningCustomer() throws Throwable {
    this.topNavigationBarPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), TopNavigationBarPage.class);
    this.loginPage.inputUserName(LoginPageTestData.LOGIN_NAME);
    this.loginPage.inputPassword(LoginPageTestData.PASSWORD);
    accountPage = this.loginPage.tapOnLoginButton();
  }

  @Then("I navigate to login page and login as a returning customer")
  public void iNavigateToLoginLoginPageAndLoginAsAReturningCustomer() throws Throwable {
    this.page.navigateTo(GlobalVarsHelper.getLoginPageUrl());
    this.loginPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), LoginPage.class);
    this.loginPage.inputUserName(LoginPageTestData.LOGIN_NAME);
    this.loginPage.inputPassword(LoginPageTestData.PASSWORD);
    accountPage = this.loginPage.clickOnLoginButtonInLoginPage();
  }

  @When("I navigate to login page and login with invalid credentials")
  public void i_navigate_to_login_page_and_login_with_invalid_credentials() throws Throwable {
    this.topNavigationBarPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), TopNavigationBarPage.class);
    this.loginPage.loginWithInvalidCredentials("wrong_loginname", "wrong_password");
  }

  @When("I navigate to login page and login with valid credentials")
  public void i_navigate_to_login_page_and_login_with_valid_credentials() throws Throwable {
    this.topNavigationBarPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), TopNavigationBarPage.class);
    this.loginPage.inputUserName(LoginPageTestData.LOGIN_NAME);
    this.loginPage.inputPassword(LoginPageTestData.PASSWORD);
    accountPage = this.loginPage.clickOnLoginButtonInLoginPage();
  }

  @And("I login in login page as a returning customer with invalid login name {string} and invalid {string}")
  public void iLoginInLoginPageAsAReturningCustomerWithInvalidLoginNameAndInvalid(String loginname, String password) throws Throwable {
    this.topNavigationBarPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), TopNavigationBarPage.class);
    this.loginPage.inputUserName(loginname);
    this.loginPage.inputPassword(password);
    this.loginPage.clickLoginButtonInLoginPage();
  }

  @Given("should be presented with the following Error validation message as {string}")
  public void should_be_presented_with_the_following_error_validation_message_as(String errorValueMsg) {
    Assert.assertTrue(this.loginPage.getErrorMessageIsPresent().contains(errorValueMsg));
  }

  @And("I am redirected to the login page")
  public void i_am_redirected_to_the_login_page() {
    this.loginPage.assertPageIsLoginPage();

  }

  @Given("I go to {string}")
  public void iGoTo() throws Throwable {
    if (WebDrv.getInstance().getWebDriver() == null) {
      this.page.navigateTo(getFulUrl());
    } else {
      WebDrv.getInstance().getWebDriver().manage().deleteAllCookies();
      this.page.navigateTo(getFulUrl());
    }
  }

  @Then("clicking this link should take me to the sign in page")
  public void clicking_this_link_should_take_me_to_the_sign_in_page() throws Throwable {
    this.page.assertOnHeadingText("Account login");
  }

  @And("I login with invalid credentials")
  public void iLoginWithInvalidCredentials() {
    this.loginPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), LoginPage.class);
    this.loginPage.loginWithInvalidCredentials(LoginPageTestData.INVALID_LOGIN_NAME, LoginPageTestData.INVALID_PASSWORD);
  }

  @Then("should be presented with confirmation message as {string}")
  public void shouldBePresentedWithConfirmationMessageAs(String arg0) {

  }

  @When("I login with username as {string} and Password as {string}")
  public void iLoginWithUsernameAsUsernameAndPasswordAsPassword(String userName, String password) {
    this.loginPage.inputUserName(userName);
    this.loginPage.inputPassword(password);
    this.accountPage = this.loginPage.clickOnLoginButtonInLoginPage();
  }

  @And("I can see the logo image is displayed")
  public void iCanSeeTheLogoImageAsIsDisplayed() {
    Assert.assertTrue(this.page.isLogoPresent());
  }

  @And("I should see {string} is displayed")
  public void iShouldSeeIsDisplayed(String poweredText) {
    Assert.assertTrue(this.page.isPoweredTextPresent(poweredText));
  }

  @And("I should see promo advert is displayed")
  public void iShouldSeePromoAdvertIsDisplayed() {
    Assert.assertTrue(this.page.isPromoAdvertPresent());
  }

  @Then("should be presented with the following error warning message as {string}")
  public void shouldBePresentedWithTheFollowingErrorWarningValidationMessageAs(String ErrorWarningValidationMessage) {
    LoginPage loginPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), LoginPage.class);
    AssertionHelper.updateTestStatus(loginPage.getErrorAlertDangerLoginMessage().contains(ErrorWarningValidationMessage));
  }

}