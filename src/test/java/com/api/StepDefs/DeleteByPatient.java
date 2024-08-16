package com.api.StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteByPatient {
	
	@Given("Dietician create DELETE request")
	public void dietician_create_delete_request() {
	   
	}

	@When("Dietician send DELETE http request with endpoint")
	public void dietician_send_delete_http_request_with_endpoint() {
	
	}

	@Then("Dietician recieves {int} unauthorized")
	public void dietician_recieves_unauthorized(Integer int1) {
	  
	}

	@Given("Admin create GET request")
	public void admin_create_get_request() {
	  
	}

	@When("Admin send GET http request with endpoint")
	public void admin_send_get_http_request_with_endpoint() {
	   
	}

	@Then("Admin recieves {int} Forbidden")
	public void admin_recieves_forbidden(Integer int1) {
	   
	}

	@Given("Patient create GET request")
	public void patient_create_get_request() {
	    
	}

	@When("Patient send GET http request with endpoint")
	public void patient_send_get_http_request_with_endpoint() {
	   
	}

	@Then("Patient  recieves {int} Forbidden")
	public void patient_recieves_forbidden(Integer int1) {
	    
	}

	@Then("Dietician recieves {int} ok with details of the patient id")
	public void dietician_recieves_ok_with_details_of_the_patient_id(Integer int1) {
	   
	}

	@Given("Dietician create POST request")
	public void dietician_create_post_request() {
	   
	}

	@When("Dietician send POST http request with endpoint")
	public void dietician_send_post_http_request_with_endpoint() {
	   
	}

	@Then("Dietician recieves {int} method not allowed")
	public void dietician_recieves_method_not_allowed(Integer int1) {
	    

	}

	@Then("Dietician recieves {int} not found")
	public void dietician_recieves_not_found(Integer int1) {
	   

	}

	@When("Dietician send DELETE http request with invalid endpoint")
	public void dietician_send_delete_http_request_with_invalid_endpoint() {
	  

	}

}
