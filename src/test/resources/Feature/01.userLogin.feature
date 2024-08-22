##Author: Vani
##Feature: UserLogin (positive and Negative)
Feature: User Login new

@LoginPositive1
Scenario: Check user able to login as admin with valid data
Given User creates Post request with request body
When User send POST HTTP request with endpoint
Then User recieves status code created with response body

@LoginInvalidCredential2
Scenario: Check user able to login as admin with invalid credential
Given User creates Post request with invalid credential
When User send POST HTTP request with endpoint
Then User recieves 401 unauthorized

@LoginInvalidMethod3
Scenario: Check user able to login as admin with valid credential and invalid method
Given User creates GET request with request body for userLogin
When User send GET HTTP request with endpoint for userLogin
Then User recieves 405 method not allowed

@LoginInvalidEndpoint4
Scenario: Check user able to login as admin with valid credential and invalid endpoint
Given User creates Post request with request body.
When User send POST HTTP request with invalid endpoint
Then User recieves 401 unauthorized

@LoginInvalidContentType5
Scenario: Check user able to login as admin with valid credential and invalid content type
Given User creates Post request with request body and invalid content type.
When User send POST HTTP request with endpoint
Then User recieves 415 unsupported media type

@DieticianLogin6
Scenario: Check user able to login as dietician with valid credential
Given User creates Post request with request body for Dietician login
When User send POST HTTP request with endpoint for Dietician login
Then User recieves 200 created with response body for Dietician login

@DieticianInvalid7
Scenario: Check user able to login as dietician with invalid credential
Given User creates Post request with invalid credential for Dietician login
When User send POST HTTP request with endpoint for Dietician login
Then User recieves 401 unauthorized

@PatientLogin8
Scenario: Check user able to login as patient with valid credential
Given User creates Post request with request body for patient Login
When User send POST HTTP request with endpoint for patient Login
Then User recieves 200 created with response body for patient Login

@PatientInvalidLogin9
Scenario: Check user able to login as patient with invalid credential
Given User creates Post request with invalid credential for patient login
When User send POST HTTP request with endpoint for patient login
Then User recieves 401 unauthorized for patient login