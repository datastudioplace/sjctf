package com.localhost8888.cucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
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
    //tags = "@Leads",
        tags = "@createLeads",

    dryRun = false)
public class CreateLeadsRunner extends AbstractTestNGCucumberTests {


}
