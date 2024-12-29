package com.localhost8888.cucumber.stepDefinitions;

import com.localhost8888.pages.LoginPage;
import com.localhost8888.pages.AccountPage;
import com.localhost8888.webdriverutilities.WebDrv;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class AccountSteps {

    private WebDriver driver = WebDrv.getInstance().getWebDriver();
    private LoginPage loginPage = new LoginPage();
    private AccountPage accountPage;


/*    @And("the page title should be displayed as {string}")
    public void thePageTitleShouldBeDisplayedAs(String expectedTitle) {
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Page title did not match");
    }*/


}