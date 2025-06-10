Feature: validating Place API's

Scenario: Verify if user is successfully added
	Given Add employee payload
	When users calls "CREATE_USER" with "post" http request
	Then "status" of the API is "201"
	And verify user is added to the respective "2"

Scenario: Verify get all users
	When users calls "GET_ALL_USERS" with "get" http request
	Then "status" of the API is "200"
	
Scenario: Verify Get user by ID
	When users calls "GET_USER_BY_ID" with "get" http request and parameter "3"
	Then "status" of the API is "200"
	
Scenario: Update the user data
	Given Add employee payload
	When users calls "UPDATE_USER_BY_ID" with "put" http request and parameter "2"
	Then "status" of the API is "200"
	And verify user is added to the respective "5"
	