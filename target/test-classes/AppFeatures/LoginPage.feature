
Feature: Login page feature



Scenario: Validate Login page title is displayed
Given user is on login page
Then login page title should be displayed as "Login - My Store"




Scenario: Validate Forgot Password link is displayed
Given user is on login page
Then "Forgot your password link?" should be displayed




Scenario: Login with correct credentials
Given user is on login page
When user enters username as "subbu.genie94@gmail.com"
And enters password as  "subhankar.94"
And clicks on Login button
Then user should be navigated to Accounts page
And accounts page title should be displayed as "My account - My Store"
