package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.elements.ElementState;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HomeUserintefacePage extends Form {
    private IElementFactory elementFactory = AqualityServices.getElementFactory();
    private ILink startLink = elementFactory.getLink(By.xpath("//a[@class = 'start__link']"),"startLink", ElementState.DISPLAYED);

    public HomeUserintefacePage(By locator, String name) {
        super(locator, name);
    }

    public void startLinkClick(){
        startLink.click();
    }

    @Override
    public boolean isDisplayed(){
        return AqualityServices.getBrowser().getDriver().findElement(getLocator()).isDisplayed();
    }
}
