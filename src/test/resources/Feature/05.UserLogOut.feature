#Author: Vani
#Keywords Summary :

Feature: User Log out
 
 Background: Set bearer token in header

  @Logout1
  Scenario: Check admin able to logout  
    Given User creates GET request 
    When User send GET HTTP request with endpoint
    Then User recieves 200 created with Logout successful message
    
   @Logout2
  Scenario: Check admin able to logout  with invalid method
    Given User creates POST request
    When User send POST HTTP request with endpoint
    Then User recieves 405 method not allowed

 @Logout3
  Scenario: Check dietician able to logout  
     Given User creates GET request 
    When User send GET HTTP request with endpoint
    Then User recieves 200 created with Logout successful message
    
@Logout4
Scenario:Check dietician able to logout  with invalid method
Given User creates POST request
When User send POST HTTP request with endpoint
Then User recieves 405 method not allowed

@Logout5
Scenario: Check patient able to logout  
Given User creates GET request 
When User send GET HTTP request with endpoint
Then User recieves 200 created with Logout successful message

@Logout6
Scenario: Check patient able to logout  with invalid method
Given User creates POST request 
When User send POST HTTP request with endpoint
Then User recieves 405 method not allowed

@LogoutAdminwithoutAuth7
Scenario: Check admin able to logout  without auth
Given User creates GET request 
When User send GET HTTP request with endpoint
Then User recieves 401 unauthorized

@LogoutDietwithoutAuth8
Scenario: Check dietician able to logout  
Given User creates GET request 
When User send GET HTTP request with endpoint
Then User recieves 401 unauthorized

@LogoutPatientwithoutAuth9
Scenario: Check patient able to logout  
Given User creates GET request 
When User send GET HTTP request with endpoint
Then User recieves 401 unauthorized






  