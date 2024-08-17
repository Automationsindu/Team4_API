package com.api.StepDefs;

import java.io.FileNotFoundException;

import com.api.Actions.UserLogin_Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserLogin_Admin {
	
	UserLogin_Actions actionsLogin= new UserLogin_Actions();
	RequestSpecification reqSpec;
	Response response;
	
	
	@Given("User creates Post request with request body")
	public void user_creates_post_request_with_request_body() throws FileNotFoundException {
		//actionsLogin.readProperties();
		reqSpec = actionsLogin.buildRequest();
	}

	@When("User send POST HTTP request with endpoint")
	public void user_send_post_http_request_with_endpoint() throws FileNotFoundException {
		response= actionsLogin.loginToGetAuthorized_User(reqSpec);
		actionsLogin.storeAuthToken(response);
	}

	@Then("User recieves {int} created with response body")
	public void user_recieves_created_with_response_body(Integer int1) {
		
		
		System.out.println("test");
	}


}
