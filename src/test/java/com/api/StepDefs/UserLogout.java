package com.api.StepDefs;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.api.ReusableUtils.API_BaseSetUp_Validations;

import java.io.FileNotFoundException;

import com.api.Actions.UserLogout_Actions;

public class UserLogout {
	UserLogout_Actions logout =new UserLogout_Actions();
	RequestSpecification reqSpec;
	Response response;
	int statusCode;
	long expectedResponseTime;
	String expectedContentType;
	private String currentTag;
	
	@Before
	public void beforeScenario(Scenario scenario) {
		currentTag = scenario.getSourceTagNames().iterator().next();
	}
	
@Given("Admin User creates GET request to logout")
public void admin_user_creates_get_request_to_logout() throws FileNotFoundException {
	reqSpec = logout.buildRequest();
}

@When("The {string} send GET HTTP request with endpoint")
public void the_send_get_http_request_with_endpoint(String string) {

	try {
		response = logout.userLogout(reqSpec,currentTag);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


@Then("Admin User recieves {int} created with Logout successful message")
public void admin_user_recieves_created_with_logout_successful_message(Integer int1) {

	statusCode =response.getStatusCode();
	expectedResponseTime=response.getTime();
	expectedContentType= response.contentType();
	API_BaseSetUp_Validations.executeAllMethods(response,statusCode,expectedResponseTime,expectedContentType);
}

@Given("Admin User creates POST request to logout")
public void admin_user_creates_post_request_to_logout() throws FileNotFoundException {
	reqSpec = logout.buildRequest();
}
@When("The {string} send POST HTTP request with endpoint to logout")
public void the_send_post_http_request_with_endpoint_to_logout(String string) {
	try {
		response = logout.userLogout(reqSpec,currentTag);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


@Then("Admin User recieves {int} method not allowed when logging out")
public void admin_user_recieves_method_not_allowed_when_logging_out(Integer int1) {

	statusCode =response.getStatusCode();
	expectedResponseTime=response.getTime();
	expectedContentType= response.contentType();
	API_BaseSetUp_Validations.executeAllMethods(response,statusCode,expectedResponseTime,expectedContentType);
}

@When("The {string} send GET HTTP request with no Auth and with endpoint")
public void the_send_get_http_request_with_no_auth_and_with_endpoint(String string) {
	try {
		response = logout.userLogout(reqSpec,currentTag);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
@Then("Admin User recieves {int} unauthorized without auth")
public void admin_user_recieves_unauthorized_without_auth(Integer int1) {

	statusCode =response.getStatusCode();
	expectedResponseTime=response.getTime();
	expectedContentType= response.contentType();
	API_BaseSetUp_Validations.executeAllMethods(response,statusCode,expectedResponseTime,expectedContentType);
}

}
