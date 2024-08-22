package com.api.TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

/*
@CucumberOptions(plugin = {"pretty", "html:target/Cucumber_Rest_Assured.html"},
features = "src/test/resources/Feature",
glue = {"com.api.StepDefs"})
*/



@CucumberOptions(
		//tags ="@positive11",
//"@LoginPositive1 or  @create_dietician_positive or @DieticianLogin1",
		//or @DieticianInvalid2",
		features = "src/test/resources/Feature",
				    //"src/test/resources/Feature/05.UserLogOut.feature"},
        glue = {"com.api.StepDefs"},
        plugin = {"pretty", "html:target/cucumber-reports"})


public class TestRunner_API {

}
