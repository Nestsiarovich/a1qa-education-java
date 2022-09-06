package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class ThirdGameUserinterfaceForm extends Form {
    public ThirdGameUserinterfaceForm(By locator, String name) {
        super(locator, name);
    }

    @Override
    public boolean isDisplayed(){
        return AqualityServices.getBrowser().getDriver().findElement(getLocator()).isDisplayed();
    }
}
