#Author: Abinaya
# only admin token

Feature: Validate Dietician Endpoints (POST, GET, GET All)

  
  @create_dietician_positive
  Scenario Outline: Check if admin is able to create dietician with valid data and token 
    Given Set admin token and Admin creates Dietician POST request with valid data
    When Admin sends Dietician "<Dietician>" POST http request with endpoint
    Then Admin should receive status code 201 created and with response body having auto created dietician ID and login password

    Examples: 
      | Dietician	  | 
      | Dietician1 	| 
      | Dietician2 	|  
      
 @create_dietician_invalidData
  Scenario: Check if admin is able to create dietician with invalid data
    Given Set admin token and Admin creates Dietician POST request with invalid data
    When Admin sends Dietician POST http request with endpoint
    Then Admin should receive 400 Bad request
    
	
  @create_dietician_invalidMethod
  Scenario: Check admin able to create dietician with valid data and invalid method
    Given Set admin token and Admin creates Dietician POST request with valid data
    When Admin sends Dietician PUT http request with endpoint
    Then Admin should receive 405 method not allowed
    
  @create_dietician_invalidEndpoint
  Scenario: Check admin able to create dietician with valid data and invalid endpoint
    Given Set admin token and Admin creates Dietician POST request with valid data
    When Admin sends Dietician POST http request with invalid endpoint
    Then Admin should receive 404 not found
    
  @create_dietician_invalidContentType
  Scenario: Check admin able to create dietician with valid data and invalid content type
    Given Set admin token and Admin creates Dietician POST request with valid data 
    When Admin send POST http request with valid endpoint and invalid content type
    Then Admin should receive 415 unsupported media type
