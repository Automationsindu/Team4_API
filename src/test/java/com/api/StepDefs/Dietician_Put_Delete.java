package com.api.StepDefs;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.api.Actions.Dietician_Post_Get_Actions;
import com.api.Actions.Dietician_Put_Delete_Actions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Dietician_Put_Delete {
	
	Dietician_Put_Delete_Actions actionDietician = new Dietician_Put_Delete_Actions();
	RequestSpecification reqSpec;
	Response response;
	String requestData;
	private String currentTag;

	
	@Before
	public void beforeScenario(Scenario scenario) {
		currentTag = scenario.getSourceTagNames().iterator().next();
		
	}
	
	@Given("Admin creates PUT request with valid data")
	public void admin_creates_put_request_with_valid_data() throws InvalidFormatException, IOException {
	    
		reqSpec = actionDietician.buildRequest();
		requestData = actionDietician.buildputValidRequestData(reqSpec);
		
	}

	@When("Admin send PUT http request with endpoint")
	public void admin_send_put_http_request_with_endpoint() {
	   
		
	}

	@Then("Admin recieves {int} unauthorized")
	public void admin_recieves_unauthorized(Integer int1) {
	    
		
	}

}
