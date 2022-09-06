package forms;

import aquality.selenium.elements.interfaces.*;
import org.openqa.selenium.By;

public class PanelHeadingForm extends BaseForm{
    private static By baseElementLocator = By.xpath("//div[@class = 'panel-heading']");
    private ILabel baseElement = getElementFactory().getLabel(baseElementLocator, "BaseElement");
    private ILink addLink;

    public PanelHeadingForm() {
        super(baseElementLocator, "panelHeadingForm");
        addLink = baseElement.findChildElement(By.xpath("//a"), "addLink", ILink.class);
    }

    public void clickAddLink(){
        addLink.click();
    }
}