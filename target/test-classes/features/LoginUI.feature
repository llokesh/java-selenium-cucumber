Feature: Login feature
Verify user is able to login to the site

@ui @validcredentials
Scenario Outline: Login as a authenticated user
	Given user is on home page
	When user navigate to Login page
	And user enters "<username>" and "<Password>"
	Then verify logo is displayed
	And user logs out

	Examples:
	| username                     | Password         |
	| jeevan.king@gmail.com         | Sun$Daisy132     |

	
@ui @missingcredentials
Scenario: Login with empty username
	Given user is on home page
	When user navigate to Login page
	And user clicks the next button
	Then verify error message is displayed
	
	
@ui @invalidcredentials
Scenario: Login with wrong credentials 
	Given user is on home page
	When user navigate to Login page
	And user enters username 
	And user enters password
	  | Password         |
		| RG$1234FDSSA     |
		| DG$1234FDSSA     |
	Then verify error message is displayed
	

@ui @validcredentials
Scenario Outline: User on login page and login with valid and invalid inputs from Excel "<Sheetname>" and <RowNumber>
  Given user is on home page
  When user navigate to Login page
  When The user enter sheet "<Sheetname>" and <RowNumber>
  Then verify logo is displayed
  And user logs out
  
  Examples:
  | Sheetname | RowNumber |
  | login     |         0 |
  | login     |         1 |
 