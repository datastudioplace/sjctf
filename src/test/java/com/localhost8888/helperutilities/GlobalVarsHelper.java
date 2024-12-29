package com.localhost8888.helperutilities;

public class GlobalVarsHelper {

  public static final int IMPLICIT_WAIT_TIME = 10;
  public static final int PAGE_LOAD_TIME = 15;
  public static final int EXPLICIT_WAIT_BASIC_TIME = 30;
  // All characters validation
  public static final String ALL_CHARACTERS_VALIDATION =
      "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz!#$%&'*+-/=?^_`\\:#£:@][{|}~;.,()";
  private static final GlobalVarsHelper ourInstance = new GlobalVarsHelper();
  private String candidateUrl;
  public static String LOGIN_NAME = "webdriverio2";
  public static String PASSWORD = "webdriverio2";
  public static String INVALID_PASSWORD = "Password1234567";
  public static String USER_FIRST_NAME = "User First Name";
  public static String USER_LAST_NAME = "User Last Name";
  public static String USER_EMAIL_ADDRESS = "useremail@address.com";
  public static String CONFIG_PROPERTIES_DIRECTORY = "properties\\config.properties";
  public static String DATA_PROVIDER_JSONPATH =
      System.getProperty("user.dir") + "//src//test//java//testData//data//Register.json";
  public static String HOMEPAGE_PAGE_URL = "http://localhost:8888";
  public static String URL_HOMEPAGE = "http://localhost:8888";
  public static String REGISTRATION_PAGE_URL =
      "http://localhost:8888/index.php?rt=account/create";
  public static String REGISTRATION_PAGE_TITLE = "Register Account";
  public static String REGISTRATION_PAGE_HEADER = "Register Account";
  public static String LOGIN_PAGE_URL =
      "http://localhost:8888/";
  public static String LOGIN_PAGE_TITLE = "ACCOUNT LOGIN";
  public static String LOGIN_PAGE_HEADER = "My Account";
  public static String BROWSER = "Chrome";
  public static String RETURNING_CUSTOMER = "Returning Customer";
  public static String NEW_CUSTOMER = "New Customer";
  public static String myAccountInformation = "My Account Information";
  public static String REGISTER_JSON_PATH =
      "//src//test//java//opencart//testData.data//createAnAccount.json";
  public static String recoveryPassword_Username = "benazeta70";
  public static String EMAIL = "email@email.com";
  public static String accountSuccessfullyUpdated =
      "Success: Your account has been Success: Your account has been successfully updated..";
  public static String wrong_password = "Password_Wrong";
  public static String pass_word = "Password";
  public static String CONTINUE_BUTTON = "Continue";
  public static String HOMEPAGE_TITLE = "Your Store";
  public static String ACCOUNT_LOGOUT_HEADER = "Account Logout";
  public static String ACCOUNT_EDIT_URL_PATH = "account/edit";
  public static String PRODUCT_NAME_1 = "Skinsheen Bronzer Stick";
  public static String PRODUCT_NAME_2 = "Benefit Bella Bamba";
  public static String PRODUCT_NAME_3 = "Absolue Eye Precious Cells";
  public static String Benefit_Bella_Bamba = "Benefit Bella Bamba";
  // =================================================================//
  public static String LASTNAME = "John";
  public static String FIRSTNAME = "Doe";
  public static String TELEPHONE = "0740500000000";
  public static String FAX = "0740500000001";
  public static String VALID_PASSWORD = "webdriverio2";
  public static String INCORRECT_LOGIN_PASSWORD_PROVIDED =
      "Warning: No match for E-Mail Address and/or Password.";
  public static String RECOVERY_PASSWORD_SUCCESS_MSG =
      "Success: Password reset link has been sent to your e-mail address";
  public static String RECOVERY_LOGINNAME_SUCCESS_MSG =
      "Success: Your login name reminder has been sent to your e-mail address.";
  public static String FORGET_YOUR_PASSWORD_LINK_TXT = "Forgot your password?";
  public static String FORGET_YOUR_LOGINNAME_LINK_TXT = "Forgot your login?";
  public static int explicitWait = 15;
  public static int EXPWAIT = 5;
  public static int SHORT_IMPLICIT_WAIT_TIME = 5;
  public static int THREE = 3;
  public static int TWO = 2;
  public static int ONE = 1;
  public static int FIVE = 5;
  public static int SIX = 6;
  public static int IMPLICIT_TIMEOUT = 10;
  public static int IMPLICIT_WAIT_TIMEOUT = 1;
  public static int DEFAULT_EXPLICIT_TIMEOUT = 15;
  public static int EXPLICIT_TIMEOUT = 30;
  public static int POLLING_TIMEOUT = 250;
  public static int PAGE_LOAD_TIMEOUT = 120;
  public static int DEFAULT_IMPLICIT_TIMEOUT = 7;
  public static int implicitWait = 10;



  public String getCandidateURL() {
    return candidateUrl;
  }

  // FTE Page
  public static String GOOGLE_ANALYTICS_DETAILS =
      "Google Analytics stores the following cookies on your computer:"
          + "\n"
          + "cookies and purpose\n"
          + "Name Purpose Expires\n"
          + "_ga Counts how many people have visited NHS Jobs and tracks if you have visited before 2 years\n"
          + "_gid Counts how many people have visited NHS Jobs and tracks if you have visited before 24 hours\n"
          + "_gat Limits the rate of page view requests recorded by Google 1 minute";
  public static String ESSENTIAL_COOKIES_DETAILS =
      "NHS Jobs' cookies message\n"
          + "You'll see a message about cookies when you first visit NHS Jobs. A cookie will then be stored on your computer, so it knows you've seen it and knows not to show it again."
          + "\n"
          + "cookies and purpose\n"
          + "Name Purpose Expires\n"
          + "seen_cookie_message Saves a message to let us know that you have seen our cookie message 28 days\n"
          + "NHS Jobs' cookies preference\n"
          + "A cookie will be stored on your computer with your preference regarding optional cookies."
          + "\n"
          + "cookies and purpose\n"
          + "Name Purpose Expires\n"
          + "analytics_enabled Saves your preference regarding optional cookies 1 year\n"
          + "Cross site request forgery (CSRF) cookie\n"
          + "We use a CSRF cookie to check that a request has originated from our site. This helps to prevent any malicious activity taking place during your time spent on the website."
          + "\n"
          + "cookies and purpose\n"
          + "Name Purpose Expires\n"
          + "_csrf Validates that the request is from our site on page reload\n"
          + "NHS Jobs administrator\n"
          + "We use this cookie to store your user session including your login session and application session."
          + "\n"
          + "cookies and purpose\n"
          + "Name Purpose Expires\n"
          + "nhs-jobs-administrator Saves your unique user session to keep you logged in 90 minutes\n"
          + "Locale\n"
          + "We use this cookie to store the users selected language, either English (en) or Welsh (cy)."
          + "\n"
          + "Name Purpose Expires\n"
          + "locale Saves the users selected language 1 year";
  static String UPDATED_SUCCESSFULLY = "Success: Your account has been successfully updated";
  static String THANKS_FOR_SHOPPING_WITH_US = "Thank you for shopping with us!";
  private static String URL = "http://localhost:8888";
  private static String URL_LOGIN = "http://localhost:8888";
  private static String URL_REGISTER =
      "http://localhost:8888";
  private String responseHeaderAuthorisationCode;
  private boolean useAuthCode = false;
  private String customerUrl;

  private GlobalVarsHelper() {}

  public static String getConfigPropertiesDirectory() {
    return CONFIG_PROPERTIES_DIRECTORY;
  }

  public static String getDataProviderJsonpath() {
    return DATA_PROVIDER_JSONPATH;
  }

  public static String getUrlHomepage() {
    return URL_HOMEPAGE;
  }

  public static String getRegistrationPageUrl() {
    return REGISTRATION_PAGE_URL;
  }

  public static String getRegistrationPageTitle() {
    return REGISTRATION_PAGE_TITLE;
  }

  public static String getRegistrationPageHeader() {
    return REGISTRATION_PAGE_HEADER;
  }

  public static String getLoginPageUrl() {
    return LOGIN_PAGE_URL;
  }

  public static String getLoginPageTitle() {
    return LOGIN_PAGE_TITLE;
  }

  public static String getLoginPageHeader() {
    return LOGIN_PAGE_HEADER;
  }

  public static String getBROWSER() {
    return BROWSER;
  }

  public static String getReturningCustomer() {
    return RETURNING_CUSTOMER;
  }

  public static String getNewCustomer() {
    return NEW_CUSTOMER;
  }

  public static String getMyAccountInformation() {
    return myAccountInformation;
  }

  public static String getRegisterJsonPath() {
    return REGISTER_JSON_PATH;
  }

  public static String getRecoveryPassword_Username() {
    return recoveryPassword_Username;
  }

  public static String getAccountSuccessfullyUpdated() {
    return accountSuccessfullyUpdated;
  }

  public static String getWrong_password() {
    return wrong_password;
  }

  public static String getPass_word() {
    return pass_word;
  }

  public static String getContinueButton() {
    return CONTINUE_BUTTON;
  }

  public static String getHomepageTitle() {
    return HOMEPAGE_TITLE;
  }

  public static String getAccountLogoutHeader() {
    return ACCOUNT_LOGOUT_HEADER;
  }

  public static String getAccountEditUrlPath() {
    return ACCOUNT_EDIT_URL_PATH;
  }

  public static String getProductName1() {
    return PRODUCT_NAME_1;
  }

  public static String getProductName2() {
    return PRODUCT_NAME_2;
  }

  public static String getProductName3() {
    return PRODUCT_NAME_3;
  }

  public static String getBenefit_Bella_Bamba() {
    return Benefit_Bella_Bamba;
  }

  public static String getLASTNAME() {
    return LASTNAME;
  }

  public static String getFIRSTNAME() {
    return FIRSTNAME;
  }

  public static String getTELEPHONE() {
    return TELEPHONE;
  }

  public static String getFAX() {
    return FAX;
  }


  public static String getPASSWORD() {
    return PASSWORD;
  }

  public static String getIncorrectLoginPasswordProvided() {
    return INCORRECT_LOGIN_PASSWORD_PROVIDED;
  }

  public static String getRecoveryPasswordSuccessMsg() {
    return RECOVERY_PASSWORD_SUCCESS_MSG;
  }

  public static String getRecoveryLoginnameSuccessMsg() {
    return RECOVERY_LOGINNAME_SUCCESS_MSG;
  }

  public static String getForgetYourPasswordLinkTxt() {
    return FORGET_YOUR_PASSWORD_LINK_TXT;
  }

  public static String getForgetYourLoginnameLinkTxt() {
    return FORGET_YOUR_LOGINNAME_LINK_TXT;
  }

  public static int getExplicitWait() {
    return explicitWait;
  }

  public static int getEXPLICITWAIT() {
    return EXPWAIT;
  }

  public static int getShortImplicitWaitTime() {
    return SHORT_IMPLICIT_WAIT_TIME;
  }

  public static int getTHREE() {
    return THREE;
  }

  public static int getTWO() {
    return TWO;
  }

  public static int getONE() {
    return ONE;
  }

  public static int getFIVE() {
    return FIVE;
  }

  public static int getSIX() {
    return SIX;
  }

  public static int getImplicitTimeout() {
    return IMPLICIT_TIMEOUT;
  }

  public static int getImplicitWaitTimeout() {
    return IMPLICIT_WAIT_TIMEOUT;
  }

  public static int getDefaultExplicitTimeout() {
    return DEFAULT_EXPLICIT_TIMEOUT;
  }

  public static int getExplicitTimeout() {
    return EXPLICIT_TIMEOUT;
  }

  public static int getPollingTimeout() {
    return POLLING_TIMEOUT;
  }

  public static int getPageLoadTimeout() {
    return PAGE_LOAD_TIMEOUT;
  }

  public static int getDefaultImplicitTimeout() {
    return DEFAULT_IMPLICIT_TIMEOUT;
  }

  public static int getImplicitWait() {
    return implicitWait;
  }

  public static String getUpdatedSuccessfully() {
    return UPDATED_SUCCESSFULLY;
  }

  public static String getThanksForShoppingWithUs() {
    return THANKS_FOR_SHOPPING_WITH_US;
  }

  public static GlobalVarsHelper getInstance() {
    return ourInstance;
  }

  public static String getEmailAddress() {
    return EMAIL;
  }

  public static String getLoginName() {
    return LOGIN_NAME;
  }

  public String getResponseHeaderAuthorisationCode() {
    return responseHeaderAuthorisationCode;
  }

  public void setResponseHeaderAuthorisationCode(String authorization) {
    System.setProperty("http.headers.Authorization", authorization);
  }

  public boolean isUseAuthCode() {
    return useAuthCode;
  }

  public void setUseAuthCode(boolean b) {
    this.useAuthCode = b;
    System.setProperty("https.proxyHost", "proxy.corp.shn.uk");
  }

  public String getURL() {
    return "http://localhost:8888";
  }

  public void setURL(String URL) {
    GlobalVarsHelper.URL = URL;
  }

  public String getLoginURL() {
    return "http://localhost:8888";
  }

  public void setLoginURL(String URL_LOGIN) {
    GlobalVarsHelper.URL_LOGIN = URL_LOGIN;
  }

  public String getRegistrationURL() {
    return "http://localhost:8888";
  }

  public void setRegistrationURL(String URL_REGISTER) {
    GlobalVarsHelper.URL_REGISTER = URL_REGISTER;
  }
}
