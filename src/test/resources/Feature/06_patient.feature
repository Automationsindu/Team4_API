##Author: Sindu
##Feature: PatientLogin 
##Scenario: Positive and negative 
Feature: Post Operation [create patient]

# Negative Scenario: Unauthorized access
@NoAuth
Scenario Outline: Check dietician able to create patient with no auth
    Given Dietician creates POST request by entering valid data into the form-data key and value fields with "<authorization>"
    When Dietician sends POST http request with endpoint with noAuth
    Then Dietician receives 401 unauthorized patient
    
   Examples:
    |authorization|
    |noAuth|
    
    
@using_adminToken
# Negative Scenario: Forbidden access for admin
Scenario Outline: Check admin able to create patient with admin bearer token 
    Given Admin creates POST request by entering valid data into the form-data key and value fields with "<adminToken>"
    When Admin sends POST http request with endpoint
    Then Admin receives 403 forbidden
    
    Examples:
    |adminToken|
    |admin_Token|


@using_patientToken
# Negative Scenario: Forbidden access for patient
Scenario Outline: Check patient able to create patient with patient bearer token
    Given Patient creates POST request by entering valid data into the form-data key and value fields "<patientToken>"
    When Patient sends POST http request with endpoint
    Then Patient receives 403 forbidden
    
    Examples:
    |patientToken|
    |patient_token|

@positive11
Scenario: Check dietician able to create patient with valid data and token
    Given Dietician creates POST request by entering valid data (Mandatory and additional details) into the form-data key and value fields
    When Dietician sends POST http request with endpoint
    Then Dietician receives 201 created and with response body (Auto created dietician ID and login password)
    
  
 @Positive @mandatory_fields   
# Positive Scenario: Successful creation of patient with only valid mandatory details
Scenario: Check dietician able to create patient only with valid mandatory details
    Given Dietician creates POST request only by valid mandatory details into the form-data key and value fields
    When Dietician sends POST http request with endpoint with only mandatory field
    Then Dietician receives 201 created and with response body (Auto created dietician ID and login password)
    
 
 
 @invalidMandatory
 # Negative Scenario: Creation attempt with invalid mandatory detail
Scenario Outline: Check dietician able to create patient with invalid data "
    Given Dietician creates POST request only by invalid mandatory details into the form-data key and value fields with "<mandatory details>"
    When Dietician sends POST http request with endpoint with invalid mandatory
    Then Dietician receives 400 Bad request
 Examples:
    |mandatory details|
    |mandatory_details_Invalid|

@invalidAdditional
# Negative Scenario: Creation attempt with valid mandatory fields and invalid additional details
Scenario Outline: Check dietician able to create patient with valid mandatory fields and invalid data  
    Given Dietician creates POST request only by invalid additional details into the form-data key and value fields "<additional details>" 
    When Dietician sends POST http request with endpoint with invalid additional
    Then Dietician receives 400 Bad request   
 Examples:
    |additional details|
    |additional_details_Invalid|
    
    
    
 
@invalid_HTTP
# Negative Scenario: Invalid HTTP method used
Scenario Outline: Check dietician able to create patient with valid data and invalid method
    Given Dietician creates PUT request by entering valid data into the form-data key and value fields "<invalidHttp>"
    When Dietician sends PUT http request with endpoint
    Then Dietician receives 405 method not allowed
	
	Examples:
	|invalidHttp|
	|invalid_HTTP|


@invalid_endpoint
# Negative Scenario: Invalid endpoint used
Scenario Outline: Check dietician able to create patient with valid data and invalid endpoint
    Given Dietician creates POST request by entering valid data into the form-data key and value fields "<invalidEndpoint>"
    When Dietician sends POST http request with invalid endpoint
    Then Dietician receives 404 not found
	
	Examples:
	|invalidEndpoint|
	|invalid_endpoint|
	
	@getAllPatients
# Positive Scenario: Get all patients
Scenario: Check dietician able to retrieve all patients
    Given  Dietician create GET request patient
    When Dietician send GET http request with endpoint patient
    Then Dietician recieves 200 ok with response body
	
	
@getAll_noAuth
Scenario: Dietician able to retrieve all patients
    Given Dietician create GET request patient
    When Dietician send GET http request with endpoint patient
    Then Dietician receives 401 unauthorized patient

@getAll_adminToken  
Scenario: Admin is able to retrieve patients
    Given Admin create GET request patient
    When Admin send GET http request with endpoint patient
    Then Admin receives 403 Forbidden

@getAll_patientToken  
Scenario: Patient is able to retrieve patients
    Given Patient create GET request patient
    When Patient send GET http request with endpoint patient
    Then Patient receives 403 Forbidden


@getAll_invalidReq
Scenario: Dietician able to retrieve all patients with PUT request
    Given Dietician create PUT request
    When Dietician send PUT http request with endpoint
    Then Dietician receives 405 method not allowed

@getAll_invalidPoints  
Scenario: Dietician able to retrieve all patients with invalid endpoint
    Given Dietician create GET request with invalid endpoint
    When Dietician send GET http request with invalid endpoint
    Then Dietician receives 404 not found	


@getAll_morbidity_positive  
Scenario: Check dietician able to retrieve patients morbidity details by patient ID
    Given Dietician create GET request patient
    When Dietician send GET http request with endpoint patient
    Then Dietician recieves 200 ok with details of the patient id
   		
	
    
