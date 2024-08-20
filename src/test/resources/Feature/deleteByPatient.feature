@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Check dietician able to delete patient by ID
    Given Dietician create DELETE request 
    When Dietician send DELETE http request with endpoint
    Then Dietician recieves 401 unauthorized 
    
     @tag2
  Scenario: Check admin is able to retrieve patients morbidity details by patient ID
    Given Admin create GET request 
    When Admin send GET http request with endpoint
    Then Admin recieves 403 Forbidden
    
     @tag3
  Scenario: Check patient is able to retrieve patients morbidity details by patient ID
    Given Patient create GET request 
    When Patient send GET http request with endpoint
    Then Patient  recieves 403 Forbidden 
    
     @tag4
  Scenario: Check dietician able to delete patient by ID
    Given Dietician create DELETE request 
    When Dietician send DELETE http request with endpoint
    Then Dietician recieves 200 ok with details of the patient id
    
     @tag5
  Scenario: Check dietician able to delete patient by id with invalid method
    Given Dietician create POST request 
    When Dietician send POST http request with endpoint
    Then Dietician recieves 405 method not allowed
    
     @tag6
  Scenario: Check dietician able to delete patient by invalid id
    Given Dietician create DELETE request 
    When Dietician send DELETE http request with endpoint
    Then Dietician recieves 404 not found
    
     @tag7
  Scenario: Check dietician able to delete patient by id with invalid endpoint
    Given Dietician create DELETE request 
    When Dietician send DELETE http request with invalid endpoint
    Then Dietician recieves 404 not found