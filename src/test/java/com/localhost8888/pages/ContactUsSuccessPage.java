package com.localhost8888.pages;

import com.localhost8888.helperutilities.assertion.VerificationHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsSuccessPage {
  private final Logger log = LogManager.getLogger(ContactUsSuccessPage.class);
  Page page;
  IndexPage indexPage;

  @FindBy(css = ".mb40 > p:nth-of-type(2)")
  private WebElement successfullySentMsg;

  @FindBy(css = ".mb40 > a[title='Continue']")
  private WebElement continueBtn;

  public String getContinueButtonText() {
    return new VerificationHelper().getText(continueBtn);
  }

  public String getSuccessfullySentMessage() {
    return new VerificationHelper().getText(successfullySentMsg);
  }

  public LoginPage clickOnContinueButton() {
    continueBtn.click();
    return new LoginPage();
  }
}
