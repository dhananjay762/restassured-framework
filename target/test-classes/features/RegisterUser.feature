Feature: User Registration

  @user
  Scenario: Register a user in toolsqa application
  	Given Form parameter is set for post call
  	When  Create user with all details in Register.txt file
  	And   Make a post call
  	Then  the status code is 200
