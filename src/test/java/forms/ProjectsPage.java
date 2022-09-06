package forms;

import org.openqa.selenium.By;

public class ProjectsPage extends BaseForm{
    public ProjectsPage(String name) {
        super(By.xpath("//div[@class = 'panel-heading']"), name);
    }

    public FooterForm getFooterForm(){
        return new FooterForm();
    }

    public ListGroupForm switchToListGroupForm(){
        return new ListGroupForm();
    }

    public PanelHeadingForm switchToPanelHeadingForm(){
        return new PanelHeadingForm();
    }
}
