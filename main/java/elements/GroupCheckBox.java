package elements;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.elements.ElementState;
import aquality.selenium.elements.CheckBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GroupCheckBox extends CheckBox {
    public GroupCheckBox(By locator, String name, ElementState state) {
        super(locator, name, state);
    }

    public int getSize(){
        List<WebElement> webElements = AqualityServices.getBrowser().getDriver().findElements(getLocator());
        return webElements.size();
    }

    public WebElement getElement(int index){
        List<WebElement> webElements = AqualityServices.getBrowser().getDriver().findElements(getLocator());
        return webElements.get(index);
    }

    public void checkLastCheckBox(){
        getElement(getSize()-1).click();
    }
}
