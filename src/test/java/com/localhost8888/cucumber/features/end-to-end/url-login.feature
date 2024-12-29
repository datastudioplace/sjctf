@Url
Feature: Login Functionality

  @createLeads
  Scenario Outline: user should be able to login and create leads
    Given I landed on Ecommerce website
    And I should see the login form
 #   And I login valid with credentials
    And I login with username "admin" and password "admin"
    And I can see "Administrator", user image help and setting icons are displayed
    And the page title should be displayed as"Administrator"
    Then should be presented with the following validation message as "<loginValidationMessage>"
    And I am presented with the following menu button
      | Calendar        |
      | Leads           |
      | Organizations   |
      | Contacts        |
      | Opportunities   |
      | Products        |
      | Documents       |
      | Email           |
      | Trouble Tickets |
      | Dashboard       |
      | More            |
    And I hover over an item "More"
    And I should see a dropdown menu with the following options
      | Tools     |
      | Analytics |
      | Marketing |
      | Support   |
      | Inventory |
      | Sales     |
    And hover over "user Image" next to user name
    And I tap on the "Leads"
    And I can see Create New Lead icon
    And I click on the Create New Lead icon
    When I enter the following lead information
      | John                |
      | Doe                 |
      | Acme Corp           |
      | Existing Customer   |
      | 123 Main St         |
      | Anytown             |
      | 12345               |
      | United States       |
      | This is a test lead |
    And I click on the save button
    #Then I should see the lead created successfully messages "John" and "LEA13"
    Then I should see the lead created was successful as "John"

    Examples:
      | loginValidationMessage |
      | Administrator          |