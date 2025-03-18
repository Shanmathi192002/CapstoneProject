Feature: Login functionality

Scenario: Unsuccessful login with invalid credentials
Given User is on the login page
When User enters invalid credentials
And User clicks the login button

Scenario: Successful login with valid credentials
Given User is on the login page
When User enters valid credentials
And User clicks the login button
Then User should be logged in successfully
