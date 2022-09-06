package framework.utils;

import framework.browser.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    public static void waitElementIsVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(Integer.parseInt(JsonReader.read("ExplicitWaitLimit", JsonReader.PathToFrameworkJSON))));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitAlertIsVisible(){
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(Integer.parseInt(JsonReader.read("ExplicitWaitLimit", JsonReader.PathToFrameworkJSON))));
        wait.until(ExpectedConditions.alertIsPresent());
    }

}
