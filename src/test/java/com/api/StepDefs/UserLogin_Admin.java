package com.api.StepDefs;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.api.Actions.UserLogin_Actions;
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
	Integer statusCode;
	
	@Before
	public void beforeScenario(Scenario scenario) {
		currentTag = scenario.getSourceTagNames().iterator().next();
	}
	
	
	@Given("User creates Post request with request body")
	public void user_creates_post_request_with_request_body() throws FileNotFoundException {
		//actionsLogin.readProperties();
		reqSpec = actionsLogin.buildRequest();
	}

	@When("User send POST HTTP request with endpoint")
	public void user_send_post_http_request_with_endpoint() throws InvalidFormatException, IOException {
		try {
		//	response= actionsLogin.loginToGetAuthorized_User(reqSpec);
			statusCode =actionsLogin.loginToGetAuthorized_User(reqSpec,currentTag);
			
		} catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	@Then("User recieves status code created with response body")
	public void user_recieves_created_with_response_body() {
		try {
			actionsLogin.loginResponseCode(statusCode,reqSpec,currentTag);
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
	public void user_recieves_unauthorized(Integer int1) throws org.apache.poi.openxml4j.exceptions.InvalidFormatException, IOException {
		
			actionsLogin.loginResponseCode(statusCode,reqSpec,currentTag);
		
	}

@Given("User creates GET request with request body for userLogin")
public void user_creates_get_request_with_request_body() throws FileNotFoundException {
    
	reqSpec = actionsLogin.buildRequest();
}

@When("User send GET HTTP request with endpoint for userLogin")
public void user_send_get_http_request_with_endpoint() {
	try {
		//	response= actionsLogin.loginToGetAuthorized_User(reqSpec);
		 statusCode = actionsLogin.loginToGetAuthorized_User(reqSpec,currentTag);
			
		} catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

@Then("User recieves {int} method not allowed")
public void user_recieves_method_not_allowed(Integer int1) {
	try {
		 actionsLogin.loginResponseCode(statusCode,reqSpec,currentTag);
	} catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

@Given("User creates Post request with request body.")
public void user_creates_post_request_with_request_body1() throws FileNotFoundException {
	reqSpec = actionsLogin.buildRequest();
	
}

@When("User send POST HTTP request with invalid endpoint")
public void user_send_post_http_request_with_invalid_endpoint() throws org.apache.poi.openxml4j.exceptions.InvalidFormatException, IOException {
	
	 statusCode =actionsLogin.loginToGetAuthorized_User(reqSpec,currentTag);
		
}

@Given("User creates Post request with request body and invalid content type.")
public void user_creates_post_request_with_request_body_and_invalid_content_type() throws FileNotFoundException {
    
	reqSpec = actionsLogin.buildRequest();
}

@Then("User recieves {int} unsupported media type")
public void user_recieves_unsupported_media_type(Integer int1) {
    
	try {
		actionsLogin.loginResponseCode(statusCode,reqSpec,currentTag);
	} catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 
}

@Given("User creates Post request with request body for Dietician login")
public void user_creates_post_request_with_request_body_for_dietician_login() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("User send POST HTTP request with endpoint for Dietician login")
public void user_send_post_http_request_with_endpoint_for_dietician_login() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("User recieves {int} created with response body for Dietician login")
public void user_recieves_created_with_response_body_for_dietician_login(Integer int1) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Given("User creates Post request with invalid credential for Dietician login")
public void user_creates_post_request_with_invalid_credential_for_dietician_login() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Given("User creates Post request with request body for patient Login")
public void user_creates_post_request_with_request_body_for_patient_login() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("User send POST HTTP request with endpoint for patient Login")
public void user_send_post_http_request_with_endpoint_for_patient_login() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("User recieves {int} created with response body for patient Login")
public void user_recieves_created_with_response_body_for_patient_login(Integer int1) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Given("User creates Post request with invalid credential for patient login")
public void user_creates_post_request_with_invalid_credential_for_patient_login() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("User send POST HTTP request with endpoint for patient login")
public void user_send_post_http_request_with_endpoint_for_patient_login1() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("User recieves {int} unauthorized for patient login")
public void user_recieves_unauthorized_for_patient_login(Integer int1) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}



}
