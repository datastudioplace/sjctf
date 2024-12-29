package com.localhost8888.cucumber.runners;

import io.cucumber.testng.CucumberOptions;
import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
    monochrome = true,
    features = {"src/test/java/com/localhost8888/cucumber/features/"},
    glue = {"com.localhost8888.cucumber.stepDefinitions"},
    plugin = {"pretty", "html:target/cucumber-html", "json:target/cucumber.json"},
    tags = "@CandidateRegressionNew")
public class CustomerRunner {

  @BeforeClass
  public static void setup() throws Throwable {
    /*		AdminUIClearDownHelper.clearEmployerUserAndEmployerTestData(AdminUITestData.MULTI_ORG_EMPLOYER_CODE);
    SetUpHelper.clearTestData();
    SetUpHelper.changePassword("nhsbsa.nhsjobs@nhsbsa.nhs.uk", "m4sterpassw0rd?", "Password1234");
    SetUpHelper.createUser();
    CandidateSetUpHelper.changeSafeguardingSetting();
    CandidateSetUpHelper.LoginAsEmployerUser();*/
  }

  @AfterClass
  public static void tearDown() throws IOException, InterruptedException {
    /*		SetUpHelper.clearCandidateTestData();
    SetUpHelper.clearTestData();*/
  }
}
