package pages;

import framework.browser.Browser;
import framework.elements.Button;
import framework.elements.Span;
import framework.pages.BasePage;
import framework.utils.JSExecutor;
import framework.utils.JsonReader;
import framework.utils.LoggerUtil;
import org.openqa.selenium.By;

public class DemoQANestedFramesPage extends BasePage {
    public DemoQANestedFramesPage(By locator, String name) {
        super(locator, name);
    }

    public boolean checkNestedFrames(){
        Browser.switchToFrame(By.xpath("//iframe[@src='/sampleiframe']"));
        Span txtInParentFrame = new Span(By.xpath("//body"), "txtInParentFrame");
        if (txtInParentFrame.getText().equals(JsonReader.read("txtInParentFrameCheck",JsonReader.PathToDataTestsJSON))){
            Browser.switchToFrame(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
            Span txtInChildFrame = new Span(By.xpath("//body"), "txtInChildFrame");
            if (txtInChildFrame.getText().equals(JsonReader.read("txtInChildFrameCheck",JsonReader.PathToDataTestsJSON))){
                Browser.switchToDefaultContent();
                return true;
            } else {
                LoggerUtil.logWarning("Text in child frame is incorrect - " + txtInChildFrame.getText());
                Browser.switchToDefaultContent();
                return false;
            }
        } else {
            LoggerUtil.logWarning("Text in parent frame is incorrect - " + txtInParentFrame.getText());
            Browser.switchToDefaultContent();
            return false;
        }
    }

    public void clickToFramesBtn(){
        Button btnFrames = new Button(By.xpath("//div[@class='element-list collapse show']//li[@id='item-2']"),"btnFrames");
        JSExecutor.click(btnFrames);
    }
}
