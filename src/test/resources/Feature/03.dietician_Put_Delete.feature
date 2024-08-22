#Author: Ishu

Feature: Validating Dietician Put & Delete
@update_dietician_with_no_auth
Scenario: Check admin able to update dietician with valid data and dietician id

Given Admin creates PUT request with valid data and sets No Auth
When Admin send PUT http request with endpoint
Then Admin receives 401 unauthorized

@update_dietician_with_dieticianID
Scenario: Check admin able to update dietician with valid data, dietician id and dietician token

Given Admin creates PUT request with valid data 
When Admin send PUT http request with endpoint
Then Admin recieves 403 forbidden

@update_dietician_with_PatientID
Scenario: Check admin able to update dietician with valid data , dietician id and patient token

Given Admin creates PUT request with valid data with patient id
When Admin send PUT http request with endpoint
Then Admin recieves 403 forbidden

