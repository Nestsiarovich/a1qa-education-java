package pages;

import org.openqa.selenium.By;

public class VkFeedPage extends BaseForm{
    public VkFeedPage(By locator, String name) {
        super(locator, name);
    }

    public LeftMenuForm switchToLeftMenuForm(){
        return new LeftMenuForm();
    }
}
