package com.api.TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

//plugin={"pretty", "html:target/Cucumber_DsAlgo_1Browser.html","json:target/cucumber-report.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, //reporting purpose
//monochrome = false, // console output color
//dryRun = !true, //To add new method give true


@CucumberOptions(tags ="@DieticianInvalid2",
//"@LoginPositive1 or  @create_dietician_positive or @DieticianLogin1",
		//or @DieticianInvalid2",
		features = "src/test/resources/Feature",
				    //"src/test/resources/Feature/05.UserLogOut.feature"},
        glue = {"com.api.StepDefs"},
        plugin = {"pretty", "html:target/cucumber-reports"})

public class TestRunner_API {

}
