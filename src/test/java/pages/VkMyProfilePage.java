package pages;

import aquality.selenium.elements.interfaces.*;
import org.openqa.selenium.By;

public class VkMyProfilePage extends BaseForm{
    private ILabel pageName = getElementFactory().getLabel(By.xpath("//h1[@class = 'page_name']"), "pageName");

    public VkMyProfilePage(By locator, String name) {
        super(locator, name);
    }

    public String getPageName(){
        return pageName.getText();
    }

    public PostForm switchToPostForm(int userId, int postId){
        return new PostForm(userId, postId);
    }
}
