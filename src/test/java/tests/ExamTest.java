package tests;

import aquality.selenium.browser.AqualityServices;
import forms.*;
import io.restassured.response.Response;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Utils;
import static aquality.selenium.browser.AqualityServices.*;
import static utils.Randomizer.*;
import static utils.apiUtils.RequestSender.*;
import static utils.apiUtils.StatusCodes.*;
import static utils.managers.ConfigManager.*;
import static utils.managers.ConfigManager.ConfigKeys.*;
import static utils.managers.DataManager.*;
import static utils.managers.DataManager.DataKeys.*;

public class ExamTest extends BaseTest{
    @Test
    public void ExamUiApiV2Test(){
        Response response;
        String projectId;
        String projectName;
        String testId;
        String testName;
        ProjectsPage projectsPage = new ProjectsPage("projectsPage");
        ProjectPage projectPage = new ProjectPage("projectPage");
        AddProjectPage addProjectPage = new AddProjectPage("addProjectPage");

        response = getAccessTokenApi(getConfigValue(VARIANT));
        Assert.assertEquals(response.statusCode(), SUCCESS.code,
                String.format("Token request failed\nStatus code: %d\nResponse: %s", response.statusCode(), response.body().asPrettyString()));
        projectsPage.waitToDisplayed();
        Assert.assertTrue(projectsPage.getBaseLocatorText().contains(getConfigValue(HOME_PAGE_INDICATOR)),
                String.format("Failed to display %s form", projectsPage.getName()));
        sendCookieApi(getDataValue(DataKeys.PARAM_TOKEN), response.body().asString());
        getBrowser().refresh();
        projectsPage.getFooterForm().waitToDisplayed();
        Assert.assertEquals(projectsPage.getFooterForm().getVersion(), getConfigValue(VARIANT),
                String.format("Version is incorrect: %s\nMust be: %s", projectsPage.getFooterForm().getVersion(), getConfigValue(VARIANT)));
        projectId = projectsPage.switchToListGroupForm().clickElementReturnId(getConfigValue(PROJECT_NAME));
        projectPage.switchToNavTabsForm().waitToDisplayed();
        Assert.assertTrue(projectPage.switchToNavTabsForm().getTabHref().contains(String.format("%s%s",getConfigValue(PROJECT_ID_TEXT) ,projectId)),
                String.format("Failed to display %s", projectPage.getName()));
        Assert.assertTrue(Utils.isTableSorted(getConfigValue(SORT_COLUMN_NAME), projectPage.switchToTestsTableForm().getCellsFormColumnByName(getConfigValue(SORT_COLUMN_NAME))),
                String.format("Table isn't sorted by %s",getConfigValue(SORT_COLUMN_NAME)));
        Assert.assertTrue(Utils.isTestsInResponseByName(getTestsJsonApi(projectId), projectPage.switchToTestsTableForm().getCellsFormColumnByName(getConfigValue(SEARCH_COLUMN_NAME))),
                "Test isn't in response");
        getBrowser().goBack();
        projectsPage.waitToDisplayed();
        Assert.assertTrue(projectsPage.getBaseLocatorText().contains(getConfigValue(HOME_PAGE_INDICATOR)),
                String.format("Failed to display %s form!", projectsPage.getName()));
        projectsPage.switchToPanelHeadingForm().clickAddLink();
        projectName = getRandomString(getConfigValueAsInt(LENGTH_RANDOM_STRING));
        AqualityServices.getBrowser().tabs().switchToTab(1);
        addProjectPage.waitToDisplayed();
        Assert.assertTrue(addProjectPage.isDisplayed(),
                String.format("Failed to display %s", addProjectPage.getName()));
        Assert.assertTrue(addProjectPage.addProject(projectName),
                String.format("Project %s not saved", projectName));
        AqualityServices.getBrowser().tabs().closeTab();
        AqualityServices.getBrowser().tabs().switchToTab(0);
        AqualityServices.getBrowser().refresh();
        Assert.assertTrue(projectsPage.switchToListGroupForm().isElementInForm(projectName),
                String.format("Project %s not in %s", projectName, projectsPage.switchToListGroupForm().getName()));
        projectId = projectsPage.switchToListGroupForm().clickElementReturnId(projectName);
        projectPage.switchToNavTabsForm().waitToDisplayed();
        Assert.assertTrue(projectPage.switchToNavTabsForm().getTabHref().contains(String.format("%s%s",getConfigValue(PROJECT_ID_TEXT) ,projectId)),
                String.format("Failed to display %s", projectPage.getName()));
        testName = getRandomString(getConfigValueAsInt(LENGTH_RANDOM_STRING));
        response = putTestApi(getRandomString(getConfigValueAsInt(LENGTH_RANDOM_STRING)), projectName, testName,
                getRandomString(getConfigValueAsInt(LENGTH_RANDOM_STRING)), getConfigValue(MACHINE_ADDRESS));
        Assert.assertEquals(response.statusCode(), SUCCESS.code,
                String.format("Test not putted\nStatus code: %d\nResponse: %s", response.statusCode(), response.body().asPrettyString()));
        testId = response.body().asString();
        response = putTestLogApi(testId, getRandomString(getConfigValueAsInt(LENGTH_RANDOM_STRING)));
        Assert.assertEquals(response.statusCode(), SUCCESS.code,
                String.format("Log not putted\nStatus code: %d\nResponse: %s", response.statusCode(), response.body().asPrettyString()));
        response = putTestAttachment(testId, AqualityServices.getBrowser().getDriver().getScreenshotAs(OutputType.BASE64), getDataValue(CONTENT_TYPE));
        Assert.assertEquals(response.statusCode(), SUCCESS.code,
                String.format("ScreenShot not uploaded\nStatus code: %d\nResponse: %s", response.statusCode(), response.body().asPrettyString()));
        projectPage.switchToTestsTableForm().waitDangerAlertIsNotDisplayed();
        Assert.assertTrue(Utils.isTestInTableByName(testName,projectPage.switchToTestsTableForm().getCellsFormColumnByName(getConfigValue(SEARCH_COLUMN_NAME))),
                String.format("Test %s not in table", testName));
    }
}
