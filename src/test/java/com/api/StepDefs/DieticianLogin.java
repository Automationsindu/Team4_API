package com.api.StepDefs;

import java.io.FileNotFoundException;

import com.api.Actions.UserLogin_Actions;
import com.api.ReusableUtils.API_BaseSetUp_Validations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DieticianLogin {
	UserLogin_Actions actionsLogin= new UserLogin_Actions();
	RequestSpecification reqSpec;
	Response response;
	int statusCode;
	long expectedResponseTime;
	String expectedContentType;
	
@Given("User creates Post request with request body for Dietician login")
public void user_creates_post_request_with_request_body_for_dietician_login() throws FileNotFoundException {
	reqSpec = actionsLogin.buildRequest();
}

@When("User send POST HTTP request with endpoint for Dietician login")
public void user_send_post_http_request_with_endpoint_for_dietician_login() {
	response =actionsLogin.DietLogin(reqSpec);
}

@Then("User recieves {int} created with response body for Dietician login")
public void user_recieves_created_with_response_body_for_dietician_login(Integer int1) {
	statusCode =response.getStatusCode();
	expectedResponseTime=response.getTime();
	expectedContentType= response.contentType();
	API_BaseSetUp_Validations.executeAllMethods(response,statusCode,expectedResponseTime,expectedContentType);
}
@Given("User creates Post request with invalid credential for Dietician login")
public void user_creates_post_request_with_invalid_credential_for_dietician_login() throws FileNotFoundException {
	
	reqSpec = actionsLogin.buildRequest();
}

@Then("User recieves {int} unauthorized for Dietician login")
public void user_recieves_unauthorized_for_dietician_login(Integer int1) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
}
