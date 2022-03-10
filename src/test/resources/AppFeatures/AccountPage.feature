Feature: Account Page Feature

Background:
Given user has already logged into application with valid credentials
|username               |password    |
|subbu.genie94@gmail.com|subhankar.94|


@accounts
Scenario: Validate Accounts page title
Given user is on Accounts page
Then Accounts page title should be displayed as "My account - My Store"



@accounts
Scenario: Validate Accounts page section names displayed & total count
Given user is on Accounts page
When accounts page sections are retrieved
Then below accounts section are displayed
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|

And accounts section total count should be 5