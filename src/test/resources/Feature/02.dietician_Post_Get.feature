#Author: Abinaya
# only admin token

Feature: Validate Dietician Endpoints (POST, GET, GET All)

  
  @create_dietician_positive
  Scenario Outline: Check if admin is able to create dietician with valid data and token 
    Given Admin creates Dietician POST request with valid data
    When Set admin token and Admin sends Dietician "<Dietician>" POST http request with endpoint
    Then Admin should receive status code 201 created and with response body having auto created dietician ID and login password

    Examples: 
      | Dietician	  | 
      | Dietician1 	| 
      | Dietician2 	|  
      

    
  @create_dietician_invalidData
  Scenario Outline: Check if admin is able to create dietician with invalid data
    Given Admin creates Dietician POST request with "<Invalid_Data>"
    When Set admin token and Admin sends Dietician POST http request with endpoint
    Then Admin should receive 400 Bad request
    
    Examples: 
      | Invalid_Data	  				| 
      | invalid_Contact_number 	| 
      | invalid_FirstName				|
      | invalid_LastName	  		| 
      | invalid_HospitalPincode | 
      | invalid_HospitalCity		|
      | invalid_Education	  		| 
      | invalid_Email 					| 
      | invalid_DOB							|
  	
  @create_dietician_invalidMethod
  Scenario: Check admin able to create dietician with valid data and invalid method
    Given Admin creates Dietician POST request with valid data
    When Set admin token and Admin sends Dietician PUT http request with endpoint
    Then Admin should receive 405 method not allowed
    
  @create_dietician_invalidEndpoint
  Scenario: Check admin able to create dietician with valid data and invalid endpoint
    Given Admin creates Dietician POST request with valid data
    When Set admin token and Admin sends Dietician POST http request with invalid endpoint
    Then Admin should receive 404 not found
    
  @create_dietician_invalidContentType
  Scenario: Check admin able to create dietician with valid data and invalid content type
    Given Admin creates Dietician POST request with valid data 
    When Set admin token and Admin send POST http request with valid endpoint and invalid content type
    Then Admin should receive 415 unsupported media type
