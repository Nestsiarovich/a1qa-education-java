package forms;

import aquality.selenium.elements.interfaces.*;
import org.openqa.selenium.By;
import static utils.managers.ConfigManager.*;

public class FooterForm extends BaseForm{
    private static By baseElementLocator = By.xpath("//footer");
    private ILabel baseElement = getElementFactory().getLabel(baseElementLocator, "BaseElement");
    private ILabel versionLabel;

    public FooterForm() {
        super(baseElementLocator, "footerForm");
        versionLabel = baseElement.findChildElement(By.xpath("//span"), "versionLabel", ILabel.class);
    }

    public String getVersion(){
        return versionLabel.getText().replace(getConfigValue(ConfigKeys.VERSION_TEXT), "");
    }
}
