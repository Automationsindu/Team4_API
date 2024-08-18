package com.api.StepDefs;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.api.Actions.UserLogin_Actions;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

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
	public void user_send_post_http_request_with_endpoint() throws InvalidFormatException, IOException {
		try {
		//	response= actionsLogin.loginToGetAuthorized_User(reqSpec);
			actionsLogin.loginToGetAuthorized_User(reqSpec);
			
		} catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//actionsLogin.storeAuthToken(response);
	}
	

	@Then("User recieves status code created with response body")
	public void user_recieves_created_with_response_body() {
		try {
			actionsLogin.loginResponseCode(reqSpec);
		} catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Given("User creates Post request with invalid credential")
	public void user_creates_post_request_with_invalid_credential() throws FileNotFoundException {
		reqSpec = actionsLogin.buildRequest();
	}

	@Then("User recieves {int} unauthorized")
	public void user_recieves_unauthorized(Integer int1) {
	   System.out.println("user recieves 401 unauthorized");
	}

}
