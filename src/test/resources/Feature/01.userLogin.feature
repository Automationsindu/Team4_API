##Author: Vani
##Feature: UserLogin 

Feature: User Login new

Scenario: Check user able to login as admin with valid data
Given User creates Post request with request body
When User send POST HTTP request with endpoint
Then User recieves 200 created with response body

@Login1
Scenario: Check user able to login as admin with invalid credential
Given User creates Post request with invalid credential
When User send POST HTTP request with endpoint
Then User recieves 401 unauthorized
