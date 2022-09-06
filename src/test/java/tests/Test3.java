package tests;

import framework.browser.Browser;
import framework.tests.BaseTest;
import framework.utils.JsonReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DemoQAElementsPage;
import pages.DemoQAMainPage;
import pages.DemoQAWebTablesPage;

public class Test3 extends BaseTest {
    private DemoQAMainPage MainPage = new DemoQAMainPage(By.id("app"), "MainPageToolsQA");
    private DemoQAElementsPage ElementsPage = new DemoQAElementsPage(By.id("app"), "ElementsPageToolsQA");
    private DemoQAWebTablesPage WebTablesPage = new DemoQAWebTablesPage(By.id("app"), "WebTablesPageToolsQA");

    @DataProvider
    public Object[][] testData() {
        return new Object[][] {
                new Object[] {"Jon","Snow","knownothing@gmail.com","30","3000","alpha"},
                new Object[] {"Buttercup","Cumbersnatch", "BudapestCandygram@mail.ru", "41", "2000", "beta"},
        };
    }

    @Test (dataProvider = "testData")
    public void tablesTest(String firstName, String secondName, String email, String age, String salary, String department) {
        Browser.openPage(JsonReader.read("urlToMainPage", JsonReader.PathToDataTestsJSON));
        Assert.assertTrue(MainPage.isPageOpened(), MainPage.getPageName() + " isn't open");
        MainPage.clickToElementsBtn();
        ElementsPage.clickToWebTablesBtn();
        Assert.assertTrue(WebTablesPage.isPageOpened(), WebTablesPage.getPageName() + " isn't open");
        WebTablesPage.clickToAddBtn();
        Assert.assertTrue(WebTablesPage.registrationFormIsVisible(),"Registration form isn't open");
        WebTablesPage.fillingInTheTable(firstName, secondName, email, age, salary, department);
        WebTablesPage.clickToSubmitBtn();
        Assert.assertTrue(WebTablesPage.checkTableRecord(firstName, secondName, email, age, salary, department), "Record not in table");
        WebTablesPage.deleteRacord(firstName, secondName, email, age, salary, department);
        Assert.assertTrue(WebTablesPage.checkIsRecordDelete(firstName, secondName, email, age, salary, department), "Record not deleted");
    }
}
