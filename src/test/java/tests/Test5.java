package tests;

import framework.browser.Browser;
import framework.tests.BaseTest;
import framework.utils.JsonReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DemoQAMainPage;
import pages.DemoQAProgressBarPage;
import pages.DemoQASliderPage;
import pages.DemoQAWidgetsPage;

public class Test5 extends BaseTest {
    private DemoQAMainPage MainPage = new DemoQAMainPage(By.id("app"), "MainPageToolsQA");
    private DemoQAWidgetsPage WidgetsPage = new DemoQAWidgetsPage(By.id("app"), "WidgetsPageToolsQA");
    private DemoQASliderPage SlidersPage = new DemoQASliderPage(By.id("app"), "SlidersPageToolsQA");
    private DemoQAProgressBarPage ProgressBarPage = new DemoQAProgressBarPage(By.id("app"), "SlidersPageToolsQA");

    @Test
    public void sliderAndProgressBarTest() {
        Browser.openPage(JsonReader.read("urlToMainPage", JsonReader.PathToDataTestsJSON));
        Assert.assertTrue(MainPage.isPageOpened(), MainPage.getPageName() + " isn't open");
        MainPage.clickToWidgetsBtn();
        WidgetsPage.clickToSliderBtn();
        Assert.assertTrue(SlidersPage.isPageOpened(), SlidersPage.getPageName() + " isn't open");
        SlidersPage.clickSlider();
        Assert.assertEquals(SlidersPage.getSliderValue(), SlidersPage.getRandomPercent(), "Percents are different");
        SlidersPage.clickToProgressBarBtn();
        Assert.assertTrue(ProgressBarPage.isPageOpened(), ProgressBarPage.getPageName() + " isn't open");
        ProgressBarPage.clickToStartStopBtn();
        ProgressBarPage.stopProgressBar();
        Assert.assertTrue(ProgressBarPage.checkProgressBarResult(),"Age error more then 2%");
    }
}
