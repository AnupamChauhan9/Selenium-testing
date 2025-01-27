Feature: User Login
Registerd user should be able to login 
Scenario: Login with valid Credentials
Given user navigate to login page
When user enter email address "amotooricap9@gmmail.com"
And enter password "12345"
And Click on login button
Then user should logged sucerssfully
