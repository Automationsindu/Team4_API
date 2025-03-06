package com.api.StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdadePatient {
	
	@Given("Dietician creates PUT request by entering valid data into the form-data key and value fields.")
	public void dietician_creates_put_request_by_entering_valid_data_into_the_form_data_key_and_value_fields() {
	   

	}

	@When("Dietician send PUT http request with endpoint")
	public void dietician_send_put_http_request_with_endpoint() {
	   

	}

	@Then("Dietician recieves {int} unauthorized")
	public void dietician_recieves_unauthorized(Integer int1) {
	    

	}

	@Given("Admin creates PUT request by entering valid data into the form-data key and value fields.")
	public void admin_creates_put_request_by_entering_valid_data_into_the_form_data_key_and_value_fields() {
	   

	}

	@When("Admin send PUT http request with endpoint")
	public void admin_send_put_http_request_with_endpoint() {
	    

	}

	@Then("Admin recieves {int} forbidden")
	public void admin_recieves_forbidden(Integer int1) {
	    

	}

	@Given("Patient creates PUT request by entering valid data into the form-data key and value fields.")
	public void patient_creates_put_request_by_entering_valid_data_into_the_form_data_key_and_value_fields() {
	   

	}

	@When("Patient send PUT http request with endpoint")
	public void patient_send_put_http_request_with_endpoint() {
	  

	}

	@Then("Patient recieves {int} forbidden")
	public void patient_recieves_forbidden(Integer int1) {
	   

	}

	@Given("Dietician creates PUT request by entering valid data. \\( Mandatory and additional details) into the form-data key and value fields.")
	public void dietician_creates_put_request_by_entering_valid_data_mandatory_and_additional_details_into_the_form_data_key_and_value_fields() {
	   

	}

	@Then("Dietician recieves {int} ok and with updated response body.")
	public void dietician_recieves_ok_and_with_updated_response_body(Integer int1) {
	    

	}

	@Given("Dietician creates PUT request by entering only valid mandatory details into the form-data key and value fields.")
	public void dietician_creates_put_request_by_entering_only_valid_mandatory_details_into_the_form_data_key_and_value_fields() {
	    

	}

	@Given("Dietician creates PUT request by entering only valid additional details into the form-data key and value fields.")
	public void dietician_creates_put_request_by_entering_only_valid_additional_details_into_the_form_data_key_and_value_fields() {
	   

	}

	@Then("Dietician recieves {int} Bad request")
	public void dietician_recieves_bad_request(Integer int1) {
	   

	}

	@Given("Dietician creates PUT request by entering only invalid additional details into the form-data key and value fields.")
	public void dietician_creates_put_request_by_entering_only_invalid_additional_details_into_the_form_data_key_and_value_fields() {
	    

	}

	@Then("Dietician recieves {int} not found")
	public void dietician_recieves_not_found(Integer int1) {
	

	}

	@Given("Dietician creates PUT request by not attaching any file into the form-data key and value fields.")
	public void dietician_creates_put_request_by_not_attaching_any_file_into_the_form_data_key_and_value_fields() {
	   

	}

	@When("Dietician send POST http request with endpoint")
	public void dietician_send_post_http_request_with_endpoint() {
	    

	}

	@Then("Dietician recieves {int} method not allowed")
	public void dietician_recieves_method_not_allowed(Integer int1) {
	   

	}

	@When("Dietician sent PUT http request with invalid endpoint")
	public void dietician_sent_put_http_request_with_invalid_endpoint() {
	   

	}

	@Given("Dietician creates PUT request by entering valid data into the form-data key and value fields and invalid content type")
	public void dietician_creates_put_request_by_entering_valid_data_into_the_form_data_key_and_value_fields_and_invalid_content_type() {
	   

	}

	@Then("Dietician recieves {int} unsupported media type")
	public void dietician_recieves_unsupported_media_type(Integer int1) {
	    

	}


}
