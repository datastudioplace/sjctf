package com.localhost8888.cucumber.stepDefinitions;

import com.localhost8888.pages.*;
import com.localhost8888.webdriverutilities.WebDrv;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Objects;

public class TopNavigationBarSteps {
  private WebDriver driver;
  private TopNavigationBarPage topNavigationBarPage;

  public TopNavigationBarSteps() {
    driver = WebDrv.getInstance().getWebDriver();
    topNavigationBarPage = new TopNavigationBarPage();
  }

/*  @And("the page title should be displayed as {string}")
  public void thePageTitleShouldBeDisplayedAs(String expectedTitle) {
    String actualTitle = driver.getTitle();
    Assert.assertEquals(actualTitle, expectedTitle, "Page title did not match");
  }*/

  @Then("should be presented with the following validation message as {string}")
  public void shouldBePresentedWithTheFollowingValidationMessageAs(String expectedMessage) {
    String actualMessage = topNavigationBarPage.getUserNameText();
    Assert.assertEquals(actualMessage, expectedMessage, "Validation message did not match");
  }

  @And("I am presented with the following menu button")
  public void iAmPresentedWithTheFollowingMenuButton(List<String> menuButtons) {
    for (String button : menuButtons) {
      switch (button) {
        case "Calendar":
          Assert.assertTrue(topNavigationBarPage.isCalendarLinkDisplayed(), "Calendar link is not displayed");
          break;
        case "Leads":
          Assert.assertTrue(topNavigationBarPage.isLeadsLinkDisplayed(), "Leads link is not displayed");
          break;
        case "Organizations":
          Assert.assertTrue(topNavigationBarPage.isOrganizationsLinkDisplayed(), "Organizations link is not displayed");
          break;
        case "Contacts":
          Assert.assertTrue(topNavigationBarPage.isContactsLinkDisplayed(), "Contacts link is not displayed");
          break;
        case "Opportunities":
          Assert.assertTrue(topNavigationBarPage.isOpportunitiesLinkDisplayed(), "Opportunities link is not displayed");
          break;
        case "Products":
          Assert.assertTrue(topNavigationBarPage.isProductsLinkDisplayed(), "Products link is not displayed");
          break;
        case "Documents":
          Assert.assertTrue(topNavigationBarPage.isDocumentsLinkDisplayed(), "Documents link is not displayed");
          break;
        case "Email":
          Assert.assertTrue(topNavigationBarPage.isEmailLinkDisplayed(), "Email link is not displayed");
          break;
        case "Trouble Tickets":
          Assert.assertTrue(topNavigationBarPage.isTroubleTicketsLinkDisplayed(), "Trouble Tickets link is not displayed");
          break;
        case "Dashboard":
          Assert.assertTrue(topNavigationBarPage.isDashboardLinkDisplayed(), "Dashboard link is not displayed");
          break;
        case "More":
          Assert.assertTrue(topNavigationBarPage.isMoreLinkDisplayed(), "More link is not displayed");
          break;
        default:
          throw new IllegalArgumentException("Invalid menu button: " + button);
      }
    }
  }

  @And("I hover over an item {string}")
  public void iHoverOverAnItem(String item) {
    if ("More".equals(item)) {
      topNavigationBarPage.hoverOverMoreLink();
    } else {
      throw new IllegalArgumentException("Invalid item to hover over: " + item);
    }
  }

  @And("I should see a dropdown menu with the following options")
  public void iShouldSeeADropdownMenuWithTheFollowingOptions(List<String> dropdownOptions) {
    for (String option : dropdownOptions) {
      Assert.assertTrue(topNavigationBarPage.isDropdownOptionDisplayed(option), option + " option is not displayed");
    }
  }

  @And("I tap on the {string}")
  public void iTapOnThe(String link) {
      if (link.equals("Leads")) {
          topNavigationBarPage.clickLeadsLink();
      } else {
          throw new IllegalArgumentException("Invalid link to tap on: " + link);
      }
  }


  @And("I can see {string}, user image help and setting icons are displayed")
  public void iCanSeeUserImageHelpAndSettingIconsAreDisplayed(String expectedUserName) {
    Assert.assertTrue(topNavigationBarPage.isUserNameDisplayed(), "User name is not displayed");
    Assert.assertEquals(topNavigationBarPage.getUserNameText().trim(), expectedUserName, "User name did not match");
    Assert.assertTrue(topNavigationBarPage.isUserImageDisplayed(), "User image is not displayed");
    Assert.assertTrue(topNavigationBarPage.isHelpIconDisplayed(), "Help icon is not displayed");
    Assert.assertTrue(topNavigationBarPage.isCrmSettingsIconDisplayed(), "CRM Settings icon is not displayed");
  }

  @And("hover over {string} next to user name")
  public void hoverOverNextToUserName(String element) {
    if ("user Image".equalsIgnoreCase(element)) {
      topNavigationBarPage.hoverOverUserImage();
    } else {
      throw new IllegalArgumentException("Invalid element to hover over: " + element);
    }
  }

  @Then("I should see {string} from the drop down list")
  public void iShouldSeeFromTheDropDownList(String expectedOption, List<String> dropdownOptions) {
    Assert.assertTrue(topNavigationBarPage.isDropdownOptionDisplayed(expectedOption), expectedOption + " option is not displayed");
    for (String option : dropdownOptions) {
      Assert.assertTrue(topNavigationBarPage.isDropdownOptionDisplayed(option), option + " option is not displayed");
    }
  }

  @When("I click on the {string} link")
  public void iClickOnTheLink(String link) {
    if ("Sign Out".equalsIgnoreCase(link)) {
      topNavigationBarPage.clickSignOut();
    } else {
      throw new IllegalArgumentException("Invalid link to click on: " + link);
    }
  }

}