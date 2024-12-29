package com.localhost8888.reportFiles.extentlisteners;

import com.localhost8888.webdriverutilities.WebDrv;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ExtentManager {

  public static String screenshotPath;
  public static String screenshotName;
  private static ExtentReports extent;

  public static ExtentReports createInstance(String fileName) {
    ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);

    htmlReporter.config().setTheme(Theme.STANDARD);
    htmlReporter.config().setDocumentTitle(fileName);
    htmlReporter.config().setEncoding("utf-8");
    htmlReporter.config().setReportName(fileName);

    extent = new ExtentReports();
    extent.attachReporter(htmlReporter);
    extent.setSystemInfo("Automation Tester", "B Azeta");
    extent.setSystemInfo("Organization", "localhost8888");
    extent.setSystemInfo("Build no", "ATS-1234");
    return extent;
  }

  public static void captureScreenshot() {

    File scrFile =
        ((TakesScreenshot) WebDrv.getInstance().getWebDriver()).getScreenshotAs(OutputType.FILE);

    Date d = new Date();
    screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

    try {
      FileUtils.copyFile(
          scrFile, new File(System.getProperty("user.dir") + "\\reports\\" + screenshotName));
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
    TakesScreenshot ts = (TakesScreenshot) driver;
    File source = ts.getScreenshotAs(OutputType.FILE);
    File file =
        new File(System.getProperty("user.dir") + "//extentReports//" + testCaseName + ".png");
    FileUtils.copyFile(source, file);
    return System.getProperty("user.dir") + "//extentReports//" + testCaseName + ".png";
  }
}