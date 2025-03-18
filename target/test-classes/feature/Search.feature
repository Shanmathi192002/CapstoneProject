Feature: Search Functionality
  As a user, I want to search for books and apply filters so that I can find my desired book easily.

  Scenario: Search for a product and apply filters
    Given User is logged into the application
    When User searches for "Harry Potter"
    And User applies price filter
    And User applies discount filter
    And User applies language filter
    Then Search results should be displayed
