package pages;

import framework.elements.Button;
import framework.pages.BasePage;
import framework.utils.JSExecutor;
import org.openqa.selenium.By;

public class DemoQAWidgetsPage extends BasePage{
    public DemoQAWidgetsPage(By locator, String name) {
        super(locator, name);
    }

    public void clickToSliderBtn(){
        Button btnSlider = new Button(By.xpath("//div[@class='element-list collapse show']//li[@id='item-3']"),"btnWebTables");
        JSExecutor.click(btnSlider);
    }
}
