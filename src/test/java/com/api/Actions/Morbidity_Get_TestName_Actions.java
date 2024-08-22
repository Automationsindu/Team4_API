package com.api.Actions;

import java.io.FileNotFoundException;
import com.api.EnvVariables.EnvConstants;
import com.api.EnvVariables.EnvVariables;
import com.api.ReusableUtils.Reusable_CRUD_Operations;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Morbidity_Get_TestName_Actions {
	
	Reusable_CRUD_Operations restUtil= new Reusable_CRUD_Operations();
	Response response;
	public String requestBody = "";
/*=================================Building request specification======================================*/

public RequestSpecification buildRequest() throws FileNotFoundException
{
	RequestSpecification reqSpec;
	reqSpec = restUtil.getRequestSpec();
	return reqSpec;
}

public Response morbidityAdminTokenFastingGlucose(RequestSpecification reqSpec)
{
	String endpoint = EnvConstants.morbidity_Endpoint+"/"+"Fasting Glucose";

	System.out.println("Morbidity TestName is : " + endpoint);
	
    response = restUtil.retrieve(reqSpec, EnvVariables.token, endpoint);
	
	return response;	

}

public Response morbidityAdminTokenInvalidMethod(RequestSpecification reqSpec)
{
	String endpoint = EnvConstants.morbidity_Endpoint+"/"+"Fasting Glucose";

	System.out.println("Morbidity TestName is : " + endpoint);
	
    response = restUtil.post(reqSpec, EnvVariables.token, endpoint);
	
	return response;
}

public Response morbidityAdminTokenInvalidTestName(RequestSpecification reqSpec)
{
	String endpoint = EnvConstants.morbidity_Endpoint+"/"+"Fasting Glucose123";

	System.out.println("Morbidity TestName is : " + endpoint);
    response = restUtil.retrieve(reqSpec, EnvVariables.token, endpoint);
	//System.out.println("The Admin token for Morbidity stored in EnvVariables.token is "+ EnvVariables.token);
	return response;
}

public Response morbidityAdminTokenInvalidEndpoint(RequestSpecification reqSpec)
{
	String endpoint = EnvConstants.Invalid_morbidity_Endpoint+"/"+"Fasting Glucose";

	System.out.println("Morbidity TestName is : " + endpoint);
    response = restUtil.retrieve(reqSpec, EnvVariables.token, endpoint);
	//System.out.println("The Admin token for Morbidity stored in EnvVariables.token is "+ EnvVariables.token);
	return response;
}

public Response GetMorbidityDieticianwithNoAuth(RequestSpecification reqSpec)
{
	String endpoint = EnvConstants.morbidity_Endpoint+"/"+"Plasma Glucose";

	System.out.println("Morbidity TestName is : " + endpoint);
    response = restUtil.retrieve(reqSpec, endpoint);
    System.out.println("The Admin token for Morbidity stored in EnvVariables.token is "+ EnvVariables.token);
	return response;
}

public Response morbidityDieticianTokenTSH(RequestSpecification reqSpec)
{
	String endpoint = EnvConstants.morbidity_Endpoint+"/"+"TSH";

	System.out.println("Morbidity TestName is : " + endpoint);

	System.out.println("EnvVariables.Diet_token : " + EnvVariables.Diet_token);
	
    response = restUtil.retrieve(reqSpec, EnvVariables.Diet_token, endpoint);
	
	return response;	

}

public Response morbidityDieticianTokenInvalidMethod(RequestSpecification reqSpec)
{
	String endpoint = EnvConstants.morbidity_Endpoint+"/"+"T3";

	System.out.println("Morbidity TestName is : " + endpoint);
	
    response = restUtil.post(reqSpec, EnvVariables.Diet_token, endpoint);
	
	return response;
}

public Response morbidityDieticianTokenInvalidEndpoint(RequestSpecification reqSpec)
{
	String endpoint = EnvConstants.Invalid_morbidity_Endpoint+"/"+"T3";

	System.out.println("Morbidity TestName is : " + endpoint);
    response = restUtil.retrieve(reqSpec, EnvVariables.Diet_token, endpoint);
	//System.out.println("The Admin token for Morbidity stored in EnvVariables.token is "+ EnvVariables.token);
	return response;
}

public Response morbidityDieticianTokenInvalidTestName(RequestSpecification reqSpec)
{
	String endpoint = EnvConstants.morbidity_Endpoint+"/"+"T5";

	System.out.println("Morbidity TestName is : " + endpoint);
    response = restUtil.retrieve(reqSpec, EnvVariables.Diet_token, endpoint);
	//System.out.println("The Admin token for Morbidity stored in EnvVariables.token is "+ EnvVariables.token);
	return response;
}

public Response morbidityPatientTestName(RequestSpecification reqSpec)
{
	String endpoint = EnvConstants.morbidity_Endpoint+"/"+"T4";

	System.out.println("Morbidity TestName is : " + endpoint);
    response = restUtil.retrieve(reqSpec, EnvVariables.Patient_token, endpoint);
	System.out.println("The Patient token for Morbidity stored in Patient_token is "+ EnvVariables.Patient_token);
	return response;
}
}
