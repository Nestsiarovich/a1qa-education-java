package tests;

import aquality.selenium.core.utilities.*;
import org.testng.annotations.*;
import static aquality.selenium.browser.AqualityServices.*;
import static utils.Managers.DataManager.getVkUrl;

public abstract class BaseTest {
    @BeforeTest
    protected void beforeTest(){
        getBrowser().goTo(getVkUrl());
        getBrowser().maximize();
    }

    @AfterTest(alwaysRun = true)
    protected void afterTest(){
        if (isBrowserStarted()){
            getBrowser().quit();
        }
    }
}
