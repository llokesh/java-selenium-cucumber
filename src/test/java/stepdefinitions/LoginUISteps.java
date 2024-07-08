package stepdefinitions;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import PageModels.LoginPage;
import Utilities.ExcelReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class LoginUISteps{
	
	public WebDriver driver;
	LoginPage loginPage = new LoginPage();
	
    
	String excelpath ="src/test/resources/ExcelData/Data.xlsx";
	String environment = System.getProperty("env") == null? "dev": System.getProperty("env");
	
	
    //Hooks steps
    @Before("@ui")
    public void beforeSetUp() throws MalformedURLException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        
        if(environment == "docker" ) {
        	driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),options);
        } else {
        driver = new ChromeDriver(options);
        }
    	loginPage = PageFactory.initElements(driver, LoginPage.class);
    	
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    
    @After("@ui")
    //Tear down driver after each test
    public void afterTearDown() {
    	if(driver!=null) {
    		driver.quit();
    	}
        System.out.println("The Browser is quit successfully");
    }

	//Gherkin steps
	@Given("^user is on home page$")

    public void user_is_on_homepage() throws Throwable {

          loginPage.navigateToHomePage();

      }

     

      @When("^user navigate to Login page$")

      public void user_navigates_to_Login_Page() throws Throwable {

          loginPage.clickSignIn();

      }
      

      @When("The user enter sheet {string} and {int}")
       public void the_user_enter_sheet_and(String sheetname, Integer rownum) throws InvalidFormatException, IOException {
        ExcelReader reader=new ExcelReader();
        List<Map<String,String>> listLogin= reader.getData(excelpath, sheetname);
        String username=listLogin.get(rownum).get("Username");
        String Password=listLogin.get(rownum).get("Password");
        
        loginPage.enterUserName(username);
      	loginPage.clickNext();
      
       loginPage.enterPassword(Password);
       loginPage.clickNext();
       }

     

      @And("user enters {string} and {string}")

      public void user_enters_examples_credentials(String username, String Password) throws Throwable {
    	  
          loginPage.enterUserName(username);
          loginPage.clickNext();
          
          loginPage.enterPassword(Password);
          loginPage.clickNext();

      }
      
      @When("user enters password")

      public void user_enters_datatable_credentials(DataTable dataTable) throws InterruptedException{
         System.out.println("Credentials Entered");

         List<Map<String, String>> user = dataTable.asMaps(String.class, String.class);

         for (Map<String, String> form : user) {
        	 String passWord = form.get("Password");
        	 
             loginPage.enterPassword(passWord);
             loginPage.clickNext();

         }
      }
      
      @And("user enters username")

      public void user_enters_username() throws Throwable {
    	  
          loginPage.enterUserName("ok@gmail.com");
          loginPage.clickNext();

      }
      
      @And("user clicks the next button")

      public void user_clicks_next() throws Throwable {
    	  
          loginPage.clickNext();

      }


      @Then("^verify logo is displayed$")

      public void verify_header_is_displayed() throws Throwable {

          Assert.assertTrue(loginPage.brandLogoExists());

      }
      
      @Then("^verify error message is displayed$")

      public void verify_error_is_displayed() throws Throwable {

          Assert.assertTrue(loginPage.errorMessageExists());

      }
      
      @And("user logs out")

      public void logs_out() throws Throwable {
    	  
          loginPage
          	.logOut();

      }
}
