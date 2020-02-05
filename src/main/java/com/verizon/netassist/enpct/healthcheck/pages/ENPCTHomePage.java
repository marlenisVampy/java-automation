package com.verizon.netassist.enpct.healthcheck.pages;

import com.verizon.util.DateTime;
import com.verizon.util.Wait;
import com.verizon.webdrivers.option.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

/**
 * Created by vjean on 8/17/2017.
 */
@SuppressWarnings({"ALL", "FieldCanBeLocal"})
public class ENPCTHomePage extends DateTime {

    public static WebDriverFacade driver;
    private Wait wait = new Wait();
    //Dummy data
    private String clo = "WAS069297001";  //"CFS003168001";
    private String fakeClo = "NOCLO1234567";
    private String date = "1/1/11";

    public ENPCTHomePage(WebDriverFacade driver) {
        this.driver = driver;
    }

    public void clickOnItem_maintenance() {
        WebElement item_maintenance = driver.findElement(By.xpath(".//a[text()='Item Maintenance']/../../li[3]/a"));
        item_maintenance.click();
    }

    public boolean isPageOpened() {
        WebElement heading = driver.findElement(By.xpath(".//*[@id='j_idt13']/h5/strong"));
        wait.setSecondsToWait(2);
        wait.untilElementIsOnScreen(heading);
        System.out.println("\n> Successfully LoggedIn to " + driver.getTitle() + " Homepage.");
        return heading.getText().toString().contains("Welcome");
    }

    public String showLoginAs() {
        WebElement loginAs = driver.findElement(By.tagName("h5"));
        return loginAs.getText().toUpperCase();
    }

    public void enterSearchWithValidCLO() {
        wait.setSecondsToWait(4);
        WebElement searchWithValidCLO = driver.findElement(By.xpath(".//th[text()='CLO']/../td[1]/input"));
        wait.untilElementIsOnScreen(searchWithValidCLO);
        try {
            searchWithValidCLO.clear();
            searchWithValidCLO.sendKeys(clo);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void selectAcceptedState() {
        WebElement acceptedState = driver.findElement(By.xpath(".//th[text()='State']/../td[2]/select/option[2]"));
        wait.untilElementIsClickable(acceptedState);
        acceptedState.click();
    }

    public void clickOnQueryNormal() {
        wait.setSecondsToWait(7);
        WebElement queryNoraml = driver.findElement(By.xpath(".//span[text()='Normal']/../../button[2]/span[2]"));
        wait.untilElementIsClickable(queryNoraml);
        try {
            queryNoraml.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void resetNormalQuery() {
        WebElement resetNormalQuery = driver.findElement(By.xpath(".//span[text()='Reset']/../../button/span"));
        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(resetNormalQuery);
        resetNormalQuery.click();
    }

    public void enterSearchWithInvalidCLO() {
        wait.setSecondsToWait(4);
        WebElement searchWithInValidCLO = driver.findElement(By.xpath(".//th[text()='CLO']/../td[1]/input"));
        try {
            searchWithInValidCLO.sendKeys(fakeClo);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        System.out.println("\n> Search with invalid CLO performed Successfully.");
    }

    public String showQueryNormalInvalidCLOSearchError() {
        WebElement queryNormalInvalidCLOSearchError = driver.findElement(By.xpath(".//*[@id='frmCenter:messages']/div/ul/li/span[2]"));
        wait.setSecondsToWait(2);
        wait.untilElementIsOnScreen(queryNormalInvalidCLOSearchError);
        return queryNormalInvalidCLOSearchError.getText().toUpperCase();
    }

    public void clickOnSubmitCLO() {
        wait.setSecondsToWait(3);
        WebElement submitCLO = driver.findElement(By.xpath(".//span[text()='Submit']/../../button/span"));

        wait.untilElementIsClickable(submitCLO);
        try {
            submitCLO.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public boolean isSearchCompleted() {
        wait.setSecondsToWait(3);
        WebElement searchCompleted = driver.findElement(By.xpath(".//*[@id='frmCenter:j_idt230']/tbody/tr[1]/td[2]"));

        wait.untilElementIsOnScreen(searchCompleted);
        System.out.println("\n> You Searched for CLO #: " + searchCompleted.getText().toUpperCase());
        System.out.println("\n> Search Completed Successfully.");
        return searchCompleted.getText().toString().contains(clo);
    }

    public void clickOnNext() {
        wait.setSecondsToWait(5);
        for (int i = 0; i <= 5; i++) {
            wait.setSecondsToWait(8);
            WebElement next = driver.findElement(By.xpath(".//span[text()='Next >']/../../button[2]"));
            wait.untilElementIsClickable(next);
            next.click();
            System.out.println("\n> Next is clicked.");
        }
    }

    public void clickOnRefresh() {
        wait.setSecondsToWait(8);
        WebElement refresh = driver.findElement(By.xpath(".//span[text()='Refresh']/../../button[3]"));
        wait.untilElementIsClickable(refresh);
        refresh.click();
        System.out.println("\n> Refresh is clicked.");
    }

    public void clickOnUpdate() {
        wait.setSecondsToWait(7);
        WebElement update = driver.findElement(By.xpath(".//span[text()='Update']/../../button[4]"));
        wait.untilElementIsClickable(update);
        update.click();
        System.out.println("\n> Update is clicked.");
    }

    public void clickOnViewDesignedCircuit() {
        wait.setSecondsToWait(6);
        WebElement viewDesignedCircuit = driver.findElement(By.xpath(".//span[text()='View Designed Circuit']/../../button[9]"));
        wait.untilElementIsClickable(viewDesignedCircuit);
        viewDesignedCircuit.click();
        System.out.println("\n> View Designed Circuit is clicked.");
    }

    public void closePopupWindow() {
        wait.setSecondsToWait(2);
        WebElement popUpWindow = driver.findElement(By.xpath(".//span[text()='WORD DISPLAY (OWDDOC)']/../a/span"));
        if (popUpWindow != null) {
            popUpWindow.click();
            System.out.println("\n> Pop up Window is closed.");
        } else {

        }
    }

    public void clickOnViewTfas() {
        wait.setSecondsToWait(5);
        WebElement viewTfas = driver.findElement(By.xpath(".//span[text()='View TFAS']/../../button[10]"));
        wait.untilElementIsClickable(viewTfas);
        viewTfas.click();
        System.out.println("\n> View TFAS is clicked.");
    }

    public void clickOnReQuery() {
        wait.setSecondsToWait(7);
        WebElement reQuery = driver.findElement(By.xpath(".//span[text()='ReQuery']/../../button[8]"));
        wait.untilElementIsClickable(reQuery);
        reQuery.click();
        System.out.println("\n> ReQuery is clicked.");
    }

    public void clickOnHold() {
        wait.setSecondsToWait(5);
        WebElement hold = driver.findElement(By.xpath(".//span[text()='Hold']/../../button[7]"));
        wait.untilElementIsClickable(hold);
        hold.click();
        System.out.println("\n> Hold is clicked.");
    }

    public void clickOnAccept() {
        wait.setSecondsToWait(5);
        WebElement accept = driver.findElement(By.xpath(".//span[text()='Accept']/../../button[4]"));
        wait.untilElementIsClickable(accept);
        accept.click();
        System.out.println("\n> Accept is clicked.");
    }

    public void clickOnReOpen() {
        wait.setSecondsToWait(4);
        WebElement reOpen = driver.findElement(By.xpath(".//span[text()='ReOpen']/../../button[6]"));
        wait.untilElementIsClickable(reOpen);
        reOpen.click();
        System.out.println("\n> ReOpen is clicked.");
        clickOnAccept();
    }

    public void performAllClickOptionsOne() {
        wait.setSecondsToWait(3);
        clickOnNext();
        clickOnRefresh();
        clickOnUpdate();
        clickOnViewDesignedCircuit();
        closePopupWindow();
        clickOnViewTfas();
        clickOnReQuery();
        clickOnHold();
        clickOnAccept();
        clickOnReOpen();
    }

    //This will make the CLO inaccessible by completing its status
    public void clickOnComplete() {
        wait.setSecondsToWait(2);
        WebElement complete = driver.findElement(By.xpath(".//span[text()='Complete']/../../button[5]"));
        wait.untilElementIsClickable(complete);
        complete.click();
        System.out.println("\n> Complete is clicked.");
    }

    public void clickOnQueryFuture() {
        wait.setSecondsToWait(2);
        WebElement queryFuture = driver.findElement(By.xpath(".//span[text()='Future']/../../button[3]"));
        queryFuture.click();
    }

    public boolean isQueryFutureValid() {
        WebElement validateQueryFuture = driver.findElement(By.id("frmCenter:j_idt1123"));
        System.out.println("\n> Query Future was Selected Successfully.");
        return validateQueryFuture.getText().toString().contains("Future");
    }

    public static String showFutureDate() {
        WebElement getFutureDate = driver.findElement(By.xpath(".//*[@id='frmCenter:j_idt2111_input']"));
        return getFutureDate.getAttribute("value");
    }

    public static void compareDate() {

        if (getLocalDate().compareTo(showFutureDate()) < 0) {
            System.out.println("\n> Query Future Date is greater than current date. " + "(" + showFutureDate() + " > " + getLocalDate() + ")");
        } else {
            System.out.println("\n> Current date is: " + getCurrentDateAndTime());
        }
    }

    public boolean isQueryFutureStateValid() {
        WebElement validateQueryFutureState = driver.findElement(By.xpath(".//*[@id='frmCenter:j_idt1123']/tbody/tr[2]/td/center/table[1]/tbody/tr[6]/td[2]"));
        System.out.println("\n> Query Future State is 'Open'.");
        return validateQueryFutureState.getText().toString().contains("Open");
    }

    public void clearFutureDate() {
        wait.setSecondsToWait(1);
        WebElement getFutureDate = driver.findElement(By.xpath(".//*[@id='frmCenter:j_idt2111_input']"));
        getFutureDate.clear();
    }

    public void searchQueryFutureWithAvalidCLO() {
        wait.setSecondsToWait(2);
        WebElement queryFutureSearchWithValidCLO = driver.findElement(By.xpath(".//*[@id='frmCenter:j_idt1123']/tbody/tr[2]/td/center/table[1]/tbody/tr[1]/td[1]/input"));
        clearFutureDate();
        queryFutureSearchWithValidCLO.sendKeys(clo);
    }

    public void clickOnQueryFutureSubmitButton() {
        wait.setSecondsToWait(1);
        WebElement queryFutureSubmitButton = driver.findElement(By.id("frmCenter:j_idt2115"));
        queryFutureSubmitButton.click();
    }

    public boolean isQueryFutureSearchValid() {
        wait.setSecondsToWait(3);
        WebElement queryFutureSearchValidation = driver.findElement(By.xpath(".//*[@id='frmCenter:j_idt230']/tbody/tr[1]/td[2]"));
        System.out.println("\n> Query Future Search completed Successfully.");
        return queryFutureSearchValidation.getText().toString().contains(clo);
    }

    public void searchQFcrossConnect() {
        wait.setSecondsToWait(2);
        clickOnQueryFuture();
        resetQF();
        clearFutureDate();
        selectCrossConnect();
        wait.setSecondsToWait(4);
        clickOnQueryFutureSubmitButton();
    }

    public void resetQF() {
        wait.setSecondsToWait(2);
        WebElement resetQF = driver.findElement(By.xpath(".//span[text()='Reset']/../../button"));
        wait.untilElementIsClickable(resetQF);
        resetQF.click();
    }

    public void clickOnCenter() {
        wait.setSecondsToWait(2);
        WebElement clickOnCenter = driver.findElement(By.xpath(".//span[text()='Center']/../../button[4]"));
        wait.untilElementIsClickable(clickOnCenter);
        clickOnCenter.click();
    }

    public boolean isQueryCenterValid() {
        WebElement validateQueryCenter = driver.findElement(By.xpath(".//*[@id='frmCenter:j_idt2141']/tbody/tr[1]/td/span"));
        System.out.println("\n> Query Center Was Selected Successfully.");
        return validateQueryCenter.getText().toString().contains("Center");
    }

    public static String showCenterDate() {
        WebElement getCenterDate = driver.findElement(By.id("frmCenter:j_idt3126_input"));
        return getCenterDate.getAttribute("value");
    }

    public static void isCenterDateCurrent() {

        if (getLocalDate().compareTo(showCenterDate()) == 0) {
            System.out.println("\n> Center Date, " + showCenterDate() + " is equal to Current Date " + getLocalDate());
        } else {
            System.out.println("\n> Check your system time, " + getCurrentDateAndTime() + " ,it might not be updated.");
        }
    }

    public boolean isCenterStateOpen() {
        WebElement validateCenterStateisOpen = driver.findElement(By.xpath(".//*[@id='frmCenter:j_idt2141']/tbody/tr[2]/td/center/table[1]/tbody/tr[6]/td[2]"));
        System.out.println("\n> Center was Selected Successfully.");
        return validateCenterStateisOpen.getText().toString().contains("Open");
    }

    public void clickToQueryCenterSearchWithoutCLO() {
        WebElement clickToQueryCenterSearchWithoutCLO = driver.findElement(By.id("frmCenter:j_idt3128"));
        wait.untilElementIsClickable(clickToQueryCenterSearchWithoutCLO);
        try {
            clickToQueryCenterSearchWithoutCLO.click();
            System.out.println("\n> Query Center Search executed successfully without a CLO number.");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void performAllClickOptionsTwo() {

        WebElement checkForValidRecord = driver.findElement(By.xpath(".//*[@id='frmCenter:messages']/div/ul/li/span[2]"));

        if (!(checkForValidRecord.getText().toString().contains("No record found"))) {
            wait.setSecondsToWait(2);
            clickOnNext();
            clickOnRefresh();
            clickOnAccept();
            clickOnUpdate();
            clickOnViewDesignedCircuit();
            closePopupWindow();
            clickOnViewTfas();
            clickOnReQuery();
            clickOnAccept();
            clickOnHold();
            clickOnAccept();
            clickOnReOpen();
        } else {

        }
    }

    public void clickOnQueryMyProfile() {
        wait.setSecondsToWait(5);
        WebElement clickQueryMyProfile = driver.findElement(By.xpath(".//span[text()='My Profile']/../../button[5]/span[2]"));
        wait.untilElementIsClickable(clickQueryMyProfile);
        try {
            clickQueryMyProfile.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("\n> Element not found.");
        }
    }

    public boolean isQueryMyProfileValid() {
        WebElement validateQueryMyProfile = driver.findElement(By.xpath(".//*[@id='frmCenter:j_idt3154']/tbody/tr[1]/td/span"));
        System.out.println("\n> Query My Profile Was Selected Successfully!");
        return validateQueryMyProfile.getText().toString().contains("Profile");
    }

    public boolean isQueryMyProfileOpen() {
        WebElement validateQueryMyProfileIsOpen = driver.findElement(By.xpath(".//*[@id='frmCenter:j_idt3154']/tbody/tr[2]/td/center/table[1]/tbody/tr[6]/td[2]"));
        System.out.println("\n> Query My Profile State is 'Open'.");
        return validateQueryMyProfileIsOpen.getText().toString().contains("Open");
    }

    public String showQueryMyProfileDate() {
        WebElement getQueryMyProfileDate = driver.findElement(By.id("frmCenter:j_idt4139_input"));
        return getQueryMyProfileDate.getAttribute("value");
    }

    public void searchQueryMyProfileWithAvalidCLO() {
        wait.setSecondsToWait(5);
        WebElement searchQueryMyProfileWithaValidCLO = driver.findElement(By.xpath(".//*[@id='frmCenter:j_idt3154']/tbody/tr[2]/td/center/table[1]/tbody/tr[1]/td[1]/input"));
        searchQueryMyProfileWithaValidCLO.sendKeys(clo);
    }

    public void clickQueryMyProfileSubmitButton() {
        WebElement clickQueryMyProfileSubmitButton = driver.findElement(By.xpath(".//span[text()='Submit']/../../button"));
        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(clickQueryMyProfileSubmitButton);
        try {
            clickQueryMyProfileSubmitButton.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        System.out.println("\n> Query My Profile Search was performed Successfully.");
    }

    public void searchQueryMyProfileWithoutCLO() {
        wait.setSecondsToWait(5);
        WebElement searchQueryMyProfileWithOutaCLO = driver.findElement(By.xpath(".//span[text()='Reset']/../../button"));
        wait.untilElementIsClickable(searchQueryMyProfileWithOutaCLO);
        searchQueryMyProfileWithOutaCLO.click();
    }

    public void clickOnQueryWorking() {
        wait.setSecondsToWait(5);
        WebElement clickOnQueryWorking = driver.findElement(By.xpath(".//span[text()='Working']/../../button[6]"));
        wait.untilElementIsClickable(clickOnQueryWorking);
        try {
            clickOnQueryWorking.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public boolean isQueryWoringValid() {
        WebElement validateQueryWoring = driver.findElement(By.id("frmCenter:j_idt4167"));
        System.out.println("\n> Query Working Was Selected Successfully!");
        return validateQueryWoring.getText().toString().contains("Working");
    }

    public void selectCrossConnect() {
        wait.setSecondsToWait(1);
        WebElement crossConnect = driver.findElement(By.xpath(".//th[text()='Order Type']/../td[1]/select/option[1]"));
        wait.untilElementIsClickable(crossConnect);
        crossConnect.click();
    }

    public void clickOnQWsubmitButton() {
        wait.setSecondsToWait(2);
        WebElement submit = driver.findElement(By.xpath(".//span[text()='Submit']/../../button"));
        wait.untilElementIsClickable(submit);
        submit.click();
    }

    public void selectEquipment() {
        wait.setSecondsToWait(1);
        clickOnQueryWorking();
        WebElement equipment = driver.findElement(By.xpath(".//th[text()='Order Type']/../td[1]/select/option[2]"));
        wait.untilElementIsClickable(equipment);
        equipment.click();
        clickOnQWsubmitButton();
    }

    public String showEmployeeName() {
        WebElement getEmployeeName = driver.findElement(By.xpath(".//th[text()='Employee']/../td/div/div[2]/../label"));
        return getEmployeeName.getText();
    }

    public void clickOnQuerySeventyFour() {
        wait.setSecondsToWait(5);
        WebElement querySeventyFour = driver.findElement(By.xpath(".//span[text()='74']/../../button[7]"));
        wait.untilElementIsClickable(querySeventyFour);
        try {
            querySeventyFour.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public boolean isQuerySeventyFourValid() {
        wait.setSecondsToWait(3);
        WebElement validateQuerySeventyFour = driver.findElement(By.xpath(".//*[@id='frmCenter:j_idt230']/tbody/tr[5]/td[4]"));
        System.out.println("\n> Query 74 was Selected successfully!");
        return validateQuerySeventyFour.getText().toString().contains("74");
    }

    public String showQuerySeventyFourStatus() {
        WebElement validateQuerySeventyFour = driver.findElement(By.xpath(".//*[@id='frmCenter:j_idt230']/tbody/tr[5]/td[4]"));
        return validateQuerySeventyFour.getText().toUpperCase();
    }

    public void clickOnQuerySeventyFourDate() {
        wait.setSecondsToWait(3);
        WebElement querySeventyFourDate = driver.findElement(By.xpath(".//span[text()='74 Date']/../../button[8]"));
        wait.untilElementIsClickable(querySeventyFourDate);
        querySeventyFourDate.click();
    }

    public void enterQuerySeventyFourDateStartDate() {
        wait.setSecondsToWait(1);
        WebElement querySeventyFourDateStartDate = driver.findElement(By.id("frmCenter:j_idt5200_input"));
        querySeventyFourDateStartDate.clear();
        querySeventyFourDateStartDate.sendKeys(date);
        System.out.println("\n> Query 74 date set.");
    }

    public void clickOnQuerySeventyFourDateSubmitButton() {
        wait.setSecondsToWait(1);
        WebElement querySeventyFourDateSubmitButton = driver.findElement(By.id("frmCenter:j_idt5204"));
        querySeventyFourDateSubmitButton.click();
        System.out.println("\n> Query 74 date search executed successfully.");
    }

    public void clickOnQueryIandB() {
        wait.setSecondsToWait(3);
        WebElement queryIandB = driver.findElement(By.xpath(".//span[text()='I&B']/../../button[9]"));
        wait.untilElementIsClickable(queryIandB);
        try {
            queryIandB.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        System.out.println("\n> Query I&B Selected Successfully.");
    }

    public void clickOnQueryIandBDate() {
        wait.setSecondsToWait(5);
        WebElement queryIandBDate = driver.findElement(By.xpath(".//span[text()='I&B Date']/../../button[10]"));
        wait.untilElementIsClickable(queryIandBDate);
        try {
            queryIandBDate.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        System.out.println("\n> Query I&B Date Selected Successfully.");
    }

    public void enterQueryIandBDateStartDate() {
        wait.setSecondsToWait(2);
        WebElement queryIandBDateStartDate = driver.findElement(By.xpath(".//th[text()='Start Date']/../td/span/input"));
        queryIandBDateStartDate.clear();
        queryIandBDateStartDate.sendKeys(date);
        System.out.println("\n> Query I&B date is Set.");
    }

    public void clickOnQueryIandBDateSubmitButton() {
        wait.setSecondsToWait(2);
        WebElement queryIandBDateSubmitButton = driver.findElement(By.xpath(".//span[text()='Submit']/../../button[1]"));
        queryIandBDateSubmitButton.click();
        System.out.println("\n> Query I&B Date Search Executed Successfully.");
    }

    public void clickOnQueryActivity() {
        wait.setSecondsToWait(4);
        WebElement queryActivity = driver.findElement(By.xpath(".//span[text()='Activity']/../../button[11]"));
        wait.untilElementIsClickable(queryActivity);
        try {
            queryActivity.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        System.out.println("\n> Query Activity Was Selected Successfully!");
    }

    public String showQueryActivityBy() {
        wait.setSecondsToWait(1);
        WebElement queryActivityBy = driver.findElement(By.xpath(".//th[text()='By']/../td[2]/div/div[2]/select/../../label"));
        wait.untilElementIsOnScreen(queryActivityBy);
        return queryActivityBy.getText().toUpperCase();
    }

    public void clickOnQueryActivitySumitButton() {
        wait.setSecondsToWait(5);
        WebElement queryActivitySumitButton = driver.findElement(By.xpath(".//span[text()='Submit']/../../button"));
        wait.untilElementIsClickable(queryActivitySumitButton);
        try {
            queryActivitySumitButton.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void searchActivityAccept() {
        wait.setSecondsToWait(2);

        WebElement accept = driver.findElement(By.xpath(".//th[text()='Activity']/../td[1]/select/option[1]"));
        wait.untilElementIsClickable(accept);
        accept.click();
        clickOnQueryActivitySumitButton();
        System.out.println("\n> query Activity Accept search executed Successfully!");
    }

    public void searchActivityComplete() {
        wait.setSecondsToWait(4);
        clickOnQueryActivity();
        clickOnActivityResetButton();

        wait.setSecondsToWait(5);
        WebElement complete = driver.findElement(By.xpath(".//th[text()='Activity']/../td[1]/select/option[2]"));
        wait.untilElementIsClickable(complete);
        complete.click();
        clickOnQueryActivitySumitButton();
        System.out.println("\n> query Activity Complete search executed Successfully!");
    }

    public void searchActivityHold() {
        wait.setSecondsToWait(4);
        clickOnQueryActivity();
        WebElement hold = driver.findElement(By.xpath(".//th[text()='Activity']/../td[1]/select/option[3]"));
        hold.click();
        clickOnQueryActivitySumitButton();
        System.out.println("\n> query Activity Hold search executed Successfully!");
    }

    public void searchActivityOpen() {
        wait.setSecondsToWait(4);
        clickOnQueryActivity();
        WebElement open = driver.findElement(By.xpath(".//th[text()='Activity']/../td[1]/select/option[4]"));
        open.click();
        clickOnQueryActivitySumitButton();
        System.out.println("\n> query Activity Open search executed Successfully!");
    }

    public void searchActivityReOpen() {
        wait.setSecondsToWait(4);
        clickOnQueryActivity();
        WebElement reOpen = driver.findElement(By.xpath(".//th[text()='Activity']/../td[1]/select/option[5]"));
        reOpen.click();
        clickOnQueryActivitySumitButton();
        System.out.println("\n> query Activity ReOpen search executed Successfully!");
    }

    public void searchActivityUpdate() {
        wait.setSecondsToWait(4);
        clickOnQueryActivity();
        WebElement update = driver.findElement(By.xpath(".//th[text()='Activity']/../td[1]/select/option[6]"));
        update.click();
        clickOnQueryActivitySumitButton();
        System.out.println("\n> query Activity Update search executed Successfully!");
    }

    public void searchActivityVoidedComplete() {
        wait.setSecondsToWait(4);
        clickOnQueryActivity();
        WebElement vComplete = driver.findElement(By.xpath(".//th[text()='Activity']/../td[1]/select/option[7]"));
        vComplete.click();
        clickOnQueryActivitySumitButton();
        System.out.println("\n> query Activity Voided Complete search executed Successfully!");
    }

    public void performAllActivitySearch() {
        searchActivityAccept();
        searchActivityComplete();
        searchActivityHold();
        searchActivityOpen();
        searchActivityReOpen();
        searchActivityUpdate();
        searchActivityVoidedComplete();
    }

    public void clickOnActivityResetButton() {
        wait.setSecondsToWait(2);
        WebElement reset = driver.findElement(By.xpath(".//span[text()='Reset']/../../button"));
        wait.untilElementIsClickable(reset);
        reset.click();
    }
}
