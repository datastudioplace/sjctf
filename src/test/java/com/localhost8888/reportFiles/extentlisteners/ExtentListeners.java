package com.localhost8888.reportFiles.extentlisteners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentListeners implements ITestListener {

  public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
  static Date d = new Date();
  static String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
  private static ExtentReports extent =
      ExtentManager.createInstance(System.getProperty("user.dir") + "\\reports\\" + fileName);

  public void onTestStart(ITestResult result) {

    ExtentTest test =
        extent.createTest(
            result.getTestClass().getName()
                + "     @TestCase : "
                + result.getMethod().getMethodName());
    testReport.set(test);
  }

  public void onTestSuccess(ITestResult result) {
    String methodName = result.getMethod().getMethodName();
    String logText = "<b>" + "TEST CASE:- " + methodName.toUpperCase() + " PASSED" + "</b>";
    Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
    testReport.get().pass(m);
  }

  public void onTestFailure(ITestResult result) {
    String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());
    testReport
        .get()
        .fail(
            "<details>"
                + "<summary>"
                + "<b>"
                + "<font color="
                + "red>"
                + "Exception Occured:Click to see"
                + "</font>"
                + "</b >"
                + "</summary>"
                + excepionMessage.replaceAll(",", "<br>")
                + "</details>"
                + " \n");

    String failureLogg = "TEST CASE FAILED";
    Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
    testReport.get().log(Status.FAIL, m);
    testReport.get().fail(result.getThrowable());
  }

  public void onTestSkipped(ITestResult result) {
    String methodName = result.getMethod().getMethodName();
    String logText = "<b>" + "Test Case:- " + methodName + " Skipped" + "</b>";
    Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
    testReport.get().skip(m);
  }

  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    // TODO Auto-generated method stub

  }

  public void onStart(ITestContext context) {}

  public void onFinish(ITestContext context) {
    if (extent != null) {
      extent.flush();
      			String pathOfExtentReport = System.getProperty("user.dir") + "\\extent_report\\index.html";
      File extentReport = new File(pathOfExtentReport);
      try {
      	Desktop.getDesktop().browse(extentReport.toURI());
      } catch (IOException e) {
      	e.printStackTrace();
      }
    }
  }
}