package com.api.StepDefs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.api.Actions.Morbidity_Get_Actions;
import com.api.ReusableUtils.API_BaseSetUp_Validations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Morbidity_Get {
	
	Morbidity_Get_Actions actionsMorbidity = new Morbidity_Get_Actions();	
	RequestSpecification reqSpec;
	Response response;
	int statusCode;
	long expectedResponseTime;
	String expectedContentType;
	
	/*----- Admin Token Morbidity -----*/
	@Given("Admin create GET request")
	public void admin_create_get_request() throws FileNotFoundException {
	    // Write code here that turns the phrase above into concrete actions
		
		reqSpec = actionsMorbidity.buildRequest();
		
	}

	@When("Admin send GET http request with endpoint")
	public void admin_send_get_http_request_with_endpoint() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		    
	   response = actionsMorbidity.RetrieveAdminMorbidity(reqSpec);	
	}

	@Then("Admin receives {int} ok with details")
	public void admin_receives_ok_with_details(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		//assertThat("Status code is not equal", response.getStatusCode(), is(int1));
		statusCode =response.getStatusCode();
		expectedResponseTime=response.getTime();
		expectedContentType= response.contentType();
		API_BaseSetUp_Validations.executeAllMethods(response,statusCode,expectedResponseTime,expectedContentType);
		API_BaseSetUp_Validations.validateStatusCode(response,statusCode);
		API_BaseSetUp_Validations.validateContentType(response,"application/json");
	    throw new io.cucumber.java.PendingException();
	}

	/* ----- Morbidity Dietician No Authorized ---*/
	@Given("Dietician create GET request")
	public void dietician_create_get_request() throws FileNotFoundException {
	    // Write code here that turns the phrase above into concrete actions
		reqSpec = actionsMorbidity.buildRequest();
		
	   // throw new io.cucumber.java.PendingException();
	}

	@When("Dietician send GET http request with endpoint")
	public void dietician_send_get_http_request_with_endpoint() {
	    // Write code here that turns the phrase above into concrete actions
		 response = actionsMorbidity.GetMorbiditywithNoAuth(reqSpec);	
		 
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Dietician receives {int} unauthorized")
	public void dietician_receives_unauthorized(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	//	assertThat("Status code is not equal", response.getStatusCode(), is(int1));
		statusCode =response.getStatusCode();
		expectedResponseTime=response.getTime();
		expectedContentType= response.contentType();
		API_BaseSetUp_Validations.executeAllMethods(response,statusCode,expectedResponseTime,expectedContentType);
		API_BaseSetUp_Validations.validateStatusCode(response,statusCode);
		API_BaseSetUp_Validations.validateContentType(response,"application/json");
	    throw new io.cucumber.java.PendingException();
	}
/* ------ Admin Token with Invalid Method ----*/
	@Given("Admin create POST request")
	public void admin_create_post_request() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin send POST http request")
	public void admin_send_post_http_request() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin recieves {int} method not allowed")
	public void admin_recieves_method_not_allowed(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
  /* ----- Admin Token with Invalid Endpoint ----- */
	@When("Admin send GET http request")
	public void admin_send_get_http_request() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("admin recieves {int} not found")
	public void admin_recieves_not_found(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

  /* ------- Dietician Token to retrieve 200 ok ----- */	 
	@Then("Dietician receives {int} ok with details")
	public void dietician_receives_ok_with_details(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	/* ------Dietician Token with invalid method -------*/
	
	@Given("Dietician create POST request")
	public void dietician_create_post_request() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	
	@When("Dietician send POST http request")
	public void dietician_send_post_http_request() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Dietician recieves {int} method not allowed")
	public void dietician_recieves_method_not_allowed(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	/* ------Dietician Token with invalid endpoint -------*/
	@When("Dietician send GET http request")
	public void dietician_send_get_http_request() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Dietician recieves {int} not found")
	public void dietician_recieves_not_found(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	
	
	/*------ Set Patient Token ------*/
	@Given("Patient create GET request")
	public void patient_create_get_request() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Patient send GET http request with endpoint")
	public void patient_send_get_http_request_with_endpoint() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Patient recieves {int} Forbidden")
	public void patient_recieves_forbidden(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
}
