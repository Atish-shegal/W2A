Feature: Login

In order to perform login
As a user
I want to enter correct username and password

Scenario: In order to verify login to facebook
		Given user navigates to facebook
		When user validates the homepage title
		Then user entered the username
		And user entered the password
		Then user should login 