Feature: Login

Background:
Given I enter valid Url


Scenario Outline: To test with different data


When I enter valid UserName "<name>"
And I enter valid Password "<pwd>"
And click Submit
Then I should see user name "<loginName>"

Examples:
|name |pwd 			|loginName |
|Admin|admin123	|Welcome Paul|
|Admin |admin123			|Welcome Paul|

