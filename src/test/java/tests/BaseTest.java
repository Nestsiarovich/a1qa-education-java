package tests;

import org.testng.annotations.*;
import static aquality.selenium.browser.AqualityServices.*;
import static utils.managers.ConfigManager.*;
import static utils.managers.ConfigManager.ConfigKeys.*;
import static utils.managers.DataManager.*;

public abstract class BaseTest {
    @BeforeMethod
    protected void browserSettingAndStart(){
        getBrowser().maximize();
        getBrowser().goTo(getWebUrl(getConfigValue(LOGIN), getConfigValue(PASSWORD), getConfigValue(MACHINE_ADDRESS), getConfigValue(PORT)));
    }

    @AfterMethod(alwaysRun = true)
    protected void afterTest(){
        if (isBrowserStarted()){
            getBrowser().quit();
        }
    }
}
