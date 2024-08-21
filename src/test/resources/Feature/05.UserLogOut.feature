#Author: Vani

Feature: User Log out
 
 Background: Set bearer token in header

  @AdminLogout1
  Scenario: Check admin able to logout  
    Given Admin User creates GET request to logout
    When Admin User send GET HTTP request with endpoint
    Then Admin User recieves 200 created with Logout successful message
    
   @AdminLogout2
  Scenario: Check admin able to logout  with invalid method
    Given Admin User creates POST request to logout
    When Admin User send POST HTTP request with endpoint to logout
    Then Admin User recieves 405 method not allowed when logging out

 @DieticianLogout3
  Scenario: Check dietician able to logout  
     Given Dietician User creates GET request to logout
    When Dietician User send GET HTTP request with endpoint to logout
    Then Dietician User recieves 200 created with Logout successful message
    
@DieticianLogout4
Scenario:Check dietician able to logout  with invalid method
Given Dietician User creates POST request to logout
When Dietician User send POST HTTP request with endpoint
Then Dietician User recieves 405 method not allowed when logging out

@patientLogout5
Scenario: Check patient able to logout  
Given patient User creates GET request to logout
When patient User send GET HTTP request with endpoint to logout
Then patient User recieves 200 created with Logout successful message

@patientLogout6
Scenario: Check patient able to logout  with invalid method
Given patient User creates POST request to logout
When patient User send POST HTTP request with endpoint to logout
Then patient User recieves 405 method not allowed while logging out

@LogoutAdminwithoutAuth7
Scenario: Check admin able to logout  without auth
Given Admin User creates GET request to logout
When Admin User send GET HTTP request with no Auth and with endpoint
Then Admin User recieves 401 unauthorized without auth

@LogoutDietwithoutAuth8
Scenario: Check dietician able to logout  
Given Dietician User creates GET request to logout
When Dietician User send GET HTTP request with no Auth and with endpoint to logout
Then Dietician User recieves 401 unauthorized without auth

@LogoutPatientwithoutAuth9
Scenario: Check patient able to logout  
Given patient User creates GET request to logout
When Patient User send GET HTTP request with endpoint and without auth
Then Patient User recieves 401 unauthorized without auth






  