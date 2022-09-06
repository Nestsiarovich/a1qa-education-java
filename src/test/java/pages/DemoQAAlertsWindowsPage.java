package pages;

import framework.elements.Button;
import framework.pages.BasePage;
import framework.utils.JSExecutor;
import org.openqa.selenium.By;

public class DemoQAAlertsWindowsPage extends BasePage {
    public DemoQAAlertsWindowsPage(By locator, String name) {
        super(locator, name);
    }

    public void clickToAlertsBtn(){
        Button btnAlerts = new Button(By.xpath("//div[@class='element-list collapse show']//li[@id='item-1']"),"btnAlerts");
        JSExecutor.click(btnAlerts);
    }

    public void clickToNestedFramesBtn(){
        Button btnNestedFrames = new Button(By.xpath("//div[@class='element-list collapse show']//li[@id='item-3']"),"btnNestedFrames");
        JSExecutor.click(btnNestedFrames);
    }

    public void clickBrowserWindowsBtn(){
        Button btnBrowserWindows = new Button(By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']"),"btnBrowserWindows");
        JSExecutor.click(btnBrowserWindows);
    }
}
