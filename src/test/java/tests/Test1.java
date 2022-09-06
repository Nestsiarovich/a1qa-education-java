package tests;

import framework.browser.Browser;
import framework.tests.BaseTest;
import framework.utils.JsonReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DemoQAAlertsPage;
import pages.DemoQAAlertsWindowsPage;
import pages.DemoQAMainPage;

public class Test1 extends BaseTest {
    private DemoQAMainPage MainPage = new DemoQAMainPage(By.id("app"), "MainPageToolsQA");
    private DemoQAAlertsWindowsPage AlertsWindowsPage = new DemoQAAlertsWindowsPage(By.id("app"), "AlertsWindowsPageToolsQA");
    private DemoQAAlertsPage AlertsPage = new DemoQAAlertsPage(By.id("app"), "AlertsPageToolsQA");

    @Test
    public void alertsTest() {
        Browser.openPage(JsonReader.read("urlToMainPage", JsonReader.PathToDataTestsJSON));
        Assert.assertTrue(MainPage.isPageOpened(), MainPage.getPageName() + " isn't open");
        MainPage.clickToAlertsFrameWindowsBtn();
        AlertsWindowsPage.clickToAlertsBtn();
        Assert.assertTrue(AlertsPage.isPageOpened(), AlertsPage.getPageName() + " isn't open");
        AlertsPage.clickToSeeAlertsBtn();
        Assert.assertEquals(AlertsPage.getAlertText(),JsonReader.read("txtAlertToSeeCheck", JsonReader.PathToDataTestsJSON), "AlertToSee text is incorrect");
        AlertsPage.clickOkInAlert();
        Assert.assertTrue(AlertsPage.checkIsAlertClosed(), "Alert isn't close");
        AlertsPage.clickConfirmBoxWillAppearBtn();
        Assert.assertEquals(AlertsPage.getAlertText(),JsonReader.read("txtConfirmAlertCheck", JsonReader.PathToDataTestsJSON), "AlertConfirm text is incorrect");
        AlertsPage.clickOkInAlert();
        Assert.assertTrue(AlertsPage.checkIsAlertClosed(), "Alert isn't close");
        Assert.assertEquals(AlertsPage.checkConfirmText(),JsonReader.read("txtConfirmOk", JsonReader.PathToDataTestsJSON));
        AlertsPage.clickPromptBoxWillAppearBtn();
        Assert.assertEquals(AlertsPage.getAlertText(),JsonReader.read("txtPromptAlertCheck", JsonReader.PathToDataTestsJSON), "AlertPrompt text is incorrect");
        AlertsPage.sendTextToAlert();
        AlertsPage.clickOkInAlert();
        Assert.assertTrue(AlertsPage.checkIsAlertClosed(), "Alert isn't close");
        Assert.assertEquals(AlertsPage.checkRandomText(),JsonReader.read("txtRandomAlertCheck",JsonReader.PathToDataTestsJSON) + AlertsPage.getRandomTXT(), "AlertPrompt text is incorrect");
    }
}
