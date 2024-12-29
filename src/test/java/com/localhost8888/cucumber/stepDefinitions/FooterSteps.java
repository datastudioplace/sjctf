package com.localhost8888.cucumber.stepDefinitions;

import com.localhost8888.pages.FooterPage;
import com.localhost8888.webdriverutilities.WebDrv;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FooterSteps {
  FooterPage footerPage;

  public FooterSteps() {
    footerPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), FooterPage.class);
  }

  @And("I should see all the links in the footer index page")
  public void iShouldSeeAllTheLinksInTheFooterIndexPage() {
    footerPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), FooterPage.class);
//    Assert.assertTrue(footerPage.isPoweredByVtigerDisplayed(), "Powered by vtiger CRM is not displayed");
//    Assert.assertTrue(footerPage.isVtigerLinkDisplayed(), "vtiger.com link is not displayed");
//    Assert.assertTrue(footerPage.isReadLicenseLinkDisplayed(), "Read License link is not displayed");
//    Assert.assertTrue(footerPage.isPrivacyPolicyLinkDisplayed(), "Privacy Policy link is not displayed");
    Assert.assertTrue(footerPage.isFacebookLinkDisplayed(), "Facebook link is not displayed");
    Assert.assertTrue(footerPage.isTwitterLinkDisplayed(), "Twitter link is not displayed");
    Assert.assertTrue(footerPage.isLinkedinLinkDisplayed(), "Linkedin link is not displayed");
    Assert.assertTrue(footerPage.isYoutubeLinkDisplayed(), "Youtube link is not displayed");
    Assert.assertTrue(footerPage.isManualsLinkDisplayed(), "Manuals link is not displayed");
    Assert.assertTrue(footerPage.isForumsLinkDisplayed(), "Forums link is not displayed");
    Assert.assertTrue(footerPage.isBlogsLinkDisplayed(), "Blogs link is not displayed");
  }

  @And("I should see all the links in the footer pages")
  public void iShouldSeeAllTheLinksInTheFooterPage() {
    footerPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), FooterPage.class);
    Assert.assertTrue(footerPage.isPoweredByVtigerDisplayed(), "Powered by vtiger CRM is not displayed");
    Assert.assertTrue(footerPage.isVtigerLinkDisplayed(), "vtiger.com link is not displayed");
    Assert.assertTrue(footerPage.isReadLicenseLinkDisplayed(), "Read License link is not displayed");
    Assert.assertTrue(footerPage.isPrivacyPolicyLinkDisplayed(), "Privacy Policy link is not displayed");

  }

  @And("I verify if the links are present and enabled")
  public void iVerifyIfTheLinksArePresentAndEnabled() {
    footerPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), FooterPage.class);
    Assert.assertTrue(footerPage.isReadLicenseLinkEnabled(), "Read License link is not enabled");
    Assert.assertTrue(footerPage.isPrivacyPolicyLinkEnabled(), "Privacy Policy link is not enabled");
    Assert.assertTrue(footerPage.isFacebookLinkEnabled(), "Facebook link is not enabled");
    Assert.assertTrue(footerPage.isTwitterLinkEnabled(), "Twitter link is not enabled");
    Assert.assertTrue(footerPage.isLinkedinLinkEnabled(), "Linkedin link is not enabled");
    Assert.assertTrue(footerPage.isYoutubeLinkEnabled(), "Youtube link is not enabled");
    Assert.assertTrue(footerPage.isManualsLinkEnabled(), "Manuals link is not enabled");
    Assert.assertTrue(footerPage.isForumsLinkEnabled(), "Forums link is not enabled");
    Assert.assertTrue(footerPage.isBlogsLinkEnabled(), "Blogs link is not enabled");
  }

  @And("I verify if the links are present")
  public void iVerifyIfTheLinksArePresent() {
    footerPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), FooterPage.class);
    Assert.assertTrue(footerPage.isReadLicenseLinkDisplayed(), "Read License link is not enabled");
    Assert.assertTrue(footerPage.isPrivacyPolicyLinkDisplayed(), "Privacy Policy link is not enabled");
    Assert.assertTrue(footerPage.isFacebookLinkDisplayed(), "Facebook link is not enabled");

  }

  @And("I click on each of the link and navigate back to index page")
  public void iClickOnEachOfTheLinkAndNavigateBackToIndexPage() {
    footerPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), FooterPage.class);
    //footerPage.clickVtigerLink();
    //WebDrv.getInstance().getWebDriver().navigate().back();
    footerPage.clickReadLicenseLink();
    WebDrv.getInstance().getWebDriver().navigate().back();
    footerPage.clickPrivacyPolicyLink();
    WebDrv.getInstance().getWebDriver().navigate().back();
    footerPage.clickFacebookLink();
    WebDrv.getInstance().getWebDriver().navigate().back();
    footerPage.clickTwitterLink();
    WebDrv.getInstance().getWebDriver().navigate().back();
    footerPage.clickLinkedinLink();
    WebDrv.getInstance().getWebDriver().navigate().back();
    footerPage.clickYoutubeLink();
    WebDrv.getInstance().getWebDriver().navigate().back();
    footerPage.clickManualsLink();
    WebDrv.getInstance().getWebDriver().navigate().back();
    footerPage.clickForumsLink();
    WebDrv.getInstance().getWebDriver().navigate().back();
    footerPage.clickBlogsLink();
    WebDrv.getInstance().getWebDriver().navigate().back();
  }
}