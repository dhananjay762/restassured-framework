Feature: Get book by author name

  @googleBookApi
  Scenario: User calls web service to get books by author name
  	Given Books exist with author name as "Alan Brinkley"
  	When  User retrieves the book by author name
		Then The status code is 200
		And  Verify that book id is not blank
		And  Verify that book title is not blank