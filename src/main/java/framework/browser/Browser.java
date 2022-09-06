package framework.browser;

import framework.utils.LoggerUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import java.util.ArrayList;

public class Browser {
    public static void openPage(String url){
        DriverFactory.getDriver().get(url);
    }

    public static String getUrl(){
        return DriverFactory.getDriver().getCurrentUrl();
    }

    public static Alert getAlert(){
        return DriverFactory.getDriver().switchTo().alert();
    }

    public static void switchToFrame(By element){
        LoggerUtil.logInfo("Switch to frame");
        DriverFactory.getDriver().switchTo().frame(DriverFactory.getDriver().findElement(element));
    }

    public static void switchToDefaultContent(){
        LoggerUtil.logInfo("Switch to default content");
        DriverFactory.getDriver().switchTo().defaultContent();
    }

    public static void switchToTab(Integer TabNumber){
        ArrayList<String> tabs = new ArrayList<String> (DriverFactory.getDriver().getWindowHandles());
        LoggerUtil.logInfo("Switch to tab - " + TabNumber);
        DriverFactory.getDriver().switchTo().window(tabs.get(TabNumber));
    }

    public static void closeTab(){
        DriverFactory.getDriver().close();
    }
}
