package com.localhost8888.pages;

import com.localhost8888.helperutilities.assertion.VerificationHelper;
import com.localhost8888.helperutilities.wait.WaitUtils;
import com.localhost8888.webdriverutilities.WebDrv;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AccountPage {
  private static final Logger log = LogManager.getLogger(AccountPage.class);
  private final VerificationHelper verificationHelper = new VerificationHelper();
  private LogoutPage logoutPage;
  private WebDriver driver = WebDrv.getInstance().getWebDriver();
  private LoginPage loginPage = new LoginPage();
  private AccountPage accountPage;


  @FindBy(css = ".userName")
  private WebElement userProfileRoleName;





}