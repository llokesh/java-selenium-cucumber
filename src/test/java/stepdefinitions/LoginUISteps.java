package stepdefinitions;
import java.util.concurrent.TimeUnit;

import PageModels.LoginPage;
import Base.TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;


public class LoginUISteps extends TestBase{
	
	
	
//	public static WebDriver driver;
	
	private final WebDriver driver = new ChromeDriver();
	LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
	
	@Given("^user is on home page$")

    public void user_is_on_homepage() throws Throwable {

        // Write code here that turns the phrase above into concrete actions

//          System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
//
//          driver = new ChromeDriver();

          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

          loginPage.navigateToLoginPage();

      }

     

      @When("^user navigate to Login page$")

      public void user_navigates_to_Login_Page() throws Throwable {

          loginPage.clickSignIn();

      }

     

      @And("^user enters username and Password$")

      public void user_enters_username_and_Password() throws Throwable {
    	  
          loginPage
          	.enterUserName("likithal39@gmail.com")
          	.clickNext();
          
          loginPage
          	.enterPassword("Sun$Daisy132")
          	.clickNext();

      }

     

      @Then("^verify logo is displayed$")

      public void verify_header_is_displayed() throws Throwable {

          Assert.assertTrue(loginPage.brandLogoExists());

//           driver.quit(); 

      }
	

}
