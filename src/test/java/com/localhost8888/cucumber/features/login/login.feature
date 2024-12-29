@Url
Feature: Login Functionality

  Background: navigate to home page
    Given I landed on Ecommerce website
    And I should see the login form

  Scenario Outline: user should be able to login
    And I login valid with credentials
    Then should be presented with the following validation message as "<loginValidationMessage>"
    Examples:
      | loginValidationMessage |
      | Administrator          |

  @Url
  Scenario Outline: Goto to home page
    And I login with invalid credentials
    Then should be presented with the following error warning message as "<loginValidationMessage>"
    Examples:
      | loginValidationMessage                          |
      | You must specify a valid username and password. |



#  @Registration
#  @Url
#  Scenario: navigate to registration page
#    Given I navigate to "?rt=account/create"
#    And enter Your Personal Details section with:
#      | First Name | Last Name | Telephone     | Fax           |
#      | FirstName  | LastName  | 0740500000000 | 0740500000001 |
#    And enter Your Address Details section with:
#      | Company         | Address one | Address two | City       | Region or province | ZipCodeOrPostCode | Country        |
#      | ABC Company Ltd | Address 1   | Address 2   | Manchester | Lancashire         | M18 7QT           | United Kingdom |
#    And enter Your login Details section with:
#      | Password | Password Confirm |
#      | password | password         |
#    And I tick on subscription option "Yes"
#    And I tick on "Privacy Policy" radio button
#    And I tap on "Continue" button in register page
#
#  Scenario: Successful account registration with valid credentials
#    Given I navigate to "?rt=account/create"
#    And enter Your Personal Details section with:
#      | First Name | Last Name | Telephone     | Fax           |
#      | FirstName  | LastName  | 0740500000000 | 0740500000001 |
#    And enter Your Address Details section with:
#      | Company         | Address one | Address two | City       | Region or province | ZipCodeOrPostCode | Country        |
#      | ABC Company Ltd | Address 1   | Address 2   | Manchester | Lancashire         | M18 7QT           | United Kingdom |
#    And enter Your login Details section with:
#      | Password | Password Confirm |
#      | password | password         |
#    And I tick on subscription option "Yes"
#    And I tick on "Privacy Policy" radio button
#    And I tap on "Continue" button in register page