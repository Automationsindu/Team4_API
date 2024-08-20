#Author: Vani

Feature: Patient Login
 

@PatientLogin1
Scenario: Check user able to login as patient with valid credential
Given User creates Post request with request body for patient Login
When User send POST HTTP request with endpoint for patient Login
Then User recieves 200 created with response body for patient Login

@PatientInvalidLogin2
Scenario: Check user able to login as patient with invalid credential
Given User creates Post request with invalid credential for patient login
When User send POST HTTP request with endpoint for patient login
Then User recieves 401 unauthorized for patient login
 