##Author: Vani
##Feature: UserLogin (positive and Negative)

Feature: User Login new

@LoginPositive1
Scenario: Check user able to login as admin with valid data
Given Admin User creates Post request with request body
When Admin User send POST HTTP request with endpoint
Then Admin User recieves status code created with response body

@LoginInvalidCredential2
Scenario: Check user able to login as admin with invalid credential
Given Admin User creates Post request with invalid credential
When Admin User send POST HTTP request with endpoint
Then Admin User recieves status code created with response body

@LoginInvalidMethod3
Scenario: Check user able to login as admin with valid credential and invalid method
Given Admin User creates GET request with request body for userLogin
When Admin User send GET HTTP request with endpoint for userLogin
Then Admin User recieves status code created with response body

@LoginInvalidEndpoint4
Scenario:Check user able to login as admin with valid credential and invalid endpoint
Given Admin User creates Post request with request body
When Admin User send POST HTTP request with invalid endpoint
Then Admin User recieves status code created with response body

@LoginInvalidContentType5
Scenario: Check user able to login as admin with valid credential and invalid content type
Given Admin User creates Post request with request body and invalid content type.
When Admin User send POST HTTP request with endpoint
Then Admin User recieves status code created with response body













