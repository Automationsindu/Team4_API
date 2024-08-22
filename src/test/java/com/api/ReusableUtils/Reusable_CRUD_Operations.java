package com.api.ReusableUtils;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.api.EnvVariables.EnvConstants;
import com.api.EnvVariables.EnvVariables;
import com.google.gson.Gson;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Reusable_CRUD_Operations {
	
	ExcelUtils excelUtils= new ExcelUtils();
	 private static final Random random = new Random();
	
	
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


/* =====================Reusable code for extracting particular given string value from response================ */

public String extractStringFromResponse(Response response, String responseString)
{
	//System.out.println(response.asPrettyString());
	String expecString= response.jsonPath().getString((responseString).trim());
	return expecString;
	
}




/* Reusable code for HTTP_POST_REQUEST with auth-token */

public Response create(RequestSpecification reqSpec, String authToken ,String requestBody, String endPoint) {
	Response response = reqSpec.header("Authorization","Bearer "+authToken)
			.body(requestBody).when().log().all().post(endPoint);
	return response;
}

/* =====================Reading excel and creating payload from excel by Gson================ */

public Response readExcel_create(RequestSpecification reqSpec, String authToken, String endPoint, String filePath, String sheetName) throws IOException, InvalidFormatException {
    // Read Excel Data
    //List<Map<String, String>> excelDataList = excelUtils.getExcelData(filePath, sheetName);
	 List<Map<String, String>> excelDataList = excelUtils.getData(filePath, sheetName);

    // For each row in the Excel data, convert it to JSON and send a request
    Gson gson = new Gson();
    Response response = null;

    for (Map<String, String> excelData : excelDataList) {
        // Convert each row map to JSON
        String jsonPayload = gson.toJson(excelData);
        System.out.println("file path is " + filePath);
        System.out.println("jsonPayload is " + jsonPayload);
        create(reqSpec, authToken, jsonPayload,endPoint );

        // Log the response
        System.out.println(response.getBody().asPrettyString());
    }

    // Return the last response or handle differently if needed
    return response;
}


/* ==============================code for GET request as Invalid Method request  ============================ */
public Response get(RequestSpecification reqSpec,String requestBody, String endPoint) {
	Response response = reqSpec.body(requestBody).when().get(endPoint);
	
	  // Log response details
      System.out.println(response.getBody().asPrettyString());
	return response;
} 

/* ==============================Reusable code for GET request with bearer token============================ */
public Response retrieve(RequestSpecification reqSpec, String token, String endPoint) {
	Response response = reqSpec.header("Authorization","Bearer "+ token)
			.when().get(endPoint);
	
	return response;
}
/* ==============================Reusable code for GET request with no token============================ */
public Response retrieve(RequestSpecification reqSpec, String endPoint) {
	Response response = reqSpec.when().get(endPoint);
	
	return response;
}


/* ==============================extract multiple strings from the response============================ */

//New method to extract multiple strings from the response
public List<String> extractMultipleStringsFromResponse(Response response, String... responseStrings) {
    List<String> values = new ArrayList<String>();
    for (String responseString : responseStrings) {
        String value = response.jsonPath().getString(responseString.trim());
        values.add(value);
    }
    return values;
}

/* ==============================create multipart/formData============================ */


public Response createMultipart(String authToken, File report, String endPoint, String jsonPayload1, String jsonKey, String fileKey) {
    // Initial request setup
    RequestSpecification reqSpec = RestAssured.given()
        .header("Authorization", "Bearer " + authToken)
        .contentType("multipart/form-data");


    // Reinitialize or modify multipart details before sending
    reqSpec = reqSpec
        .multiPart(fileKey, report, "application/pdf")  // File upload
        .multiPart(jsonKey, jsonPayload1, "application/json");  // JSON payload

    // Send the request
    Response response = reqSpec.when().log().all().post(endPoint);  // Log the entire request
        

    // Log the response details
   // System.out.println("Response Status Code: " + response.getStatusCode());
    System.out.println("Response Body: " + response.getBody().asPrettyString());

    return response;
}


/* ==============================create multipart/formData without report============================ */
public Response createMultipart_2(String authToken, String endPoint, String jsonPayload, String jsonKey) {
    // Initial request setup
    RequestSpecification reqSpec = RestAssured.given()
        .header("Authorization", "Bearer " + authToken)
        .contentType("multipart/form-data");
    
    // Send the multipart request with only the JSON payload
    Response response = reqSpec
        .multiPart(jsonKey, jsonPayload, "application/json")
        .when().post(endPoint);

    // Log the response
    System.out.println("Response: " + response.getBody().asPrettyString());

    // Return the response
    return response;
}

/* =====================Reading excel and creating payload from excel by Gson================ */

public Response readExcel_createPatient(String filePath, String sheetName, RequestSpecification reqSpec,String authToken,File report,String endPoint,  String jsonKey, String fileKey, String patientId ) throws IOException, InvalidFormatException {
   
	List<Map<String, String>> excelDataList = excelUtils.getData(filePath, sheetName);
	Response response = null;
	int size = excelDataList.size();
	System.out.println("Size of excelDataList: " + size);
	Gson gson;

	// Variable to store the last generated JSON payload
	String jsonPayload = null;

	// Iterate over each row and generate JSON payloads
	// Process each row in Excel using standard for loop
	for (int i = 0; i < excelDataList.size(); i++) {
		gson = new Gson();
		Map<String, String> excelData = new HashMap<>(excelDataList.get(i));
		// Generate dynamic values for DOB and Phone Number
		String dob = generateRandomDOB();
		String phoneNumber = generateRandomPhoneNumber();

		// Update the data map with dynamic values
		excelData.put("DateOfBirth", dob);
		excelData.put("ContactNumber", phoneNumber);

		// Convert the updated map to JSON
		jsonPayload = gson.toJson(excelData);

		
		response = createMultipart(authToken, report, endPoint, jsonPayload, "patientInfo", "file");
		JsonPath jsPath= new JsonPath(response.asString());
		String extractedPatientId = jsPath.getString("patientId");

		// Check if EnvVariables.patientId_Delete is empty or null
		if (EnvVariables.patientId_Delete == null || EnvVariables.patientId_Delete.isEmpty()) {
		    // Store the patientId only if the variable is empty or null
		    EnvVariables.patientId_Delete = extractedPatientId;
		    System.out.println("patientId_Delete is " + EnvVariables.patientId_Delete);
		} else {
		    System.out.println("patientId_Delete is already set and is not empty: " + EnvVariables.patientId_Delete);
		}

	}

	// Return the last generated JSON payload
	return response;
}

/* =====================================constructing random DOB======================================= */
private String generateRandomDOB() {
    int year = random.nextInt(50) + 1970; // Between 1970 and 2020
    int month = random.nextInt(12) + 1;   // Between 1 and 12
    int day = random.nextInt(28) + 1;     // Between 1 and 28 (to avoid issues with months)
    return String.format("%04d-%02d-%02d", year, month, day); // Format YYYY-MM-DD
}


/* ====================================constructing random Phone number==================================== */
// Method to generate a random phone number
public static String generateRandomPhoneNumber() {
    // Generate a random number between 1000000000 (inclusive) and 10000000000 (exclusive)
    long number = 1000000000L + random.nextLong(9000000000L);
    return Long.toString(number);
}

/* ==============================Reusable code for POST request with endpoint ============================ */
public Response create_withNoAuth(RequestSpecification reqSpec,String requestBody, String endPoint) {
	Response response = reqSpec.body(requestBody).when().post(endPoint);

	return response;
}


/*/* =====================Reading excel and creating payload from excel by Gson================ */

public String readExcel_create_withMandatory(RequestSpecification reqSpec, String authToken, String endPoint, String filePath, String sheetName) throws IOException, InvalidFormatException {
    // Read Excel Data
    //List<Map<String, String>> excelDataList = excelUtils.getExcelData(filePath, sheetName);
	 List<Map<String, String>> excelDataList = excelUtils.getData(filePath, sheetName);

    // For each row in the Excel data, convert it to JSON and send a request
    Gson gson = new Gson();
    Response response = null;
    String jsonPayload = null;

     Map<String, String> excelData = excelDataList.get(0);
        // Convert each row map to JSON
    String dob = generateRandomDOB();
	String phoneNumber = generateRandomPhoneNumber();
	
	excelData.put("DateOfBirth", dob);
	excelData.put("ContactNumber", phoneNumber);

         jsonPayload = gson.toJson(excelData);
         System.out.println("jsonPayload is "+ jsonPayload );
        
    

	// Return the last response or handle differently if needed
    return jsonPayload;
}


/* ==============================code for PUT request with bearer token as Invalid Method request============================ */
public Response put(RequestSpecification reqSpec, String token, String requestBody, String endPoint) {
	
	Response response = reqSpec.header("Authorization","Bearer "+ token)
			.body(requestBody).when().put(endPoint);
	
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


/*============== Reusable code for HTTP_GET_REQUEST with noAuthtoken ==========================*/

public Response getAllNoAuth(RequestSpecification reqSpec, String endPoint) {
	Response response = reqSpec.when().get(endPoint);
	return response;
}

/* ==============================Get_code for PUT request with bearer token as Invalid Method request============================ */
public Response get_put(RequestSpecification reqSpec, String token, String endPoint) {
	
	Response response = reqSpec.header("Authorization","Bearer "+ token).
			when().put(endPoint);
	
	return response;
}

}