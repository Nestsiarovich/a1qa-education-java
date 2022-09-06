package elements;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.elements.ElementState;
import aquality.selenium.elements.ComboBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DivComboBox extends ComboBox {
    public DivComboBox(final By locator, final String name, final ElementState state) {
        super(locator, name, state);
    }

    public WebElement getElement(int index){
        List<WebElement> webElements = AqualityServices.getBrowser().getDriver().findElements(getLocator());
        return webElements.get(index);
    }

    public int getSize(){
        List<WebElement> webElements = AqualityServices.getBrowser().getDriver().findElements(getLocator());
        return webElements.size();
    }
}
