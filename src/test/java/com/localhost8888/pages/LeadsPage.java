package com.localhost8888.pages;

import com.localhost8888.helperutilities.assertion.VerificationHelper;
import com.localhost8888.helperutilities.wait.WaitUtils;
import com.localhost8888.webdriverutilities.WebDrv;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {

  // Define elements and actions related to Leads page here
  @FindBy(css = "img[title='Create Lead...']")
  private WebElement createNewLeadButton;

  public boolean isCreateNewLeadButtonDisplayed() {
    return createNewLeadButton.isDisplayed();
  }

  public CreateNewLeadsPage clickCreateNewLeadButton() {
    createNewLeadButton.click();
    return new CreateNewLeadsPage();
  }


    public void clickLeadsLink() {
      createNewLeadButton.click();
    }


}
