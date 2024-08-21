package com.api.TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

//plugin={"pretty", "html:target/Cucumber_DsAlgo_1Browser.html","json:target/cucumber-report.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, //reporting purpose
//monochrome = false, // console output color
//dryRun = !true, //To add new method give true


@CucumberOptions(tags ="@LoginPositive1 or @create_dietician_positive or @DieticianLogin1 or @DieticianInvalid2",
		//or @DieticianInvalid2",
		features = "src/test/resources/Feature",
glue = {"com.api.StepDefs"})

public class TestRunner_API {

}
