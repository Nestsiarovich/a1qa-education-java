package forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import java.util.concurrent.TimeoutException;
import static aquality.selenium.browser.AqualityServices.*;
import static utils.managers.SettingsManager.*;

public abstract class BaseForm extends Form {
    protected BaseForm(By locator, String name) {
        super(locator, name);
    }

    public void waitToDisplayed(){
        try {
            AqualityServices.getConditionalWait().waitForTrue(() -> this.state().isDisplayed());
        } catch (TimeoutException timeoutException) {
            throw new RuntimeException(String.format("Form %s doesn't open during %s sec", this.getName(), getTimeoutCondition()));
        }
    }

    public String getBaseLocatorText(){
        return getBrowser().getDriver().findElement(getLocator()).getText();
    }

    @Override
    public boolean isDisplayed(){
        return AqualityServices.getBrowser().getDriver().findElement(getLocator()).isDisplayed();
    }
}
