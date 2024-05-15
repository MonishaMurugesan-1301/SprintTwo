Feature: login feature

Scenario Outline:successful login
Given user on Sauce page
When he login with <Username> and <Password>
And user clicks on login
Then it navigates to home page

Examples:
|Username|Password|
|standard_user|secret_sauce|
|problem_user|secret_sauce|