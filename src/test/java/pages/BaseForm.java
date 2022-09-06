package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import java.util.concurrent.TimeoutException;
import static utils.Managers.SettingsManager.getTimeoutCondition;

public abstract class BaseForm extends Form{
    protected BaseForm(By locator, String name) {
        super(locator, name);
    }

    public void waitToDisplayed(){
        try {
            AqualityServices.getConditionalWait().waitForTrue(() -> this.state().isDisplayed());
        } catch (TimeoutException e) {
            throw new RuntimeException(String.format("Page %s doesn't open for %s sec", this.getName(), getTimeoutCondition()));
        }
    }

    @Override
    public boolean isDisplayed(){
        return AqualityServices.getBrowser().getDriver().findElement(getLocator()).isDisplayed();
    }
}
