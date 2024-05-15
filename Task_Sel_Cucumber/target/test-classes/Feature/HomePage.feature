Feature: HomePage of Website 

Scenario: Selection of hotel 
	Given the user is on the homepage 
	When user selects the city  
	And the user should see available hotels
	And the user gives the input for booking hotel
	Then user can book a hotel 

	
	