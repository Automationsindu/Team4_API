package com.api.Actions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.api.EnvVariables.EnvConstants;
import com.api.EnvVariables.EnvVariables;
import com.api.ReusableUtils.Reusable_CRUD_Operations;
import com.api.ReusableUtils.UserExcelReader;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserLogin_Actions {

	Reusable_CRUD_Operations restUtil = new Reusable_CRUD_Operations();
	private String requestBody = "";
	String token;
	Response response;
	int statusCode;
	String diet_Email;
	String diet_Pwd;
	String patient_Email;
	String patient_Pwd;
	

	/*
	 * ================================create json payload======================================
	 */
	public static String createJsonPayload(String... keyValuePairs) {
		JsonObject json = new JsonObject();
		for (int i = 0; i < keyValuePairs.length; i += 2) {
			json.addProperty(keyValuePairs[i], keyValuePairs[i + 1]);
		}
		Gson gson = new Gson();
		return gson.toJson(json);
	}

	/*
	 * =================================Building request
	 * specification======================================
	 */

	public RequestSpecification buildRequest() throws FileNotFoundException {
		RequestSpecification reqSpec;
		reqSpec = restUtil.getRequestSpec();
		return reqSpec;
	}
	
	/*
	 * ============================post request to create auth token from
	 * excel===============================================
	 */

	public Response loginToGetAuthorized_User(RequestSpecification reqSpec, String currentTag) throws InvalidFormatException, IOException
			 {
		String trimmedCurrentTag = currentTag.startsWith("@") ? currentTag.substring(1) : currentTag;
		List<Map<String, String>> getUserData = (UserExcelReader.getData(EnvConstants.Excelpath, "Dietician_data"));
		Map<String, String> rowdata = getUserData.stream().filter(row -> row.get("scenario").equals(trimmedCurrentTag))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("No matching data found for tag: " + trimmedCurrentTag));
		String password = rowdata.get("password");
		String userLoginEmail = rowdata.get("userLoginEmail");
		String scenario = rowdata.get("scenario");
		System.out.println("scenario from excel :" + scenario);
		
		requestBody = createJsonPayload("password", password, "userLoginEmail", userLoginEmail);
		System.out.println("request body :" + requestBody);

		// sending request
		switch (trimmedCurrentTag) {
		case "LoginPositive1":
			response = restUtil.create(reqSpec, requestBody, EnvConstants.login_Endpoint);
			System.out.println("Admin loggedin successfully");
			break;

		case "LoginInvalidCredential2":
			response = restUtil.create(reqSpec, requestBody, EnvConstants.login_Endpoint);
			break;
		case "LoginInvalidMethod3":
			response = restUtil.get(reqSpec, requestBody, EnvConstants.login_Endpoint);

		case "LoginInvalidEndpoint4":
			response = restUtil.create(reqSpec, requestBody, EnvConstants.Invalidlogin_Endpoint);
			break;
		case "LoginInvalidContentType5":
			RequestSpecification defaultSpec = restUtil.getRequestSpec();
			RequestSpecification textspec = defaultSpec.contentType(io.restassured.http.ContentType.TEXT);
			response = restUtil.create(textspec, requestBody, EnvConstants.login_Endpoint);
			break;
		default:
			throw new RuntimeException("no matching tag :" + trimmedCurrentTag);
		}

		if (response.getStatusCode() == 200) {
			String token = restUtil.extractStringFromResponse(response, "token");
			System.out.println("The token from the response is " + token);
			EnvVariables.token = token;
			System.out.println("The token stored in EnvVariables.token is " + EnvVariables.token);

		} else {
			System.out.println("Valid Login Failed with status code: " + response.getStatusCode());
		}

		return response;

	}

	/*
	 * ===========================Dietcian Login
	 * ======================================================================
	 */

	public Response DietLogin(RequestSpecification reqSpec,String currentTag) throws InvalidFormatException, IOException {
		String trimmedCurrentTag = currentTag.startsWith("@") ? currentTag.substring(1) : currentTag;
		List<Map<String, String>> getUserData = (UserExcelReader.getData(EnvConstants.Excelpath, "Dietician_data"));
		Map<String, String> rowdata = getUserData.stream().filter(row -> row.get("scenario").equals(trimmedCurrentTag))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("No matching data found for tag: " + trimmedCurrentTag));
		
		if (trimmedCurrentTag.equals("DieticianLogin1")) {
		
		diet_Email = EnvVariables.dietician1_Email;
		diet_Pwd = EnvVariables.dietician1_loginPassword;
		System.out.println("Dietician loggedin successfully");

		}
		else if(trimmedCurrentTag.equals("DieticianInvalid2")) {
			
			diet_Email = rowdata.get("userLoginEmail");
			diet_Pwd = rowdata.get("password");
		}
		
		// Construct JSON payload using Gson

		requestBody = createJsonPayload("password", diet_Pwd, "userLoginEmail", diet_Email);
		System.out.println("request body : "+requestBody);
		response = restUtil.create(reqSpec, requestBody, EnvConstants.login_Endpoint);

		if (response.getStatusCode() == 200) {
			String token = restUtil.extractStringFromResponse(response, "token");
			System.out.println("The Dietician token from the response is " + token);
			EnvVariables.Diet_token = token;
			System.out.println("The Dietician token stored in EnvVariables.token is " + EnvVariables.Diet_token);

		} else {
			System.out.println("Valid Login Failed with status code: " + response.getStatusCode());
		}
		return response;
	}

	/*
	 * =====================================Patient
	 * Login========================================================
	 */
	public Response PatientLogin(RequestSpecification reqSpec, String currentTag)
			throws InvalidFormatException, IOException {
		
		String trimmedCurrentTag = currentTag.startsWith("@") ? currentTag.substring(1) : currentTag;
		List<Map<String, String>> getUserData = (UserExcelReader.getData(EnvConstants.Excelpath, "Dietician_data"));
		Map<String, String> rowdata = getUserData.stream().filter(row -> row.get("scenario").equals(trimmedCurrentTag))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("No matching data found for tag: " + trimmedCurrentTag));
		if (trimmedCurrentTag.equals("PatientLogin1")){
		patient_Email = EnvVariables.patient1_Email1;
		patient_Pwd = rowdata.get("password");
		System.out.println("Patient loggedin successfully");
		}
		else if(trimmedCurrentTag.equals("PatientInvalidLogin2")) {
			patient_Email = rowdata.get("userLoginEmail");
			patient_Pwd = rowdata.get("password");
			}
		// Construct JSON payload using Gson

		requestBody = createJsonPayload("password", patient_Pwd, "userLoginEmail", patient_Email);
		response = restUtil.create(reqSpec, requestBody, EnvConstants.login_Endpoint);
		statusCode = response.getStatusCode();

		if (response.getStatusCode() == 200) {
			String token = restUtil.extractStringFromResponse(response, "token");
			System.out.println("The Patient token from the response is " + token);
			EnvVariables.Patient_token = token;
			System.out.println("The Patient token stored in EnvVariables.token is " + EnvVariables.Patient_token);

		} else {
			System.out.println("Valid Login Failed with status code: " + response.getStatusCode());
		}
		return response;
	}
}
