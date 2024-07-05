package Utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Reporting {

    public static String timeStamp;
    public static String workingDirectory;

    @BeforeSuite
    public void beforeSuite() {
        String currentDir = System.getProperty("user.dir");
        System.out.println(currentDir);
        timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        workingDirectory = System.getProperty("user.dir");

        File screenshotFolder = new File(workingDirectory + "/Reporting/Screenshots/");
        File testRunFolder = new File(workingDirectory + "/Reporting/TestRuns/");

        if (!screenshotFolder.exists()) {
            new File(workingDirectory + "/Reporting/Screenshots/").mkdirs();
        }

        if (!testRunFolder.exists()) {
            new File(workingDirectory + "/Reporting/TestRuns/").mkdirs();
        }

        extent = new ExtentReports(currentDir + "/Reporting/TestRuns/TestRuns" + timeStamp + ".html");
        extent.loadConfig(new File(currentDir + "/Reporting/extent-config.xml"));
    }

    @AfterSuite
    public void afterSuite() {
        extent.flush();
        extent.close();
    }

    //public static ExtentReports extent;
    public static ExtentTest test;
    public static ExtentReports extent;

    //Used to indicate that a step has passed
    public static void PassStep(String message) {
        test.log(LogStatus.PASS, message);
    }

    //Used to indicate that a step has failed
    public static void FailStep(String message) {
        test.log(LogStatus.FAIL, message);
        Assert.fail(message);
    }

    public static void StringsEqualAssert(String expected, String actual) {
        if (!expected.equalsIgnoreCase(actual)) {
            String failMessage = String.format("%s does not equal %s", expected, actual);
            test.log(LogStatus.FAIL, failMessage);
            Assert.assertEquals(expected, actual, failMessage);
        } else {
            String successMessage = String.format("%s equals %s", expected, actual);
            test.log(LogStatus.PASS, successMessage);
            Assert.assertEquals(expected, actual, successMessage);
        }
    }
}