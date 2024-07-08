package PageModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.PropertiesCache;
import Utilities.SeleniumUtils;

public class LoginPage {
	// Contains all the login page elements

	private final WebDriver driver;

	@FindBy(id = "login_id")
	private WebElement loginUserName;

	@FindBy(id = "password")
	private WebElement loginPassword;

	@FindBy(id = "nextbtn")
	private WebElement nextButton;

	@FindBy(css = "div.zgh-brand")
	private WebElement brandLogo;

	@FindBy(css = "div.zoho_brand")
	private WebElement brandLogo1;

	@FindBy(css = "div.errorlabel")
	private WebElement errorMessage;

	@FindBy(css = "div.zgh-left-nav > div > div.head-sign-in > div.zgh-user-box> div.zgh-userPanel")
	private WebElement logoutButton;

	@FindBy(id = "continue_button")
	private WebElement continueButton;

	public final static String url = PropertiesCache.getInstance().getProperty("host.address");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public LoginPage() {
		this.driver = null;
	}

	public void navigateToHomePage() {
		driver.get(url);
	}

	public void enterUserName(String username) {
		loginUserName.sendKeys(username);
	}

	public void enterPassword(String password) {
		loginPassword.clear();
		loginPassword.sendKeys(password);

	}

	public void clickNext() {
		nextButton.click();

		//Test fails if max sign in limit is reached
		if(SeleniumUtils.isElementPresent(errorMessage)) {
		Assert.assertFalse(SeleniumUtils.isElementPresent(errorMessage), "Maximum limits are reached and user can no longer log in");
		}
	}

	public void clickSignIn() {
		driver.findElement(By.linkText("Sign in")).click();
	}

	public boolean brandLogoExists() {

		if (SeleniumUtils.isElementPresent(continueButton)) {
			continueButton.click();
		}

		return SeleniumUtils.isElementPresent(brandLogo);
	}

	public boolean errorMessageExists() {
		return SeleniumUtils.isElementPresent(errorMessage);
	}

	public void logOut() {
		logoutButton.click();
		driver.findElement(By.linkText("Sign Out")).click();
		// Waiting for the user to log out
		SeleniumUtils.wait(10);
	}
}
