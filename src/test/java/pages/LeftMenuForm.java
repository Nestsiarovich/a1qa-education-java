package pages;

import aquality.selenium.elements.interfaces.*;
import org.openqa.selenium.By;

public class LeftMenuForm extends BaseForm{
    private static By baseElementLocator = By.xpath("//ol[@Class = 'side_bar_ol']");
    private ILabel baseElement = getElementFactory().getLabel(baseElementLocator, "BaseElement");
    private IButton myProfileButton;
    public LeftMenuForm() {
        super(baseElementLocator, "leftMenu");
        myProfileButton = baseElement.findChildElement(By.xpath("//li[@id = 'l_pr']"), "myProfileButton", IButton.class);
    }

    public VkMyProfilePage clickMyProfileButton(){
        myProfileButton.click();
        return new VkMyProfilePage(By.xpath("//div[@id = 'page_info_wrap']"), "vkMyProfilePage");
    }
}
