package tests;

import classes.ResponseDoc;
import enums.LikeCodes;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.VkAuthorizationPage;
import pages.*;

import static utils.Managers.ConfigManager.*;
import static utils.Randomizer.getRandomString;
import static utils.VkApiUtils.VkApiRequestSender.*;

public class VkTest extends BaseTest{
    @Test
    public void vkApiUiTest(){
        VkMainPage vkMainPage = new VkMainPage(By.xpath("//div[@id = 'index_login']"),"vkMainPage");
        VkAuthorizationPage vkAuthorizationPage = new VkAuthorizationPage(By.xpath("//div[contains(@class, 'vkc__PassportBox__rightCol')]"),"vkAuthorizationPage");
        VkFeedPage vkFeedPage = new VkFeedPage(By.xpath("//div[@id = 'main_feed']"), "vkFeedPage");
        VkMyProfilePage vkMyProfilePage;
        PostForm post;
        ResponseDoc responseDoc;
        int userId;
        int postId;
        String messageBeforeEdit;
        String message;
        String imageIndicator;

        vkMainPage.waitToDisplayed();
        Assert.assertTrue(vkMainPage.isDisplayed(), "Failed to go to Main page");
        vkMainPage.clickSignInButton();
        vkAuthorizationPage.authorization();
        vkFeedPage.waitToDisplayed();
        Assert.assertTrue(vkFeedPage.isDisplayed(), "Authorization failed");
        vkMyProfilePage = vkFeedPage.switchToLeftMenuForm().clickMyProfileButton();
        vkMyProfilePage.waitToDisplayed();
        Assert.assertTrue(vkMyProfilePage.isDisplayed(), "Failed to go to My Profile");
        postId = addPostApi(message = getRandomString(getLengthRandomString())).getPostId();
        userId = getUserApi().getUserId(getUserIndex());
        post = vkMyProfilePage.switchToPostForm(userId, postId);
        Assert.assertEquals(post.getPostAuthorName(), vkMyProfilePage.getPageName(), "Page and Author names are different");
        Assert.assertEquals(post.getPostText(), message, "Text in post incorrect");
        responseDoc = saveDocApi(uploadFileToServerApi(getUploadServerApi().getDocUploadUrl()).getFile());
        imageIndicator = String.format("%s%d_%d",responseDoc.getType(), responseDoc.getOwnerId(), responseDoc.getId());
        messageBeforeEdit = message;
        editPostAddDocApi(Integer.toString(postId), message = getRandomString(getLengthRandomString()), imageIndicator);
        post.waitPostChanges(messageBeforeEdit);
        Assert.assertEquals(post.getPostText(), message, "Text in post incorrect");
        Assert.assertTrue(post.getHrefImage().contains(imageIndicator), "Image in post incorrect");
        addCommentToPostApi(Integer.toString(postId), getRandomString(getLengthRandomString()));
        post.clickShowNextCommentButton();
        Assert.assertEquals(post.getCommentAuthorName(), vkMyProfilePage.getPageName(), "Page and Comment name are different");
        post.clickLikeButton();
        Assert.assertEquals(getPostLikeApi(Integer.toString(postId)).getLikedCode(), LikeCodes.IS_LIKED.getCode(), "Post isn't liked");
        deletePostApi(Integer.toString(postId));
        Assert.assertFalse(post.isPostExist(), "Post not deleted");
    }
}
