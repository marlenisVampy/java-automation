package com.verizon.netassist.enpct.healthcheck.pages;

import com.verizon.webdrivers.option.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by vjean on 8/17/2017.
 */

@SuppressWarnings("ALL")
public class LoginPage {

    private WebDriverFacade driver;
    private static String userName = "JEANVL";
    private static String password = "Yanemirj17";
    private static final String BASE_URL = "https://logindevsac.ebiz.verizon.com/onepassword/onelogin.jsp?CHALLENGE=&SMAGENTNAME=$SM$MBgteQveX0dtqqjGdrBr%2f%2b3iqaCNsasPiGwuSp5AzwUImSjPaBcxS21Odv3%2bKKGM&TARGET=$SM$http%3a%2f%2ffldd1lifvtw01v%2eebiz%2everizon%2ecom%2fENPC";


    public LoginPage(WebDriverFacade driver) throws Exception {

        this.driver = driver;
        driver.start(BASE_URL);
        System.out.println("\nSuccessfully Opened " + driver.getTitle() + " Webpage.");
        driver.takeScreenshot("PageLoad");
    }

    public void setUser_ID() {
        WebElement user_ID = driver.findElement(By.id("USERID"));
        user_ID.clear();
        user_ID.sendKeys(userName);
    }

    public void setUser_password() {
        WebElement user_password = driver.findElement(By.id("PASSWORD"));
        user_password.clear();
        user_password.sendKeys(password);
    }

    private void dismissAlertDialog() {
        try {
            driver.dismissAlert();
            System.out.println("\n> Alert dialog dismissed!");
        } catch (NoAlertPresentException e) {
            assertTrue(true);
        }
    }

    private void isAlertPresent() {
        try {
            driver.acceptAlert();
            System.out.println("\n> Alert was Accepted.");
        } catch (NoAlertPresentException e) {
            assertTrue(true);
            System.out.println("\n> No alert found.");
        }
    }

    private void clickOnSignIn() {
        WebElement singIn_button = driver.findElement(By.xpath
                ("//*[@id='domainLogin']/div/div[4]/a"));
        singIn_button.click();
    }

    private void acceptPhantomjsAlert() {
        driver.acceptPhantomjs_Alert(driver);
        System.out.println("\n> PhantomJS Alert Accepted.");
    }

    @SuppressWarnings("ConstantConditions")
    public boolean isPhantomSelected() {
        if (this.driver == driver) {
            acceptPhantomjsAlert();
            clickOnSignIn();
            return true;
        } else {
            clickOnSignIn();
            isAlertPresent();
            dismissAlertDialog();
            return false;
        }
    }
}
