package com.api.StepDefs;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


import com.api.Actions.Dietician_Post_Get_Actions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Dietician_Post_Get {
	
	Dietician_Post_Get_Actions actionsDietician = new Dietician_Post_Get_Actions();
	RequestSpecification reqSpec;
	Response response;
	String requestData;
	private String currentTag;

	
	@Before
	public void beforeScenario(Scenario scenario) {
		currentTag = scenario.getSourceTagNames().iterator().next();
	}

	@Given("Admin creates Dietician POST request with valid data")
	public void admin_creates_dietician_post_request_with_valid_data() throws InvalidFormatException, IOException {
	    
		reqSpec = actionsDietician.buildRequest();
		requestData = actionsDietician.buildValidRequestData(reqSpec);
		
		
	}
	
	@Given("Admin creates Dietician POST request with {string}")
	public void admin_creates_dietician_post_request_with(String invalidData) throws InvalidFormatException, IOException {
		
		reqSpec = actionsDietician.buildRequest();
		
		System.out.println("in step def "+invalidData);
		requestData = actionsDietician.buildInValidRequestData(reqSpec,currentTag,invalidData);
	   
	}

	/*
	 * @Given("Set admin token and Admin creates Dietician POST request with invalid data"
	 * ) public void
	 * set_admin_token_and_admin_creates_dietician_post_request_with_invalid_data()
	 * throws InvalidFormatException, IOException {
	 * 
	 * reqSpec = actionsDietician.buildRequest(); requestData =
	 * actionsDietician.buildInValidRequestData(reqSpec,currentTag);
	 * 
	 * 
	 * }
	 */
	
	  @When("Set admin token and Admin sends Dietician POST http request with endpoint") 
	  public void set_admin_token_and_admin_sends_dietician_post_http_request_with_endpoint() throws
	  InvalidFormatException, IOException {
		  
		  //requestData = actionsDietician.buildInValidRequestData(reqSpec,currentTag);
		  
		  response = actionsDietician.createDietician(reqSpec,requestData,currentTag);
	  
	  //response= actionsDietician.createDietician(reqSpec,currentTag);
	  
	  //actionsDietician.storeDieticianInfo(response);
	  
	  }
	 
	
	@When("Set admin token and Admin sends Dietician {string} POST http request with endpoint")
	public void set_admin_token_and_admin_sends_dietician_post_http_request_with_endpoint(String dieticianCount) throws InvalidFormatException, IOException {
		
		 //requestData = actionsDietician.buildValidRequestData(reqSpec);
		 
		 response = actionsDietician.createDietician(reqSpec,requestData,currentTag);
		 actionsDietician.validateRequest(response);
		
		//response = actionsDietician.createDietician(reqSpec,currentTag);
		
		actionsDietician.storeDieticianInfo(response, dieticianCount);
		
	}
	
	@When("Set admin token and Admin sends Dietician PUT http request with endpoint")
	public void set_admin_token_and_admin_sends_dietician_put_http_request_with_endpoint() throws InvalidFormatException, IOException {
		
		response = actionsDietician.createDietician(reqSpec,requestData,currentTag);
	    
	}

	@Then("Admin should receive {int} method not allowed")
	public void admin_should_receive_method_not_allowed(Integer int1) {
		assertThat("Status code is not equal", response.getStatusCode(), is(int1));
	    
	}
	
	@When("Set admin token and Admin sends Dietician POST http request with invalid endpoint")
	public void set_admin_token_and_admin_sends_dietician_post_http_request_with_invalid_endpoint() throws InvalidFormatException, IOException {
		
		response = actionsDietician.createDietician(reqSpec,requestData,currentTag);
	    
	}

	@Then("Admin should receive {int} not found")
	public void admin_should_receive_not_found(Integer int1) {
		assertThat("Status code is not equal", response.getStatusCode(), is(int1));
	    
	}
	
	@When("Set admin token and Admin send POST http request with valid endpoint and invalid content type")
	public void set_admin_token_and_admin_send_post_http_request_with_valid_endpoint_and_invalid_content_type() throws InvalidFormatException, IOException {
		
		response = actionsDietician.createDietician(reqSpec,requestData,currentTag);
	    
	}

	@Then("Admin should receive {int} unsupported media type")
	public void admin_should_receive_unsupported_media_type(Integer int1) {
		assertThat("Status code is not equal", response.getStatusCode(), is(int1));
	    
	}


	@Then("Admin should receive status code {int} created and with response body having auto created dietician ID and login password")
	public void admin_should_receive_status_code_created_and_with_response_body_having_auto_created_dietician_id_and_login_password(Integer int1) {
		
		assertThat("Status code is not equal", response.getStatusCode(), is(int1));
	    
	}
	
	@Then("Admin should receive {int} Bad request")
	public void admin_should_receive_bad_request(Integer int1) {
		
		assertThat("Status code is not equal", response.getStatusCode(), is(int1));
		System.out.println(response.getStatusLine());
	    
	}
	
}
