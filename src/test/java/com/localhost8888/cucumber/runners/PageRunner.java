package com.localhost8888.cucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    dryRun = false,
    monochrome = true,
    features = {"src/test/java/com/localhost8888/cucumber/features/"},
    glue = {"com.localhost8888.cucumber.stepDefinitions"},
    plugin = {
      "pretty",
      "html:target/cucumber.html",
      "json:target/cucumber.json",
      "html:cucumberReport/cucumber.html",
      "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    },

    // tags = "@login"
    tags = "@NJA-8938")
public class PageRunner extends AbstractTestNGCucumberTests {
  /*  @Override
  @DataProvider(parallel=true)
  public Object[][] scenarios() {
  	return super.scenarios();
  }*/

}
