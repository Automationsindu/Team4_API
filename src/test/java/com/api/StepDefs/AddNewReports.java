package com.api.StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNewReports {
	
	@Given("Dietician creates PUT request by entering valid data into the form-data key and value fields and valid patient ID")
	public void dietician_creates_put_request_by_entering_valid_data_into_the_form_data_key_and_value_fields_and_valid_patient_id() {
	    
	}

	@When("Dietician send PUT http request with endpoint")
	public void dietician_send_put_http_request_with_endpoint() {
	 
	}

	@Then("Dietician recieves {int} unauthorized")
	public void dietician_recieves_unauthorized(Integer int1) {
	  
	}

	@Given("Admin creates PUT request by entering valid data into the form-data key and value fields and valid patient ID")
	public void admin_creates_put_request_by_entering_valid_data_into_the_form_data_key_and_value_fields_and_valid_patient_id() {
	    
	}

	@When("Admin send PUT http request with endpoint")
	public void admin_send_put_http_request_with_endpoint() {
	    
	}

	@Then("Admin recieves {int} forbidden")
	public void admin_recieves_forbidden(Integer int1) {
	    
	}

	@Given("Patient creates PUT request by entering valid data into the form-data key and value fields and valid patient ID")
	public void patient_creates_put_request_by_entering_valid_data_into_the_form_data_key_and_value_fields_and_valid_patient_id() {
	  
	}

	@When("Patient send PUT http request with endpoint")
	public void patient_send_put_http_request_with_endpoint() {
	   
	}

	@Then("Patient recieves {int} forbidden")
	public void patient_recieves_forbidden(Integer int1) {
	    
	}

	@Given("Dietician creates PUT request by entering valid data\\( Mandatory and additional details) into the form-data key and value fields and valid patient ID")
	public void dietician_creates_put_request_by_entering_valid_data_mandatory_and_additional_details_into_the_form_data_key_and_value_fields_and_valid_patient_id() {
	   
	}

	@Then("Dietician recieves {int} ok and with updated response body.")
	public void dietician_recieves_ok_and_with_updated_response_body(Integer int1) {
	   
	}

	@Given("Dietician creates PUT request by entering valid data into the form-data key and value fields except valid vitals data and valid patient ID")
	public void dietician_creates_put_request_by_entering_valid_data_into_the_form_data_key_and_value_fields_except_valid_vitals_data_and_valid_patient_id() {
	   
	}

	@Given("Dietician creates PUT request by entering valid data into the form-data key and value fields except file and valid patient ID")
	public void dietician_creates_put_request_by_entering_valid_data_into_the_form_data_key_and_value_fields_except_file_and_valid_patient_id() {
	   
	}

	@Given("Dietician creates PUT request by entering valid data \\( Mandatory only) into the form-data key and value fields and valid patient ID")
	public void dietician_creates_put_request_by_entering_valid_data_mandatory_only_into_the_form_data_key_and_value_fields_and_valid_patient_id() {
	   
	}

	@Given("Dietician creates PUT request by entering valid data \\( Additional details only) into the form-data key and value fields and valid patient ID")
	public void dietician_creates_put_request_by_entering_valid_data_additional_details_only_into_the_form_data_key_and_value_fields_and_valid_patient_id() {
	   
	}

	@Given("Dietician creates PUT request by entering invalid data \\( Additional details only) into the form-data key and value fields and valid patient ID")
	public void dietician_creates_put_request_by_entering_invalid_data_additional_details_only_into_the_form_data_key_and_value_fields_and_valid_patient_id() {
	  
	}

	@Then("Dietician recieves {int} Bad request")
	public void dietician_recieves_bad_request(Integer int1) {
	   
	}

	@Given("Dietician creates PUT request by entering invalid data \\( Additional details only) into the form-data key and value fields and invalid patient ID")
	public void dietician_creates_put_request_by_entering_invalid_data_additional_details_only_into_the_form_data_key_and_value_fields_and_invalid_patient_id() {
	    
	}

	@Then("Dietician recieves {int} not found")
	public void dietician_recieves_not_found(Integer int1) {
	    
	}

	@Given("Dietician creates POST request by entering valid data into the form-data key and value fields and valid patient ID")
	public void dietician_creates_post_request_by_entering_valid_data_into_the_form_data_key_and_value_fields_and_valid_patient_id() {
	  
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

	@Given("Dietician creates PUT request by entering valid data into the form-data key and value fields and valid patient ID with invalid content type")
	public void dietician_creates_put_request_by_entering_valid_data_into_the_form_data_key_and_value_fields_and_valid_patient_id_with_invalid_content_type() {
	   
	}

	@Then("Dietician recieves {int} unsupported media type")
	public void dietician_recieves_unsupported_media_type(Integer int1) {
	  
	}

}
