package com.demos;

import com.demos.supplier.DriverFactory;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class HoverableDropdownTest {

  private WebDriver driver;
  private Actions actions;

  @BeforeTest
  @Parameters("browser")
  public void setDriver(@Optional("chrome") String browser) {
    this.driver = DriverFactory.getDriver(browser);
    this.actions = new Actions(driver);
  }

  public void dropdownTest() {
    this.driver.get("https://automationteststore.com/");
    List<WebElement> categories =
        this.driver.findElements(By.xpath("//*[@id='categorymenu']/nav/ul/li/a"));
    categories.stream()
        .filter(element -> element.getText().equalsIgnoreCase("Apparel & accessories"))
        .map(ele -> actions.moveToElement(ele))
        .findFirst()
        .ifPresent(Actions::perform);

    Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
  }

  @AfterTest
  public void quitDriver() {
    this.driver.quit();
  }
}
