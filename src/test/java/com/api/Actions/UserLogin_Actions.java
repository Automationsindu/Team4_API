package com.api.Actions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

import org.apache.http.entity.ContentType;

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
int statusCode;

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

public Integer loginToGetAuthorized_User(RequestSpecification reqSpec,String currentTag) throws org.apache.poi.openxml4j.exceptions.InvalidFormatException, IOException {
	//readProperties();
	
	String trimmedCurrentTag = currentTag.startsWith("@")? currentTag.substring(1) : currentTag ;
		  List<Map<String, String>> getUserData= (UserExcelReader.getData(EnvConstants.Excelpath, "Dietician_data"));
		 Map<String, String> rowdata =getUserData.stream().filter(row -> row.get("scenario").equals(trimmedCurrentTag)).findFirst()
				 .orElseThrow(() -> new RuntimeException("No matching data found for tag: " + trimmedCurrentTag));
		 
		 String password= rowdata.get("password");
		String userLoginEmail= rowdata.get("userLoginEmail");
		String scenario = rowdata.get("scenario");
		System.out.println("scenario from excel :"+scenario);

		 // Construct JSON payload using Gson
	    JsonObject json = new JsonObject();
	    json.addProperty("password", password);
	    json.addProperty("userLoginEmail", userLoginEmail);

	    Gson gson = new Gson();
	    requestBody = gson.toJson(json);
	   
	    // sending request
	    switch(trimmedCurrentTag) {
	    case "LoginPositive1":
	    	response = restUtil.create(reqSpec,requestBody, EnvConstants.login_Endpoint);
	    	break;
	    
	    case "LoginInvalidCredential2":
	    	response = restUtil.create(reqSpec,requestBody, EnvConstants.login_Endpoint);
	    	break;
	    case "LoginInvalidMethod3":
	    	response = restUtil.get(reqSpec,requestBody, EnvConstants.login_Endpoint);
	    	
	    case "LoginInvalidEndpoint4":
	    	response = restUtil.create(reqSpec,requestBody, EnvConstants.Invalidlogin_Endpoint);
	    	break;
	    case "LoginInvalidContentType5":
	    	RequestSpecification defaultSpec = restUtil.getRequestSpec();
	    	RequestSpecification textspec = defaultSpec.contentType(io.restassured.http.ContentType.TEXT);
	    	response = restUtil.create(textspec,requestBody, EnvConstants.login_Endpoint);
	    	break;
	    	default :
	    		throw new RuntimeException("no matching tag :" +trimmedCurrentTag);
	    }
	    
	    statusCode =response.getStatusCode();
	    
		    if (response.getStatusCode() == 200) {
		    	System.out.println("Valid Login Successful :"+response.getStatusCode());
		    	String token= restUtil.extractStringFromResponse(response, "token");
		    	System.out.println("The token from the response is "+ token);
		    	EnvVariables.token=token;
		    	System.out.println("The token stored in EnvVariables.token is "+ EnvVariables.token);
		    	
		    }else {
                System.out.println("Valid Login Failed with status code: " + response.getStatusCode());
            }
	    
		 return statusCode;
		
}
		 
/*===========================verifying login response code =====================================================*/
public void loginResponseCode(Integer statusCode,RequestSpecification reqSpec,String currentTag) throws org.apache.poi.openxml4j.exceptions.InvalidFormatException, IOException  {
	
	        if (statusCode == 200) {
	        	System.out.println("Received 200 OK response.");
	        } else if (statusCode == 401) {
	        	   System.out.println("Received 401 Unauthorized response.");
	        }
	        else if (statusCode == 405) {
	        	   System.out.println("User recieves 405 method not allowed");
	        }
	        else if (statusCode == 415) {
	        	System.out.println("User recieves 415 unsupported media type");
	        }
	        else if(statusCode == 400) {
	        	System.out.println("User received Status 400 – Bad Request");
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
