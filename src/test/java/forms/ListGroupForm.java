package forms;

import aquality.selenium.elements.interfaces.*;
import org.openqa.selenium.*;
import java.util.List;
import static utils.managers.ConfigManager.*;
import static utils.managers.ConfigManager.ConfigKeys.*;

public class ListGroupForm extends BaseForm{
    private static By baseElementLocator = By.xpath("//div[@class = 'list-group']");
    private ILabel baseElement = getElementFactory().getLabel(baseElementLocator, "BaseElement");
    private List<ILink> listGroupItems;

    public ListGroupForm() {
        super(baseElementLocator, "listGroupForm");
        listGroupItems = baseElement.findChildElements(By.xpath("//a[@class = 'list-group-item']"), "items", ILink.class);
    }

    public String clickElementReturnId(String elementName){
        for (int i = 0; i < listGroupItems.size(); i++) {
            if (listGroupItems.get(i).getText().equals(elementName)){
                String projectId = listGroupItems.get(i).getHref().substring(
                        listGroupItems.get(i).getHref().lastIndexOf(getConfigValue(PROJECT_ID_TEXT)) + getConfigValue(PROJECT_ID_TEXT).length());
                listGroupItems.get(i).click();
                return projectId;
            }
        }
        return null;
    }

    public boolean isElementInForm(String elementName){
        for (int i = 0; i < listGroupItems.size(); i++) {
            if (listGroupItems.get(i).getText().equals(elementName)){
                return true;
            }
        }
        return false;
    }
}
