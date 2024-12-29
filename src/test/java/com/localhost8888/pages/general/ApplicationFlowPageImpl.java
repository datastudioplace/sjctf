package com.localhost8888.pages.general;

import com.localhost8888.helperutilities.assertors.WebElementOrderingAssertor;
import com.localhost8888.pages.Page;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class ApplicationFlowPageImpl extends Page implements ApplicationFlowPage {
  @FindBy(how = How.XPATH, using = "/html/body/div/div[1]/div[2]/section/ul/li/a")
  private List<WebElement> breadCrumbs;

  @Override
  public void assertElementIsDisplayed(
      String expectedElementName, boolean isExpectedToBeDisplayed) {
    /*    if (expectedElementName.equalsIgnoreCase("Back Link") && isExpectedToBeDisplayed) {
      Assert.assertTrue(continueButton.isDisplayed());
    } else if (expectedElementName.equalsIgnoreCase("Save and continue button")
        && isExpectedToBeDisplayed) {
      Assert.assertTrue(saveAndContinueButton.isDisplayed());
    } else if (expectedElementName.equalsIgnoreCase("Save and come back later link")
        && isExpectedToBeDisplayed) {
      Assert.assertTrue(saveAndComeBackLaterLink.isDisplayed());
    }*/
  }

  public void assertJobTitleIsAboveHeading(String expectedJobTitle) {
    WebElementOrderingAssertor webElementOrderingAssertor =
        new WebElementOrderingAssertor("heading-container");
    webElementOrderingAssertor.assertOnOrderOfWebElementsByListOrder(
        Arrays.asList("job_title", "heading"));
    Assert.assertEquals(
        expectedJobTitle,
        "Job title is not matching with actual content: ",
        String.valueOf(breadCrumbs.stream().findFirst()));
  }

  @Override
  public void assertBreadCrumbIsAboveHeading(String breadCrumb) {
    Assert.assertTrue(breadCrumb.contains((CharSequence) breadCrumbs));
  }
}
