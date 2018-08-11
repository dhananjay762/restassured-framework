Feature: User Registration

  @registerUser
  Scenario: Register a user in toolsqa application
  	Given Form parameter is set for post call
  	When  Create user with all details in "Register.txt" file
  	And   Make a post call
  	Then  Status code should be 200
  	And   Validate that user is added successfully
  	Then  Make a post call
  	And   Status code should be 201
		And   Validate that user already exists