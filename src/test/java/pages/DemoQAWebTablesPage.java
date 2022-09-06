package pages;

import framework.elements.Button;
import framework.elements.Div;
import framework.elements.TextBox;
import framework.pages.BasePage;
import framework.utils.JsonReader;
import framework.utils.LoggerUtil;
import org.openqa.selenium.By;

public class DemoQAWebTablesPage extends BasePage {
    public DemoQAWebTablesPage(By locator, String name) {
        super(locator, name);
    }

    public void clickToAddBtn(){
        Button btnAdd = new Button(By.id("addNewRecordButton"),"btnAdd");
        btnAdd.click();
    }

    public boolean registrationFormIsVisible(){
        Div divRegistrationForm = new Div(By.xpath("//div[@class ='modal-content']"),"divRegistrationForm");
        return divRegistrationForm.isElementDisplayed();
    }

    public void fillingInTheTable(String firstName, String secondName, String email, String age, String salary, String department){
        TextBox txtBoxFirstName = new TextBox(By.id("firstName"), "txtBoxFirstName");
        txtBoxFirstName.clear();
        txtBoxFirstName.putText(firstName);
        TextBox txtBoxSecondName = new TextBox(By.id("lastName"), "txtBoxSecondName");
        txtBoxSecondName.clear();
        txtBoxSecondName.putText(secondName);
        TextBox txtEmail = new TextBox(By.id("userEmail"), "txtEmail");
        txtEmail.clear();
        txtEmail.putText(email);
        TextBox txtAge = new TextBox(By.id("age"), "txtAge");
        txtAge.clear();
        txtAge.putText(age);
        TextBox txtSalary = new TextBox(By.id("salary"), "txtSalary");
        txtSalary.clear();
        txtSalary.putText(salary);
        TextBox txtDepartment = new TextBox(By.id("department"), "txtDepartment");
        txtDepartment.clear();
        txtDepartment.putText(department);
    }

    public void clickToSubmitBtn(){
        Button btnSubmit = new Button(By.id("submit"),"btnSubmit");
        btnSubmit.click();
    }

    public Integer findElementInTable(String firstName, String secondName, String email, String age, String salary, String department){
        String recordForComparison = firstName+secondName+age+email+salary+department;
        for (int i = 0; i < Integer.parseInt(JsonReader.read("searchDepthInTable", JsonReader.PathToTestJSON)); i++){
            Div tableRecord = new Div(By.xpath("//div[@class='rt-tr-group'][" + (i+1) + "]"), "record");
            if (tableRecord.getText().replace("\n","") != null){
                if(tableRecord.getText().replace("\n","").equals(recordForComparison)){
                    LoggerUtil.logInfo("Record in table");
                    return (i+1);
                }
            }
        }
        LoggerUtil.logWarning("Record not in table");
        return null;
    }

    public Boolean checkTableRecord(String firstName, String secondName, String email, String age, String salary, String department) {
        if (findElementInTable(firstName, secondName, email, age, salary, department) != null){
            return true;
        } else {
            return false;
        }
    }

    public void deleteRacord(String firstName, String secondName, String email, String age, String salary, String department){
        Button btnDeleteRecord = new Button(By.id("delete-record-"+findElementInTable(firstName,secondName,email,age,salary,department)),"btnDeleteRecord");
        btnDeleteRecord.click();
    }

    public Boolean checkIsRecordDelete(String firstName, String secondName, String email, String age, String salary, String department) {
        if (findElementInTable(firstName, secondName, email, age, salary, department) == null){
            return true;
        } else {
            return false;
        }
    }
}
