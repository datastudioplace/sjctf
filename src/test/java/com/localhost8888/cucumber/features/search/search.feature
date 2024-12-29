@NJA-19060
Feature: verification of search functionality
  As a customer
  I want to be able to search for product
  So that can order online

  Background: navigate to home page
    Given I landed on Ecommerce website
    #Given I am on home page

  Scenario: Search for a product with keyword
    And I can see the search widget
    And I click on search field
    And I should see list of dropdown items
    And I should see list of dropdown items are greater than "6"
    When I search for a product with search keyword "Men"
    And the Page is displayed
    And I am redirected to the correct page with url path "search&keyword=Men"
    Then the page correct heading should be "SEARCH"
    Then I can see the search result for "Men"
    And I can see the search result for search keyword "Men" is greater than "0"
    Then I verify the search results contain the keyword "Men"