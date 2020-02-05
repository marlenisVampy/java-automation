package com.verizon.webdrivers.option;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by vjean on 8/29/2017.
 */
public class WebDriverFacade {

    private WebDriver driver = null;
    private static final long WAIT_SECONDS = 8;

    public WebDriverFacade(Browsers browser) {
        WebDriverFactory factory = new WebDriverFactory();
        driver = factory.CreateInstance(browser);
    }

    public void start(String url) {
        driver.get(url);
    }

    public void closeBrowser() {
        if (driver != null)
            driver.quit();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void windowMaximize() {
        driver.manage().window().maximize();
    }

    public void timespan() {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
    }

    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public Object executeJavaScript(String script) {
        return ((JavascriptExecutor) driver).executeScript(script);
    }

    public WebElement findElement(By by) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, WAIT_SECONDS);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception ex) {
            return NullWebElement.getNull();
        }
    }

    public List<WebElement> findElements(By by) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_SECONDS);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void takeScreenshot(String screenshotName) {
        try {
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

            File destFile = new File("./screenshots/" + screenshotName + ".png");
            System.out.println("\n> [SCREENSHOT SAVED.]");
            FileUtils.copyFile(srcFile, destFile);
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
    }

    public void acceptPhantomjs_Alert(WebDriverFacade driver) {
        driver.executeJavaScript("window.alert = function(){}");
        driver.executeJavaScript("window.confirm = function(){return true;}");
    }

    public void scrollToElement(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
