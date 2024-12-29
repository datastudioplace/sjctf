package com.localhost8888.listeners;

import com.localhost8888.enums.ConfigProperties;
import com.localhost8888.utils.PropertyUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Implements {@link IRetryAnalyzer}.
 *
 * <p>Helps in rerunning the failed tests.
 *
 * <p>Jan 21, 2021
 *
 * @author Amuthan Sakthivel
 * @version 1.0
 * @since 1.0
 */
public class RetryFailedTests implements IRetryAnalyzer {

  private int count = 0;
  private int retries = 1;

  /**
   * Return true when needs to be retried and false otherwise. Maximum will retry for one time.
   * Retry will happen if user desires to and set the value in the property file
   */
  @Override
  public boolean retry(ITestResult result) {
    boolean value = false;

    try {
      if (PropertyUtils.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
        value = count < retries;
        count++;
      }
    } catch (Throwable e) {
      throw new RuntimeException(e);
    }
    return value;
  }
}
