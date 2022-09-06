package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.*;
import org.openqa.selenium.By;

import java.util.concurrent.TimeoutException;

import static utils.Managers.SettingsManager.getTimeoutCondition;

public class PostForm extends BaseForm{
    private static By baseElementLocator;
    private ILabel baseElement = getElementFactory().getLabel(baseElementLocator, "BaseElement");
    private ILabel postAuthorLabel;
    private ILabel commentAuthorLabel;
    private ILabel postTextLabel;
    private ILink postImageLink;
    private IButton showNextCommentButton;
    private IButton likeButton;

    protected PostForm(int ownerId, int postId) {
        super(baseElementLocator = By.xpath(String.format("//div[@id = 'post%d_%d']", ownerId, postId)), String.format("post%d_%d", ownerId, postId));
        postAuthorLabel = baseElement.findChildElement(By.xpath("//h5[@class = 'post_author']//a"), "postAuthor", ILabel.class);
        commentAuthorLabel = baseElement.findChildElement(By.xpath("//div[@class = 'reply_author']//a"), "commentAuthor", ILabel.class);
        postTextLabel = baseElement.findChildElement(By.xpath("//div[contains(@class, 'wall_post_text')]"), "postText", ILabel.class);
        postImageLink = baseElement.findChildElement(By.xpath("//div[contains(@class,'page_post_sized_thumbs ')]//a"), "imageLink", ILink.class);
        showNextCommentButton = baseElement.findChildElement(By.xpath("//span[@class = 'js-replies_next_label']"), "nextCommentButton", IButton.class);
        likeButton = baseElement.findChildElement(By.xpath("//div[@class = 'PostButtonReactions__icon ']"), "likeButton", IButton.class);
    }

    public String getPostAuthorName(){
        return postAuthorLabel.getText();
    }

    public String getCommentAuthorName(){
        return commentAuthorLabel.getText();
    }

    public String getPostText(){
        return postTextLabel.getText();
    }

    public String getHrefImage(){
        return postImageLink.getHref();
    }

    public void clickShowNextCommentButton(){
        showNextCommentButton.click();
    }

    public void clickLikeButton(){
        likeButton.click();
    }

    public boolean isPostExist(){
        try {
            AqualityServices.getConditionalWait().waitForTrue(() -> this.state().waitForNotDisplayed());
            return this.state().isClickable();
        } catch (TimeoutException e) {
            throw new RuntimeException(String.format("Post %s doesn't delete for %s sec", this.getName(), getTimeoutCondition()));
        }
    }

    public void waitPostChanges(String textBeforeChanges){
        try {
            AqualityServices.getConditionalWait().waitForTrue(() -> textBeforeChanges != getPostText());
        } catch (TimeoutException e) {
            throw new RuntimeException(String.format("Page hasn't changes for %s sec", getTimeoutCondition()));
        }
    }
}
