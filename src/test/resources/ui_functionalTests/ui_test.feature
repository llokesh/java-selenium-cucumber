Feature: Login feature
Verify user is able to login to the site

Scenario: Login as a authenticated user
Given: user is on home page
When user navigate to Login page
And user enters username and Password
Then verify header is displayed