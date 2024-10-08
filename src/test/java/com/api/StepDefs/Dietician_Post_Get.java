package com.api.StepDefs;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.api.Actions.Dietician_Post_Get_Actions;
import com.api.ReusableUtils.API_BaseSetUp_Validations;

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

	@Given("User creates Dietician POST request with valid data")
	public void user_creates_dietician_post_request_with_valid_data() throws InvalidFormatException, IOException {

		reqSpec = actionsDietician.buildRequest();
		requestData = actionsDietician.buildValidRequestData(reqSpec);

	}

	@Given("Admin creates Dietician POST request with valid {string}")
	public void admin_creates_dietician_post_request_with_valid(String data)
			throws InvalidFormatException, IOException {

		reqSpec = actionsDietician.buildRequest();

		requestData = actionsDietician.buildValidRequestData(reqSpec);

		if (data.equalsIgnoreCase("Mandatory_Additional")) {

			requestData = actionsDietician.buildWithAdditionalData(requestData);

		}
	}

	@Given("Admin creates Dietician POST request with {string}")
	public void admin_creates_dietician_post_request_with(String invalidData)
			throws InvalidFormatException, IOException {

		reqSpec = actionsDietician.buildRequest();
		requestData = actionsDietician.buildInValidRequestData(reqSpec, currentTag, invalidData);

	}

	@When("Set admin token and Admin sends Dietician POST http request with endpoint")
	public void set_admin_token_and_admin_sends_dietician_post_http_request_with_endpoint()
			throws InvalidFormatException, IOException {

		response = actionsDietician.createDietician(reqSpec, requestData, currentTag);

	}

	@When("Set admin token and Admin sends Dietician PUT http request with endpoint")
	public void set_admin_token_and_admin_sends_dietician_put_http_request_with_endpoint()
			throws InvalidFormatException, IOException {

		response = actionsDietician.createDietician(reqSpec, requestData, currentTag);

	}

	@When("Set admin token and Admin sends Dietician POST http request with invalid endpoint")
	public void set_admin_token_and_admin_sends_dietician_post_http_request_with_invalid_endpoint()
			throws InvalidFormatException, IOException {

		response = actionsDietician.createDietician(reqSpec, requestData, currentTag);

	}

	@When("Set admin token and Admin send POST http request with valid endpoint and invalid content type")
	public void set_admin_token_and_admin_send_post_http_request_with_valid_endpoint_and_invalid_content_type()
			throws InvalidFormatException, IOException {

		response = actionsDietician.createDietician(reqSpec, requestData, currentTag);

	}

	@When("Admin sends Dietician POST http request with endpoint")
	public void admin_sends_dietician_post_http_request_with_endpoint() throws InvalidFormatException, IOException {

		response = actionsDietician.createDietician(reqSpec, requestData, currentTag);

	}

	@Then("Admin should receive status code {int} created and with response body having auto created {string} dietician ID and login password")
	public void admin_should_receive_status_code_created_and_with_response_body_having_auto_created_dietician_id_and_login_password(
			Integer statusCode, String dieticianCount) {

		actionsDietician.validateDieticianResponse(response, statusCode);
		actionsDietician.storeDieticianInfo(response, dieticianCount);

	}

	@Then("Admin should receive {int} Bad request")
	public void admin_should_receive_bad_request(Integer statusCode) {

		actionsDietician.validateResponse(response, statusCode);

	}

	@Then("Admin should receive {int} {string} for dietician module")
	public void admin_should_receive_for_dietician_module(Integer statusCode, String errorMsg) {

		actionsDietician.validateErrorCodeResponse(response, errorMsg, statusCode);

	}

	@Then("Admin should receive {int} {string} for invalid dietician id")
	public void admin_should_receive_for_invalid_dietician_id(Integer statusCode, String errorMsg) {

		actionsDietician.validateInvalidIDResponse(response, errorMsg, statusCode);

	}

	@Given("User creates GET request to retrieve all dieticians")
	public void user_creates_get_request_to_retrieve_all_dieticians() throws FileNotFoundException {

		reqSpec = actionsDietician.buildRequest();

	}

	@When("Admin sends GET all dieticians http request with endpoint")
	public void admin_sends_get_all_dieticians_http_request_with_endpoint() throws InvalidFormatException, IOException {

		response = actionsDietician.getAllDieticians(reqSpec, currentTag);
	}

	@When("Set admin token and Admin sends GET all dieticians http request with endpoint")
	public void set_admin_token_and_admin_sends_get_all_dieticians_http_request_with_endpoint()
			throws InvalidFormatException, IOException {

		response = actionsDietician.getAllDieticians(reqSpec, currentTag);

	}

	@When("Set admin token and Admin sends PUT all dieticians http request with endpoint")
	public void set_admin_token_and_admin_sends_put_all_dieticians_http_request_with_endpoint()
			throws InvalidFormatException, IOException {

		response = actionsDietician.getAllDieticians(reqSpec, currentTag);

	}

	@When("Set admin token and Admin sends GET all dieticians http request with invalid endpoint")
	public void set_admin_token_and_admin_sends_get_all_dieticians_http_request_with_invalid_endpoint()
			throws InvalidFormatException, IOException {

		response = actionsDietician.getAllDieticians(reqSpec, currentTag);
	}

	@Then("Admin should receive {int} ok with response body")
	public void admin_should_receive_ok_with_response_body(Integer statusCode) {

		actionsDietician.validateGetAllDieticiansResponse(response, statusCode);

	}

	@Then("Admin should receive {int} ok with details of the dietician id")
	public void admin_should_receive_ok_with_details_of_the_dietician_id(Integer statusCode) {

		actionsDietician.validateGetDieticianByIDResponse(response, statusCode);

	}

	@Given("User creates GET request to retrieve dietician by ID")
	public void user_creates_get_request_to_retrieve_dietician_by_id() throws FileNotFoundException {

		reqSpec = actionsDietician.buildRequest();

	}

	@When("Admin sends GET dietician by ID http request with endpoint")
	public void admin_sends_get_dietician_by_id_http_request_with_endpoint()
			throws InvalidFormatException, IOException {

		response = actionsDietician.getDieticianByID(reqSpec, currentTag);

	}

	@When("Set admin token and Admin sends GET dietician by ID http request with endpoint")
	public void set_admin_token_and_admin_sends_get_dietician_by_id_http_request_with_endpoint()
			throws InvalidFormatException, IOException {

		response = actionsDietician.getDieticianByID(reqSpec, currentTag);

	}

	@When("Set admin token and Admin sends POST dietician by ID http request with endpoint")
	public void set_admin_token_and_admin_sends_post_dietician_by_id_http_request_with_endpoint()
			throws InvalidFormatException, IOException {

		response = actionsDietician.getDieticianByID(reqSpec, currentTag);

	}

	@When("Set admin token and Admin sends GET dietician by ID http request with invalid id")
	public void set_admin_token_and_admin_sends_get_dietician_by_id_http_request_with_invalid_id()
			throws InvalidFormatException, IOException {

		response = actionsDietician.getDieticianByID(reqSpec, currentTag);

	}

	@When("Set admin token and Admin sends GET dietician by ID http request with invalid endpoint")
	public void set_admin_token_and_admin_sends_get_dietician_by_id_http_request_with_invalid_endpoint()
			throws InvalidFormatException, IOException {

		response = actionsDietician.getDieticianByID(reqSpec, currentTag);

	}

	@When("Set dietician token and User sends Dietician POST http request with endpoint")
	public void set_dietician_token_and_user_sends_dietician_post_http_request_with_endpoint()
			throws InvalidFormatException, IOException {

		response = actionsDietician.createDietician(reqSpec, requestData, currentTag);

	}

	@Then("User should receive {int} forbidden for dietician module")
	public void user_should_receive_forbidden_for_dietician_module(Integer statusCode) {

		actionsDietician.validateResponse(response, statusCode);

	}

	@When("Set dietician token and User sends GET all dieticians http request with endpoint")
	public void set_dietician_token_and_user_sends_get_all_dieticians_http_request_with_endpoint()
			throws InvalidFormatException, IOException {

		response = actionsDietician.getAllDieticians(reqSpec, currentTag);

	}

	@When("Set dietician token and User sends GET dietician by ID http request with endpoint")
	public void set_dietician_token_and_user_sends_get_dietician_by_id_http_request_with_endpoint()
			throws InvalidFormatException, IOException {

		response = actionsDietician.getDieticianByID(reqSpec, currentTag);

	}

	@When("Set patient token and User sends Dietician POST http request with endpoint")
	public void set_patient_token_and_user_sends_dietician_post_http_request_with_endpoint()
			throws InvalidFormatException, IOException {

		response = actionsDietician.createDietician(reqSpec, requestData, currentTag);

	}

	@When("Set patient token and User sends GET all dieticians http request with endpoint")
	public void set_patient_token_and_user_sends_get_all_dieticians_http_request_with_endpoint()
			throws InvalidFormatException, IOException {

		response = actionsDietician.getAllDieticians(reqSpec, currentTag);

	}

	@When("Set patient token and User sends GET dietician by ID http request with endpoint")
	public void set_patient_token_and_user_sends_get_dietician_by_id_http_request_with_endpoint()
			throws InvalidFormatException, IOException {

		response = actionsDietician.getDieticianByID(reqSpec, currentTag);

	}

	@Then("User should receive {int} ok with details of the dietician id")
	public void user_should_receive_ok_with_details_of_the_dietician_id(Integer statusCode) {

		actionsDietician.validateGetDieticianByIDResponse(response, statusCode);

	}

	@Then("User should receive {int} ok with response body")
	public void user_should_receive_ok_with_response_body(Integer statusCode) {

		actionsDietician.validateGetAllDieticiansResponse(response, statusCode);

	}

}
