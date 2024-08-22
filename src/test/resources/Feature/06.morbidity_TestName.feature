
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
  
 
 