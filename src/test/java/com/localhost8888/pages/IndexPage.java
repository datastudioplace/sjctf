package com.localhost8888.pages;

import com.localhost8888.helperutilities.assertion.VerificationHelper;
import com.localhost8888.webdriverutilities.WebDrv;
import java.time.Duration;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndexPage {
  private static final Logger log = LogManager.getLogger(IndexPage.class);
  private final String linkSubMenu = "//a[text()='%s']";
  private final String linkSubMenu2 = "//div[text()='%s']/parent::a[text()='%s']";
  WebDriverWait wait;
  By addToCart = By.cssSelector("[title='Add to Cart']");

  @FindBy(css = ".welcome_msg h4")
  private WebElement welcome_msg;

  @FindBy(xpath = "///h2[@innertext='Fast shipping']")
  private WebElement fastShipping;

  @FindBy(xpath = "///h2[@innertext='Easy Payments']")
  private WebElement easyPayments;

  @FindBy(xpath = "///h2[@innertext='Shipping Options']")
  private WebElement shippingOptions;

  @FindBy(xpath = "///h2[@innertext='Large Variety']")
  private WebElement largeVariety;

  @FindBy(xpath = "span.maintext")
  private List<WebElement> headingLists;

  @FindBy(css = ".col-md-3.col-sm-6.col-xs-12")
  private List<WebElement> allProductsList;

  @FindBy(css = ".info_links_footer > li:nth-of-type(5) > a")
  private WebElement contactusLink;

  public String getFastShipping() {
    return fastShipping.getText();
  }

  public String getEasyPayments() {
    return easyPayments.getText();
  }

  public String getShippingOptions() {
    return shippingOptions.getText();
  }

  public String getLargeVarietyLargeVariety() {
    return largeVariety.getText();
  }

  public List<WebElement> getHeadingLists() {
    return headingLists;
  }

  public List<WebElement> getProductList() {
    return allProductsList;
  }

  public void addProductsToCart(String productName) {
    WebElement prod = getProductByName(productName);
    prod.findElement(addToCart).click();
  }

  public WebElement getProductByName(String productName) {
    return allProductsList.stream()
        .parallel()
        .filter(
            product ->
                product
                    .findElement(By.cssSelector("a.prdocutname"))
                    .getText()
                    .contains(productName))
        .findFirst()
        .orElse(null);
  }

  public IndexPage addProductToCart(String productName) {
    List<WebElement> products =
        WebDrv.getInstance()
            .getWebDriver()
            .findElements(By.cssSelector("div.col-md-3.col-sm-6.col-xs-12"));
    WebElement prod =
        products.stream()
            .parallel()
            .filter(
                product ->
                    product
                        .findElement(By.cssSelector("a"))
                        .getText()
                        .equalsIgnoreCase(productName))
            .findFirst()
            .orElse(null);
    assert prod != null;
    prod.findElement(By.cssSelector("a.productcart")).click();
    log.info("Product " + productName + " added to cart");
    return this;
  }

  public String getWelcomeMessage() {
    wait = new WebDriverWait(WebDrv.getInstance().getWebDriver(), Duration.ofSeconds(10));
    return new VerificationHelper().getText(welcome_msg);
  }
}
