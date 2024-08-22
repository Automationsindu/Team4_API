package com.api.StepDefs;

import java.io.FileNotFoundException;

import com.api.Actions.Morbidity_Get_TestName_Actions;
import com.api.ReusableUtils.API_BaseSetUp_Validations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Morbidity_Get_TestName {
	Morbidity_Get_TestName_Actions actionsMorbidityTestName = new Morbidity_Get_TestName_Actions();
	RequestSpecification reqSpec;
	Response response;
	int statusCode;
	long expectedResponseTime;
	String expectedContentType;
	
	@Given("Admin with valid token create GET request")
	public void admin_with_valid_token_create_get_request() throws FileNotFoundException {
		reqSpec = actionsMorbidityTestName.buildRequest();
		
	}

	@When("Admin with valid token send GET http request with endpoint")
	public void admin_with_valid_token_send_get_http_request_with_endpoint() {
		response = actionsMorbidityTestName.morbidityAdminTokenFastingGlucose(reqSpec);
	    
	}

	@Then("Admin with valid token receives {int} ok with details")
	public void admin_with_valid_token_receives_ok_with_details(Integer statusCode) {
		statusCode =response.getStatusCode();
		expectedResponseTime=response.getTime();
		expectedContentType= response.contentType();
		API_BaseSetUp_Validations.executeAllMethods(response,statusCode,expectedResponseTime,expectedContentType);
		API_BaseSetUp_Validations.validateStatusCode(response,statusCode);
		API_BaseSetUp_Validations.validateContentType(response,"application/json");
	}


	@Given("Admin with valid token create POST request")
	public void admin_with_valid_token_create_post_request() throws FileNotFoundException {
		reqSpec = actionsMorbidityTestName.buildRequest();
	}

	@When("Admin with valid token send POST http request")
	public void admin_with_valid_token_send_post_http_request() {
		response = actionsMorbidityTestName.morbidityAdminTokenInvalidMethod(reqSpec);	
	    
	}

	@Then("Admin with valid token recieves {int} method not allowed")
	public void admin_with_valid_token_recieves_method_not_allowed(Integer statusCode) {
		API_BaseSetUp_Validations.validateStatusCode(response,statusCode);
		API_BaseSetUp_Validations.validateContentType(response,"application/json");
	    
	}

	@When("Admin with valid token send GET http request")
	public void admin_with_valid_token_send_get_http_request() {
		response = actionsMorbidityTestName.morbidityAdminTokenInvalidEndpoint(reqSpec);	
	}

	@Then("admin with valid token recieves {int} not found")
	public void admin_with_valid_token_recieves_not_found(Integer statusCode) {
		API_BaseSetUp_Validations.validateStatusCode(response,statusCode);
		API_BaseSetUp_Validations.validateContentType(response,"application/json");
	}
	
	@When("Admin with valid token send GET http request with invalid TestName")
	public void admin_with_valid_token_send_get_http_request_with_invalid_test_name() {
		response = actionsMorbidityTestName.morbidityAdminTokenInvalidTestName(reqSpec);
	}
	

     @Given("Dietician create GET request with no Authorization")
     public void dietician_create_get_request_with_no_authorization() throws FileNotFoundException {
    	 reqSpec = actionsMorbidityTestName.buildRequest();
}
	
	@When("Dietician send GET http request with no Authorization")
	public void dietician_send_get_http_request_with_no_authorization() {
		response = actionsMorbidityTestName.GetMorbidityDieticianwithNoAuth(reqSpec);
	}

	@Then("Dietician with no Authorization receives {int} unauthorized")
	public void dietician_with_no_authorization_receives_unauthorized(Integer statusCode) {
		API_BaseSetUp_Validations.validateStatusCode(response,statusCode);
		API_BaseSetUp_Validations.validateContentType(response,"application/json");
	   
	}
	@Given("Dietician with valid token and test name create GET request")
	public void dietician_with_valid_token_and_test_name_create_get_request() throws FileNotFoundException {
		reqSpec = actionsMorbidityTestName.buildRequest();
	}
	
	@When("Dietician with valid token and test name send GET http request with endpoint")
	public void dietician_with_valid_token_and_test_name_send_get_http_request_with_endpoint() {
		
		response = actionsMorbidityTestName.morbidityDieticianTokenTSH(reqSpec);
	}

	@Then("Dietician with valid token receives {int} ok with details")
	public void dietician_with_valid_token_receives_ok_with_details(Integer statusCode) {
		API_BaseSetUp_Validations.validateStatusCode(response,statusCode);
		API_BaseSetUp_Validations.validateContentType(response,"application/json");
	}


	@Given("Dietician with valid token and test name create POST request")
	public void dietician_with_valid_token_and_test_name_create_post_request() throws FileNotFoundException {
		reqSpec = actionsMorbidityTestName.buildRequest();
	}

	@When("Dietician with valid token and test name send POST http request")
	public void dietician_with_valid_token_and_test_name_send_post_http_request() {
		
		response = actionsMorbidityTestName.morbidityDieticianTokenInvalidMethod(reqSpec);
	}

	@Then("Dietician with valid token and test name recieves {int} method not allowed")
	public void dietician_with_valid_token_and_test_name_recieves_method_not_allowed(Integer statusCode) {
		API_BaseSetUp_Validations.validateStatusCode(response,statusCode);
		API_BaseSetUp_Validations.validateContentType(response,"application/json");
	}
 
	@Given("Dietician with valid token and test name and invalid endpoint create GET request")
	public void dietician_with_valid_token_and_test_name_and_invalid_endpoint_create_get_request() throws FileNotFoundException {
		reqSpec = actionsMorbidityTestName.buildRequest();
	}

	@When("Dietician with valid token and test name send GET http request")
	public void dietician_with_valid_token_and_test_name_send_get_http_request() {
		response = actionsMorbidityTestName.morbidityDieticianTokenInvalidEndpoint(reqSpec);
	}

	@Then("Dietician with valid token and test name recieves {int} not found")
	public void dietician_with_valid_token_and_test_name_recieves_not_found(Integer statusCode) {
		API_BaseSetUp_Validations.validateStatusCode(response,statusCode);
		API_BaseSetUp_Validations.validateContentType(response,"application/json");
	}
	
	@Given("Dietician with invalid testname create GET request")
	public void dietician_with_invalid_testname_create_get_request() throws FileNotFoundException {
		reqSpec = actionsMorbidityTestName.buildRequest();
	}

	@When("Dietician with invalid testname send GET http request with invalid TestName")
	public void dietician_with_invalid_testname_send_get_http_request_with_invalid_test_name() {
		
		response = actionsMorbidityTestName.morbidityDieticianTokenInvalidTestName(reqSpec);
	}

	@Then("Dietician with invalid testname recieves {int} not found")
	public void dietician_with_invalid_testname_recieves_not_found(Integer statusCode) {
		API_BaseSetUp_Validations.validateStatusCode(response,statusCode);
		API_BaseSetUp_Validations.validateContentType(response,"application/json");
	}
	
	@Given("Patient create GET request to retrieve morbidity by test name")
	public void patient_create_get_request_to_retrieve_morbidity_by_test_name() throws FileNotFoundException {
		reqSpec = actionsMorbidityTestName.buildRequest();
	}

	@When("Patient send GET http request with endpoint to retrieve morbidity by test name")
	public void patient_send_get_http_request_with_endpoint_to_retrieve_morbidity_by_test_name() {
		response = actionsMorbidityTestName.morbidityPatientTestName(reqSpec);
	}

	@Then("Patient recieve {int} Forbidden")
	public void patient_recieve_forbidden(Integer statusCode) {
		API_BaseSetUp_Validations.validateStatusCode(response,statusCode);
		API_BaseSetUp_Validations.validateContentType(response,"application/json");
	}









}
