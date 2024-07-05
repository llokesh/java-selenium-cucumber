package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class BrowserFactory {
    private static final String browserType = PropertiesCache.getInstance().getProperty("driver.browser");
    private static final String browserPath = PropertiesCache.getInstance().getProperty("driver.path");
    public static WebDriver driver;


    public static WebDriver GetBrowserInstance(String testname, String resize) throws MalformedURLException {

        driver = GetLocalBrowserInstance(browserType, resize);
        return driver;
    }

    private static WebDriver GetLocalBrowserInstance(String browserType, String resize) {
        //Currently local test runs support only chrome browser.
        ChromeOptions options = new ChromeOptions();
        options.addArguments(Arrays.asList(Config.ChromeOptions));
        if(resize.equals("True")) {
            options.addArguments("--window-size=800,800");
        }
        if (browserType.equalsIgnoreCase("chrome")) {
            try {
                System.setProperty("webdriver.chrome.driver", browserPath);
                driver = new ChromeDriver(options);
            } catch (Exception e) {
                throw new Error("Driver for " + browserType + " could not be found.");
            }
        } else
            throw new Error("Browser not supported - supported browser is Chrome.");
        return driver;
    }


    private static String getTestRunName(String testCaseName, String browserName) {
        String testType = "";
        testType = browserName.equals("ie") ? "BVT" : "Functional";
        return browserName.toUpperCase() + " - " + testType + " - "
                + PropertiesCache.getInstance().getProperty("origin") + " - "
                + testCaseName;
    }

    public static WebDriver GetDriver() {
        return driver;
    }
}
