package com.api.StepDefs;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.api.Actions.Patient_Actions;
import com.api.ReusableUtils.API_BaseSetUp_Validations;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Patient_StepDef extends API_BaseSetUp_Validations  {
	
	Patient_Actions patient_Actions= new Patient_Actions();
	RequestSpecification reqSpec;
	Response response;
	static String expecContenValue="application/json";
	static long expecResponseTime=5000;
	private String currentTag;
	String reqData;
	
	@Before
	public void beforeScenario(Scenario scenario) {
		currentTag = scenario.getSourceTagNames().iterator().next();
	}
	
	
	/*=======================Scenario: Check dietician able to create patient with no auth=====================*/
	@Given("Dietician creates POST request by entering valid data into the form-data key and value fields with {string}")
	public void dietician_creates_post_request_by_entering_valid_data_into_the_form_data_key_and_value_fields_with(String noAuth) throws com.fasterxml.jackson.databind.exc.InvalidFormatException, IOException, InvalidFormatException {
		reqSpec=patient_Actions.buildRequest();
		reqData=patient_Actions.buildInValidRequestData(reqSpec, currentTag, noAuth);
	}

	@When("Dietician sends POST http request with endpoint with noAuth")
	public void dietician_sends_post_http_request_with_endpoint_with_noAuth() throws InvalidFormatException, IOException {
		response=patient_Actions.createPatient_AllTest(reqSpec, reqData, currentTag);
	}
	
	
	@Then("Dietician receives {int} unauthorized patient")
	public void dietician_receives_unauthorized_patient(Integer statusCode) {
		API_BaseSetUp_Validations.executeAllMethods(response, statusCode, expecResponseTime, expecContenValue);

	}

	/*=======================Scenario: Check admin able to create patient with admin bearer token =====================*/
	
	@Given("Admin creates POST request by entering valid data into the form-data key and value fields with {string}")
	public void admin_creates_post_request_by_entering_valid_data_into_the_form_data_key_and_value_fields_with(String adminToken) throws com.fasterxml.jackson.databind.exc.InvalidFormatException, InvalidFormatException, IOException {
		reqSpec= patient_Actions.buildRequest();
		reqData=patient_Actions.buildInValidRequestData(reqSpec, currentTag, adminToken);
	}

	@When("Admin sends POST http request with endpoint")
	public void admin_sends_post_http_request_with_endpoint() throws com.fasterxml.jackson.databind.exc.InvalidFormatException, IOException {
		response=patient_Actions.createPatient_AllTest(reqSpec, reqData, currentTag);
	}

	@Then("Admin receives {int} forbidden")
	public void admin_receives_forbidden(Integer statusCode) {
		API_BaseSetUp_Validations.executeAllMethods(response, statusCode, expecResponseTime, expecContenValue);

	}

	/*=======================Scenario: Check patient able to create patient with patient bearer token ===============*/
	
	
	@Given("Patient creates POST request by entering valid data into the form-data key and value fields {string}")
	public void patient_creates_post_request_by_entering_valid_data_into_the_form_data_key_and_value_fields(String patientToken) throws com.fasterxml.jackson.databind.exc.InvalidFormatException, InvalidFormatException, IOException {
	    reqSpec= patient_Actions.buildRequest();
		reqData=patient_Actions.buildInValidRequestData(reqSpec, currentTag, patientToken);
	}

	@When("Patient sends POST http request with endpoint")
	public void patient_sends_post_http_request_with_endpoint() throws com.fasterxml.jackson.databind.exc.InvalidFormatException, IOException {
		response=patient_Actions.createPatient_AllTest(reqSpec, reqData, currentTag);
	}

	@Then("Patient receives {int} forbidden")
	public void patient_receives_forbidden(Integer int1) {
	   
	}

/*====Scenario: check dietician able to create patient with valid data and token Mandatory and additional details ===*/
	
	@Given("Dietician creates POST request by entering valid data \\(Mandatory and additional details) into the form-data key and value fields")
	public void dietician_creates_post_request_by_entering_valid_data_mandatory_and_additional_details_into_the_form_data_key_and_value_fields() throws InvalidFormatException, IOException {
		reqSpec = patient_Actions.buildRequest();
		
	}

	@When("Dietician sends POST http request with endpoint")
	public void dietician_sends_post_http_request_with_endpoint() throws InvalidFormatException, IOException {
		response=patient_Actions.createPatient(reqSpec);
	}

	@Then("Dietician receives {int} created and with response body \\(Auto created dietician ID and login password)")
	public void dietician_receives_created_and_with_response_body_auto_created_dietician_id_and_login_password(Integer statusCode) {
		API_BaseSetUp_Validations.executeAllMethods(response, statusCode, expecResponseTime, expecContenValue);

	}

	/*================Scenario: Check dietician able to create patient only with valid mandatory details =====================*/
	
	
	@Given("Dietician creates POST request only by valid mandatory details into the form-data key and value fields")
	public void dietician_creates_post_request_only_by_valid_mandatory_details_into_the_form_data_key_and_value_fields() throws InvalidFormatException, IOException {
		reqSpec = patient_Actions.buildRequest();
		
	}
	
	@When("Dietician sends POST http request with endpoint with only mandatory field")
	public void dietician_sends_post_http_request_with_endpoint_with_only_mandatory_field() throws InvalidFormatException, IOException {
	    System.out.println("creating patient without adding reports");
	    response= patient_Actions.createPatient_mandatory(reqSpec);
	}

	
	
	/*================Scenario: Check dietician able to create patient only with Invalid mandatory details =====================*/
		
	@Given("Dietician creates POST request only by invalid mandatory details into the form-data key and value fields with {string}")
	public void dietician_creates_post_request_only_by_invalid_mandatory_details_into_the_form_data_key_and_value_fields_with(String mandatory_details) throws com.fasterxml.jackson.databind.exc.InvalidFormatException, InvalidFormatException, IOException {
		reqSpec= patient_Actions.buildRequest();
		reqData=patient_Actions.buildInValidRequestData(reqSpec, currentTag, mandatory_details);
		
	}
	
	@When("Dietician sends POST http request with endpoint with invalid mandatory")
	public void dietician_sends_post_http_request_with_endpoint_with_invalid_mandatory() throws com.fasterxml.jackson.databind.exc.InvalidFormatException, IOException {
		response=patient_Actions.createPatient_AllTest(reqSpec, reqData, currentTag);
	}

	@Then("Dietician receives {int} Bad request")
	public void dietician_receives_bad_request(Integer statusCode) {
		API_BaseSetUp_Validations.executeAllMethods(response, statusCode, expecResponseTime, expecContenValue);

	}

	
/*==Scenario: Check dietician able to create patient with valid mandatory fields and invalid data (additional details)==*/
	
	@Given("Dietician creates POST request only by invalid additional details into the form-data key and value fields {string}")
	public void dietician_creates_post_request_only_by_invalid_additional_details_into_the_form_data_key_and_value_fields(String additional_details) throws com.fasterxml.jackson.databind.exc.InvalidFormatException, InvalidFormatException, IOException {
		reqSpec= patient_Actions.buildRequest();
		reqData=patient_Actions.buildInValidRequestData(reqSpec, currentTag, additional_details);
	
	}
	
	@When("Dietician sends POST http request with endpoint with invalid additional")
	public void dietician_sends_post_http_request_with_endpoint_with_invalid_additional() throws com.fasterxml.jackson.databind.exc.InvalidFormatException, IOException {
		response=patient_Actions.createPatient_AllTest(reqSpec, reqData, currentTag);
	}


	/*===========Scenario: Check dietician able to create patient with valid data and invalid method ==========*/
	
	@Given("Dietician creates PUT request by entering valid data into the form-data key and value fields {string}")
	public void dietician_creates_put_request_by_entering_valid_data_into_the_form_data_key_and_value_fields(String invalidHttp) throws com.fasterxml.jackson.databind.exc.InvalidFormatException, InvalidFormatException, IOException {
		reqSpec= patient_Actions.buildRequest();
		reqData=patient_Actions.buildInValidRequestData(reqSpec, currentTag, invalidHttp);
		
	}

	@When("Dietician sends PUT http request with endpoint")
	public void dietician_sends_put_http_request_with_endpoint() throws com.fasterxml.jackson.databind.exc.InvalidFormatException, IOException {
		response=patient_Actions.createPatient_AllTest(reqSpec, reqData, currentTag);
		
	}

	@Then("Dietician receives {int} method not allowed")
	public void dietician_receives_method_not_allowed(Integer statusCode) {
		API_BaseSetUp_Validations.executeAllMethods(response, statusCode, expecResponseTime, expecContenValue);

	}

	
	/*===========Scenario: Check dietician able to create patient with valid data and invalid endpoint ==========*/
	@Given("Dietician creates POST request by entering valid data into the form-data key and value fields {string}")
	public void dietician_creates_post_request_by_entering_valid_data_into_the_form_data_key_and_value_fields(String invalidEndpoint) throws com.fasterxml.jackson.databind.exc.InvalidFormatException, InvalidFormatException, IOException {
		reqSpec= patient_Actions.buildRequest();
		reqData=patient_Actions.buildInValidRequestData(reqSpec, currentTag, invalidEndpoint);
		
	}

	@When("Dietician sends POST http request with invalid endpoint")
	public void dietician_sends_post_http_request_with_invalid_endpoint() throws com.fasterxml.jackson.databind.exc.InvalidFormatException, IOException {
		response=patient_Actions.createPatient_AllTest(reqSpec, reqData, currentTag);
	}

	@Then("Dietician receives {int} not found")
	public void dietician_receives_not_found(Integer statusCode) {
		API_BaseSetUp_Validations.executeAllMethods(response, statusCode, expecResponseTime, expecContenValue);

	}
	
	/*===========Scenario: Get All patients_positive ==========*/	

@Given("Dietician create GET request patient")
public void dietician_create_get_request_patient() throws FileNotFoundException {
    reqSpec= patient_Actions.buildRequest();
}

@When("Dietician send GET http request with endpoint patient")
public void dietician_send_get_http_request_with_endpoint_patient() throws com.fasterxml.jackson.databind.exc.InvalidFormatException, IOException {
	response=patient_Actions.Get_Patient_AllTest(reqSpec, currentTag);
}

@Then("Dietician recieves {int} ok with response body")
public void dietician_recieves_ok_with_response_body(Integer statusCode) {
	API_BaseSetUp_Validations.executeAllMethods(response, statusCode, expecResponseTime, expecContenValue);


}


/*============================Scenario: Get All patients_getAll_adminToken ===========================*/	

@Given("Admin create GET request patient")
public void admin_create_get_request_patient() throws FileNotFoundException {
	reqSpec= patient_Actions.buildRequest();
}

@When("Admin send GET http request with endpoint patient")
public void admin_send_get_http_request_with_endpoint_patient() throws com.fasterxml.jackson.databind.exc.InvalidFormatException, IOException {
	response=patient_Actions.Get_Patient_AllTest(reqSpec, currentTag);
}

@Then("Admin receives {int} Forbidden")
public void admin_receives_forbidden1(Integer statusCode) {
	
	API_BaseSetUp_Validations.executeAllMethods(response, statusCode, expecResponseTime, expecContenValue);

}

/*============================Scenario: Get All patients_getAll_patientToken===========================*/

@Given("Patient create GET request patient")
public void patient_create_get_request_patient() throws FileNotFoundException {
	reqSpec= patient_Actions.buildRequest();
}

@When("Patient send GET http request with endpoint patient")
public void patient_send_get_http_request_with_endpoint_patient() throws com.fasterxml.jackson.databind.exc.InvalidFormatException, IOException {
	response=patient_Actions.Get_Patient_AllTest(reqSpec, currentTag);
}

@Then("Patient receives {int} Forbidden")
public void patient_receives_forbidden1(Integer statusCode) {
	API_BaseSetUp_Validations.executeAllMethods(response, statusCode, expecResponseTime, expecContenValue);

}


/*============================Scenario: Get All patients_getAll_PutReq ===========================*/

@Given("Dietician create PUT request")
public void dietician_create_put_request() throws FileNotFoundException {
	reqSpec= patient_Actions.buildRequest();
}

@When("Dietician send PUT http request with endpoint")
public void dietician_send_put_http_request_with_endpoint() throws com.fasterxml.jackson.databind.exc.InvalidFormatException, IOException {
	response=patient_Actions.Get_Patient_AllTest(reqSpec, currentTag);
}


/*============================Scenario: Get All patients_getAll_invalid endpoint ===========================*/

@Given("Dietician create GET request with invalid endpoint")
public void dietician_create_get_request_with_invalid_endpoint() throws FileNotFoundException {
	reqSpec= patient_Actions.buildRequest();
}

@When("Dietician send GET http request with invalid endpoint")
public void dietician_send_get_http_request_with_invalid_endpoint() throws com.fasterxml.jackson.databind.exc.InvalidFormatException, IOException {
	response=patient_Actions.Get_Patient_AllTest(reqSpec, currentTag);
}

}
