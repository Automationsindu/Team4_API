package com.api.StepDefs;

import java.io.FileNotFoundException;

import com.api.Actions.Dietician_Post_Get_Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Dietician_Post_Get {
	
	Dietician_Post_Get_Actions actionsDietician = new Dietician_Post_Get_Actions();
	RequestSpecification reqSpec;
	Response response;

	@Given("Set admin token and Admin creates Dietician POST request with valid data.")
	public void set_admin_token_and_admin_creates_dietician_post_request_with_valid_data() throws FileNotFoundException {
	    
		reqSpec = actionsDietician.buildRequest();
	}

	@When("Admin sends Dietician POST http request with endpoint")
	public void admin_sends_dietician_post_http_request_with_endpoint() throws FileNotFoundException {
		
		response= actionsDietician.createDietician(reqSpec);
		actionsDietician.storeDieticianInfo(response);
	    
	}

	@Then("Admin should receive status code {int} created and with response body having auto created dietician ID and login password")
	public void admin_should_receive_status_code_created_and_with_response_body_having_auto_created_dietician_id_and_login_password(Integer int1) {
	    
	    
	}
	
}
