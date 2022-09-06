import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Singleton {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null)
            driver = new EdgeDriver();
        return driver;
    }

    private static SteamPage steamPage;

    public static SteamPage getSteamPage() {
        if (steamPage == null)
            steamPage = new SteamPage();
        return steamPage;
    }
}