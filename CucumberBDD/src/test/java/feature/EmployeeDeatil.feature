Feature: validating Place API's

Scenario: Verify if place is successfully added
	Given Add employee payload
	When users calls AddemployeeeApi with post http request
	Then "status" of the API is "201"
	