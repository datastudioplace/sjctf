package com.localhost8888.reportFiles.report;

import com.localhost8888.utils.Constants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

  public static ExtentReports setUpExtentReport() {

    ExtentSparkReporter reporter = new ExtentSparkReporter(Constants.EXECUTION_REPORT_PATH);

    ExtentReports extent = new ExtentReports();

    extent.attachReporter(reporter);

    return extent;
  }
}
