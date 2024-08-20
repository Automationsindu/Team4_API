@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Check dietician able to update patient with valid data
    Given Dietician creates PUT request by entering valid data into the form-data key and value fields.
    When Dietician send PUT http request with endpoint
    Then Dietician recieves 401 unauthorized
  
   @tag2
  Scenario: Check admin able to update patient with valid data and admin token
    Given Admin creates PUT request by entering valid data into the form-data key and value fields.
    When Admin send PUT http request with endpoint
    Then Admin recieves 403 forbidden

@tag3
  Scenario: Check patient able to update patient with valid data and patient token
    Given Patient creates PUT request by entering valid data into the form-data key and value fields.
    When Patient send PUT http request with endpoint
    Then Patient recieves 403 forbidden

 

@tag4
  Scenario: Check dietician able to create patient with valid data and token
    Given Dietician creates PUT request by entering valid data. ( Mandatory and additional details) into the form-data key and value fields.
    When Patient send PUT http request with endpoint
   Then  Dietician recieves 200 ok and with updated response body. 
   
   
@tag5
  Scenario: Check dietician able to update patient only with valid mandatory details
    Given Dietician creates PUT request by entering only valid mandatory details into the form-data key and value fields.
    When Patient send PUT http request with endpoint
   Then  Dietician recieves 200 ok and with updated response body.
   
   @tag6
  Scenario: Check dietician able to update patient with mandatory fields empty and only with valid additional details
    Given Dietician creates PUT request by entering only valid additional details into the form-data key and value fields.
    When Patient send PUT http request with endpoint
   Then  Dietician recieves 400 Bad request 
   
    @tag7
  Scenario: Check dietician able to update patient with invalid data
    Given Dietician creates PUT request by entering only invalid additional details into the form-data key and value fields.
    When Patient send PUT http request with endpoint
   Then  Dietician recieves 400 Bad request 
   
     @tag8
  Scenario: Check dietician able to update patient with valid data and invalid patient id in path parameter
    Given Dietician creates PUT request by entering only valid mandatory details into the form-data key and value fields.
    When Patient send PUT http request with endpoint
   Then  Dietician recieves 404 not found
   
     @tag9
  Scenario: Check dietician able to update patient with existing file by not attaching new file 
    Given Dietician creates PUT request by not attaching any file into the form-data key and value fields.
    When Patient send PUT http request with endpoint
   Then  Dietician recieves 200 ok and with updated response body. 
   
   @tag10
  Scenario: Check dietician able to update patient with valid data and invalid method
    Given Dietician creates PUT request by entering valid data into the form-data key and value fields.
    When Dietician send POST http request with endpoint
   Then  Dietician recieves 405 method not allowed
   
   @tag11
  Scenario: Check dietician able to update patient with valid data and invalid endpoint
    Given Dietician creates PUT request by entering valid data into the form-data key and value fields.
    When Dietician sent PUT http request with invalid endpoint
   Then  Dietician recieves 404 not found
   
    @tag12
  Scenario: Check dietician able to update patient with valid data, patient id and invalid content type
    Given Dietician creates PUT request by entering valid data into the form-data key and value fields and invalid content type
    When Dietician send PUT http request with endpoint
   Then  Dietician recieves 415 unsupported media type
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   