package com.verizon.netassist.enpct.healthcheck.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.verizon.util.Wait;
import com.verizon.webdrivers.option.WebDriverFacade;

/**
 * Created by vjean on 8/28/2017.
 */
public class EnpctHomeJobListPage {
    private WebDriverFacade driver;
    private Wait wait = new Wait();

    public EnpctHomeJobListPage(WebDriverFacade driver) {
        this.driver = driver;
    }

    public void clickOnJobList() {
        WebElement jobList = driver.findElement(By.xpath(".//a[text()='Job List']/../../li[5]/a"));
        wait.setSecondsToWait(3);
        wait.untilElementIsClickable(jobList);
        jobList.click();
    }

    public boolean isJobListValid() {
        WebElement validateJobList = driver.findElement(By.xpath(".//span[text()='Job List']/../span"));
        wait.setSecondsToWait(3);
        wait.untilElementIsOnScreen(validateJobList);
        System.out.println("\n> Job List Selected Successfully.");
        return validateJobList.getText().toString().contains("Job List");
    }

    public String showJobListRecord() {
        WebElement showJobListRecord = driver.findElement(By.xpath(".//*[@id='frmCenter:dtList']/div[1]"));
        wait.setSecondsToWait(2);
        wait.untilElementIsOnScreen(showJobListRecord);
        return showJobListRecord.getText();
    }

    public void showJobData() {
        WebElement showJobData = driver.findElement(By.xpath(".//*[@id='frmCenter:dtList:0:j_idt118']"));
        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(showJobData);
        showJobData.click();
    }
}
