package com.demos;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class sauceLab_OrangeHRMTest {

  RemoteWebDriver driver;

  @Test
  public void login() throws MalformedURLException {

    ChromeOptions browserOptions = new ChromeOptions();
    browserOptions.setPlatformName("Windows 11");
    browserOptions.setBrowserVersion("latest");
    Map<String, Object> sauceOptions = new HashMap();
    sauceOptions.put("username", "oauth-shelendra.1989-93261");
    sauceOptions.put("accessKey", "737c575c-0684-4a88-a20b-d3684420c05e");
    sauceOptions.put("build", "Test Automation");
    sauceOptions.put("name", "Sanity test");
    browserOptions.setCapability("sauce:options", sauceOptions);

    URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
    driver = new RemoteWebDriver(url, browserOptions);
    // Open Chrome
    // driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    // Open login page
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    // Enter username
    driver.findElement(By.name("username")).sendKeys("Admin");

    // Enter password
    driver.findElement(By.name("password")).sendKeys("admin123");

    // Click on login button.
    driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
  }

  @Test
  public void testAdmin() {
    driver.findElement(By.xpath("//span[text()='Admin']")).click();
    boolean isDisplayed = driver.findElement(By.xpath("//h5[text()='System Users']")).isDisplayed();

    Assert.assertTrue(isDisplayed);
  }

  @Test
  public void testLogout() {
    driver.findElement(By.xpath("//img[@alt=\"profile picture\"]")).click();
    driver.findElement(By.linkText("Logout")).click();
  }
}
