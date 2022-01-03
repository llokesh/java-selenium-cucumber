package ui_runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/resources/ui_functionalTests"}, glue= {"ui_stepdefinations"})

public class runner {

}
