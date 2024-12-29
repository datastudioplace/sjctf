package com.demos;

import com.localhost8888.helperutilities.LinkUtil;
import com.demos.supplier.DriverFactory;
import java.time.LocalDateTime;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BrokenLinkTest {

  private WebDriver driver;

  @BeforeTest
  @Parameters("browser")
  public void setDriver(@Optional("chrome") String browser) {
    this.driver = DriverFactory.getDriver(browser);
    this.driver.manage().window().maximize();
  }

  // https://the-internet.herokuapp.com/broken_images

  @Test
  public void linkTest() {
    this.driver.get("https://automationteststore.com/");

    System.out.println("Before :: " + LocalDateTime.now());

    List<String> brokenLinks =
        this.driver.findElements(By.xpath("//*[@href]")).stream()
            .parallel()
            .map(e -> e.getAttribute("href"))
            .filter(src -> LinkUtil.getResponseCode(src) != 200)
            .toList(); // Using toList() instead of collect(Collectors.toList())

    // If you need to use the brokenLinks list, you can add further processing here
    brokenLinks.forEach(link -> System.out.println("Broken link: " + link));

    System.out.println("After :: " + LocalDateTime.now());
  }

  @AfterTest
  public void quitDriver() {
    this.driver.quit();
  }
}
