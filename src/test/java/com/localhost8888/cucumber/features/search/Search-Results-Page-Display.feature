@searchResult

Feature: Search results page display
  As a candidate
  I want to see the search results page
  So that I can find the product that I am looking for

  Scenario: Search without any keyword and search criterion
    Given I landed on Ecommerce website

    And I search for products with " "
    And I tap on the Search button
    And I can see the search result for "<Product Name>"


















