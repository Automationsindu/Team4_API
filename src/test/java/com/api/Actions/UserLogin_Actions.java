package com.api.Actions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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

/*=================================reading credentials from Excel file ======================================*/

public void readExcel() throws InvalidFormatException, IOException {

	try {
List<Map<String, String>> getUserData= (UserExcelReader.getData(EnvConstants.Excelpath, "Dietician_data"));
for (Map<String, String> row : getUserData){
	String password= row.get("password");	
	String userLoginEmail= row.get("userLoginEmail");
	 // Construct JSON payload using Gson
    JsonObject json = new JsonObject();
    json.addProperty("password", password);
    json.addProperty("userLoginEmail", userLoginEmail);

    Gson gson = new Gson();
    requestBody = gson.toJson(json);
	
}
}
	catch (IOException | org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
        e.printStackTrace(); // Print the exception stack trace for debugging
    }
}
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
 	

/*============================post request to create auth token===============================================*/

public Response loginToGetAuthorized_User(RequestSpecification reqSpec) throws InvalidFormatException, IOException {
	//readProperties();
	readExcel();
	System.out.println("Login request Body is : "+requestBody);
	Response response = restUtil.create(reqSpec,requestBody, EnvConstants.login_Endpoint);
	
	return response;
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
