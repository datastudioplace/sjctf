Feature: footerPage Functionality

  Scenario: should be able to use footer links on index page
    Given I navigate to "/"
    Then I should see all the links in the footer index page
    And I verify if the links are present and enabled

  Scenario: should be able to use footer links in Account page
    Given I navigate to "/"
    When I login valid with credentials
    Then I should see all the links in the footer pages
