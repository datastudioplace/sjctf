package com.localhost8888.pages;

import com.localhost8888.helperutilities.assertion.VerificationHelper;
import com.localhost8888.webdriverutilities.WebDrv;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
  private static final Logger log = LogManager.getLogger(LogoutPage.class);
  IndexPage indexPage;

  @FindBy(xpath = "//p[contains(text(),'You have been logged off your account. It is now s')]")
  private WebElement saveToLogoutTxt;

  @FindBy(css = ".mb40 > a[title='Continue']")
  private WebElement logoutAccountContinueBtn;

  @FindBy(xpath = "//*[@id='maincontainer']/div/div/div/div/section/a")
  private WebElement logoutAccountContinueButton;

  @FindBy(css = ".heading1")
  private WebElement accountLogoutTxt;

  public String getLogoutAccountContinueButtonText() {
    return new VerificationHelper().getText(logoutAccountContinueBtn);
  }

  public String getAccountLogoutText() {
    return new VerificationHelper().getText(accountLogoutTxt);
  }

  public IndexPage clickOnLogoutContinueButton() {
    logoutAccountContinueButton.click();
    log.info("Clicked logout continue button..");
    indexPage = PageFactory.initElements(WebDrv.getInstance().getWebDriver(), IndexPage.class);
    return indexPage;
  }

  public String getLogoutContinueButtonTxt() {
    return new VerificationHelper().getText(logoutAccountContinueButton);
  }

  public boolean assertContinueButtonIsDisplayed() {
    return new VerificationHelper().isDisplayed(logoutAccountContinueButton);
  }
}
