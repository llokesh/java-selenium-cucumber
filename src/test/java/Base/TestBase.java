package Base;


import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.LogStatus;

import PageModels.LoginPage;
import Utilities.BrowserFactory;
import Utilities.PropertiesCache;
import Utilities.Reporting;
import Utilities.SeleniumUtils;

//Each test class should inherit this one
public class TestBase extends Reporting {
    protected WebDriver driver;

    protected LoginPage loginPage;
    
    @AfterMethod
    //Tear down driver after each test
    public void tearDown(ITestResult result) {
        boolean testResult = result.isSuccess();
        String sessionId = ((RemoteWebDriver) driver).getSessionId().toString();
        tearDownlocalHost(result);
        if (driver == null)
            return;
        driver.quit();
        PassStep("Browser successfully quit");
        System.out.println("The result is "+ testResult + "for session Id: " + sessionId);
    }

    private void tearDownlocalHost(ITestResult result) {
        try {
            if (!result.isSuccess()) {
                String screenshotFileName = workingDirectory + "/Reporting/Screenshots/" + timeStamp + result.getMethod().getMethodName() + ".png";

                TakesScreenshot ts = (TakesScreenshot) driver;
                File source = ts.getScreenshotAs(OutputType.FILE);

                FileUtils.copyFile(source, new File(screenshotFileName));

                System.out.println("Screenshot taken");

                test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture(screenshotFileName));
            } else {
                System.out.println(result.getMethod().getMethodName() + " has successfully passed.");
            }
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
        extent.endTest(test);
    }


    public void initializePageObjects() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @BeforeMethod
    public void methodSetup(Method method) throws MalformedURLException {
        test = extent.startTest(this.getClass().getSimpleName() + "::" + method.getName());
        if (method.getName().equals("validateTapTable")) {
            PropertiesCache.getInstance().setProperty("resize", "True");
        }
        driver = BrowserFactory.GetBrowserInstance(method.getName(), PropertiesCache.getInstance().getProperty("resize"));
        SeleniumUtils.setDriver(driver);
        PassStep("Browser successfully launched");
        initializePageObjects();
    }


}