package com.api.StepDefs;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.api.Actions.UserLogin_Actions;
import com.api.ReusableUtils.API_BaseSetUp_Validations;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserLogin_Admin {
	
	UserLogin_Actions actionsLogin= new UserLogin_Actions();
	RequestSpecification reqSpec;
	Response response;
	private String currentTag;
	int statusCode;
	long expectedResponseTime;
	String expectedContentType;
	
	@Before
	public void beforeScenario(Scenario scenario) {
		currentTag = scenario.getSourceTagNames().iterator().next();
	}
	
	
	@Given("Admin User creates Post request with request body")
	public void user_creates_post_request_with_request_body() throws FileNotFoundException {
		
		reqSpec = actionsLogin.buildRequest();
	}

	@When("Admin User send POST HTTP request with endpoint")
	public void user_send_post_http_request_with_endpoint() throws InvalidFormatException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		
			response =actionsLogin.loginToGetAuthorized_User(reqSpec,currentTag);
	}
	

	@Then("Admin User recieves status code created with response body")
	public void user_recieves_created_with_response_body() {
		statusCode =response.getStatusCode();
		expectedResponseTime=response.getTime();
		expectedContentType= response.contentType();
		API_BaseSetUp_Validations.executeAllMethods(response,statusCode,expectedResponseTime,expectedContentType);
			
	}
	@Given("Admin User creates Post request with invalid credential")
	public void user_creates_post_request_with_invalid_credential() throws FileNotFoundException {
		reqSpec = actionsLogin.buildRequest();
	}


@Given("Admin User creates GET request with request body for userLogin")
public void user_creates_get_request_with_request_body() throws FileNotFoundException {
    
	reqSpec = actionsLogin.buildRequest();
}

@When("Admin User send GET HTTP request with endpoint for userLogin")
public void user_send_get_http_request_with_endpoint() {
	try {
		
		response = actionsLogin.loginToGetAuthorized_User(reqSpec,currentTag);
			
		} catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException | IOException e) {
			
			e.printStackTrace();
		}	
	}


@When("Admin User send POST HTTP request with invalid endpoint")
public void user_send_post_http_request_with_invalid_endpoint() throws org.apache.poi.openxml4j.exceptions.InvalidFormatException, IOException {
	
	response =actionsLogin.loginToGetAuthorized_User(reqSpec,currentTag);
		
}

@Given("Admin User creates Post request with request body and invalid content type.")
public void user_creates_post_request_with_request_body_and_invalid_content_type() throws FileNotFoundException {
    
	reqSpec = actionsLogin.buildRequest();
}


}
