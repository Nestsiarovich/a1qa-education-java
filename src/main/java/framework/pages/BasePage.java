package framework.pages;
import framework.browser.DriverFactory;
import framework.utils.LoggerUtil;
import framework.utils.Waits;
import org.openqa.selenium.By;

public abstract class BasePage {
    static protected By uniqElementLocator;
    static protected String pageName;

    public BasePage(By locator, String name){
        this.uniqElementLocator = locator;
        this.pageName = name;
    }

    public static boolean isPageOpened(){
        Waits.waitElementIsVisible(DriverFactory.getDriver().findElement(uniqElementLocator));
        if (DriverFactory.getDriver().findElement(uniqElementLocator).isDisplayed()){
            return true;
        }
        else {
            LoggerUtil.logWarning("Page isn't open:" + pageName);
            return false;
        }
    }

    public static String getPageName(){
        return pageName;
    }
}
