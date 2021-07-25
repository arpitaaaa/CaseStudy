Feature: Login



Scenario: To Login with valid input

Given I enter valid Url
When I enter valid UserName "Admin" 
And I enter valid Password "admin123" 
And click Submit
Then I should see user name "Welcome Nishanth05" 

