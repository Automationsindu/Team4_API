package com.api.ReusableUtils;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import com.api.EnvVariables.EnvConstants;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Reusable_CRUD_Operations {
	
	
	
	/* ==============================    Request Specification builder     ============================ */
public RequestSpecification getRequestSpec() throws FileNotFoundException
{
	RestAssured.baseURI=  EnvConstants.qaEnvironmentbaseURI;
	PrintStream log= new PrintStream(new FileOutputStream("RestAPIHackathonLogs.txt"));
	
	RequestSpecification req= RestAssured.given().auth().none()
							  .filter(RequestLoggingFilter.logRequestTo(log)).filter(ResponseLoggingFilter.logResponseTo(log))
							  .contentType(ContentType.JSON);;
	return req;
}



/* ==============================Reusable code for POST request without endpoint ============================ */
public Response create(RequestSpecification reqSpec,String requestBody, String endPoint) {
	Response response = reqSpec.body(requestBody).when().post(endPoint);
	
	  // Log response details
      System.out.println(response.getBody().asPrettyString());
	return response;
} 

/* ==============================Reusable code for POST request with bearer token ============================ */
public Response create(RequestSpecification reqSpec, String token, String requestBody, String endPoint) {
	Response response = reqSpec.header("Authorization","Bearer "+ token)
			.body(requestBody).when().post(endPoint);
	
	return response;
}

/* =====================Reusable code for extracting particular given string value from response================ */

public String extractStringFromResponse(Response response, String responseString)
{
	//System.out.println(response.asPrettyString());
	String expecString= response.jsonPath().getString((responseString).trim());
	return expecString;
	
}
}