package com.localhost8888.pages;

import com.localhost8888.helperutilities.assertion.VerificationHelper;
import com.localhost8888.helperutilities.wait.WaitUtils;
import com.localhost8888.webdriverutilities.WebDrv;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FooterPage {
  @FindBy(xpath = "//span[contains(text(), 'Powered by vtiger CRM')]")
  private WebElement poweredByVtiger;

  @FindBy(xpath = "//a[contains(text(), 'vtiger.com')]")
  private WebElement vtigerLink;

  @FindBy(xpath = "//a[contains(text(), 'Read License')]")
  private WebElement readLicenseLink;

  @FindBy(xpath = "//a[contains(text(), 'Privacy Policy')]")
  private WebElement privacyPolicyLink;

  @FindBy(css = "img[src='include/images//Facebook.png']")
  private WebElement facebookLink;

  @FindBy(css = "img[src='include/images//Twitter.png']")
  private WebElement twitterLink;

  @FindBy(css = "img[src='include/images//Linkedin.png']")
  private WebElement linkedinLink;

  @FindBy(css = "img[src='include/images//Youtube.png']")
  private WebElement youtubeLink;

  @FindBy(css = "img[src='include/images//Manuals.png']")
  private WebElement manualsLink;

  @FindBy(css = "img[src='include/images//Forums.png']")
  private WebElement forumsLink;

  @FindBy(css = "img[src='include/images//Blogs.png']")
  private WebElement blogsLink;

  public FooterPage() {
    PageFactory.initElements(WebDrv.getInstance().getWebDriver(), this);
  }

  public boolean isPoweredByVtigerDisplayed() {
    return new VerificationHelper().isDisplayed(poweredByVtiger);
  }

  public boolean isVtigerLinkDisplayed() {
    return new VerificationHelper().isDisplayed(vtigerLink);
  }

  public boolean isReadLicenseLinkDisplayed() {
    return new VerificationHelper().isDisplayed(readLicenseLink);
  }

  public boolean isPrivacyPolicyLinkDisplayed() {
    return new VerificationHelper().isDisplayed(privacyPolicyLink);
  }

  public boolean isFacebookLinkDisplayed() {
    return new VerificationHelper().isDisplayed(facebookLink);
  }

  public boolean isTwitterLinkDisplayed() {
    return new VerificationHelper().isDisplayed(twitterLink);
  }

  public boolean isLinkedinLinkDisplayed() {
    return new VerificationHelper().isDisplayed(linkedinLink);
  }

  public boolean isYoutubeLinkDisplayed() {
    return new VerificationHelper().isDisplayed(youtubeLink);
  }

  public boolean isManualsLinkDisplayed() {
    return new VerificationHelper().isDisplayed(manualsLink);
  }

  public boolean isForumsLinkDisplayed() {
    return new VerificationHelper().isDisplayed(forumsLink);
  }

  public boolean isBlogsLinkDisplayed() {
    return new VerificationHelper().isDisplayed(blogsLink);
  }

  public boolean isVtigerLinkEnabled() {
    return new VerificationHelper().isEnabled(vtigerLink);
  }

  public boolean isReadLicenseLinkEnabled() {
    return new VerificationHelper().isDisplayed(readLicenseLink);
  }

  public boolean isPrivacyPolicyLinkEnabled() {
    return new VerificationHelper().isEnabled(privacyPolicyLink);
  }

  public boolean isFacebookLinkEnabled() {
    return new VerificationHelper().isEnabled(facebookLink);
  }

  public boolean isTwitterLinkEnabled() {
    return new VerificationHelper().isEnabled(twitterLink);
  }

  public boolean isLinkedinLinkEnabled() {
    return new VerificationHelper().isEnabled(linkedinLink);
  }

  public boolean isYoutubeLinkEnabled() {
    return new VerificationHelper().isEnabled(youtubeLink);
  }

  public boolean isManualsLinkEnabled() {
    return new VerificationHelper().isEnabled(manualsLink);
  }

  public boolean isForumsLinkEnabled() {
    return new VerificationHelper().isEnabled(forumsLink);
  }

  public boolean isBlogsLinkEnabled() {
    return new VerificationHelper().isEnabled(blogsLink);
  }

  public void clickVtigerLink() {
    WaitUtils.waitForElementToBeClickable(vtigerLink).ifPresent(WebElement::click);
  }

  public void clickReadLicenseLink() {
    WaitUtils.waitForElementToBeClickable(readLicenseLink).ifPresent(WebElement::click);
  }

  public void clickPrivacyPolicyLink() {
    privacyPolicyLink.click();
  }

  public void clickFacebookLink() {
    facebookLink.click();
  }

  public void clickTwitterLink() {
    WaitUtils.waitForElementToBeClickable(twitterLink).ifPresent(WebElement::click);
  }

  public void clickLinkedinLink() {
    WaitUtils.waitForElementToBeClickable(linkedinLink).ifPresent(WebElement::click);
  }

  public void clickYoutubeLink() {
    WaitUtils.waitForElementToBeClickable(youtubeLink).ifPresent(WebElement::click);
  }

  public void clickManualsLink() {
    WaitUtils.waitForElementToBeClickable(manualsLink).ifPresent(WebElement::click);
  }

  public void clickForumsLink() {
    WaitUtils.waitForElementToBeClickable(forumsLink).ifPresent(WebElement::click);
  }

  public void clickBlogsLink() {
    WaitUtils.waitForElementToBeClickable(blogsLink).ifPresent(WebElement::click);
  }
}