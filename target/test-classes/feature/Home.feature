Feature: Home Page
  As a user
  I want to verify the search bar is displayed
  So that I can search for books

  @home
  Scenario: Verify search bar display
    Given User is on the home page
    Then Search bar should be displayed
