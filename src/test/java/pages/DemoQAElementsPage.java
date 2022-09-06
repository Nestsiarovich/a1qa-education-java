package pages;

import framework.elements.Button;
import framework.pages.BasePage;
import org.openqa.selenium.By;

public class DemoQAElementsPage extends BasePage {
    public DemoQAElementsPage(By locator, String name) {
        super(locator, name);
    }

    public void clickToWebTablesBtn(){
        Button btnWebTables = new Button(By.xpath("//div[@class='element-list collapse show']//li[@id='item-3']"),"btnWebTables");
        btnWebTables.click();
    }

}
