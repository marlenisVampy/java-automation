package com.verizon.netassist.enpct.healthcheck.pages;

import com.verizon.util.Wait;
import com.verizon.webdrivers.option.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by vjean on 8/21/2017.
 */
@SuppressWarnings("ALL")
public class EnpctHomeAdministrationPage {

    private WebDriverFacade driver;
    private Wait wait = new Wait();
    private String validUser = "JEANVL";

    public EnpctHomeAdministrationPage(WebDriverFacade driver) {
        this.driver = driver;
    }

    public void clickOnAdministrationHome() {
        wait.setSecondsToWait(6);
        WebElement administrationHome = driver.findElement(By.xpath(".//a[text()='Administration']/../../li[4]"));

        wait.untilElementIsClickable(administrationHome);
        try {
            administrationHome.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        System.out.println("\n> Administration Was Successfully Selected!");
    }

    public void clickOnNPCCenters() {
        WebElement nPCCenters = driver.findElement(By.xpath(".//span[text()='NPC Centers']/../../button[1]"));

        wait.setSecondsToWait(3);
        wait.untilElementIsClickable(nPCCenters);
        try {
            nPCCenters.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public boolean iSeNPCCentersValid() {
        wait.setSecondsToWait(3);
        WebElement validateNPCCenters = driver.findElement(By.xpath(".//span[text()='Administration - Centers - NPC Center']/../../td/span"));

        System.out.println("\n> WFA NPC Centers was Selected Successfully.");
        return validateNPCCenters.getText().toString().contains("Administration - Centers - NPC Center");
    }

    public String showNPCCentersRecords() {
        wait.setSecondsToWait(5);
        WebElement showNPCCentersRecords = driver.findElement(By.xpath(".//*[@id='frmCenter:message']/div/ul/li/span[2]"));

        wait.setSecondsToWait(5);
        wait.untilElementIsOnScreen(showNPCCentersRecords);
        return showNPCCentersRecords.getText();
    }

    public void createNewCenter() {
        WebElement newCenter = driver.findElement(By.xpath(".//span[text()='New Center']/../../button[1]"));
        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(newCenter);
        try {
            newCenter.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void enterDummyDataNewCenterUser() throws Exception {
        WebElement centerName = driver.findElement(By.xpath(".//td[text()='Center Name:']/../td[2]/input"));
        WebElement phoneNumber = driver.findElement(By.xpath(".//td[text()='Phone Number:']/../td[2]/input"));
        WebElement pageSubject = driver.findElement(By.xpath(".//td[text()='Pager Subject:']/../td[2]/input"));
        WebElement pageContent = driver.findElement(By.xpath(".//td[text()='Pager Content:']/../td[2]/input"));
        WebElement textMessageFrom = driver.findElement(By.xpath(".//td[text()='Text Message From:']/../td[2]/input"));
        WebElement checkBoxYesOne = driver.findElement(By.xpath(".//td[text()='WFA/DI Disaster Recovery Enabled:']/../td[2]/table/tbody/tr/td[1]/div/div[2]/span"));
        WebElement checkBoxYesTwo = driver.findElement(By.xpath(".//td[text()='Auto Escalation Paging:']/../td[2]/table/tbody/tr/td[1]/div/div[2]/span"));

        try {
            centerName.sendKeys("TODAYTEST");
            phoneNumber.sendKeys("555555555");
            pageSubject.sendKeys("11");
            pageContent.sendKeys("whatever_11");
            textMessageFrom.sendKeys("THIS_COMPANY");

            checkBoxYesOne.click();
            checkBoxYesTwo.click();

        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void clickOnOptionCenterRegionWest(String WEST) {

        WebElement dropDownCenterRegion = driver.findElement(By.xpath(".//td[text()='Center Region:']/../td[2]/div/div[3]/span"));
        dropDownCenterRegion.click();
        List<WebElement> options = driver.findElements(By.xpath(".//li[text()='WEST']/../li"));

        for (WebElement opt : options) {
            if (opt.getText().equals(WEST)) {
                opt.click();
                return;
            }
        }
        throw new NoSuchElementException("can' find " + WEST + "in dropdown ");
    }

    public void clickOnOptionTimeZone(String EDT) {
        WebElement dropDownTimezone = driver.findElement(By.xpath(".//td[text()='Time Zone:']/../td[2]/div/div[3]/span"));
        dropDownTimezone.click();
        List<WebElement> options = driver.findElements(By.xpath(".//li[text()='EDT - EASTERN']/../li"));

        for (WebElement opt : options) {
            if (opt.getText().equals(EDT)) {
                opt.click();
                return;
            }
        }
        throw new NoSuchElementException("can' find " + EDT + "in dropdown ");
    }

    public void clickAddNewCenters() {
        WebElement clickAdd = driver.findElement(By.xpath(".//span[text()='Add']/../../button[1]"));
        clickAdd.click();
        System.out.println("\n> New Center Created Successfully.");
    }

    public String confirmMessage() {
        WebElement confirmationMessage = driver.findElement(By.xpath(".//*[@id='frmCenter:contentListUpdate']/table/tbody/tr[2]/td/label"));
        wait.setSecondsToWait(2);
        wait.untilElementIsOnScreen(confirmationMessage);
        return confirmationMessage.getText();
    }

    public void closeCreateCenterWindow() {
        wait.setSecondsToWait(2);
        WebElement closeWindow = driver.findElement(By.xpath("//div[@id='frmCenter:wvDialog']/div/a/span"));
        wait.untilElementIsClickable(closeWindow);
        try {
            closeWindow.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void clickOnReloadNpcCenters() {
        WebElement reloadNpcCenters = driver.findElement(By.xpath(".//span[text()='Reload NPC Centers']/../../button[2]"));
        wait.setSecondsToWait(1);
        wait.untilElementIsClickable(reloadNpcCenters);
        reloadNpcCenters.click();
    }

    public void clickOnWorkType() {
        WebElement workType = driver.findElement(By.xpath(".//span[text()='Work Type']/../../button[2]"));
        wait.setSecondsToWait(5);
        wait.untilElementIsClickable(workType);
        try {
            workType.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public boolean validateWorkType() {
        WebElement validateWorkType = driver.findElement(By.xpath(".//span[text()='Administration - Centers - Work Type']/../span"));
        System.out.println("\n> Work Type Selected Successfully.");
        return validateWorkType.getText().toString().contains("Work Type");
    }

    public void createNewWorkType() {
        WebElement newWorkType = driver.findElement(By.xpath(".//span[text()='New Work Type']/../../button"));

        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(newWorkType);
        try {
            newWorkType.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void enterDummyDataNewWorkType() {
        WebElement workTypedata = driver.findElement(By.xpath(".//b[text()='Work Type:']/../../td[2]/input"));
        WebElement workCodeDropdown = driver.findElement(By.xpath(".//td[text()='Work Code:']/../td[2]/../td[2]/select"));
        WebElement optionWorkCode = driver.findElement(By.xpath(".//option[text()='GP']/../option[7]"));
        WebElement shortDescription = driver.findElement(By.xpath(".//td[text()='Short Description:']/../td[2]/input"));
        WebElement longDescription = driver.findElement(By.xpath(".//td[text()='Long Description:']/../td[2]/textarea"));
        WebElement categoryDropdown = driver.findElement(By.xpath(".//td[text()='Category:']/../td[2]/select"));
        WebElement optionCategory = driver.findElement(By.xpath(".//option[text()='MN']/../option[5]"));
        WebElement priority = driver.findElement(By.xpath(".//td[text()='Priority:']/../td[2]/input"));
        WebElement colorDropdown = driver.findElement(By.xpath(".//td[text()='Color:']/../td[2]/select"));
        WebElement optionColor = driver.findElement(By.xpath(".//option[text()='GREEN']/../option[2]"));
        WebElement addButton = driver.findElement(By.xpath(".//span[text()='Add']/../../button[1]"));

        wait.setSecondsToWait(2);
        wait.untilElementIsOnScreen(workTypedata);
        try {
            workTypedata.sendKeys("ZTEST");
            workCodeDropdown.click();
            optionWorkCode.click();
            shortDescription.sendKeys("ZTESTShortdesc");
            longDescription.sendKeys("ZTESTLONGdesc");
            categoryDropdown.click();
            optionCategory.click();
            priority.sendKeys("1");
            colorDropdown.click();
            optionColor.click();
            addButton.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public String duplicateWorkTypeMessage() {
        wait.setSecondsToWait(4);
        WebElement confirmationMessage = driver.findElement(By.xpath(".//*[@id='frmCenter:contentListUpdate']/table/tbody/tr[2]/td/label"));
        WebElement workTypeMessage = driver.findElement(By.xpath("//*[@id='frmCenter:contentListUpdate']/table/tbody/tr[2]/td/label"));


        wait.untilElementIsOnScreen(confirmationMessage);
        return workTypeMessage.getText();
    }

    public void closeNewWorkTypeWindow() {
        WebElement closeNewWorkTypeWindow = driver.findElement(By.xpath(".//span[text()='Cancel']/../../button[3]"));

        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(closeNewWorkTypeWindow);
        closeNewWorkTypeWindow.click();
    }

    public void clickOnTem_Clusters() {

        WebElement tem_Clusters = driver.findElement(By.xpath(".//span[text()='Clusters']/../../button[1]/span[2]"));

        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(tem_Clusters);
        try {
            tem_Clusters.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        System.out.println("\n> TEMS Clusters was Selected Successfully.");
    }

    public boolean is_tem_ClustersValid() {
        WebElement tem_ClustersValidation = driver.findElement(By.xpath(".//span[text()='Administration - Clusters']/../span"));
        System.out.println("\n> Administration Clusters Was Successfully Selected.");
        return tem_ClustersValidation.getText().toString().contains("Clusters");
    }

    public String showTotalClusters() {
        WebElement totalClusters = driver.findElement(By.xpath(".//*[@id='frmCenter:message']/div/ul/li/span[2]"));
        return totalClusters.getText();
    }

    public void createNewCluster() {
        WebElement newCluster = driver.findElement(By.xpath(".//span[text()='New Cluster']/../../button[1]"));
        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(newCluster);
        try {
            newCluster.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void enterDummyDataNewClusters() {
        WebElement clusters = driver.findElement(By.xpath(".//b[text()='Cluster:']/../../td[2]/input"));
        WebElement clustersDescription = driver.findElement(By.xpath(".//td[text()='Description:']/../td[2]/input"));

        wait.setSecondsToWait(1);
        wait.untilElementIsOnScreen(clusters);
        clusters.sendKeys("111");
        clustersDescription.sendKeys("TEST-159");
    }

    public void clickToEnterDummyDataNewClusters() {
        WebElement keystone = driver.findElement(By.xpath(".//span[text()='KEYSTONE']/../../div/div[2]/span"));
        WebElement deflm = driver.findElement(By.xpath(".//span[text()='DEFLM']/../../div/div[2]/span"));
        WebElement njflm = driver.findElement(By.xpath(".//span[text()='NJFLM']/../../div/div[2]/span"));
        WebElement deddm = driver.findElement(By.xpath(".//span[text()='DEDDM']/../../div/div[2]/span"));
        WebElement test = driver.findElement(By.xpath(".//span[text()='TEST']/../../div/div[2]/span"));
        WebElement madison = driver.findElement(By.xpath(".//span[text()='MADISON']/../../div/div[2]/span"));
        WebElement nydstdcs = driver.findElement(By.xpath(".//span[text()='NYDSTDCS']/../../div/div[2]/span"));
        WebElement emptyCenter = driver.findElement(By.xpath(".//span[text()='EMPTY CENTER']/../../div/div[2]/span"));
        WebElement philadelphia = driver.findElement(By.xpath(".//span[text()='PHILADELPHIA']/../../div/div[2]/span"));
        WebElement addCluster = driver.findElement(By.xpath(".//span[text()='Add']/../../button[1]"));
        WebElement optionUpdate = driver.findElement(By.xpath(".//span[text()='Update']/../../button[1]"));

        wait.setSecondsToWait(2);
        //wait.untilElementIsClickable(keystone);

        keystone.click();
        deflm.click();
        njflm.click();
        deddm.click();
        test.click();
        madison.click();
        nydstdcs.click();
        emptyCenter.click();
        philadelphia.click();
        addCluster.click();

        if (showClusterMessage().contains("already exist.")) {
            optionUpdate.click();
            System.out.println("\n> Cluster Updated.");
        } else {
            System.out.println("\n> Could not Create New Cluster.");
        }
    }

    public String showClusterMessage() {
        WebElement clusterMessage = driver.findElement(By.xpath(".//*[@id='frmCenter:contentListUpdate']/table/tbody/tr[3]/td/label"));
        wait.setSecondsToWait(2);
        wait.untilElementIsOnScreen(clusterMessage);
        return clusterMessage.getText();
    }

    public void closeClusterNewWindow() {
        WebElement closeClusterNewWindow = driver.findElement(By.xpath(".//span[text()='Cancel']/../../button[3]"));
        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(closeClusterNewWindow);
        closeClusterNewWindow.click();
    }

    public void clickOnCenters() {
        WebElement centers = driver.findElement(By.xpath(".//span[text()='Centers']/../../button[2]"));
        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(centers);
        centers.click();
    }

    public boolean isCentersOpened() {
        WebElement centersisOpened = driver.findElement(By.xpath(".//span[text()='Administration - Centers - TEMS Center List']/../span"));
        System.out.println("\n> Centers Was Successfully Selected.");
        return centersisOpened.getText().toString().contains("Centers ");
    }

    public String showTotalCenters() {
        wait.setSecondsToWait(4);
        WebElement totalCenters = driver.findElement(By.xpath(".//*[@id='frmCenter:message']/div/ul/li/span[2]"));
        wait.untilElementIsOnScreen(totalCenters);
        return totalCenters.getText();
    }

    public void createTemsNewCenter() {
        WebElement temsNewCenter = driver.findElement(By.xpath(".//span[text()='New Center']/../../button[1]"));
        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(temsNewCenter);
        temsNewCenter.click();
    }

    public void enterDummyDataNewCenter() {
        WebElement centerData = driver.findElement(By.xpath(".//b[text()='Center:']/../../td[2]/input"));
        WebElement DescriptionData = driver.findElement(By.xpath(".//td[text()='Description:']/../td[2]/input"));
        WebElement AreaData = driver.findElement(By.xpath(".//td[text()='Area:']/../td[2]/input"));
        WebElement typeData = driver.findElement(By.xpath(".//td[text()='Type:']/../td[2]/input"));
        WebElement sortData = driver.findElement(By.xpath(".//td[text()='Sort:']/../td[2]/input"));
        WebElement activeNoData = driver.findElement(By.xpath(".//td[text()='Active:']/../td/table/tbody/tr/td[3]/div[1]/div/span"));

        wait.setSecondsToWait(2);
        wait.untilElementIsOnScreen(centerData);
        try {
            centerData.sendKeys("CenterTest");
            DescriptionData.sendKeys("Center Test Description");
            AreaData.sendKeys("AREA51");
            typeData.sendKeys("T-CENTER01");
            sortData.sendKeys("6");
            activeNoData.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        System.out.println("\n> Data Entered");
    }

    public void scrollPageDown() {
        WebElement ele = driver.findElement(By.xpath(".//span[text()='Add']/../../button[1]/span"));
        driver.scrollToElement(ele);
    }

    public void clickOnAdd() {
        wait.setSecondsToWait(3);
        WebElement addCenterButton = driver.findElement(By.xpath(".//span[text()='Add']/../../button[1]/span"));
        wait.untilElementIsClickable(addCenterButton);
        addCenterButton.click();
        System.out.println("\n> Data Added");
    }

    public String showByName() {
        wait.setSecondsToWait(2);
        WebElement byNameMessage = driver.findElement(By.xpath(".//span[text()='Update']/../../../../tr[2]/td/label"));
        wait.untilElementIsOnScreen(byNameMessage);
        return byNameMessage.getText();
    }

    public String showAddMessage() {
        wait.setSecondsToWait(2);
        WebElement addedMessage = driver.findElement(By.xpath(".//span[text()='Update']/../../../../tr[3]/td/label"));
        wait.untilElementIsOnScreen(addedMessage);
        return addedMessage.getText();
    }

    public void closeCenterNew() {
        wait.setSecondsToWait(1);
        WebElement closecenterNew = driver.findElement(By.xpath(".//span[text()='Add/Update Center']/../span/../a/span"));
        closecenterNew.click();
    }

    public void clickReloadCenterList() {
        WebElement reloadCenterList = driver.findElement(By.xpath("// .//span[text()='Reload Center List']/../../button[2]"));
        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(reloadCenterList);
        reloadCenterList.click();
    }

    public void clickOnCategories() {
        wait.setSecondsToWait(8);
        WebElement categories = driver.findElement(By.xpath(".//span[text()='Categories']/../../button[1]"));
        wait.untilElementIsClickable(categories);
        categories.click();
    }

    public boolean isCategoriesValid() {
        WebElement validateCategories = driver.findElement(By.xpath(".//span[text()='Administration - Disposition - Categories']/../span"));
        System.out.println("\n> Categories Was Successfully Selected.");
        return validateCategories.getText().toString().contains("Categories");
    }

    public String showTotalCategories() {
        wait.setSecondsToWait(4);
        WebElement totalCategories = driver.findElement(By.xpath(".//*[@id='frmCenter:message']/div/ul/li/span[2]"));
        wait.untilElementIsOnScreen(totalCategories);
        return totalCategories.getText();
    }

    public void createNewCategory() {
        WebElement newcategory = driver.findElement(By.xpath(".//span[text()='New Category']/../../button[1]"));
        wait.setSecondsToWait(4);
        wait.untilElementIsClickable(newcategory);
        newcategory.click();
    }

    public void enterDummyDataNewCategory() {
        WebElement categoryData = driver.findElement(By.xpath(".//b[text()='Category:']/../../td[2]/input"));
        WebElement descriptionData = driver.findElement(By.xpath(".//td[text()='Description:']/../td[2]/input"));
        WebElement addCategory = driver.findElement(By.xpath(".//span[text()='Add']/../../button[1]"));

        wait.setSecondsToWait(4);
        wait.untilElementIsOnScreen(categoryData);

        categoryData.sendKeys("NewTest2017");
        descriptionData.sendKeys("Description TEST2017");

        addCategory.click();

        System.out.println("\n> New Category created.");
    }

    public String addedBy() {
        WebElement addedby = driver.findElement(By.xpath(".//*[@id='frmCenter:opAdminDispositionCategoriesListUpdate']/table/tbody/tr[2]/td/label"));
        wait.setSecondsToWait(2);
        wait.untilElementIsOnScreen(addedby);
        return addedby.getText();
    }

    public String showCategoryAddedMessage() {
        WebElement categoryAddedMessage = driver.findElement(By.xpath(".//*[@id='frmCenter:opAdminDispositionCategoriesListUpdate']/table/tbody/tr[3]/td/label"));
        wait.setSecondsToWait(2);
        wait.untilElementIsOnScreen(categoryAddedMessage);
        return categoryAddedMessage.getText();
    }

    public void closeNewCategory() {
        WebElement closeNewCategory = driver.findElement(By.xpath(".//span[text()='Cancel']/../../button[3]"));
        wait.setSecondsToWait(3);
        wait.untilElementIsClickable(closeNewCategory);
        closeNewCategory.click();
    }

    public void clickOnReloadDispositionCategories() {
        WebElement reloadDispositionCateories = driver.findElement(By.xpath(".//span[text()='Reload Disposition Categories']/../../button[2]"));
        wait.setSecondsToWait(3);
        wait.untilElementIsClickable(reloadDispositionCateories);
        reloadDispositionCateories.click();
    }

    public void clickOnCodes() {
        WebElement codes = driver.findElement(By.xpath(".//span[text()='Codes']/../../button[2]"));
        wait.setSecondsToWait(3);
        wait.untilElementIsClickable(codes);
        codes.click();
    }

    public boolean isCodesValid() {
        WebElement validateCodes = driver.findElement(By.xpath(".//span[text()='Administration - Disposition - Codes']/../span"));
        wait.setSecondsToWait(3);
        wait.untilElementIsOnScreen(validateCodes);
        System.out.println("\n> Codes Was Successfully Selected.");
        return validateCodes.getText().toString().contains("Codes");
    }

    public String showTotalCodes() {
        WebElement totalCodes = driver.findElement(By.xpath(".//*[@id='frmCenter:message']/div/ul/li/span[2]"));
        wait.setSecondsToWait(2);
        wait.untilElementIsOnScreen(totalCodes);
        return totalCodes.getText();
    }

    public void createNewCodes() {
        WebElement createNewCodes = driver.findElement(By.xpath(".//span[text()='New Code']/../../button[1]"));
        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(createNewCodes);
        createNewCodes.click();
    }

    public void enterDummyDataNewCode() {
        WebElement CodeInput = driver.findElement(By.xpath(".//b[text()='Code:']/../../td[2]/input"));
        WebElement DescriptionInput = driver.findElement(By.xpath(".//td[text()='Description:']/../td[2]/input"));
        WebElement longDescriptionCode = driver.findElement(By.xpath(".//td[text()='Long Description:']/../td[2]/textarea"));
        WebElement dispositionCategory = driver.findElement(By.xpath(".//td[text()='Disposition Category:']/../td[2]/input"));
        WebElement active = driver.findElement(By.xpath(".//td[text()='Active:']/../td[2]/input"));
        WebElement addNewCode = driver.findElement(By.xpath(".//span[text()='Add']/../../button[1]"));

        wait.setSecondsToWait(3);
        wait.untilElementIsOnScreen(CodeInput);

        CodeInput.sendKeys("C0123");
        DescriptionInput.sendKeys("NEW EQUIPMENT TEST");
        longDescriptionCode.sendKeys("New Equipment Ready for Test");
        dispositionCategory.sendKeys("New Category");

        active.click();
        driver.scrollToElement(addNewCode);
        addNewCode.click();
    }

    public String showCodeaddedBy() {
        WebElement codeaddedBy = driver.findElement(By.xpath(".//*[@id='frmCenter:contentListUpdate']/table/tbody/tr[2]/td/label"));
        wait.setSecondsToWait(2);
        wait.untilElementIsOnScreen(codeaddedBy);
        return codeaddedBy.getText();
    }

    public String showCodeAddedMessage() {
        WebElement codeAddedMessage = driver.findElement(By.xpath(".//*[@id='frmCenter:contentListUpdate']/table/tbody/tr[3]/td/label"));
        wait.setSecondsToWait(2);
        wait.untilElementIsOnScreen(codeAddedMessage);
        return codeAddedMessage.getText();
    }

    public void closeNewCode() {
        WebElement closeNewCode = driver.findElement(By.xpath(".//span[text()='Cancel']/../../button[3]"));
        wait.setSecondsToWait(3);
        wait.untilElementIsClickable(closeNewCode);
        closeNewCode.click();
    }

    public void clickOnReloadDispositioncodes() {
        WebElement reloadDispositioncodes = driver.findElement(By.xpath(".//span[text()='Reload Disposition Codes']/../../button[2]"));
        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(reloadDispositioncodes);
        reloadDispositioncodes.click();
    }

    public void clickOnList() {
        wait.setSecondsToWait(8);
        WebElement list = driver.findElement(By.xpath(".//span[text()='List']/../../button[1]/span[2]"));
        wait.untilElementIsClickable(list);
        list.click();
    }

    public boolean isListValid() {
        WebElement validateList = driver.findElement(By.xpath(".//span[text()='Administration - User - List']/../span"));
        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(validateList);
        System.out.println("\n> List Was Selected Successfully.");
        return validateList.getText().toString().contains("List");
    }

    public void searchForValidUser() {
        WebElement searchForValidUser = driver.findElement(By.xpath(".//span[text()='Find']/../../script/../input"));
        wait.setSecondsToWait(2);
        wait.untilElementIsOnScreen(searchForValidUser);
        searchForValidUser.sendKeys(validUser);
        System.out.println("\n> Search performed.");
    }

    public void findValidUser() {
        WebElement findValidUser = driver.findElement(By.xpath(".//span[text()='Find']/../../button[1]"));
        wait.setSecondsToWait(2);
        wait.untilElementIsClickable(findValidUser);
        findValidUser.click();
    }

    public void clickOnUserGroup() {
        WebElement userGroup = driver.findElement(By.xpath(".//span[text()='User Group']/../../button[1]/span[2]"));
        wait.setSecondsToWait(4);
        wait.untilElementIsClickable(userGroup);
        userGroup.click();
    }

    public boolean isUsergroupValid() {
        WebElement validateUserGroup = driver.findElement(By.xpath("//span[text()='Administration - User - User Groups']/../span"));
        wait.setSecondsToWait(2);
        wait.untilElementIsOnScreen(validateUserGroup);
        System.out.println("\n> User Group Was Selected Successfully.");
        return validateUserGroup.getText().toString().contains("User Groups");
    }
}
