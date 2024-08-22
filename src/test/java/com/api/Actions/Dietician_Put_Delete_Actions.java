package com.api.Actions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


import com.api.EnvVariables.EnvConstants;
import com.api.EnvVariables.EnvVariables;
import com.api.ReusableUtils.Reusable_CRUD_Operations;
import com.api.ReusableUtils.UserExcelReader;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class Dietician_Put_Delete_Actions {
	
	
	Reusable_CRUD_Operations restUtil = new Reusable_CRUD_Operations();
	private String requestBody = "";
	Response response;
	String token;
	String ContactNumber;
	String DateOfBirth;
	String Education;
	String Email;
	String Firstname;
	String HospitalCity;
	String HospitalName;
	String HospitalPincode;
	String HospitalStreet;
	String Lastname;
	
	/*=================================Building request specification======================================*/
	
	public RequestSpecification buildRequest() throws FileNotFoundException
	{
		RequestSpecification reqSpec;
		reqSpec = restUtil.getRequestSpec();
		return reqSpec;
	}
	
	public static String createJsonPayload(String... keyValuePairs) {
		JsonObject json = new JsonObject();
		for (int i = 0; i < keyValuePairs.length; i += 2) {
			json.addProperty(keyValuePairs[i], keyValuePairs[i + 1]);
		}
		Gson gson = new Gson();
		return gson.toJson(json);
	}

	
	
	/*
	 * ============================put request with valid data with no Auth===============================================
	 */
	public String buildputValidRequestData(RequestSpecification reqSpec)
			throws InvalidFormatException, IOException {
		
		ContactNumber = RandomStringUtils.randomNumeric(10);
		DateOfBirth = (LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70))))).toString();
		Education = RandomStringUtils.randomAlphabetic(10);
		Email = RandomStringUtils.randomAlphanumeric(6) + "@ninja.com";
		Firstname = RandomStringUtils.randomAlphabetic(10);
		HospitalCity = RandomStringUtils.randomAlphabetic(10);
		HospitalName = RandomStringUtils.randomAlphabetic(10);
		HospitalPincode = RandomStringUtils.randomNumeric(6);
		HospitalStreet = RandomStringUtils.randomAlphabetic(10);
		Lastname = RandomStringUtils.randomAlphabetic(10);
		
		requestBody = createJsonPayload("ContactNumber", ContactNumber, "DateOfBirth", DateOfBirth, "Education",
				Education, "Email", Email, "Firstname", Firstname, "HospitalCity", HospitalCity, "HospitalName",
				HospitalName, "HospitalPincode", HospitalPincode, "HospitalStreet", HospitalStreet, "Lastname",
				Lastname);
		
		System.out.println("Login request Body positive is : " + requestBody);
		
		return requestBody;

	}
public void validateRequest(Response response) {
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		
		System.out.println("Login json :" + jsonPathEvaluator.get("ContactNumber"));
		
		System.out.println("req json :" + ContactNumber);
		
		assertThat("ContactNumber is not matching", jsonPathEvaluator.get("ContactNumber"), is(ContactNumber));
		
		//Assert.assertEquals(jsonPathEvaluator.get("ContactNumber"), ContactNumber, "Correct ContactNumber received in the Response");
	
	}
	
	public Response updateDietician(RequestSpecification reqSpec, String requestData, String currentTag)
			throws InvalidFormatException, IOException {

		
		String trimmedCurrentTag = currentTag.startsWith("@")? currentTag.substring(1) : currentTag ;
		
		System.out.println("trimmedCurrentTag is : " + trimmedCurrentTag);
		 
		    // sending request
		
		    switch(trimmedCurrentTag) {
		    case "update_dietician_positive":
		    	response = restUtil.create(reqSpec, EnvVariables.token, requestBody,
						EnvConstants.updateDietician_Endpoint);
		    	break;
		    
		    case "update_dietician_invalidData":
		    	response = restUtil.create(reqSpec, EnvVariables.token, requestBody,
						EnvConstants.updateDietician_Endpoint);
		    	break;
		    case "update_dietician_invalidMethod":
		    	response = restUtil.put(reqSpec, EnvVariables.token, requestBody,
						EnvConstants.updateDietician_Endpoint);
		  
		    	break;
		    	
		    case "update_dietician_invalidEndpoint":
		    	response = restUtil.create(reqSpec, EnvVariables.token, requestBody,
						EnvConstants.updateDietician_Endpoint);
		    	break;
		    case "update_dietician_invalidContentType":
		    	//RequestSpecification defaultSpec = restUtil.getRequestSpec();
		    	
		    	RequestSpecification textspec = reqSpec.contentType(io.restassured.http.ContentType.TEXT);
		    	response = restUtil.create(textspec, EnvVariables.token, requestBody,
						EnvConstants.updateDietician_Endpoint);
		    	break;
		    	default :
		    		throw new RuntimeException("no matching tag :" +trimmedCurrentTag);
		    }
		    
		    //System.out.println("out switch case "+response.asPrettyString());
		 
		return response;
	}

	public Response UpdateDietician(RequestSpecification reqSpec, String requestData, String currentTag) {
		// TODO Auto-generated method stub
		return null;
	}
}
