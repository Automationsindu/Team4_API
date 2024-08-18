##Author: Vani
##Feature: UserLogin (positive and Negative)

Feature: User Login new

@Login1
Scenario: Check user able to login as admin with valid data
Given User creates Post request with request body
When User send POST HTTP request with endpoint
Then User recieves status code created with response body

