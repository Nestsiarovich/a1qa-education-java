package pages;

import framework.browser.Browser;
import framework.elements.Link;
import framework.pages.BasePage;
import framework.utils.JsonReader;
import org.openqa.selenium.By;

public class DemoQALinksPage extends BasePage {
    public DemoQALinksPage(By locator, String name) {
        super(locator, name);
    }

    public void clickHomeLink() {
        Link linkHome = new Link(By.id("simpleLink"),"linkHome");
        linkHome.click();
        Browser.switchToTab(1);
    }

    public void switchToFirstTab(){
        Browser.switchToTab(0);
    }
}
