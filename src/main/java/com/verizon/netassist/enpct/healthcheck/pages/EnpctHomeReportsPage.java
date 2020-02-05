package com.verizon.netassist.enpct.healthcheck.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.verizon.util.Wait;
import com.verizon.webdrivers.option.WebDriverFacade;

/**
 * Created by vjean on 9/1/2017.
 */
public class EnpctHomeReportsPage {

    private WebDriverFacade driver;
    private Wait wait = new Wait();

    public EnpctHomeReportsPage(WebDriverFacade driver) {
        this.driver = driver;
    }

    public void clickOnReports() {
        wait.setSecondsToWait(8);
        WebElement reports = driver.findElement(By.xpath(".//a[text()='Reports']/../../li[7]"));

        wait.untilElementIsClickable(reports);
        reports.click();
    }

    public boolean isRoportsValid() {
        WebElement validateReports = driver.findElement(By.xpath(".//span[text()='Reports - Administration']/../span"));
        wait.setSecondsToWait(2);
        wait.untilElementIsOnScreen(validateReports);
        System.out.println("\n> Reports Was Selected successfully.");
        return validateReports.getText().toString().contains("Reports");
    }

    public void clickOnCenterCodes() {
        WebElement centerCodes = driver.findElement(By.xpath(".//a[text()='Center Codes']"));
        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(centerCodes);
        centerCodes.click();
        System.out.println("\n> Center Codes Was Selected successfully.");
    }

    public void clickOnGenerateCenterCodes() {
        WebElement generateAdminReport = driver.findElement(By.xpath(".//span[text()='Generate']/../../button"));
        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(generateAdminReport);
        generateAdminReport.click();
        System.out.println("\n> Center Codes Report Was Generated successfully.");
    }

    public void clickOnAdmin() {
        WebElement admin = driver.findElement(By.xpath(".//a[text()='Admin']"));
        wait.setSecondsToWait(5);
        wait.untilElementIsClickable(admin);
        admin.click();
    }

    public void clickOnClusterCodes() {
        WebElement clusterCodes = driver.findElement(By.xpath(".//a[text()='Cluster Codes']"));
        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(clusterCodes);
        clusterCodes.click();
        System.out.println("\n> Cluster Codes Was Selected successfully.");
    }

    public void clickOnGenerateClusterCodes() {
        WebElement generateClusterCodesReport = driver.findElement(By.xpath(".//span[text()='Generate']/../../button"));
        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(generateClusterCodesReport);
        generateClusterCodesReport.click();

        System.out.println("\n> Cluster Center Codes Report Was Generated successfully.");
    }

    public void clickOnEmployeeInfo() {
        clickOnAdmin();

        WebElement employeeInformation = driver.findElement(By.xpath(".//a[text()='Employee Information']"));
        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(employeeInformation);
        employeeInformation.click();
        System.out.println("\n> Employee Information Was Selected successfully.");
    }

    public void clickOnEmployeeInfoReport() {
        WebElement employeeInfoReport = driver.findElement(By.xpath(".//span[text()='Generate']/../../button"));
        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(employeeInfoReport);
        employeeInfoReport.click();
    }

    public void clickOnUnknownCenterCodes() {
        clickOnAdmin();

        WebElement unknownCenterCodes = driver.findElement(By.xpath(".//a[text()='Unknown Center Codes']"));
        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(unknownCenterCodes);
        unknownCenterCodes.click();
        System.out.println("\n> Unknown Center Codes Was Selected successfully.");
    }

    public void clickOnGenerateUnknownCenterCodesReport() {
        WebElement unknownCenterCodesReport = driver.findElement(By.xpath(".//span[text()='Generate']/../../button"));
        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(unknownCenterCodesReport);
        unknownCenterCodesReport.click();
        System.out.println("\n> Unknown Center Codes Report Was Generated successfully.");
    }

    public void clickOnStatistical() {
        wait.setSecondsToWait(5);
        WebElement statistical = driver.findElement(By.xpath(".//a[text()='Statistical']"));

        wait.untilElementIsClickable(statistical);
        statistical.click();
    }

    public boolean isStatisticalValid() {
        WebElement validateStatistical = driver.findElement(By.xpath(".//span[text()='Reports - Statistical']/../span"));
        wait.setSecondsToWait(2);
        wait.untilElementIsOnScreen(validateStatistical);
        System.out.println("\n> Statistical Was Selected Successfully.");
        return validateStatistical.getText().toString().contains("Statistical");
    }

    public void clickOnStatusByNe() {
        WebElement statusByNe = driver.findElement(By.xpath(".//a[text()='#32 - 74 Status by NE']"));
        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(statusByNe);
        statusByNe.click();
        System.out.println("\n> #32 - 74 Status by NE Was Selected Successfully.");
    }

    public void clickOnStatusByNeGenerate() {
        WebElement statusByNeGenerate = driver.findElement(By.xpath(".//span[text()='Generate']/../../button"));
        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(statusByNeGenerate);
        statusByNeGenerate.click();
        System.out.println("\n> #32 - 74 Status by NE Report Was Generated Successfully.");
    }

    public void clickOnDailyCommError() {
        wait.setSecondsToWait(10);
        clickOnStatistical();

        WebElement dailyCommunicationError = driver.findElement(By.xpath(".//a[text()='#43 - Daily Communication Errors by NE']"));
        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(dailyCommunicationError);
        dailyCommunicationError.click();
        System.out.println("\n> #43 - Daily Communication Errors by NE Was Selected Successfully.");
    }

    public void selectYearToDateGenerateCommReport() {
        WebElement selectYearToDate = driver.findElement(By.xpath(".//td[text()='Date Range:']/../td[2]/table/tbody/tr[2]/td/input"));
        WebElement dailyCommErrorReport = driver.findElement(By.xpath(".//span[text()='Generate']/../../button"));
        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(selectYearToDate);
        selectYearToDate.click();
        dailyCommErrorReport.click();

        System.out.println("\n> #43 - Daily Communication Errors by NE Report Was Generated Successfully.");
    }

    public void clickOnCountsByNe() {
        wait.setSecondsToWait(5);
        clickOnStatistical();

        WebElement countsByNe = driver.findElement(By.xpath(".//a[text()='I&B Counts by NE']"));
        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(countsByNe);

        countsByNe.click();
        System.out.println("\n> I&B Counts by NE Was Selected Successfully.");
    }

    public void selectYearToDateGenerateCountsReport() {
        WebElement selectYearToDateCounts = driver.findElement(By.xpath(".//td[text()='Date Range:']/../td[2]/table/tbody/tr[2]/td/input"));
        WebElement generateCountsReport = driver.findElement(By.xpath(".//span[text()='Generate']/../../button"));

        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(selectYearToDateCounts);
        selectYearToDateCounts.click();
        generateCountsReport.click();

        System.out.println("\n> I&B Counts by NE Report Was Generated Successfully.");
    }

    public void clickOnCompletedItemByEmployee() {
        wait.setSecondsToWait(5);
        clickOnStatistical();

        WebElement completedItemByEmployee = driver.findElement(By.xpath(".//a[text()='#16 - Completed Items by Employee']"));
        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(completedItemByEmployee);
        completedItemByEmployee.click();

        System.out.println("\n> #16 - Completed Items by Employee Was Selected Successfully.");
    }

    public void selectYearToDateGenerateItemsEmployeeReport() {
        WebElement dateRangeCompletedItemByEmployee = driver.findElement(By.xpath(".//td[text()='Date Range:']/../td[2]/table/tbody/tr[2]/td/input"));
        WebElement generateItemByEmployeeReport = driver.findElement(By.xpath(".//span[text()='Generate']/../../button"));

        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(dateRangeCompletedItemByEmployee);
        dateRangeCompletedItemByEmployee.click();
        generateItemByEmployeeReport.click();

        System.out.println("\n> #16 - Completed Items by Employee Was Generated Successfully.");
    }

    public void clickOnCompletedWorked() {
        wait.setSecondsToWait(5);
        clickOnStatistical();

        WebElement completedWorkCount = driver.findElement(By.xpath(".//a[text()='#31 - Completed Work Count by Elapsed Time/Employee']"));
        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(completedWorkCount);
        completedWorkCount.click();

        System.out.println("\n> #31 - Completed Work Count by Elapsed Time/Employee Was Selected Successfully.");
    }

    public void selectYearToDateGenerateCompletedWorkReport() {
        WebElement dateRangeCompletedWork = driver.findElement(By.xpath(".//td[text()='Date Range:']/../td[2]/table/tbody/tr[3]/td/input"));
        WebElement generateCompletedWorkReport = driver.findElement(By.xpath(".//span[text()='Generate']/../../button"));

        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(dateRangeCompletedWork);
        dateRangeCompletedWork.click();
        generateCompletedWorkReport.click();

        System.out.println("\n> #31 - Completed Work Count by Elapsed Time/Employee Was Generated Successfully.");
    }

    public void clickOnEmployeeCompleted() {
        wait.setSecondsToWait(5);
        clickOnStatistical();

        WebElement employeeCompleted = driver.findElement(By.xpath(".//a[text()='#33 - Employee Completed Items by Disposition']"));
        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(employeeCompleted);
        employeeCompleted.click();

        System.out.println("\n> #33 - Employee Completed Items by Disposition Was Selected Successfully.");
    }

    public void selectYearToDateGenerateEmployeeCompletedReport() {
        WebElement dateRangeEmployeeCompleted = driver.findElement(By.xpath(".//td[text()='Date Range:']/../td[2]/table/tbody/tr[3]/td/input"));
        WebElement generateEmployeeCompletedReport = driver.findElement(By.xpath(".//span[text()='Generate']/../../button"));

        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(dateRangeEmployeeCompleted);
        dateRangeEmployeeCompleted.click();
        generateEmployeeCompletedReport.click();

        System.out.println("\n> #33 - Employee Completed Items by Disposition Was Generate Successfully.");
    }

    public void clickOnTodayReport() {
        WebElement todayReport = driver.findElement(By.xpath(".//a[text()=\"Today's Reports\"]"));

        wait.setSecondsToWait(10);
        wait.untilElementIsClickable(todayReport);
        todayReport.click();
    }

    public boolean validateTodayReport() {
        WebElement validateTodayReport = driver.findElement(By.xpath(".//span[text()=\"Reports - Today's\"]/../span"));
        wait.setSecondsToWait(2);
        wait.untilElementIsOnScreen(validateTodayReport);
        System.out.println("\n> Today's Reports Was Selected Successfully.");
        return validateTodayReport.getText().toString().contains("Today's");
    }

    public void clickOnAllMStatus() {
        WebElement allmStatus = driver.findElement(By.xpath(".//a[text()='All M Status']"));

        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(allmStatus);
        allmStatus.click();

        System.out.println("\n> All M Status Was Selected Successfully.");
    }

    public void clickOnGenerateAllmStatusReport() {
        WebElement generateAllmStatus = driver.findElement(By.xpath(".//span[text()='Generate']/../../button"));

        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(generateAllmStatus);
        generateAllmStatus.click();

        System.out.println("\n> All M Status Report Was Generated Successfully.");
    }

    public void clickOnAllMStatusADI() {
        wait.setSecondsToWait(5);
        clickOnTodayReport();

        WebElement allmStatusADI = driver.findElement(By.xpath(".//a[text()='All M Status ADI']"));
        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(allmStatusADI);
        allmStatusADI.click();

        System.out.println("\n> All M Status ADI Was Selected Successfully.");
    }

    public void clickOnGenerateAllmStatusADIReport() {
        WebElement generateAllmStatusADI = driver.findElement(By.xpath(".//span[text()='Generate']/../../button"));

        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(generateAllmStatusADI);
        generateAllmStatusADI.click();

        System.out.println("\n> All M Status ADI Report Was Generated Successfully.");
    }

    public void clickOnItemNotCompleted() {
        wait.setSecondsToWait(10);
        clickOnTodayReport();

        WebElement itemNotCompleted = driver.findElement(By.xpath(".//a[text()='#11 - Items not complete by NE Location']"));
        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(itemNotCompleted);
        itemNotCompleted.click();

        System.out.println("\n> Items not complete by NE Location Was Selected Successfully.");
    }

    public void selectDateRangeGenerateReport() {
        WebElement dateRangeItemsNotCompleted = driver.findElement(By.xpath(".//td[text()='Date Range:']/../td[2]/table/tbody/tr[3]/td/input"));
        WebElement generateItemsNotCompleted = driver.findElement(By.xpath(".//span[text()='Generate']/../../button"));

        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(dateRangeItemsNotCompleted);
        dateRangeItemsNotCompleted.click();
        generateItemsNotCompleted.click();

        System.out.println("\n> Items not complete by NE Location Report Was Generated Successfully.");
    }

    public void clickOnDueAndOpen() {
        wait.setSecondsToWait(2);
        clickOnTodayReport();

        WebElement countDueAndOpen = driver.findElement(By.xpath(".//a[text()='Count of Due and Open Items for Today']"));
        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(countDueAndOpen);
        countDueAndOpen.click();

        System.out.println("\n> Count of Due and Open Items for Today Was Selected Successfully.");
    }

    public void clickOnGenerateDueAndOpen() {
        WebElement generateDueAndOpen = driver.findElement(By.xpath(".//span[text()='Generate']/../../button"));

        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(generateDueAndOpen);
        generateDueAndOpen.click();

        System.out.println("\n> Count of Due and Open Items for Today Report Was Generated Successfully.");
    }

    public void clickOnMissedWotReport() {
        wait.setSecondsToWait(2);
        clickOnTodayReport();

        WebElement missedWotReport = driver.findElement(By.xpath(".//a[text()='Missed WOT Report ENPCT']"));
        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(missedWotReport);
        missedWotReport.click();

        System.out.println("\n> Missed WOT Report ENPCT Was Selected Successfully.");
    }

    public void clickOnGenerateMissedWotReport() {
        WebElement generateMissedWotReport = driver.findElement(By.xpath(".//span[text()='Generate']/../../button"));

        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(generateMissedWotReport);
        generateMissedWotReport.click();

        System.out.println("\n> Missed WOT Report ENPCT Report Was Generated Successfully.");
    }

    public void clickOnDailyWorkStatus() {
        wait.setSecondsToWait(2);
        clickOnTodayReport();

        WebElement dailyWorkStatus = driver.findElement(By.xpath(".//a[text()='Daily Work Status']"));

        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(dailyWorkStatus);
        dailyWorkStatus.click();

        System.out.println("\n> Daily Work Status Was Selected Successfully.");
    }

    public void selectDateRangeAndGenerateReport() {
        WebElement dateRangeDailyWorkStatus = driver.findElement(By.xpath(".//td[text()='Date Range:']/../td[2]/table/tbody/tr[2]/td/input"));
        WebElement generateDailyWorkStatusReport = driver.findElement(By.xpath(".//span[text()='Generate']/../../button"));

        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(dateRangeDailyWorkStatus);
        dateRangeDailyWorkStatus.click();
        generateDailyWorkStatusReport.click();

        System.out.println("\n> Daily Work Status Report Was Generated Successfully.");
    }
}
