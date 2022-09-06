package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import org.testng.annotations.*;

public abstract class BaseTest {
    private final ISettingsFile testsData = new JsonSettingsFile("TestsData.json");

    @BeforeMethod
    protected void beforeMethod(){
        AqualityServices.getBrowser().goTo(testsData.getValue("/urlToHomePage").toString());
        AqualityServices.getBrowser().maximize();
    }

    @AfterMethod (alwaysRun = true)
    protected void afterMethod(){
        if (AqualityServices.isBrowserStarted()){
            AqualityServices.getBrowser().quit();
        }
    }
}
