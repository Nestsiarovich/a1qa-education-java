package pages;

import framework.elements.Button;
import framework.elements.Div;
import framework.pages.BasePage;
import framework.utils.JsonReader;
import framework.utils.LoggerUtil;
import org.openqa.selenium.By;

public class DemoQAProgressBarPage extends BasePage {
    public DemoQAProgressBarPage(By locator, String name) {
        super(locator, name);
    }

    public void clickToStartStopBtn(){
        Button btnStartStop = new Button(By.id("startStopButton"),"btnStartStop");
        btnStartStop.click();
    }

    public void stopProgressBar(){
        boolean check = false;
        if ((Integer.parseInt(JsonReader.read("engineersAge", JsonReader.PathToTestJSON)) <= 100) && (Integer.parseInt(JsonReader.read("engineersAge", JsonReader.PathToTestJSON)) >= 0))
            check = true;
        else
            LoggerUtil.logWarning("Incorrect Age");
        while (check){
            Div progressBar = new Div(By.xpath("//div[@role='progressbar']"),"progressBar");
            if (progressBar.getAtributeValue("aria-valuenow").equals(JsonReader.read("engineersAge", JsonReader.PathToTestJSON))){
                clickToStartStopBtn();
                break;
            }
        }
    }

    public boolean checkProgressBarResult(){
        Div progressBar = new Div(By.xpath("//div[@role='progressbar']"),"progressBar");
        int ageDifference = Math.abs(Integer.parseInt(progressBar.getAtributeValue("aria-valuenow")) - Integer.parseInt(JsonReader.read("engineersAge", JsonReader.PathToTestJSON)));
        if (ageDifference <= Integer.parseInt(JsonReader.read("ageError", JsonReader.PathToDataTestsJSON)))
            return true;
        else
            return false;
    }
}
