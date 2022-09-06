package framework.elements;
import framework.browser.DriverFactory;
import framework.utils.LoggerUtil;
import framework.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class BaseElement {
    protected static By elementLocator;
    protected static String elementName;

    public BaseElement(By locator, String name){
        this.elementLocator = locator;
        this.elementName = name;
    }

    public static WebElement getWebElement(){
        return DriverFactory.getDriver().findElement(elementLocator);
    }

    public static boolean isElementDisplayed(){
        Waits.waitElementIsVisible(getWebElement());
        return getWebElement().isDisplayed();
    }

    public static void click(){
        Waits.waitElementIsVisible(getWebElement());
        LoggerUtil.logInfo(elementName + " click");
        getWebElement().click();
    }

    public static String getText(){
        Waits.waitElementIsVisible(getWebElement());
        LoggerUtil.logInfo("Get text from - " + getElementName());
        return getWebElement().getText();
    }

    public static String getElementName(){
        return elementName;
    }

    public static void clear(){
        Waits.waitElementIsVisible(getWebElement());
        LoggerUtil.logInfo("Clear WebElement - " + elementName);
        getWebElement().clear();
    }

    public static void putText(String text){
        Waits.waitElementIsVisible(getWebElement());
        LoggerUtil.logInfo("Put - " + text + " in " + elementName);
        getWebElement().sendKeys(text);
    }

    public static int getWidth(){
        LoggerUtil.logInfo("Get Width " + elementName + " - " + getWebElement().getSize().getWidth());
        return getWebElement().getSize().getWidth();
    }

    public static String getAtributeValue(String attribute){
        LoggerUtil.logInfo("Get Attribute - " + attribute + ", value - " + getWebElement().getAttribute(attribute) + " of - " + elementName);
        return getWebElement().getAttribute(attribute);
    }
}
