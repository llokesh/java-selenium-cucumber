package ui_stepdefinations;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class ui_steps {
	
	public static WebDriver driver;
	
	@Given("^user is on home page$")

    public void user_is_on_homepage() throws Throwable {

        // Write code here that turns the phrase above into concrete actions

          System.setProperty("webdriver.chrome.driver", "driver/chromedriver");

          driver = new ChromeDriver();

          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

          driver.get("http://automationpractice.com");

      }

     

      @When("^user navigate to Login page$")

      public void user_navigates_to_Login_Page() throws Throwable {

          driver.findElement(By.linkText("Sign in")).click();

      }

     

      @And("^user enters username and Password$")

      public void user_enters_username_and_Password() throws Throwable {

      driver.findElement(By.id("email")).sendKeys("blog.cucumber@gmail.com");

          driver.findElement(By.id("passwd")).sendKeys("Cucumber@blog");

          driver.findElement(By.id("SubmitLogin")).click();  

      }

     

      @Then("^verify header is displayed$")

      public void verify_header_is_displayed() throws Throwable {

          driver.findElement(By.cssSelector("#header_logo>a>img")).isDisplayed();

           driver.quit(); 

      }
	

}
