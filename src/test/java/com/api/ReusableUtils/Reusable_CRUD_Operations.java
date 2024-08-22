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
							  .contentType(ContentType.JSON);
	return req;
}

/* ==============================Reusable code for POST request with endpoint ============================ */
public Response create(RequestSpecification reqSpec,String requestBody, String endPoint) {
	Response response = reqSpec.body(requestBody).when().post(endPoint);
	
	  // Log response details
      System.out.println(response.getBody().asPrettyString());
	return response;
}
/* ==============================code for GET request as Invalid Method request  ============================ */
public Response get(RequestSpecification reqSpec, String endPoint) {
	Response response = reqSpec.when().get(endPoint);
	
	  // Log response details
      System.out.println(response.getBody().asPrettyString());
	return response;
} 
/* ==============================code for POST request as Invalid Method request  ============================ */
public Response postLogout(RequestSpecification reqSpec,String token, String endPoint) {
	Response response = reqSpec.when().post(endPoint);
	
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
/* ==============================Reusable code for GET request with bearer token============================ */
public Response retrieve(RequestSpecification reqSpec, String token, String endPoint) {
	Response response = reqSpec.header("Authorization","Bearer "+ token)
			.when().get(endPoint);
	 System.out.println(response.getBody().asPrettyString());
	return response;
}
/* ==============================Reusable code for GET request with no token============================ */
public Response retrieve(RequestSpecification reqSpec, String endPoint) {
	Response response = reqSpec.when().get(endPoint);
	 System.out.println(response.getBody().asPrettyString());
	return response;
}
/* ==============================code for POST request with no request body as Invalid Method request============================ */
public Response post(RequestSpecification reqSpec, String token, String endPoint) {
	Response response = reqSpec.header("Authorization","Bearer "+ token)
			.when().post(endPoint);
	
	return response;
} 
/* ==============================code for PUT request with bearer token as Invalid Method request============================ */
public Response put(RequestSpecification reqSpec, String token, String requestBody, String endPoint) {
	
	Response response = reqSpec.header("Authorization","Bearer "+ token)
			.body(requestBody).when().put(endPoint);
	
	return response;
}
/* ==============================code for PUT request with no request body as Invalid Method request============================ */
public Response put(RequestSpecification reqSpec,String token,String endPoint) {
	
	Response response = reqSpec.header("Authorization","Bearer "+ token).when().put(endPoint);
	
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