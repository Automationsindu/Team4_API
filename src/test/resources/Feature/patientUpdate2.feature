@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Check dietician able to update patient with valid data
    Given Dietician creates PUT request by entering valid data into the form-data key and value fields.
    When Dietician send PUT http request with endpoint
    Then Dietician recieves 401 unauthorized
  
   @tag1
  Scenario: Check admin able to update patient with valid data and admin token
    Given Admin creates PUT request by entering valid data into the form-data key and value fields.
    When Admin send PUT http request with endpoint
    Then Admin recieves 403 unauthorized

@tag1
  Scenario: Check patient able to update patient with valid data and patient token
    Given Patient creates PUT request by entering valid data into the form-data key and value fields.
    When Patient send PUT http request with endpoint
    Then Patient recieves 403 unauthorized

 

@tag1
  Scenario: Check patient able to update patient with valid data and patient token
    Given Dietician creates PUT request by entering valid data. ( Mandatory and additional details) into the form-data key and value fields.
    When Patient send PUT http request with endpoint
    Then Patient recieves 403 unauthorized