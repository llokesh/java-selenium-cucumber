Feature: Validation of get method
 
 Background: GET request
 Given I send a GET request to the URL to get user details
 
@GetUserDetails
@api
  Scenario: Send a valid Request to get user details
   
  Then the response will return status 200 

   
@GetUserDetails
@api
  Scenario: Validate ID is not null
 
  Then Validate ID is not null
  
@GetUserDetails
@api
  Scenario: Fetch Phone names containing Apple
 
  Then Fetch Phone names containing "Apple"
  
  
@GetUserDetails
@api
  Scenario: Fetch Phone name of lowest price
 
  Then Fetch Phone name of lowest price
