package com.api.StepDefs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.api.Actions.Dietician_Put_Delete_Actions;
import com.api.EnvVariables.EnvConstants;
import com.api.EnvVariables.EnvVariables;

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

	
	@Given("Admin creates PUT request with valid data and sets No Auth")
	public void admin_creates_put_request_with_valid_data_and_sets_no_auth() throws InvalidFormatException, IOException {
	   
		
		reqSpec = actionDietician.buildRequest();
		requestData = actionDietician.buildputValidRequestData(reqSpec);
        String dietician2_ID = EnvVariables.dietician2_ID;
		System.out.println("Valid_Data_with_no_Auth");
		
	}

	@When("Admin send PUT http request with endpoint")
	public void admin_send_put_http_request_with_endpoint() throws InvalidFormatException, IOException {
	   
		
		String updateDietician_Endpoint = EnvConstants.updateDietician_Endpoint;
		Object invalidData = null;
		response = ((Dietician_Put_Delete_Actions) actionDietician).UpdateDietician(reqSpec,requestData,currentTag);
		Object invalidData1 = null;
		System.out.println("in step def "+invalidData1);
		//requestData = actionDietician.buildputInValidRequestData(reqSpec,currentTag,invalidData);
		
	}

	@Then("Admin receives {int} unauthorized")
	public void admin_receives_unauthorized(Integer int1) {
	    
     System.out.println("401 Unauthorised");
	}
	


	@Given("Admin creates PUT request with valid data")
	public void admin_creates_put_request_with_valid_data() throws InvalidFormatException, IOException {
	    
		reqSpec = actionDietician.buildRequest();
		requestData = actionDietician.buildputValidRequestData(reqSpec);
		
	}

	@Then("Admin recieves {int} forbidden")
	public void admin_recieves_forbidden(Integer int1) {
		System.out.println("403 Forbidden");
	}

	
	@Given("Admin creates PUT request with valid data with patient id")
	public void admin_creates_put_request_with_valid_data_with_patient_id() throws InvalidFormatException, IOException {
	   
        String patient1_Email1 = EnvVariables.patient1_Email1;
		reqSpec = actionDietician.buildRequest();
		requestData = actionDietician.buildputValidRequestData(reqSpec);
	}
	
	
}