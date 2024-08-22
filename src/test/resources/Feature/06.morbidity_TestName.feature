
@MorbidityTestName
Feature: Get Morbidity by TestName

  @morbidityAdminTokenFastingGlucose  
  Scenario: Check admin able to retrieve morbidity by TestName
  
  Given Admin with valid token create GET request
  When Admin with valid token send GET http request with endpoint
  Then Admin with valid token receives 200 ok with details
  
  @morbidityAdminTokenInvalidMethod
  Scenario: Check admin able to retrieve morbidity by testname with invalid method
  Given Admin with valid token create POST request 
  When Admin with valid token send POST http request
  Then Admin with valid token recieves 405 method not allowed
  
  @morbidityAdminTokenInvalidEndpoint
  Scenario: Check admin able to retrieve morbidity by testname with invalid endpoint
  Given Admin with valid token create GET request 
  When Admin with valid token send GET http request
  Then admin with valid token recieves 404 not found
  
  @morbidityAdminTokenInvalidTestName
  Scenario: Check admin able to retrieve morbidity by invalid testname 
  Given Admin with valid token create GET request 
  When Admin with valid token send GET http request with invalid TestName
  Then admin with valid token recieves 404 not found
  
  @morbidityDietitianNoAuth
  Scenario: Check dietitian able to retrieve morbidity by TestName with No Authorization
  Given Dietician create GET request with no Authorization
  When Dietician send GET http request with no Authorization
  Then Dietician with no Authorization receives 401 unauthorized
  
  @morbidityDieticianTokenTSH 
  Scenario: Check dietician able to retrieve morbidity by TestName  
  Given Dietician with valid token and test name create GET request
  When Dietician with valid token and test name send GET http request with endpoint
  Then Dietician with valid token receives 200 ok with details
  
  @morbidityDieticianTokenInvalidMethod
  Scenario: Check dietician able to retrieve morbidity by testname with invalid method
  Given Dietician with valid token and test name create POST request 
  When Dietician with valid token and test name send POST http request
  Then Dietician with valid token and test name recieves 405 method not allowed
  
  @morbidityDieticianTokenInvalidEndpoint
  Scenario: Check dietician able to retrieve morbidity by testname with invalid endpoint
  Given Dietician with valid token and test name and invalid endpoint create GET request 
  When Dietician with valid token and test name send GET http request
  Then Dietician with valid token and test name recieves 404 not found
  
  @morbidityDieticianTokenInvalidTestName
  Scenario: Check dietician able to retrieve morbidity by invalid testname 
  Given Dietician with invalid testname create GET request 
  When Dietician with invalid testname send GET http request with invalid TestName
  Then Dietician with invalid testname recieves 404 not found
  
 
 