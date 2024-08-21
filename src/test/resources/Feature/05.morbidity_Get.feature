
@morbidity
Feature: Get Morbidity

  @morbidityDietitianNoAuth
  Scenario: Check dietitian able to retrieve all morbidity details
  Given Dietician create GET request
  When Dietician send GET http request with endpoint
  Then Dietician receives 401 unauthorized
  
  @morbidityAdmin
  Scenario: Check admin able to retrieve all morbidity
  Given Admin create GET request
  When Admin send GET http request with endpoint
  Then Admin receives 200 ok with details
  
  @morbidityAdminInvalidMethod
  Scenario: Check admin able to retrieve all morbidities details with invalid method
  Given Admin create POST request 
  When Admin send POST http request
  Then Admin recieves 405 method not allowed
  
  @morbidityAdminInvalidEndpoint
  Scenario: Check admin able to retrieve all morbidities details with invalid endpoint
  Given Admin create GET request 
  When Admin send GET http request
  Then admin recieves 404 not found
  
  @morbidityDietician
  Scenario: Check dietician able to retrieve all morbidity
  Given Dietician create GET request
  When Dietician send GET http request with endpoint
  Then Dietician receives 200 ok with details
  
  @morbidityDieticianInvalidMethod
  Scenario: Check dietician able to retrieve all morbidities details with invalid method
  Given Dietician create POST request 
  When Dietician send POST http request
  Then Dietician recieves 405 method not allowed
  
  @morbidityDieticianInvalidEndpoint
  Scenario: Check dietician able to retrieve all morbidities details with invalid endpoint
  Given Dietician create GET request 
  When Dietician send GET http request
  Then Dietician recieves 404 not found
  
  @morbidityPatient
  Scenario: Check patient able to retrieve all morbidity
  Given Patient create GET request
  When Patient send GET http request with endpoint
  Then Patient recieves 403 Forbidden
  