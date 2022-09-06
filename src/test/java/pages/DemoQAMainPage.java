package pages;

import framework.elements.Button;
import framework.pages.BasePage;
import org.openqa.selenium.By;

public class DemoQAMainPage extends BasePage {
    public DemoQAMainPage(By locator, String name) {
        super(locator, name);
    }

    public static void clickToAlertsFrameWindowsBtn(){
        Button btnAlertsFrameWindows = new Button(By.xpath("//div[@class='card mt-4 top-card'][3]"), "btnAlertsFramesWindows");
        btnAlertsFrameWindows.click();
    }

    public static void clickToElementsBtn(){
        Button btnElements = new Button(By.xpath("//div[@class='card mt-4 top-card'][1]"), "btnElements");
        btnElements.click();
    }

    public static void clickToWidgetsBtn(){
        Button btnWidgets = new Button(By.xpath("//div[@class='card mt-4 top-card'][4]"), "btnWidgets");
        btnWidgets.click();
    }
}
