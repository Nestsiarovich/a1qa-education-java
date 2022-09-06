package pages;

import elements.DivComboBox;
import utils.Randomizer;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.elements.ElementState;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class FirstGameUserinterfaceForm extends Form {
    private IElementFactory elementFactory = AqualityServices.getElementFactory();
    private ITextBox passwordInput = elementFactory.getTextBox(By.xpath("//input[contains(@placeholder, 'Password')]"), "passwordInput", ElementState.DISPLAYED);
    private ITextBox emailInput = elementFactory.getTextBox(By.xpath("//input[contains(@placeholder, 'email')]"), "emailInput", ElementState.DISPLAYED);
    private ITextBox domainInput = elementFactory.getTextBox(By.xpath("//input[@placeholder='Domain']"), "domainInput", ElementState.DISPLAYED);
    private IButton tLDButton = elementFactory.getButton(By.xpath("//div[@class='dropdown__opener']"), "TLDButton", ElementState.DISPLAYED);
    private IButton nextButton = elementFactory.getButton(By.xpath("//a[@class='button--secondary']"), "nextButton", ElementState.DISPLAYED);
    private IButton hideButton = elementFactory.getButton(By.xpath("//button[contains(@class, 'help-form__send-to-bottom-button')]"), "hideButton", ElementState.DISPLAYED);
    private IButton disagreeCookiesButton = elementFactory.getButton(By.xpath("//button[contains(text(), 'no')]"), "disagreeCookiesButton", ElementState.DISPLAYED);
    private DivComboBox tLDDropdown = elementFactory.getCustomElement(DivComboBox::new, By.xpath("//div[contains(@class,'dropdown__list-item')]"), "TLDDropdown", ElementState.DISPLAYED);
    private ICheckBox acceptCheckBox = elementFactory.getCheckBox(By.xpath("//span[contains(@class, 'checkbox__check')]"),"AcceptCheckBox", ElementState.DISPLAYED);
    private ILabel helpFormTitle = elementFactory.getLabel(By.xpath("//h2[@class = 'help-form__title']"), "helpFormTitle", ElementState.DISPLAYED);
    private ILabel timer = elementFactory.getLabel(By.xpath("//div[contains(@class, 'timer')] "), "timer", ElementState.DISPLAYED);
    private static final ISettingsFile testsData = new JsonSettingsFile("TestsData.json");
    private String password = "";
    private String email = "";

    public FirstGameUserinterfaceForm(By locator, String name) {
        super(locator, name);
    }

    private String getPassword(){
        password = Randomizer.passwordGeneration();
        return password;
    }

    private boolean emailCheck(){
        char[] charEmailArray = email.toCharArray();
        char[] charPasswordArray = password.toCharArray();
        for (int i = 0; i < charEmailArray.length; i++)
            for (int j = 0; j < charPasswordArray.length; j++){
                if (charEmailArray[i] == charPasswordArray[j])
                    return true;
            }
        return false;
    }

    private String getEmail(){
        email = Randomizer.emailGeneration();
        while (true){
            if (emailCheck())
                break;
            email = Randomizer.emailGeneration();
        }
        return email;
    }

    private int getDomainIndex(){
        while (true){
            int index = Randomizer.generateRandomIndexForComboBox(tLDDropdown.getSize());
            if (tLDDropdown.getElement(index).equals(testsData.getValue("/comboBoxException")) == false){
                return index;
            }
        }
    }

    public void fillingOutTheForm(){
        passwordInput.clearAndType(getPassword());
        emailInput.clearAndType(getEmail());
        domainInput.clearAndType(Randomizer.domainGeneration());
        tLDButton.click();
        tLDDropdown.getElement(getDomainIndex()).click();
        acceptCheckBox.check();
    }

    public void clickNextButton(){
        nextButton.click();
    }

    public void hideHelpForm(){
        hideButton.click();
        helpFormTitle.state().waitForNotDisplayed();
    }

    public boolean isHelpFormHide(){
        return !helpFormTitle.state().isDisplayed();
    }

    public void acceptCookies(){
        disagreeCookiesButton.state().waitForClickable();
        disagreeCookiesButton.click();
    }

    public boolean isCookiesFormHide(){
        return !disagreeCookiesButton.state().isDisplayed();
    }


    public String getTimerValue(){
        return timer.getText();
    }

    public String getTimerComparisonValue(){
        return testsData.getValue("/timerComparisonValue").toString();
    }

    @Override
    public boolean isDisplayed(){
        return AqualityServices.getBrowser().getDriver().findElement(getLocator()).isDisplayed();
    }
}
