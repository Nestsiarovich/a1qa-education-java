package forms;

import org.openqa.selenium.By;

public class ProjectPage extends BaseForm{
    public ProjectPage(String name) {
        super(By.xpath("//li[@role = 'presentation']"), name);
    }

    public TestsTableForm switchToTestsTableForm(){
        return new TestsTableForm();
    }

    public NavTabsForm switchToNavTabsForm(){
        return new NavTabsForm();
    }
}
