package pages;

import aquality.selenium.elements.interfaces.ILabel;
import elements.GroupCheckBox;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.elements.ElementState;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeoutException;

public class SecondGameUserinterfaceForm extends Form {
    private IElementFactory elementFactory = AqualityServices.getElementFactory();
    private GroupCheckBox groupCheckBox = elementFactory.getCustomElement(GroupCheckBox::new, By.xpath("//span[@class = 'checkbox__box']"), "groupCheckBox", ElementState.DISPLAYED);
    private IButton uploadButton = elementFactory.getButton(By.xpath("//a[contains(@class,'upload-button')]"), "uploadButton", ElementState.DISPLAYED);
    private IButton nextButton = elementFactory.getButton(By.xpath("//button[@type='button'][text()='Next']"), "nextButton", ElementState.DISPLAYED);
    private ILabel image = elementFactory.getLabel(By.xpath("//div[contains(@class, 'avatar-image')]"), "image", ElementState.EXISTS_IN_ANY_STATE);
    private static final ISettingsFile testsData = new JsonSettingsFile("TestsData.json");
    private static final ISettingsFile testsConfig = new JsonSettingsFile("TestsConfig.json");
    public SecondGameUserinterfaceForm(By locator, String name) {
        super(locator, name);
    }

    public void selectInterest(){
        groupCheckBox.checkLastCheckBox();
        Set<Integer> generated = new HashSet<Integer>();
        Random r = new Random();
        while (generated.size() < Integer.parseInt(testsData.getValue("/interestsNumber").toString())) {
            if (r.nextInt(groupCheckBox.getSize()) == Integer.parseInt(testsData.getValue("/selectAllInterestsIndex").toString()))
                continue;
            generated.add(r.nextInt(groupCheckBox.getSize()));
        }
        Integer[] indexes = generated.toArray(new Integer[generated.size()]);
        for (int i = 0; i < indexes.length; i++)
            groupCheckBox.getElement(indexes[i]).click();
    }

    public void uploadImage() {
        uploadButton.click();
        try {
            Thread.sleep(1000); //agreed to leave
            Runtime.getRuntime().exec(testsConfig.getValue("/pathToUploadScript").toString());
            AqualityServices.getConditionalWait().waitForTrue(() -> image.state().waitForDisplayed());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickNextButton(){
        nextButton.click();
    }

    @Override
    public boolean isDisplayed(){
        return AqualityServices.getBrowser().getDriver().findElement(getLocator()).isDisplayed();
    }
}
