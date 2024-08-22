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
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Dietician_Post_Get_Actions {

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
	String Middlename;
	String SecondaryContact;

	// Building request specification

	public RequestSpecification buildRequest() throws FileNotFoundException {
		RequestSpecification reqSpec;
		reqSpec = restUtil.getRequestSpec();
		return reqSpec;
	}

	// Converting request body into json format

	public static String createJsonPayload(String... keyValuePairs) {
		JsonObject json = new JsonObject();
		for (int i = 0; i < keyValuePairs.length; i += 2) {
			json.addProperty(keyValuePairs[i], keyValuePairs[i + 1]);
		}
		Gson gson = new Gson();
		return gson.toJson(json);
	}

	// Building valid request body to create a dietician with mandatory data

	public String buildValidRequestData(RequestSpecification reqSpec) throws InvalidFormatException, IOException {

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

		return requestBody;

	}

	// Building valid request body to create a dietician with mandatory and
	// additional data

	public String buildWithAdditionalData(String requestBody) throws InvalidFormatException, IOException {

		Middlename = RandomStringUtils.randomAlphabetic(8);
		SecondaryContact = RandomStringUtils.randomNumeric(10);

		requestBody = createJsonPayload("ContactNumber", ContactNumber, "DateOfBirth", DateOfBirth, "Education",
				Education, "Email", Email, "Firstname", Firstname, "HospitalCity", HospitalCity, "HospitalName",
				HospitalName, "HospitalPincode", HospitalPincode, "HospitalStreet", HospitalStreet, "Lastname",
				Lastname, "Middlename", Middlename, "SecondaryContact", SecondaryContact);

		return requestBody;

	}

	// Building invalid request body to create a dietician

	public String buildInValidRequestData(RequestSpecification reqSpec, String currentTag, String invalidData)
			throws InvalidFormatException, IOException {

		String trimmedCurrentTag = currentTag.startsWith("@") ? currentTag.substring(1) : currentTag;

		System.out.println("trimmedCurrentTag is : " + trimmedCurrentTag);

		List<Map<String, String>> getUserData = (UserExcelReader.getData(EnvConstants.Excelpath, "Dietician_Create"));
		Map<String, String> rowdata = getUserData.stream().filter(row -> row.get("Invalid_Data").equals(invalidData))
				.findFirst().orElseThrow(() -> new RuntimeException("No matching data found for tag: " + invalidData));

		if (trimmedCurrentTag.equalsIgnoreCase("create_dietician_invalidData")) {

			ContactNumber = rowdata.get("ContactNumber");
			DateOfBirth = rowdata.get("DateOfBirth");
			Education = rowdata.get("Education");
			Email = rowdata.get("Email");
			Firstname = rowdata.get("Firstname");
			HospitalCity = rowdata.get("HospitalCity");
			HospitalName = rowdata.get("HospitalName");
			HospitalPincode = rowdata.get("HospitalPincode");
			HospitalStreet = rowdata.get("HospitalStreet");
			Lastname = rowdata.get("Lastname");

			requestBody = createJsonPayload("ContactNumber", ContactNumber, "DateOfBirth", DateOfBirth, "Education",
					Education, "Email", Email, "Firstname", Firstname, "HospitalCity", HospitalCity, "HospitalName",
					HospitalName, "HospitalPincode", HospitalPincode, "HospitalStreet", HospitalStreet, "Lastname",
					Lastname);

		} else if (trimmedCurrentTag.equalsIgnoreCase("create_dietician_AdditionalData")) {
			Middlename = rowdata.get("Middlename");
			SecondaryContact = rowdata.get("SecondaryContact");

			requestBody = createJsonPayload("Middlename", Middlename, "SecondaryContact", SecondaryContact);

		}
		return requestBody;

	}

	// Sending post request to create a dietician

	public Response createDietician(RequestSpecification reqSpec, String requestData, String currentTag)
			throws InvalidFormatException, IOException {

		String trimmedCurrentTag = currentTag.startsWith("@") ? currentTag.substring(1) : currentTag;

		System.out.println("trimmedCurrentTag is : " + trimmedCurrentTag);

		switch (trimmedCurrentTag) {
		case "create_dietician_positive":
			response = restUtil.create(reqSpec, EnvVariables.token, requestBody, EnvConstants.createDietician_Endpoint);
			break;
		case "create_dietician_AdditionalData":
			response = restUtil.create(reqSpec, EnvVariables.token, requestBody, EnvConstants.createDietician_Endpoint);
			break;

		case "create_dietician_invalidData":
			response = restUtil.create(reqSpec, EnvVariables.token, requestBody, EnvConstants.createDietician_Endpoint);
			break;
		case "create_dietician_invalidMethod":
			response = restUtil.put(reqSpec, EnvVariables.token, requestBody, EnvConstants.createDietician_Endpoint);
			break;

		case "create_dietician_no_auth":
			response = restUtil.create(reqSpec, requestBody, EnvConstants.createDietician_Endpoint);
			break;
		case "create_dietician_invalidContentType":

			RequestSpecification textspec = reqSpec.contentType(io.restassured.http.ContentType.TEXT);
			response = restUtil.create(textspec, EnvVariables.token, requestBody,
					EnvConstants.createDietician_Endpoint);
			break;
		case "create_dietician_invalidEndpoint":
			response = restUtil.create(reqSpec, EnvVariables.token, requestBody,
					EnvConstants.Invalid_createDietician_Endpoint);
			break;
		case "create_dietician_with_dietician_token":
			response = restUtil.create(reqSpec, EnvVariables.Diet_token, requestBody,
					EnvConstants.createDietician_Endpoint);
			break;
		case "create_dietician_with_patient_token":
			response = restUtil.create(reqSpec, EnvVariables.Patient_token, requestBody,
					EnvConstants.createDietician_Endpoint);
			break;
		default:
			throw new RuntimeException("no matching tag :" + trimmedCurrentTag);
		}
		System.out.println("out switch case " + response.asPrettyString());
		return response;
	}

	// Sending get request to retrieve all dieticians

	public Response getAllDieticians(RequestSpecification reqSpec, String currentTag)
			throws InvalidFormatException, IOException {

		String trimmedCurrentTag = currentTag.startsWith("@") ? currentTag.substring(1) : currentTag;

		System.out.println("trimmedCurrentTag is : " + trimmedCurrentTag);

		// sending request

		switch (trimmedCurrentTag) {
		case "get_all_dieticians_no_auth":
			response = restUtil.retrieve(reqSpec, EnvConstants.createDietician_Endpoint);
			break;

		case "get_all_dieticians_positive":
			response = restUtil.retrieve(reqSpec, EnvVariables.token, EnvConstants.createDietician_Endpoint);
			break;
		case "get_all_dieticians_invalidMethod":
			response = restUtil.put(reqSpec, EnvVariables.token, EnvConstants.createDietician_Endpoint);
			break;

		case "get_all_dieticians_invalidEndpoint":
			response = restUtil.retrieve(reqSpec, EnvVariables.token, EnvConstants.Invalid_createDietician_Endpoint);
			break;
		case "get_all_dieticians_with_dietician_token":
			response = restUtil.retrieve(reqSpec, EnvVariables.Diet_token, EnvConstants.createDietician_Endpoint);
			break;
		case "get_all_dieticians_with_patient_token":
			response = restUtil.retrieve(reqSpec, EnvVariables.Patient_token, EnvConstants.createDietician_Endpoint);
			break;

		default:
			throw new RuntimeException("no matching tag :" + trimmedCurrentTag);
		}

		return response;
	}

	// Sending get request to retrieve dietician by ID

	public Response getDieticianByID(RequestSpecification reqSpec, String currentTag)
			throws InvalidFormatException, IOException {

		String trimmedCurrentTag = currentTag.startsWith("@") ? currentTag.substring(1) : currentTag;

		System.out.println("trimmedCurrentTag is : " + trimmedCurrentTag);

		String endpoint = EnvConstants.createDietician_Endpoint + "/" + EnvVariables.dietician1_ID;

		// sending request

		switch (trimmedCurrentTag) {
		case "get_dietician_ID_no_auth":
			response = restUtil.retrieve(reqSpec, endpoint);
			break;

		case "get_dietician_ID_positive":
			response = restUtil.retrieve(reqSpec, EnvVariables.token, endpoint);
			break;
		case "get_dietician_ID_invalidMethod":
			response = restUtil.post(reqSpec, EnvVariables.token, endpoint);
			break;

		case "get_dietician_ID_invalidID":
			response = restUtil.retrieve(reqSpec, EnvVariables.token,
					EnvConstants.createDietician_Endpoint + "/" + "12000");
			break;

		case "get_dietician_ID_invalidEndpoint":
			response = restUtil.retrieve(reqSpec, EnvVariables.token,
					EnvConstants.Invalid_createDietician_Endpoint + "/" + EnvVariables.dietician1_ID);
			break;

		case "get_dietician_ID_with_dietician_token":
			response = restUtil.retrieve(reqSpec, EnvVariables.Diet_token, endpoint);
			break;

		case "get_dietician_ID_with_patient_token":
			response = restUtil.retrieve(reqSpec, EnvVariables.Patient_token, endpoint);
			break;

		default:
			throw new RuntimeException("no matching tag :" + trimmedCurrentTag);

		}

		return response;
	}

	// Storing the required response data in Environment variables

	public void storeDieticianInfo(Response response, String dieticianCount) {

		if (response.getStatusCode() == 201) {

			if (dieticianCount.equalsIgnoreCase("Dietician1")) {

				EnvVariables.dietician1_ID = restUtil.extractStringFromResponse(response, "id");
				EnvVariables.dietician1_Email = restUtil.extractStringFromResponse(response, "Email");
				EnvVariables.dietician1_loginPassword = restUtil.extractStringFromResponse(response, "loginPassword");
				EnvVariables.dietician1_Firstname = restUtil.extractStringFromResponse(response, "Firstname");
				EnvVariables.dietician1_Lastname = restUtil.extractStringFromResponse(response, "Lastname");
				EnvVariables.dietician1_ContactNumber = restUtil.extractStringFromResponse(response, "ContactNumber");
				EnvVariables.dietician1_DateOfBirth = restUtil.extractStringFromResponse(response, "DateOfBirth");
				EnvVariables.dietician1_HospitalName = restUtil.extractStringFromResponse(response, "HospitalName");
				EnvVariables.dietician1_HospitalCity = restUtil.extractStringFromResponse(response, "HospitalCity");
				EnvVariables.dietician1_HospitalStreet = restUtil.extractStringFromResponse(response, "HospitalStreet");
				EnvVariables.dietician1_HospitalPincode = restUtil.extractStringFromResponse(response,
						"HospitalPincode");
				EnvVariables.dietician1_Education = restUtil.extractStringFromResponse(response, "Education");

				System.out.println("The token stored in EnvVariables.dietician1_ID is " + EnvVariables.dietician1_ID);

				System.out.println(
						"The token stored in EnvVariables.dietician1_Email is " + EnvVariables.dietician1_Email);
				System.out.println("The token stored in EnvVariables.dietician1_loginPassword is "
						+ EnvVariables.dietician1_loginPassword);

			} else if (dieticianCount.equalsIgnoreCase("Dietician2")) {
				String id = restUtil.extractStringFromResponse(response, "id");
				String loginPassword = restUtil.extractStringFromResponse(response, "loginPassword");
				String email = restUtil.extractStringFromResponse(response, "Email");
				EnvVariables.dietician2_ID = id;
				EnvVariables.dietician2_Email = email;
				EnvVariables.dietician2_loginPassword = loginPassword;
				System.out.println("The token stored in EnvVariables.dietician2_ID is " + EnvVariables.dietician2_ID);
				System.out.println(
						"The token stored in EnvVariables.dietician2_Email is " + EnvVariables.dietician2_Email);
				System.out.println("The token stored in EnvVariables.dietician2_loginPassword is "
						+ EnvVariables.dietician2_loginPassword);

			}

		}

	}

	// Reusable code for validating POST Dietician Response

	public void validateDieticianResponse(Response response, Integer statusCode) {

		// validating each field of response with the sent request body

		response.then().log().ifError().assertThat().statusCode(statusCode).contentType("application/json")
				.body("Firstname", equalTo(Firstname)).body("Lastname", equalTo(Lastname))
				.body("ContactNumber", equalTo(ContactNumber))
				.body("DateOfBirth", equalTo(DateOfBirth + "T00:00:00.000+00:00")).body("Email", equalTo(Email))
				.body("HospitalName", equalTo(HospitalName)).body("HospitalStreet", equalTo(HospitalStreet))
				.body("HospitalCity", equalTo(HospitalCity)).body("HospitalPincode", equalTo(HospitalPincode))
				.body("Education", equalTo(Education)).body("loginPassword", notNullValue()).body("id", notNullValue());

	}

	// Reusable code for validating any Response

	public void validateResponse(Response response, Integer statusCode) {

		response.then().log().ifError().assertThat().statusCode(statusCode);

	}

	// Reusable code for validating GET All Dieticians Response

	public void validateGetAllDieticiansResponse(Response response, Integer statusCode) {

		response.then().log().ifError().assertThat().statusCode(statusCode).contentType("application/json").extract()
				.response();

		List<Map<String, Object>> jsonResponse = response.jsonPath().getList("$");

		// Iterate through each object in the array

		for (Map<String, Object> item : jsonResponse) {

			// Validate that all required fields are present and not null for all Dieticians

			assertThat("id is null", item.get("id"), notNullValue());
			assertThat("Firstname is null", item.get("Firstname"), notNullValue());
			assertThat("Lastname is null", item.get("Lastname"), notNullValue());
			assertThat("ContactNumber is null", item.get("ContactNumber"), notNullValue());
			assertThat("DateOfBirth is null", item.get("DateOfBirth"), notNullValue());
			assertThat("Email is null", item.get("Email"), notNullValue());
			assertThat("HospitalName is null", item.get("HospitalName"), notNullValue());
			assertThat("HospitalStreet is null", item.get("HospitalStreet"), notNullValue());
			assertThat("HospitalCity is null", item.get("HospitalCity"), notNullValue());
			assertThat("HospitalPincode is null", item.get("HospitalPincode"), notNullValue());
			assertThat("Education is null", item.get("Education"), notNullValue());
		}

	}

	// Reusable code for validating GET Dietician by ID Response

	public void validateGetDieticianByIDResponse(Response response, Integer statusCode) {

		// validating each field of response with the sent Dietician ID details

		response.then().log().ifError().assertThat().statusCode(statusCode).contentType("application/json")
				.body("Firstname", equalTo(EnvVariables.dietician1_Firstname))
				.body("Lastname", equalTo(EnvVariables.dietician1_Lastname))
				.body("ContactNumber", equalTo(EnvVariables.dietician1_ContactNumber))
				.body("DateOfBirth", equalTo(EnvVariables.dietician1_DateOfBirth))
				.body("Email", equalTo(EnvVariables.dietician1_Email))
				.body("HospitalName", equalTo(EnvVariables.dietician1_HospitalName))
				.body("HospitalStreet", equalTo(EnvVariables.dietician1_HospitalStreet))
				.body("HospitalCity", equalTo(EnvVariables.dietician1_HospitalCity))
				.body("HospitalPincode", equalTo(EnvVariables.dietician1_HospitalPincode))
				.body("Education", equalTo(EnvVariables.dietician1_Education))
				.body("id", equalTo(Integer.parseInt(EnvVariables.dietician1_ID)));

	}

	// Reusable code for validating error code Response

	public void validateErrorCodeResponse(Response response, String errorMsg, Integer statusCode) {

		response.then().log().ifError().assertThat().statusCode(statusCode).contentType("application/json")
				.body("error", equalTo(errorMsg));

	}

	// Reusable code for validating Invalid Dietician ID error code Response

	public void validateInvalidIDResponse(Response response, String errorMsg, Integer statusCode) {

		response.then().log().ifError().assertThat().statusCode(statusCode).contentType("application/json")
				.body("errorCode", equalTo(errorMsg));

	}

}
