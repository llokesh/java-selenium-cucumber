package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
    
@CucumberOptions(tags = "", features = {"src/test/resources/features"}, glue= {"stepdefinitions"},
                 plugin = {"pretty","html:target/cucumber-reports/cucumber-pretty", 
                	        "json:target/cucumber-reports/CucumberTestReport.json",
                	        "rerun:target/cucumber-reports/rerun.txt" },
                 monochrome = true)

    
public class TestRunner extends AbstractTestNGCucumberTests {
    
}


