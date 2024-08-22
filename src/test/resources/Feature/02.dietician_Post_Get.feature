#Author: Abinaya
# no auth and admin token scenarios covered

Feature: Validate Dietician Endpoints (POST, GET, GET All)

  
  @create_dietician_positive
  Scenario Outline: Check if admin is able to create dietician with valid mandatory details and token 
    Given Admin creates Dietician POST request with valid "<Data>"
    When Set admin token and Admin sends Dietician POST http request with endpoint
    Then Admin should receive status code 201 created and with response body having auto created "<Dietician>" dietician ID and login password

    Examples: 
      | Data	  							| 	Dietician			|
      | Mandatory 						|  	Dietician1		|
      | Mandatory_Additional 	|		Dietician2    |
      
  @create_dietician_AdditionalData 
  Scenario Outline: Check if admin is able to create dietician with either valid or invalid additional details
    Given Admin creates Dietician POST request with "<Additional_Data>"
    When Set admin token and Admin sends Dietician POST http request with endpoint
    Then Admin should receive 400 Bad request
    
    Examples: 
      | Additional_Data	  			| 
      | valid_additional_data 	| 
      | invalid_additional_data	|
 
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
    Given User creates Dietician POST request with valid data
    When Set admin token and Admin sends Dietician PUT http request with endpoint
    Then Admin should receive 405 "Method Not Allowed" for dietician module
    
  @create_dietician_invalidEndpoint
  Scenario: Check admin able to create dietician with valid data and invalid endpoint
    Given User creates Dietician POST request with valid data
    When Set admin token and Admin sends Dietician POST http request with invalid endpoint
    Then Admin should receive 404 "Not Found" for dietician module
    
  @create_dietician_invalidContentType
  Scenario: Check admin able to create dietician with valid data and invalid content type
    Given User creates Dietician POST request with valid data 
    When Set admin token and Admin send POST http request with valid endpoint and invalid content type
    Then Admin should receive 415 "Unsupported Media Type" for dietician module
    
  @create_dietician_no_auth
  Scenario: Check admin able to create dietician with valid data and no auth
    Given User creates Dietician POST request with valid data  
    When Admin sends Dietician POST http request with endpoint
    Then Admin should receive 401 "Unauthorized" for dietician module

  @get_all_dieticians_no_auth
  Scenario: Check if admin is able to retrieve all dieticians with no token
    Given User creates GET request to retrieve all dieticians
    When Admin sends GET all dieticians http request with endpoint
    Then Admin should receive 401 "Unauthorized" for dietician module
	
	@get_all_dieticians_positive
  Scenario: Check if admin is able to retrieve all dieticians with valid data
    Given User creates GET request to retrieve all dieticians
    When Set admin token and Admin sends GET all dieticians http request with endpoint
    Then Admin should receive 200 ok with response body
    
  @get_all_dieticians_invalidMethod
  Scenario: Check admin able to retrieve all dietician with invalid method
    Given User creates GET request to retrieve all dieticians
    When Set admin token and Admin sends PUT all dieticians http request with endpoint
    Then Admin should receive 405 "Method Not Allowed" for dietician module
    
  @get_all_dieticians_invalidEndpoint
  Scenario: Check admin able to retrieve all dietician with invalid endpoint
    Given User creates GET request to retrieve all dieticians
    When Set admin token and Admin sends GET all dieticians http request with invalid endpoint
    Then Admin should receive 404 "Not Found" for dietician module
 
  @get_dietician_ID_no_auth
  Scenario: Check if admin is able to retrieve dietician by ID with no token
    Given User creates GET request to retrieve dietician by ID  
    When Admin sends GET dietician by ID http request with endpoint
    Then Admin should receive 401 "Unauthorized" for dietician module
	
	@get_dietician_ID_positive
  Scenario: Check if admin is able to retrieve dietician by ID with valid data
    Given User creates GET request to retrieve dietician by ID 
    When Set admin token and Admin sends GET dietician by ID http request with endpoint
    Then Admin should receive 200 ok with details of the dietician id
    
  @get_dietician_ID_invalidMethod
  Scenario: Check admin able to retrieve dietician by ID with invalid method
    Given User creates GET request to retrieve dietician by ID 
    When Set admin token and Admin sends POST dietician by ID http request with endpoint
    Then Admin should receive 405 "Method Not Allowed" for dietician module
    
  @get_dietician_ID_invalidID
  Scenario: Check admin able to retrieve dietician by ID with invalid id
    Given User creates GET request to retrieve dietician by ID
    When Set admin token and Admin sends GET dietician by ID http request with invalid id
    Then Admin should receive 404 "NOT_FOUND" for invalid dietician id
    
  @get_dietician_ID_invalidEndpoint
  Scenario: Check admin able to retrieve dietician by ID with invalid endpoint
    Given User creates GET request to retrieve dietician by ID
    When Set admin token and Admin sends GET dietician by ID http request with invalid endpoint
    Then Admin should receive 404 "Not Found" for dietician module 
    
    
    
    
    
    
    
    
    
    