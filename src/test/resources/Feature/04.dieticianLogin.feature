#Author: Vani


Feature: Dietician Login
 
@DieticianLogin1 @positive11
Scenario: Check user able to login as dietician with valid credential
Given User creates Post request with request body for Dietician login
When User send POST HTTP request with endpoint for Dietician login
Then User recieves 200 created with response body for Dietician login

@DieticianInvalid2
Scenario: Check user able to login as dietician with invalid credential
Given User creates Post request with invalid credential for Dietician login
When User send POST HTTP request with endpoint for Dietician login
Then User recieves 401 unauthorized for Dietician login
 