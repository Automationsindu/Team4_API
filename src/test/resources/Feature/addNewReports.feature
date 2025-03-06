@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Check dietician able to add new reports for existing patient with valid data
    Given Dietician creates PUT request by entering valid data into the form-data key and value fields and valid patient ID
    When Dietician send PUT http request with endpoint
    Then Dietician recieves 401 unauthorized
  
   @tag2
  Scenario: Check admin able to add new reports for existing patient with valid data and admin token
    Given Admin creates PUT request by entering valid data into the form-data key and value fields and valid patient ID
    When Admin send PUT http request with endpoint
    Then Admin recieves 403 forbidden

@tag3
  Scenario: Check patient able to add new reports for existing patient with valid data and patient token
    Given Patient creates PUT request by entering valid data into the form-data key and value fields and valid patient ID
    When Patient send PUT http request with endpoint
    Then Patient recieves 403 forbidden

 

@tag4
  Scenario: Check dietician able to add new reports with vitals for existing patient with valid data
    Given Dietician creates PUT request by entering valid data( Mandatory and additional details) into the form-data key and value fields and valid patient ID
    When Patient send PUT http request with endpoint
   Then  Dietician recieves 200 ok and with updated response body. 
   
   
@tag5
  Scenario: Check dietician able to add new reports without vitals for existing patient with valid data
    Given Dietician creates PUT request by entering valid data into the form-data key and value fields except valid vitals data and valid patient ID
    When Patient send PUT http request with endpoint
   Then  Dietician recieves 200 ok and with updated response body.
   
   @tag6
  Scenario: Check dietician able to add only new vitals without reports for existing patient with report
    Given Dietician creates PUT request by entering valid data into the form-data key and value fields except file and valid patient ID
    When Patient send PUT http request with endpoint
   Then  Dietician recieves 200 ok and with updated response body.
   
   @tag7
  Scenario: Check dietician able to add only new vitals without reports for existing patient without report
    Given Dietician creates PUT request by entering valid data into the form-data key and value fields except file and valid patient ID
    When Patient send PUT http request with endpoint
   Then  Dietician recieves 200 ok and with updated response body.
   
   @tag8
  Scenario: Check dietician able to add new reports for existing patient only with valid mandatory details
    Given Dietician creates PUT request by entering valid data ( Mandatory only) into the form-data key and value fields and valid patient ID
    When Patient send PUT http request with endpoint
   Then  Dietician recieves 200 ok and with updated response body.
   
   @tag9
  Scenario: Check dietician able to add new reports for existing patient only with valid additional details
    Given Dietician creates PUT request by entering valid data ( Additional details only) into the form-data key and value fields and valid patient ID
    When Patient send PUT http request with endpoint
   Then  Dietician recieves 200 ok and with updated response body.
   
  @tag10
  Scenario: Check dietician able to add new reports  for existing patient with invalid data
    Given Dietician creates PUT request by entering invalid data ( Additional details only) into the form-data key and value fields and valid patient ID
    When Patient send PUT http request with endpoint
   Then  Dietician recieves 400 Bad request 
   
     @tag11
  Scenario: Check dietician able to add new reports for existing patient with valid data and invalid patient id as path parameter
    Given Dietician creates PUT request by entering invalid data ( Additional details only) into the form-data key and value fields and invalid patient ID
    When Patient send PUT http request with endpoint
   Then  Dietician recieves 404 not found
   
  
   @tag12
  Scenario: Check dietician able to update patient with valid data and invalid method
    Given Dietician creates POST request by entering valid data into the form-data key and value fields and valid patient ID
    When Dietician send POST http request with endpoint
   Then  Dietician recieves 405 method not allowed
   
   @tag13
  Scenario: Check dietician able to add new reports for existing patient with valid data and invalid endpoint
    Given Dietician creates POST request by entering valid data into the form-data key and value fields and valid patient ID
    When Dietician sent PUT http request with invalid endpoint
   Then  Dietician recieves 404 not found
   
    @tag14
  Scenario: Check dietician able to add new reports for existing patient  with valid data and invalid content type
    Given Dietician creates PUT request by entering valid data into the form-data key and value fields and valid patient ID with invalid content type
    When Dietician send PUT http request with endpoint
   Then  Dietician recieves 415 unsupported media type
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   