package com.api.TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

//plugin={"pretty", "html:target/Cucumber_DsAlgo_1Browser.html","json:target/cucumber-report.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, //reporting purpose
//monochrome = false, // console output color
//tags = "@DsAlgo_1Browser", // tags from feature file
//dryRun = !true, //To add new method give true
//features = { "src/test/resources/features" }, // location of feature files
//glue = {"stepDefinition","ApplicationHooks","Utilities"}) // location of step definition files

@CucumberOptions(//tags ="@Login1",
		features = "src/test/resources/Feature/01.userLogin.feature",
glue = {"com.api.StepDefs"})

public class TestRunner_API {

}
