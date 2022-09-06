package tests;

import framework.browser.Browser;
import framework.tests.BaseTest;
import framework.utils.JsonReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DemoQAAlertsWindowsPage;
import pages.DemoQAFramesPage;
import pages.DemoQAMainPage;
import pages.DemoQANestedFramesPage;

public class Test2 extends BaseTest {
    private DemoQAMainPage MainPage = new DemoQAMainPage(By.id("app"), "MainPageToolsQA");
    private DemoQAAlertsWindowsPage AlertsWindowsPage = new DemoQAAlertsWindowsPage(By.id("app"), "AlertsWindowsPageToolsQA");
    private DemoQANestedFramesPage NestedFramesPage = new DemoQANestedFramesPage(By.id("app"), "NestedFramesPageToolsQA");
    private DemoQAFramesPage FramesPage = new DemoQAFramesPage(By.id("app"), "FramesPageToolsQA");

    @Test
    public void frameTest() {
        Browser.openPage(JsonReader.read("urlToMainPage", JsonReader.PathToDataTestsJSON));
        Assert.assertTrue(MainPage.isPageOpened(), MainPage.getPageName() + " isn't open");
        MainPage.clickToAlertsFrameWindowsBtn();
        AlertsWindowsPage.clickToNestedFramesBtn();
        Assert.assertTrue(NestedFramesPage.isPageOpened(), NestedFramesPage.getPageName() + " isn't open");
        Assert.assertTrue(NestedFramesPage.checkNestedFrames(), "Text in frames incorrect");
        NestedFramesPage.clickToFramesBtn();
        Assert.assertTrue(FramesPage.isPageOpened(), FramesPage.getPageName() + " isn't open");
        Assert.assertEquals(FramesPage.checkTxtInBottomFrame(),FramesPage.checkTxtInTopFrame(),"Text in frames is different");
    }
}
