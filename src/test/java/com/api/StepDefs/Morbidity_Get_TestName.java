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
}
