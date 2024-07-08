package Utilities;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.time.Duration;


public class SeleniumUtils {
    public static final int DEFAULT_WAIT_TIME = 30;
    public static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        SeleniumUtils.driver = driver;
        setTimeout(Config.elementWaitTimeout);
    }

    //Waits
    private static void setTimeout(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public static void WaitUntilVisible(WebElement element) {
        waitForCondition(ExpectedConditions.visibilityOf(element), Config.elementWaitTimeout);
    }

    public static void waitBy(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    private static void waitForCondition(ExpectedCondition condition, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(condition);
    }

    public static WebElement waitForElementToClickable(WebElement element) {
        waitForCondition(ExpectedConditions.elementToBeClickable(element), Config.elementWaitTimeout);
        return element;
    }

    public static void explicitWait(int sec) {
        try {
            java.lang.Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Navigation
    public static void goTo(WebDriver driver, String url) {
        driver.get(url);
    }


    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public static void switchWindowControl() {
        Set<String> windowHandles = driver.getWindowHandles();
        driver.switchTo().window(windowHandles.toArray()[1].toString());
    }

    public static void switchToIframeByIndex(int index) {
        driver.switchTo().frame(index);
    }

    public static void switchToIframeById(String Id) {
        driver.switchTo().frame(Id);
    }

    public static void switchBackToDefaultFrame() {
        driver.switchTo().defaultContent();
    }

    public static void selectDropdown(Select dropdown, int index) {
        dropdown.selectByIndex(index);
        dropdown.selectByVisibleText("visible");
        dropdown.selectByValue("value1");
    }

    public static void actions(WebElement ele, WebElement targetEle) {
        //Ability to handle keyboard events, mouse events and special actions
        Actions actions = new Actions(driver);
        actions.clickAndHold(ele)
            .moveToElement(targetEle)
            .build()
            .perform();

        actions.moveToElement(ele).build().perform();
        actions.doubleClick(ele).perform();
    }

    public static void alertPopUps() {
        //wait for alert and switch
        //Explicitly wait for the alert if needed
        Alert alert = driver.switchTo().alert();
        //Fetch the text of the alert
        String alertText = alert.toString();
        System.err.println(alertText);
        //Send keys to alert
        alert.sendKeys("Hello!");
        //Accept or dismiss alerts
        alert.accept();
        alert.dismiss();
    }

    public static void focusAndClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public static void scrollAndClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public static Boolean scrollAndFind(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
        return element.isDisplayed();
    }

    public static void scrollPage() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public static boolean isClickable(WebElement ele) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(ele));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void hitRefresh() {
        driver.navigate().refresh();

    }

    //Validation
    public static boolean isElementPresent(WebElement we) {
        try {
            return we.isDisplayed();
        } catch (Exception NoSuchElementException) {
            return false;
        }
    }

    public static boolean isElementPresent(By we) {
        try {
            return driver.findElement(we).isDisplayed();
        } catch (Exception NoSuchElementException) {
            return false;
        }
    }

    public static boolean isElementSelected(WebElement we) {
        try {
            return we.isSelected();
        } catch (Exception e) {
            return false;
        }
    }

    public static void clickElement(WebElement filterValue) {
        waitForElementToClickable(filterValue);
        filterValue.click();
    }

    public static Date addMonthsToDate(Calendar cal, int num_months) {
        cal.add(Calendar.MONTH, num_months);
        return cal.getTime();
    }

    public static void resizeBrowser() {
    //Resize current window to the set dimension
        driver.manage().window().setSize(new Dimension(800, 600));
    }

    /**
     * Find element.
     *
     * @param by the by
     * @return the web element
     */
    public static WebElement findElement(By by) {
        return driver.findElement(by);
    }
}
