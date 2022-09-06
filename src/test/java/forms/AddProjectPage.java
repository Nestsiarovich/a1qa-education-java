package forms;

import aquality.selenium.elements.interfaces.*;
import org.openqa.selenium.By;

public class AddProjectPage extends BaseForm{
    private ITextBox projectNameTextBox = getElementFactory().getTextBox(By.xpath("//input[@id = 'projectName']"), "projectNameTextBox");
    private IButton saveProjectButton = getElementFactory().getButton(By.xpath("//button[@type = 'submit']"), "saveProjectButton");
    private ILabel successAlert = getElementFactory().getLabel(By.xpath("//div[contains(@class, 'alert-success')]"), "successAlert");

    public AddProjectPage(String name) {
        super(By.xpath("//form[@id = 'addProjectForm']"), name);
    }

    public void setProjectName(String message){
        projectNameTextBox.clearAndType(message);
    }

    public void clickSaveProjectButton(){
        saveProjectButton.click();
    }

    public boolean addProject(String projectName){
        setProjectName(projectName);
        clickSaveProjectButton();
        successAlert.state().waitForDisplayed();
        return successAlert.state().isDisplayed();
    }
}
