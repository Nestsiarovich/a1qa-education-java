package pages;

import framework.browser.Browser;
import framework.elements.Button;
import framework.pages.BasePage;
import framework.utils.JSExecutor;
import framework.utils.JsonReader;
import org.openqa.selenium.By;

public class DemoQABrowserWindowsPage extends BasePage {
    public DemoQABrowserWindowsPage(By locator, String name) {
        super(locator, name);
    }

    public void clickNewTabBtn(){
        Button btnNewTab = new Button(By.id("tabButton"),"btnNewTab");
        btnNewTab.click();
        Browser.switchToTab(1);
    }

    public void closeNewTab(){
        Browser.closeTab();
        Browser.switchToTab(0);
    }

    public void clickElementsBtn(){
        Button btnElements = new Button(By.xpath("//div[@class='header-wrapper'][1]"),"btnElements");
        btnElements.click();
    }

    public void clickLinksBtn(){
        Button btnLinks = new Button(By.id("item-5"),"btnLinks");
        JSExecutor.click(btnLinks);
    }

}
