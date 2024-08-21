package com.api.Actions;

import java.io.FileNotFoundException;

import com.api.ReusableUtils.Reusable_CRUD_Operations;

import io.restassured.specification.RequestSpecification;

public class Dietician_Put_Delete_Actions {
	
	
	Reusable_CRUD_Operations restUtil= new Reusable_CRUD_Operations();
	private String requestBody = "";
	String token;
	
	/*=================================Building request specification======================================*/
	
	public RequestSpecification buildRequest() throws FileNotFoundException
	{
		RequestSpecification reqSpec;
		reqSpec = restUtil.getRequestSpec();
		return reqSpec;
	}
	 	

}
