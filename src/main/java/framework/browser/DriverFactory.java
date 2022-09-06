package framework.browser;

import framework.utils.JsonReader;
import framework.utils.LoggerUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver == null){
            switch (JsonReader.read("Browser", JsonReader.PathToFrameworkJSON)){
                case ("CHROME"):{
                    LoggerUtil.logInfo("Creating CHROME diver");
                    driver = new ChromeDriver();
                    break;
                }
                case ("FIREFOX"):{
                    LoggerUtil.logInfo("Creating FIREFOX diver");
                    driver = new FirefoxDriver();
                    break;
                }
                case ("EDGE"):{
                    LoggerUtil.logInfo("Creating EDGE diver");
                    driver = new EdgeDriver();
                    break;
                }
                default:{
                    try {
                        throw new Exception("Incorrect driver name - " + JsonReader.read("Browser", JsonReader.PathToFrameworkJSON));
                    }
                    catch (Exception e){
                        LoggerUtil.logWarning(e.getMessage());
                    }
                }
            }
        }
        return driver;
    }
}
