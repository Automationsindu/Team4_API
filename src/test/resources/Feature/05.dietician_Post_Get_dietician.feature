#Author: Abinaya
# dietician token scenarios covered

Feature: Validate Dietician Endpoints (POST, GET, GET All) with dietician token


  @create_dietician_with_dietician_token
  Scenario: Check User able to create dietician with valid data and dietician token
    Given User creates Dietician POST request with valid data
    When Set dietician token and User sends Dietician POST http request with endpoint
    Then User should receive 403 forbidden for dietician module
	
	@get_all_dieticians_with_dietician_token
  Scenario: Check User able to retrieve all dieticians with valid data and dietician token
    Given User creates GET request to retrieve all dieticians
    When Set dietician token and User sends GET all dieticians http request with endpoint
    Then User should receive 200 ok with response body
    	
	@get_dietician_ID_with_dietician_token
  Scenario: Check User able to retrieve dietician by ID with valid data and dietician token
    Given User creates GET request to retrieve dietician by ID 
    When Set dietician token and User sends GET dietician by ID http request with endpoint
    Then User should receive 200 ok with details of the dietician id
    
    
    
    
    
    
    
    
    
    
    