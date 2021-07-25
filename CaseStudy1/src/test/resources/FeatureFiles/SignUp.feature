Feature: Register New User and compose and send mail

Scenario: Register with valid input data and send new mail

Given I enter valid Url
And I click on SignUp
When I enter valid FirstName "New"
And I enter valid LastName "Admin"
And I enter valid Email "admin1@gmail.com"
And I enter valid UserName "Admin_1020"
And I enter valid Password "Admin_1"
And I enter valid ConfirmPassword "Admin_1"
And I click on Register buttton
Then I should registered successfully with Name "New Admin" and Email "admin1@gmail.com"
Then I should compose Mail
Then I should enter valid details and click on send button
Then I should see acknowledgement message

