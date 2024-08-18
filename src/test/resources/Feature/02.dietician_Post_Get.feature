#Author: Abinaya

@tag
Feature: Validate Dietician Endpoints (POST, GET, GET All)

	@tag1
  Scenario: Check if admin is able to create dietician with valid data and token 
   Given Set admin token and Admin creates Dietician POST request with valid data.
    When Admin sends Dietician POST http request with endpoint
    Then Admin should receive status code 201 created and with response body having auto created dietician ID and login password
    

	

