package com.verizon.netassist.enpct.healthcheck.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.verizon.util.Wait;
import com.verizon.webdrivers.option.WebDriverFacade;

/**
 * Created by vjean on 9/1/2017.
 */
public class EnpctHomeTfasMemoPage {

    private WebDriverFacade driver;
    private Wait wait = new Wait();

    public EnpctHomeTfasMemoPage(WebDriverFacade driver) {
        this.driver = driver;
    }

    public void clickOnTfasMemo() {
        WebElement clickOnTfasMemo = driver.findElement(By.xpath(".//a[text()='TFAS Memo']/../../li[6]"));
        wait.setSecondsToWait(4);
        wait.untilElementIsClickable(clickOnTfasMemo);
        clickOnTfasMemo.click();
    }

    public boolean isTfasMemoValid() {
        WebElement validateTfasMemo = driver.findElement(By.xpath(".//span[text()='TFAS Memo - Query']/../span"));
        wait.setSecondsToWait(2);
        wait.untilElementIsOnScreen(validateTfasMemo);
        System.out.println("\n> TFAS Memo Was Selected Successfully.");
        return validateTfasMemo.getText().toString().contains("TFAS");
    }

    public void clickOnCreate() {
        WebElement reportsCreate = driver.findElement(By.xpath(".//span[text()='Create']/../../button"));
        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(reportsCreate);
        reportsCreate.click();
        System.out.println("\n> Create Was Selected.");
    }
}
