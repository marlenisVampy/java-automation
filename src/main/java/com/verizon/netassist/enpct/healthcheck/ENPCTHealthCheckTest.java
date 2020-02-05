package com.verizon.netassist.enpct.healthcheck;

import com.verizon.netassist.enpct.healthcheck.pages.ENPCTHomePage;
import com.verizon.netassist.enpct.healthcheck.pages.EnpctHomeAdministrationPage;
import com.verizon.netassist.enpct.healthcheck.pages.EnpctHomeJobListPage;
import com.verizon.netassist.enpct.healthcheck.pages.EnpctHomeReportsPage;
import com.verizon.netassist.enpct.healthcheck.pages.EnpctHomeTfasMemoPage;
import com.verizon.netassist.enpct.healthcheck.pages.LoginPage;
import com.verizon.webdrivers.option.Browsers;
import com.verizon.webdrivers.option.WebDriverFacade;
import org.junit.Assert;

/**
 * Created by vjean on 8/17/2017.
 */
@SuppressWarnings("ALL")
public class ENPCTHealthCheckTest {

    public static void main(String[] args) throws Exception {

        /*  >> To Switch to a different browser   <<
         *   >> change current Browsers.****;      <<
         *   >> to, CHROME, IE, FIREFOX, PHANTOMJS <<
         */
        Browsers browser = Browsers.CHROME;
        WebDriverFacade driver = new WebDriverFacade(browser);
        driver.windowMaximize();
        driver.timespan();

        /*
          Login to Verizon Webpage
         */
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUser_ID();
        loginPage.setUser_password();
        loginPage.isPhantomSelected();

        /*
          Item Maintenance Query Normal
         */
        ENPCTHomePage homePage = new ENPCTHomePage(driver);
        Assert.assertTrue(homePage.isPageOpened());
        System.out.println("\n> " + homePage.showLoginAs());
        homePage.clickOnItem_maintenance();
        driver.takeScreenshot("Maintenance");
        homePage.enterSearchWithValidCLO();
        homePage.selectAcceptedState();
        homePage.clickOnSubmitCLO();
        Assert.assertTrue(homePage.isSearchCompleted());
        driver.takeScreenshot("SearchCompleted");
        homePage.performAllClickOptionsOne();
        //homePage.clickOnComplete();
        driver.takeScreenshot("QueryNormalValidCLOSearch");
        homePage.clickOnQueryNormal();
        homePage.resetNormalQuery();
        homePage.enterSearchWithInvalidCLO();
        homePage.clickOnSubmitCLO();
        System.out.println("\n> Search Result Message: " + homePage.showQueryNormalInvalidCLOSearchError());
        driver.takeScreenshot("QueryNormalInvalidCLOSearch");

        /*
          Item Maintenance Query Future
         */
        homePage.clickOnQueryFuture();
        Assert.assertTrue(homePage.isQueryFutureValid());
        driver.takeScreenshot("QueryFuture");
        System.out.println("\n> Query Future Start Date is: " + homePage.showFutureDate());
        homePage.compareDate();
        Assert.assertTrue(homePage.isQueryFutureStateValid());
        homePage.searchQueryFutureWithAvalidCLO();
        homePage.clickOnQueryFutureSubmitButton();
//        Assert.assertTrue(homePage.isQueryFutureSearchValid());
        driver.takeScreenshot("QueryFutureSearch");
        homePage.searchQFcrossConnect();
        homePage.performAllClickOptionsTwo();

        /*
          Item Maintenance Query Center
         */
        homePage.clickOnCenter();
        Assert.assertTrue(homePage.isQueryCenterValid());
        System.out.println("\n> Center End Date is: " + homePage.showCenterDate());
        homePage.isCenterDateCurrent();
        Assert.assertTrue(homePage.isCenterStateOpen());
        driver.takeScreenshot("QueryCenter");
        homePage.clickToQueryCenterSearchWithoutCLO();
        driver.takeScreenshot("QueryCenterSearch");
        homePage.performAllClickOptionsTwo();

        /*
          Item Maintenance Query My Profile
         */
        homePage.clickOnQueryMyProfile();
        Assert.assertTrue(homePage.isQueryMyProfileValid());
        Assert.assertTrue(homePage.isQueryMyProfileOpen());
        System.out.println("\n> Query My Profile Date is: " + homePage.showQueryMyProfileDate());
        driver.takeScreenshot("QueryMyProfile");
        homePage.searchQueryMyProfileWithAvalidCLO();
        homePage.clickQueryMyProfileSubmitButton();
        driver.takeScreenshot("QueryMyProfileValidCLOSearch");
        homePage.clickOnQueryMyProfile();
        homePage.searchQueryMyProfileWithoutCLO();
        driver.takeScreenshot("QueryMyProfileInvalidCLOSearch");

        /*
          Item Maintenance Query Working
         */
        homePage.clickOnQueryWorking();
        Assert.assertTrue(homePage.isQueryWoringValid());
        System.out.println("\n> Employee's Name is: " + homePage.showEmployeeName());
        driver.takeScreenshot("QueryWorking");
        homePage.selectCrossConnect();
        homePage.clickOnQWsubmitButton();
        homePage.selectEquipment();

        /*
          Item Maintenance Query 74
         */
        homePage.clickOnQuerySeventyFour();
        Assert.assertTrue(homePage.isQuerySeventyFourValid());
        System.out.println("\n> Query 74 Status is: " + homePage.showQuerySeventyFourStatus());
        driver.takeScreenshot("QuerySeventyFour");
        homePage.performAllClickOptionsOne();

        /*
          Item Maintenance Query 74 Date
         */
        homePage.clickOnQuerySeventyFourDate();
        driver.takeScreenshot("QuerySeventyFourDate");
        homePage.enterQuerySeventyFourDateStartDate();
        homePage.clickOnQuerySeventyFourDateSubmitButton();
        driver.takeScreenshot("QuerySeventyFourDateSearch");
        homePage.performAllClickOptionsOne();

        /*
          Item Maintenance Query I&B
         */
        homePage.clickOnQueryIandB();
        driver.takeScreenshot("QueryIandB");
        homePage.performAllClickOptionsOne();

        /*
          Item Maintenance Query I&B Date
         */
        homePage.clickOnQueryIandBDate();
        driver.takeScreenshot("QueryIandBDate");
        homePage.enterQueryIandBDateStartDate();
        homePage.clickOnQueryIandBDateSubmitButton();
        driver.takeScreenshot("QueryIandBDateSearch");
        homePage.performAllClickOptionsOne();

        /*
          Item Maintenance Query Activity
         */
        homePage.clickOnQueryActivity();
        System.out.println("\n> Query Activity By : " + homePage.showQueryActivityBy());
        driver.takeScreenshot("QueryActivity");
        homePage.performAllActivitySearch();
        driver.takeScreenshot("QueryActivitySearch");

        /*
          Administration WFA NPC Centers
         */
        EnpctHomeAdministrationPage administrationPage = new EnpctHomeAdministrationPage(driver);
        administrationPage.clickOnAdministrationHome();
        driver.takeScreenshot("AdministrationHome");
        administrationPage.clickOnNPCCenters();
        Assert.assertTrue(administrationPage.iSeNPCCentersValid());
        driver.takeScreenshot("eNPCCenters");
        System.out.println("\n> Current: " + administrationPage.showNPCCentersRecords());
        administrationPage.createNewCenter();
        administrationPage.enterDummyDataNewCenterUser();
        administrationPage.clickOnOptionCenterRegionWest("WEST");
        administrationPage.clickOnOptionTimeZone("EDT - EASTERN");
        administrationPage.clickAddNewCenters();
        driver.takeScreenshot("AddNewCenters");
        System.out.println("\n> " + administrationPage.confirmMessage());
        administrationPage.closeCreateCenterWindow();
        administrationPage.clickOnReloadNpcCenters();
        System.out.println("\n> New Update: " + administrationPage.showNPCCentersRecords());

        /*
          Administration WFA Work Type
         */
        administrationPage.clickOnWorkType();
        Assert.assertTrue(administrationPage.validateWorkType());
        driver.takeScreenshot("WorkType");
        administrationPage.createNewWorkType();
        administrationPage.enterDummyDataNewWorkType();
        driver.takeScreenshot("WorkTypeSearch");
        System.out.println("\n> " + administrationPage.duplicateWorkTypeMessage());
        administrationPage.closeNewWorkTypeWindow();

        /*
          Administration TEMS Clusters
         */
        administrationPage.clickOnTem_Clusters();
        Assert.assertTrue(administrationPage.is_tem_ClustersValid());
        driver.takeScreenshot("Tem_Clusters");
        System.out.println("\n> Current: " + administrationPage.showTotalClusters());
        administrationPage.createNewCluster();
        administrationPage.enterDummyDataNewClusters();
        administrationPage.clickToEnterDummyDataNewClusters();
        driver.takeScreenshot("Tem_ClustersSearch");
        System.out.println("\n> " + administrationPage.showClusterMessage());
        administrationPage.closeClusterNewWindow();

        /*
          Administration TEMS Centers
         */
        administrationPage.clickOnCenters();
        Assert.assertTrue(administrationPage.isCentersOpened());
        driver.takeScreenshot("Centers");
        System.out.println("\n> Current: " + administrationPage.showTotalCenters());
        administrationPage.createTemsNewCenter();
        administrationPage.enterDummyDataNewCenter();
        driver.takeScreenshot("CentersSearch");

        administrationPage.scrollPageDown();

        administrationPage.clickOnAdd();
        System.out.println("\n> " + administrationPage.showByName());
        System.out.println("\n> " + administrationPage.showAddMessage());
        administrationPage.closeCenterNew();
        administrationPage.clickReloadCenterList();

        System.out.println("\n> New Update: " + administrationPage.showTotalCenters());
        administrationPage.clickOnCategories();
        Assert.assertTrue(administrationPage.isCategoriesValid());
        driver.takeScreenshot("Categories");
        System.out.println("\n> Current: " + administrationPage.showTotalCategories());
        administrationPage.createNewCategory();
        administrationPage.enterDummyDataNewCategory();
        System.out.println("\n> " + administrationPage.addedBy());
        System.out.println("\n> " + administrationPage.showCategoryAddedMessage());
        driver.takeScreenshot("CategoriesNew");
        administrationPage.closeNewCategory();
        administrationPage.clickOnReloadDispositionCategories();
        //System.out.println("\n> New Update: " + administrationPage.showTotalCategories());

        /*
          Administration Codes
         */
        administrationPage.clickOnCodes();
        administrationPage.isCodesValid();
        System.out.println("\n> Current: " + administrationPage.showTotalCodes());
        driver.takeScreenshot("Codes");
        administrationPage.createNewCodes();
        administrationPage.enterDummyDataNewCode();
        System.out.println("\n> " + administrationPage.showCodeaddedBy());
        System.out.println("\n> " + administrationPage.showCodeAddedMessage());
        driver.takeScreenshot("CodesNew");
        administrationPage.closeNewCode();
        administrationPage.clickOnReloadDispositioncodes();

        /*
          Administration User List
         */
        administrationPage.clickOnList();
        Assert.assertTrue(administrationPage.isListValid());
        driver.takeScreenshot("List");
        administrationPage.searchForValidUser();
        administrationPage.findValidUser();
        driver.takeScreenshot("ListSearch");

        /*
          Administration User Group
         */
        administrationPage.clickOnUserGroup();
        Assert.assertTrue(administrationPage.isUsergroupValid());
        driver.takeScreenshot("UserGroup");

        /*
          Job List
         */
        EnpctHomeJobListPage jobListPage = new EnpctHomeJobListPage(driver);
        jobListPage.clickOnJobList();
        Assert.assertTrue(jobListPage.isJobListValid());
        driver.takeScreenshot("jobListPage");
        System.out.println("\n> " + jobListPage.showJobListRecord());
        jobListPage.showJobData();

        /*
          TFAS Memo
         */
        EnpctHomeTfasMemoPage tfasMemo = new EnpctHomeTfasMemoPage(driver);
        tfasMemo.clickOnTfasMemo();
        Assert.assertTrue(tfasMemo.isTfasMemoValid());
        driver.takeScreenshot("TfasMemo");
        tfasMemo.clickOnCreate();

        /*
          Reports
         */
        EnpctHomeReportsPage reportsPage = new EnpctHomeReportsPage(driver);
        reportsPage.clickOnReports();
        Assert.assertTrue(reportsPage.isRoportsValid());
        driver.takeScreenshot("Report");

        reportsPage.clickOnCenterCodes();
        reportsPage.clickOnGenerateCenterCodes();
        driver.takeScreenshot("GenerateCenterCodes");

        reportsPage.clickOnAdmin();
        reportsPage.clickOnClusterCodes();
        reportsPage.clickOnGenerateClusterCodes();
        driver.takeScreenshot("GenerateClusterCodes");

        reportsPage.clickOnEmployeeInfo();
        reportsPage.clickOnEmployeeInfoReport();
        driver.takeScreenshot("EmployeeInfoReport");

        reportsPage.clickOnUnknownCenterCodes();
        reportsPage.clickOnGenerateUnknownCenterCodesReport();
        driver.takeScreenshot("GenerateUnknownCenterCodesReport");

        reportsPage.clickOnStatistical();
        Assert.assertTrue(reportsPage.isStatisticalValid());
        driver.takeScreenshot("Statistical");

        reportsPage.clickOnStatusByNe();
        reportsPage.clickOnStatusByNeGenerate();
        driver.takeScreenshot("StatusByReport");

        reportsPage.clickOnDailyCommError();
        reportsPage.selectYearToDateGenerateCommReport();
        driver.takeScreenshot("GenerateCommReport");

        reportsPage.clickOnCountsByNe();
        reportsPage.selectYearToDateGenerateCountsReport();
        driver.takeScreenshot("GenerateCountsReport");

        reportsPage.clickOnCompletedItemByEmployee();
        reportsPage.selectYearToDateGenerateItemsEmployeeReport();
        driver.takeScreenshot("GenerateItemsEmployeeReport");

        reportsPage.clickOnCompletedWorked();
        reportsPage.selectYearToDateGenerateCompletedWorkReport();
        driver.takeScreenshot("GenerateCompletedWorkReport");

        reportsPage.clickOnEmployeeCompleted();
        reportsPage.selectYearToDateGenerateEmployeeCompletedReport();
        driver.takeScreenshot("GenerateEmployeeCompletedReport");

        reportsPage.clickOnTodayReport();
        reportsPage.validateTodayReport();
        driver.takeScreenshot("TodayReport");

        reportsPage.clickOnAllMStatus();
        reportsPage.clickOnGenerateAllmStatusReport();
        driver.takeScreenshot("GenerateAllmStatusReport");

        reportsPage.clickOnAllMStatusADI();
        reportsPage.clickOnGenerateAllmStatusADIReport();
        driver.takeScreenshot("GenerateAllmStatusADIReport");

        reportsPage.clickOnItemNotCompleted();
        reportsPage.selectDateRangeGenerateReport();
        driver.takeScreenshot("GenerateReport");

        reportsPage.clickOnDueAndOpen();
        reportsPage.clickOnGenerateDueAndOpen();
        driver.takeScreenshot("GenerateDueAndOpen");

        reportsPage.clickOnMissedWotReport();
        reportsPage.clickOnGenerateMissedWotReport();
        driver.takeScreenshot("GenerateMissedWotReport");

        reportsPage.clickOnDailyWorkStatus();
        reportsPage.selectDateRangeAndGenerateReport();
        driver.takeScreenshot("GenerateReport");

        /*
          delete driver Cookies
         */
        driver.deleteAllCookies();
        /*
          close browser
         */
        driver.closeBrowser();
    }
}