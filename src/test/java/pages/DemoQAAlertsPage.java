package pages;

import framework.browser.Browser;
import framework.elements.Button;
import framework.elements.Span;
import framework.pages.BasePage;
import framework.utils.JsonReader;
import framework.utils.LoggerUtil;
import framework.utils.Randomizer;
import framework.utils.Waits;
import org.openqa.selenium.By;

public class DemoQAAlertsPage extends BasePage {
    public DemoQAAlertsPage(By locator, String name) {
        super(locator, name);
    }

    private static String RandomTXT;

    public void clickToSeeAlertsBtn(){
        Button btnToSeeAlerts = new Button(By.id("alertButton"), "btnToSeeAlert");
        btnToSeeAlerts.click();
    }

    public String getAlertText(){
        return Browser.getAlert().getText();
    }

    public void clickOkInAlert(){
        Waits.waitAlertIsVisible();
        LoggerUtil.logInfo("Click 'ok' in alert");
        Browser.getAlert().accept();
    }

    public boolean checkIsAlertClosed(){
        try{
            Browser.getAlert();
            LoggerUtil.logWarning("Alert is open");
            return false;
        } catch (Exception e){
            LoggerUtil.logInfo("Alert is closed");
            return true;
        }
    }

    public void clickConfirmBoxWillAppearBtn(){
        Button btnConfirmBoxWillAppear = new Button(By.id("confirmButton"), "btnConfirmBoxWillAppear");
        btnConfirmBoxWillAppear.click();
    }

    public String checkConfirmText() {
        Span txtConfirmResult = new Span(By.id("confirmResult"), "txtConfirmResult");
        return txtConfirmResult.getText();
    }

    public void clickPromptBoxWillAppearBtn(){
        Button btnToPromptBoxWillAppear = new Button(By.id("promtButton"), "btnPromptBoxWillAppear");
        btnToPromptBoxWillAppear.click();
    }

    public void sendTextToAlert(){
        RandomTXT = Randomizer.getRandomString(Integer.parseInt(JsonReader.read("lengthRandomText",JsonReader.PathToTestJSON)));
        Waits.waitAlertIsVisible();
        LoggerUtil.logInfo("Put text to alert - " + RandomTXT);
        Browser.getAlert().sendKeys(RandomTXT);
    }

    public String checkRandomText(){
        Span txtPromptResult = new Span(By.id("promptResult"), "txtConfirmResult");
        return txtPromptResult.getText();
    }

    public String getRandomTXT(){
        return RandomTXT;
    }
}
