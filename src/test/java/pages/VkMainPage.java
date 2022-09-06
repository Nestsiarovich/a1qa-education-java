package pages;

import aquality.selenium.elements.interfaces.IButton;
import org.openqa.selenium.By;

public class VkMainPage extends BaseForm{
    private IButton signInButton = getElementFactory().getButton(By.xpath("//button[contains(@class, 'signInButton')]"), "signInButton");

    public VkMainPage(By locator, String name) {
        super(locator, name);
    }

    public void clickSignInButton(){
        signInButton.click();
    }
}
