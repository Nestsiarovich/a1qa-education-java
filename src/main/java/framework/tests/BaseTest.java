package framework.tests;
import framework.browser.DriverFactory;
import framework.utils.LoggerUtil;
import org.testng.annotations.*;

public class BaseTest {
    @BeforeSuite
    protected void setUp(){
        LoggerUtil.logInfo("Test start + setup driver");
        DriverFactory.getDriver().manage().window().maximize();
    }

    @AfterSuite(alwaysRun = true)
    protected void tearDown(){
        LoggerUtil.logInfo("Driver tear down");
        DriverFactory.getDriver().quit();
    }
}
