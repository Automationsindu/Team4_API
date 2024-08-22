#Author: Abinaya
# patient token scenarios covered

Feature: Validate Dietician Endpoints (POST, GET, GET All) with patient token


  @create_dietician_with_patient_token
  Scenario: Check User able to create dietician with valid data and patient token
    Given User creates Dietician POST request with valid data
    When Set patient token and User sends Dietician POST http request with endpoint
    Then User should receive 403 forbidden for dietician module
	
	@get_all_dieticians_with_patient_token
  Scenario: Check User able to retrieve all dieticians with valid data and patient token
    Given User creates GET request to retrieve all dieticians
    When Set patient token and User sends GET all dieticians http request with endpoint
    Then User should receive 403 forbidden for dietician module
    	
	@get_dietician_ID_with_patient_token
  Scenario: Check User able to retrieve dietician by ID with valid data and patient token
    Given User creates GET request to retrieve dietician by ID 
    When Set patient token and User sends GET dietician by ID http request with endpoint
    Then User should receive 403 forbidden for dietician module
    
