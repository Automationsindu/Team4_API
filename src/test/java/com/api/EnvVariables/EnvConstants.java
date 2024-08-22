package com.api.EnvVariables;

public class EnvConstants {
	
	
/*######################       EndPoints        ######################/*/
	
	public static final String qaEnvironmentbaseURI = "https://dietician-july-api-hackathon-80f2590665cc.herokuapp.com/dietician";

	public static final String login_Endpoint= "/login";

	
	public static final String logout_Endpoint="/logoutdietician";
	
	public static final String createDietician_Endpoint= "/dietician";
	

	public static String filePath_patientModule = ".\\src\\test\\resources\\Test_Data\\createPatient.xlsx";
	
	
	
	
	//public static String reportPath_patientModule = ".\\src\\test\\resources\\Test_Data\\GrowthHacker_Diabetes_Report_vitals.pdf";
	public static String reportPath_patientModule = ".\\src\\test\\resources\\Test_Data\\GrowthHacker_Hypothyroidism.pdf";
	
	
	

	public static String Excelpath = "src/test/resources/Test_data/Dietician_testdata.xlsx";
	
	public static String Invalidlogin_Endpoint="///login";
	
	public static final String Invalid_createDietician_Endpoint= "/dieticiann";
	


	public static final String morbidity_Endpoint= "/morbidity";

	public static final String Invalid_dietician_Email="check@html";
	
	public static final String Invalid_Dietician_pwd="dietician";

	
	public static final String createpatient = "/patient";
	
	public static final String createpatient_Invalid = "/patients";
	
	
	
	public static final String  update_patient= "/patient/" +EnvVariables.patientId; 
	
	public static final String update_vitals= "/patient/newReports/"+EnvVariables.patientId;
	
	public static final String Patients_Morbidity  ="/patient/testReports/"+EnvVariables.patientId;
	
	public static final String getAll_patients ="/patient";
	
	public static final String getBy_fileId ="/patient/testReports/viewFile/"+ EnvVariables.fileId;
	
	public static final String delete = "/patient/"+ EnvVariables.patientId; 
	
	public static String filePath_responseReport=".\\src\test\\resources\\Test_Data\\response_Report.pdf";
	
	

}
