import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class MainTest {
    private static WebDriver driver;
    private static SteamPage steamPage;

    @BeforeClass
    public static void setUp(){
        driver = Singleton.getDriver();
        steamPage = Singleton.getSteamPage();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(ConfProperties.getProperty("waitingLimit")), TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("urlToMainPage"));
    }

    @Test
    public void mainTest(){
        Assert.assertEquals(driver.getCurrentUrl(),ConfProperties.getProperty("urlToMainPage")+"/","Failed to open Steam page");
        steamPage.clickBtnAbout();
        Assert.assertEquals(driver.getCurrentUrl(),ConfProperties.getProperty("urlToAboutPage")+"/","Failed to open AboutSteam page");
        Assert.assertTrue(steamPage.isOnlineMoreThenInGame(),"Online in Game >= than general online");
        steamPage.clickBtnStore();
        Assert.assertEquals(driver.getCurrentUrl(),ConfProperties.getProperty("urlToMainPage")+"/","Failed to open Steam page");
    }

    @AfterClass
    public static void tearDown(){
        steamPage = null;
        driver.quit();
    }
}
