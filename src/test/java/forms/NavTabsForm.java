package forms;

import aquality.selenium.elements.interfaces.*;
import org.openqa.selenium.By;

public class NavTabsForm extends BaseForm{
    private static By baseElementLocator = By.xpath("//ul[contains(@class, 'nav')]");
    private ILabel baseElement = getElementFactory().getLabel(baseElementLocator, "BaseElement");
    private ILink activeTab;

    public NavTabsForm() {
        super(baseElementLocator, "navTabsForm");
        activeTab = baseElement.findChildElement(By.xpath(String.format("//li[@class = 'active']//a")), ILink.class);
    }

    public String getTabHref(){
        return activeTab.getHref();
    }
}
