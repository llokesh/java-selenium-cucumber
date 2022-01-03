package api_runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/resources/functionalTests"}, glue= {"api_stepdefinations"})

public class testRunnner {
	 
	
}


