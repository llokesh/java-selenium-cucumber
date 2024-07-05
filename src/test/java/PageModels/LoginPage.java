package PageModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.SeleniumUtils;

public class LoginPage {
    //Contains all the login page elements

    private final WebDriver driver;

    @FindBy(id = "Logout")
    private WebElement logOut;

    @FindBy(id = "login_id")
    private WebElement loginUserName;

    @FindBy(id = "password")
    private WebElement loginPassword;
    
    @FindBy(id = "nextbtn")
    private WebElement nextButton;

    @FindBy(css = "div.zgh-brand")
    private WebElement brandLogo;

    @FindBy(className = "logout-btn")
    private WebElement logoutButton;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void navigateToLoginPage() {
    	driver.get("https://www.zoho.com/");
    }

    public LoginPage enterUserName(String username) {
        loginUserName.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
    	loginPassword.sendKeys(password);
        return this;
    }
    
    public void clickNext() {
        nextButton.click();
    }
    
    public void clickSignIn() {
    	driver.findElement(By.linkText("Sign in")).click();
    }

    public boolean brandLogoExists() {
        return SeleniumUtils.isElementPresent(brandLogo);
    }

    public void logOut() {
        logOut.click();
    }
}


