Feature: Get book by ISBN
	
	@test2
  Scenario: User calls web service to get a book by its ISBN
    Given A book exists with an isbn of 9781451648546
    When User retrieves the book by isbn
    Then The status code is 200
    And Response includes the following
	| totalItems 	 	| 1 				|
	| kind				| books#volumes		|	
    And Response includes the following in any order
	| items.volumeInfo.title 		| Steve Jobs		  |
	| items.volumeInfo.publisher 	| Simon and Schuster  |   
	| items.volumeInfo.pageCount 	| 630			      |	