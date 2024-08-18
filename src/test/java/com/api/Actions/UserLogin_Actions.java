package com.api.Actions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.api.EnvVariables.EnvConstants;
import com.api.EnvVariables.EnvVariables;
import com.api.ReusableUtils.Reusable_CRUD_Operations;
import com.api.ReusableUtils.UserExcelReader;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserLogin_Actions {
	
Reusable_CRUD_Operations restUtil= new Reusable_CRUD_Operations();
private String requestBody = "";
String token;
Response response;

/*=================================reading credentials from properties file ======================================*/

	public void readProperties()
	{
	Properties prop= new Properties();
	InputStream input=null;
	
	
	try {
		//input= new FileInputStream("config.properties");
		  input = getClass().getClassLoader().getResourceAsStream("Configs/config.properties");
		  if (input == null) {
              System.out.println("Sorry, unable to find Configs/config.properties");
              return;
		  }
		prop.load(input);
		String password= prop.getProperty("password");
		String userLoginEmail= prop.getProperty("userLoginEmail");
		
		//System.out.println("password is"+ password);
		//System.out.println("userLoginEmail is"+ userLoginEmail);
		
		 // Construct JSON payload using Gson
        JsonObject json = new JsonObject();
        json.addProperty("password", password);
        json.addProperty("userLoginEmail", userLoginEmail);

        Gson gson = new Gson();
        requestBody = gson.toJson(json);
		
		
	}
	catch(IOException ex)
	{
		ex.printStackTrace();
	}
	finally
	{
		 if (input != null) {
             try {
                 input.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
	}
}
	
/*=================================Building request specification======================================*/
	
public RequestSpecification buildRequest() throws FileNotFoundException
{
	RequestSpecification reqSpec;
	reqSpec = restUtil.getRequestSpec();
	return reqSpec;
}
 	

/*============================post request to create auth token from excel===============================================*/

public List<Integer> loginToGetAuthorized_User(RequestSpecification reqSpec) throws InvalidFormatException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
	//readProperties();
	
		  List<Map<String, String>> getUserData= (UserExcelReader.getData(EnvConstants.Excelpath, "Dietician_data"));
		  int rowCount = getUserData.size();
		  System.out.println("Total rows: " + rowCount);
		  List<Integer> statusCodes = new ArrayList<>();
		  for (Map<String, String> row : getUserData){
			  
			 String scenario = row.get("scenario");
			String password= row.get("password");	
			String userLoginEmail= row.get("userLoginEmail");
			System.out.println("scenario from excel :"+scenario);
			
			 // Construct JSON payload using Gson
		    JsonObject json = new JsonObject();
		    json.addProperty("password", password);
		    json.addProperty("userLoginEmail", userLoginEmail);

		    Gson gson = new Gson();
		    requestBody = gson.toJson(json);
		    System.out.println("Login request Body is : "+requestBody);
		    // sending request
			response = restUtil.create(reqSpec,requestBody, EnvConstants.login_Endpoint);
			int code =response.getStatusCode();
			statusCodes.add(code);
			
			 if ("Login1".equals(scenario)) {
				    if (response.getStatusCode() == 200) {
				    	System.out.println("Valid Login Successful :"+response.getStatusCode());
				    	String token= restUtil.extractStringFromResponse(response, "token");
				    	System.out.println("The token from the response is "+ token);
				    	EnvVariables.token=token;
				    	System.out.println("The token stored in EnvVariables.token is "+ EnvVariables.token);
				    	
				    }else {
	                    System.out.println("Valid Login Failed with status code: " + response.getStatusCode());
	                }
			 }
			 else if("Login2".equals(scenario)) {
				 if (response.getStatusCode() == 401) {
	                    System.out.println("Unauthorized login :" +response.getStatusCode());
	                } else {
	                    System.out.println("Unauthorized login with status code: " + response.getStatusCode());
	                }
	            }
		  }
		 return statusCodes;
			 }
/*===========================verifying login response code =====================================================*/
public void loginResponseCode(RequestSpecification reqSpec) throws InvalidFormatException, org.apache.poi.openxml4j.exceptions.InvalidFormatException, IOException {
	 List<Integer> statusCodes = loginToGetAuthorized_User(reqSpec);
	 for (int statusCode : statusCodes) {
	        if (statusCode == 200) {
	        	System.out.println("Received 200 OK response.");
	        } else if (statusCode == 401) {
	        	   System.out.println("Received 401 Unauthorized response.");
	        }
}
}
		



/*===========================Storing the auth token in Env variables==============================================*/

public void storeAuthToken(Response response)
{
	//System.out.println("response sending from actions "+response.asPrettyString());
	String token= restUtil.extractStringFromResponse(response, "token");
	if (token != null && !token.isEmpty()) {
	System.out.println("The token from the response is "+ token);
	EnvVariables.token=token;
	System.out.println("The token stored in EnvVariables.token is "+ EnvVariables.token);
}else {
	 System.out.println("No token found in the response.");
}
}
}
