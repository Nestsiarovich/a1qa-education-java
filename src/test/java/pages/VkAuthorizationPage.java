package pages;

import aquality.selenium.elements.interfaces.*;
import org.openqa.selenium.By;
import static utils.Managers.ConfigManager.*;

public class VkAuthorizationPage extends BaseForm{
    private ITextBox loginTextBox = getElementFactory().getTextBox(By.xpath("//input[@name = 'login']"), "loginTextBox");
    private ITextBox passwordTextBox = getElementFactory().getTextBox(By.xpath("//input[@name = 'password']"), "passwordTextBox");
    private IButton submitButton = getElementFactory().getButton(By.xpath("//button[@type = 'submit']"), "submitButton");

    public VkAuthorizationPage(By locator, String name) {
        super(locator, name);
    }

    private void fillLoginTextBox(){
        loginTextBox.clearAndType(getLogin());
    }

    private void fillPasswordTextBox(){
        passwordTextBox.clearAndType(getPassword());
    }

    private void clickSubmitButton(){
        submitButton.click();
    }

    public void authorization(){
        waitToDisplayed();
        fillLoginTextBox();
        clickSubmitButton();
        fillPasswordTextBox();
        clickSubmitButton();
    }
}
