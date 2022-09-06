package framework.utils;

import framework.browser.DriverFactory;
import framework.elements.BaseElement;
import org.openqa.selenium.JavascriptExecutor;

public class JSExecutor {
    private static JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();

    public static void click(BaseElement element){
        Waits.waitElementIsVisible(element.getWebElement());
        LoggerUtil.logInfo(element.getElementName() + " JSExecutor click");
        js.executeScript("arguments[0].click()", element.getWebElement());
    }
}
