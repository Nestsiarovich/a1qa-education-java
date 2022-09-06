package tests;

import pages.FirstGameUserinterfaceForm;
import pages.HomeUserintefacePage;
import pages.SecondGameUserinterfaceForm;
import pages.ThirdGameUserinterfaceForm;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserinterfaceTest extends BaseTest{
    private HomeUserintefacePage homePage = new HomeUserintefacePage(By.xpath("//button[@class = 'start__button']"),"HomePage");
    private FirstGameUserinterfaceForm firstGamePage = new FirstGameUserinterfaceForm(By.xpath("//span[@class = 'login-form__terms-conditions-underline']"),"FirstGamePage");


    @Test
    public void cardsTest() {
        SecondGameUserinterfaceForm secondGamePage = new SecondGameUserinterfaceForm(By.xpath("//div[@class='avatar-and-interests__avatar-box']"),"SecondGamePage");
        ThirdGameUserinterfaceForm thirdGamePage = new ThirdGameUserinterfaceForm(By.xpath("//div[@class = 'page-indicator']"),"ThirdGamePage");

        Assert.assertTrue(homePage.isDisplayed(),"Home Page isn't opened");
        homePage.startLinkClick();
        Assert.assertTrue(firstGamePage.isDisplayed(),"First Game Page isn't opened");
        firstGamePage.fillingOutTheForm();
        firstGamePage.clickNextButton();
        Assert.assertTrue(secondGamePage.isDisplayed(),"Second Game Page isn't opened");
        secondGamePage.selectInterest();
        secondGamePage.uploadImage();
        secondGamePage.clickNextButton();
        Assert.assertTrue(thirdGamePage.isDisplayed(),"Second Game Page isn't opened");
    }

    @Test
    public void hideHelpFormTest(){
        Assert.assertTrue(homePage.isDisplayed(),"Home Page isn't opened");
        homePage.startLinkClick();
        Assert.assertTrue(firstGamePage.isDisplayed(),"First Game Page isn't opened");
        firstGamePage.hideHelpForm();
        Assert.assertTrue(firstGamePage.isHelpFormHide(), "Help Form is visible");
    }

    @Test
    public void cookiesFormTest(){
        Assert.assertTrue(homePage.isDisplayed(),"Home Page isn't opened");
        homePage.startLinkClick();
        Assert.assertTrue(firstGamePage.isDisplayed(),"First Game Page isn't opened");
        firstGamePage.acceptCookies();
        Assert.assertTrue(firstGamePage.isCookiesFormHide(),"Cookies Form is displayed");
    }

    @Test
    public void timerFormTest(){
        Assert.assertTrue(homePage.isDisplayed(),"Home Page isn't opened");
        homePage.startLinkClick();
        Assert.assertTrue(firstGamePage.isDisplayed(),"First Game Page isn't opened");
        Assert.assertEquals(firstGamePage.getTimerValue(), firstGamePage.getTimerComparisonValue(), "Timer value is incorrect");
    }
}