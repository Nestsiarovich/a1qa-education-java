package pages;

import framework.browser.Browser;
import framework.elements.Span;
import framework.pages.BasePage;
import org.openqa.selenium.By;

public class DemoQAFramesPage extends BasePage {
    public DemoQAFramesPage(By locator, String name) {
        super(locator, name);
    }

    public String checkTxtInTopFrame(){
        Browser.switchToFrame(By.id("frame1"));
        Span txtInTopFrame = new Span(By.xpath("//body"), "txtInTopFrame");
        Browser.switchToDefaultContent();
        return txtInTopFrame.getText();
    }

    public String checkTxtInBottomFrame(){
        Browser.switchToFrame(By.id("frame2"));
        Span txtInBottomFrame = new Span(By.xpath("//body"), "txtInBottomFrame");
        Browser.switchToDefaultContent();
        return txtInBottomFrame.getText();
    }
}
