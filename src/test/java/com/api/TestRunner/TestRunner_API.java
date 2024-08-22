package com.api.TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(plugin = {"pretty", "html:target/Cucumber_Rest_Assured.html"},
features = "src/test/resources/Feature",
glue = {"com.api.StepDefs"})


public class TestRunner_API {

}
