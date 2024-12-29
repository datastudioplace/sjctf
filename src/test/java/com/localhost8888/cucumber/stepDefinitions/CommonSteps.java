package com.localhost8888.cucumber.stepDefinitions;

import com.localhost8888.helperutilities.CheckPageIsLoaded;
import com.localhost8888.helperutilities.GlobalVarsHelper;
import com.localhost8888.helperutilities.assertion.AssertionHelper;
import com.localhost8888.helperutilities.get.GetValue;
import com.localhost8888.pages.*;
import com.localhost8888.utils.CommonUtils;
import com.localhost8888.webdriverutilities.WebDrv;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CommonSteps {
  Page page;

  public CommonSteps() {

  }

  @Given("I open the browser at {string}")
  public void iOpenTheBrowserAt(String uRL) {
    page = PageFactory.initElements(WebDrv.getInstance().openBrowser("", null), Page.class);
    page.navigateTo(GlobalVarsHelper.getInstance().getURL() + uRL);
  }

  @Given("^I navigate to \"([^\"]*)\"$")
  public void iNavigateTo(String route) {
    if (WebDrv.getInstance().getWebDriver() == null) {
      page = PageFactory.initElements(WebDrv.getInstance().openBrowser("", null), Page.class);
      page.navigateTo(getFulUrl(route));

    } else {
      WebDrv.getInstance().getWebDriver().manage().deleteAllCookies();
      page = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), Page.class);
      page.navigateTo(getFulUrl(route));
    }

  }

  private String getFulUrl(String route) {
    String baseUrl = determineBaseUrl(route);
    return baseUrl + route;
  }

  private String determineBaseUrl(String route) {
    String baseUrl;
    if (route.startsWith(" ")) {
      baseUrl = GlobalVarsHelper.getInstance().getCandidateURL();
    } else {
      baseUrl = GlobalVarsHelper.getInstance().getURL();
    }
    return baseUrl;
  }


  @Given("^I landed on Ecommerce website$")
  public void iLandedOnEcommerceWebsite() {
    CommonUtils.initializeReader();
    CommonUtils.openBrowserWithUrl(CommonUtils.getProperty("url"));

  }

  @Given("^I am on home page$")
  public void iAmOnHomePage() {
    CommonUtils.initializeReader();
    CommonUtils.openBrowserWithUrl(CommonUtils.getProperty("url"));

  }

  @Given("I navigate to login page")
  public void iNavigateToLoginPage() {
    CommonUtils.initializeReader();
    CommonUtils.navigateToLoginPage(CommonUtils.getProperty("loginURL"));
  }

  @Given("I navigate to Account registration page")
  public void iNavigateToAccountRegistrationPage() {
    CommonUtils.initializeReader();
    CommonUtils.navigateToRegistrationPage(CommonUtils.getProperty("registrationURL"));
  }

  @Then("^the page sub-heading displayed should be \"([^\"]*)\"$")
  public void thePageSubHeadingDisplayedShouldBe(String subHeading) {
    page = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), Page.class);
    page.assertOnSubHeadingText(subHeading);
  }

  @And("I am redirected to the correct page with url path {string}")
  public void iAmRedirectedToTheCorrectPageWithUrlPath(String urlPath) {
    page = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), Page.class);
    Assert.assertTrue(page.getThisPageUrl().contains(urlPath));
  }

  @When("I can see page title {string} and page header {string}")
  public void iCanSeePageTitleAndPageHeader(String pageTitle, String pageHeader) {
    page = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), Page.class);
    AssertionHelper.updateTestStatus(this.page.getThisPageTitle().contains(pageTitle));
    AssertionHelper.updateTestStatus(this.page.getPageHeaderText().contains(pageHeader));
  }

  @When("I can see the current page header as {string}")
  public void iCanSeeCurrentPageHeaderAs(String pageHeader) {
    page = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), Page.class);
    AssertionHelper.updateTestStatus(this.page.getThisPageHeader().contains(pageHeader));
  }


  @Given("I can see page properties as follows:")
  public void iCanSeePagePropertiesAsFollows(DataTable dataTable) {
    page = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), Page.class);
    AssertionHelper.updateTestStatus(this.page.getThisPageUrl().contains(dataTable.cell(1, 0)));
    AssertionHelper.updateTestStatus(this.page.getThisPageTitle().contains(dataTable.cell(1, 1)));
  }

  @Then("I should see {string} and {string}")
  public void iShouldSeeAnd(String pageTitle, String pageUrl) {
    page = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), Page.class);
    AssertionHelper.updateTestStatus(this.page.getThisPageTitle().contains(pageTitle));
    AssertionHelper.updateTestStatus(this.page.getThisPageUrl().contains(pageUrl));
  }

  @Then("I should see page title and url {string}, {string} respectively")
  public void iShouldSeePageTitleAndUrl(String pageTitle, String pageUrl) {
    page = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), Page.class);
    AssertionHelper.updateTestStatus(this.page.getThisPageTitle().contains(pageTitle));
    AssertionHelper.updateTestStatus(this.page.getThisPageUrl().contains(pageUrl));
  }

  @And("I logout application")
  public void iLogoutApplication() {
    AccountPage accountPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), AccountPage.class);
    //accountPage.clickOnLogoffButton();
    LogoutPage logoutPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), LogoutPage.class);
    logoutPage.clickOnLogoutContinueButton();
    WebDrv.getInstance().getWebDriver().quit();
  }

  @When("I can see page breadcrumb as follows:")
  public void iCanSeePageBreadcrumbAsFollows(DataTable dataTable) {
    page = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), Page.class);
    dataTable
        .asList()
        .forEach(
            breadcrumb ->
                AssertionHelper.updateTestStatus(
                    page.assertCurrentPageBreadCrumbMenuIsDisplayedCorrectly(breadcrumb)));
  }

  @When("I can see current page breadcrumb {string}")
  public void iCanSeeCurrentPageBreadcrumb(String pageBreadcrumb) {
    AssertionHelper.updateTestStatus(
        this.page.assertCurrentPageBreadCrumbMenuIsDisplayedCorrectly(pageBreadcrumb));
  }

  @Then("I logoff application")
  public void iLogoffApplication() {

  }

  @Then("logoff application")
  public void logoffApplication() {
    AccountPage accountPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), AccountPage.class);
    LogoutPage logoutPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), LogoutPage.class);
    //accountPage.clickOnLogoffButton();
    logoutPage.clickOnLogoutContinueButton();
  }

  @When("page header is displayed as {string}")
  public void pageHeaderIsDisplayedAs(String headerText) {
    Assert.assertEquals(this.page.getPageHeaderText(), headerText);
  }

  @And("I should see in the page as follows:")
  public void iShouldSeeInThePageAsFollows(DataTable dataTable) {
    AssertionHelper.updateTestStatus(this.page.getThisPageUrl().contains(dataTable.cell(1, 0)));
    AssertionHelper.updateTestStatus(this.page.getThisPageTitle().contains(dataTable.cell(1, 1)));
  }

/*  @Then("should be presented with the following validation message as {string}")
  public void shouldBePresentedWithTheFollowingValidationMessageAs(String loginValidationMessage) {
    AccountPage accountPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), AccountPage.class);
    //AssertionHelper.updateTestStatus(accountPage.().contains(loginValidationMessage));
  }*/


  @Then("I add the following items to cart in home page")
  public void iAddTheFollowingItemsToCartInHomePage(DataTable dataTable) {
    dataTable.asList().forEach(item -> page.addProductToCart(item));
  }

  @And("I add the following items to cart in search result page:")
  public void iAddProductsToCartInSearchResultPage(DataTable dataTable) {
    dataTable.asList().forEach(item -> page.addProductsToCart(item));
  }

  @And("I select color {string}")
  public void iSelectColor(String color) {
    // this.productIdPage.selectColor(color);
  }

  @And("I select size {string}")
  public void iSelectSize(String size) {
    // this.productIdPage.selectSize(size);
  }

  @Then("I quit browser")
  public void iQuitBrowser() {
    WebDrv.getInstance().getWebDriver().quit();
  }

  @Then("I close the browser")
  public void iCloseTheBrowser() {
    if (WebDrv.getInstance().getWebDriver() == null) {
      System.out.println("Web driver is closing browser......");
      return;
    }
    WebDrv.getInstance().getWebDriver().close();
  }

  @Given("I should see {string} link is displayed in the top menu")
  public void iShouldSeeLinkIsDisplayedInTheTopMenu(String text) {
    TopNavigationBarPage topNavigationBarPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), TopNavigationBarPage.class);
//    AssertionHelper.updateTestStatus(
//        new GetValue()
//            .getDesiredValue(
//                    topNavigationBarPage.getTopMenuList(), WebElement::getText)
//            .contains(text));
  }

  @And("tap on continues button")
  public void tapOnContinuesButton() {
    page = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), Page.class);
    page.tapOnContinueButton();
  }

  @And("I hover over on {string} and click on menuItem {string}")
  public void iHoverOverOnAndClickOnMenuItem(String categoryName, String menuItem) {
    page = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), Page.class);
    page.iHoverOverProductCategoryMenuAndClickAMenuItem(categoryName, menuItem);
  }

  @And("I hover {string} and click {string} from the dropdown list")
  public void iHoverAndClickFromTheDropdownList(String categoryName, String menuItem) {
    page = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), Page.class);
    page.iHoverOverProductCategoryMenuAndClickAMenuItem(categoryName, menuItem);
  }


  @Then("I am redirected to the correct category page")
  public void iAmRedirectedToTheCorrectCategoryPage() {
    // Write code here that verifies the correct category page is displayed
  }

  @And("the page correct heading should be {string}")
  public void thePageCorrectHeadingShouldBe(String expectedHeading) {
    page = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), Page.class);
    AssertionHelper.updateTestStatus(page.getThisPageHeader().equalsIgnoreCase(expectedHeading));
    String actualHeading = page.getPageHeaderText();
    Assert.assertEquals(actualHeading, expectedHeading, "The page heading is not correct.");
  }


  @And("the page title should be displayed as{string}")
  public void thePageTitleShouldBeDisplayedAs(String pageTitle) {
    Assert.assertTrue(Objects.requireNonNull(WebDrv.getInstance().getWebDriver().getTitle()).trim().contains(pageTitle));

  }

  @And("^I navigate to next page")
  @Then("^I tap on the Continue button$")
  public void clickOnContinueButton() {
    page = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), Page.class);
    page.clickOnContinueButton();

  }

  @When("the Page is displayed")
  public void thePageIsDisplayed() throws Exception {
    CheckPageIsLoaded.checkPageIsReady(5);
  }

  @Then("I should have the following input fields")
  public void iShouldHaveTheFollowingInputFields(List<String> inputLabels) {
    page = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), Page.class);
    for (int i = 0; i < inputLabels.size(); i++) {
      page.assertInputLabel(i, inputLabels.get(i));
      System.out.println(i + ": " + inputLabels.get(i));
    }
  }

  @And("I click on the Continue button")
  public void iClickOnTheContinueButton() {
    page = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), Page.class);
    page.clickOnContinueBtn();

  }
}
