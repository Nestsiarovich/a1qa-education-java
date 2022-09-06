package tests;

import framework.browser.Browser;
import framework.tests.BaseTest;
import framework.utils.JsonReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DemoQAAlertsWindowsPage;
import pages.DemoQABrowserWindowsPage;
import pages.DemoQALinksPage;
import pages.DemoQAMainPage;

public class Test4 extends BaseTest {
    private DemoQAMainPage MainPage = new DemoQAMainPage(By.id("app"), "MainPageToolsQA");
    private DemoQAAlertsWindowsPage AlertsWindowsPage = new DemoQAAlertsWindowsPage(By.id("app"), "AlertsWindowsPageToolsQA");
    private DemoQABrowserWindowsPage BrowserWindowsPage = new DemoQABrowserWindowsPage(By.id("app"), "BrowserWindowsPageToolsQA");
    private DemoQALinksPage LinksPage = new DemoQALinksPage(By.id("app"), "LinksPageToolsQA");

    @Test
    public void handlesTest() {
        Browser.openPage(JsonReader.read("urlToMainPage", JsonReader.PathToDataTestsJSON));
        Assert.assertTrue(MainPage.isPageOpened(), MainPage.getPageName() + " isn't open");
        MainPage.clickToAlertsFrameWindowsBtn();
        AlertsWindowsPage.clickBrowserWindowsBtn();
        Assert.assertTrue(BrowserWindowsPage.isPageOpened(), BrowserWindowsPage.getPageName() + " isn't open");
        BrowserWindowsPage.clickNewTabBtn();
        Assert.assertEquals(Browser.getUrl(), JsonReader.read("urlSamplePage", JsonReader.PathToDataTestsJSON), "New tab is incorrect - " + Browser.getUrl());
        BrowserWindowsPage.closeNewTab();
        Assert.assertTrue(BrowserWindowsPage.isPageOpened(), BrowserWindowsPage.getPageName() + " isn't open");
        BrowserWindowsPage.clickElementsBtn();
        BrowserWindowsPage.clickLinksBtn();
        Assert.assertTrue(LinksPage.isPageOpened(), LinksPage.getPageName() + " isn't open");
        LinksPage.clickHomeLink();
        Assert.assertTrue(MainPage.isPageOpened(), MainPage.getPageName() + " isn't open");
        LinksPage.switchToFirstTab();
        Assert.assertTrue(LinksPage.isPageOpened(), LinksPage.getPageName() + " isn't open");
    }
}
