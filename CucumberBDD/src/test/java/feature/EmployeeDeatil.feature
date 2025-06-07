Feature: validating Place API's

Scenario: Verify if place is successfully added
	Given Add employee payload
	When users calls AddemployeeeApi with post http request
	Then the API call is success the status code 201
	