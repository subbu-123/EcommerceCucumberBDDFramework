Feature: Contact Us functionality

#This scenario is to implement excel as the data source for parameterization

Background:
Given user has already logged into application with valid credentials
|username               |password    |
|subbu.genie94@gmail.com|subhankar.94|


Scenario Outline: Validate user is able to send message to customer support on Contact Us page
Given user is on Contact Us page
When user fills the form with details from <SheetName> and from <RowNumber>
And clicks on send button
Then a messsage should be displayed as "Your message has been successfully sent to our team."

Examples:
|SheetName      |RowNumber|
|customersupport|0        |
|customersupport|1        |
