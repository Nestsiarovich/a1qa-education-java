package pages;

import framework.browser.DriverFactory;
import framework.elements.Button;
import framework.elements.TextBox;
import framework.pages.BasePage;
import framework.utils.JSExecutor;
import framework.utils.Randomizer;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class DemoQASliderPage extends BasePage {
    private static int RandomPercent;
    public DemoQASliderPage(By locator, String name) {
        super(locator, name);
    }

    public double sliderError(){
        if (RandomPercent > 50) {
            return -(Math.abs((float)(RandomPercent - 50)*0.2));
        } else {
            return Math.abs(((float)RandomPercent - 50)*0.2);
        }
    }

    public void clickSlider() {
        RandomPercent = Randomizer.getRandomPercent();
        TextBox slider = new TextBox(By.xpath("//input[contains(@class,'range-slider')]"),"slider");
        Actions actions = new Actions(DriverFactory.getDriver());
        actions.moveToElement(slider.getWebElement()).perform();
        actions.moveByOffset(-(slider.getWidth() / 2), 0).perform();
        actions.moveByOffset((int)((float)slider.getWidth() / 100 * RandomPercent + sliderError()), 0).perform();
        actions.click().perform();
    }

    public String getSliderValue(){
        TextBox txtSlider = new TextBox(By.id("sliderValue"),"txtSliderValue");
        return txtSlider.getAtributeValue("value");
    }

    public String getRandomPercent(){
        return Integer.toString(RandomPercent);
    }

    public void clickToProgressBarBtn(){
        Button btnProgressBar = new Button(By.xpath("//div[@class='element-list collapse show']//li[@id='item-4']"),"btnProgressBar");
        JSExecutor.click(btnProgressBar);
    }
}
