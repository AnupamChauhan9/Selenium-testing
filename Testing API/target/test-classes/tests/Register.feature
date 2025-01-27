Feature: Reister user
Registerd user should be able to Search 
Scenario: register user with valid credentials
Given user navigate to  user creation page
When user enter first name  "anupam"
And user enter last name "chauhan"
And Enter email "amotooricap9@gmmail.com"
And enter password "12345" into password field
And user enter confirm password "12345"
And user select  the check box
And Click on Continue button
Then user created sucerssfully