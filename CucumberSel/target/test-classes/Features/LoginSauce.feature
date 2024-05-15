Feature: To check Login Functionality

Scenario: Check login is successful with valid credentials

Given user is on login page
When user enters Username and Password 
And click on Login button
Then user should navigate to home page