package tests;

import classes.Post;
import classes.User;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.*;
import static utils.JSONReader.pathToConfigTestJSON;
import static utils.JSONReader.pathToDataTestJSON;
import static utils.RequestCreator.createPostWithoutIdAsJSONString;
import static utils.RequestSending.getRequest;
import static utils.RequestSending.postRequest;

public class APITests {
    @Test
    public void getAllPostsTest(){
        String posts = JSONReader.readByKey(pathToConfigTestJSON,"posts");
        RequestCreator builder = new RequestCreator();
        Response response = getRequest(builder.urlMainPage().add(posts).toString());
        Assert.assertEquals(response.getStatusCode(), StatusCodes.GETSUCCESS.code,
                String.format("Status code = %d", response.getStatusCode()));
        Assert.assertTrue(Post.isStringParserableToPostsArray(response.body().asString()),
                "Response body isn't parserable to Post Object");
        Post[] postsArray = JSONParser.parseJSONToPostsArray(response.body().asString());
        Assert.assertTrue(Post.isPostArraySortedAscendingById(postsArray),
                "Posts aren't sorted ascending (by id)");
    }

    @Test
    public void get99PostTest(){
        String posts = JSONReader.readByKey(pathToConfigTestJSON,"posts");
        String id = JSONReader.readByKey(pathToConfigTestJSON,"id99");
        RequestCreator builder = new RequestCreator();
        Response response = getRequest(builder.urlMainPage().add(posts).add(id).toString());
        Assert.assertEquals(response.getStatusCode(), StatusCodes.GETSUCCESS.code,
                String.format("Status code = %d", response.getStatusCode()));
        Post post = JSONParser.parseJSONToPost(response.body().asString());
        Assert.assertTrue(post.isCorrectInformationIn99Post(),
                String.format("Post incorrect(UserId = %d; Id = %d)", post.getUserId(), post.getId()));
    }

    @Test
    public void get150PostTest(){
        String posts = JSONReader.readByKey(pathToConfigTestJSON,"posts");
        String id = JSONReader.readByKey(pathToConfigTestJSON,"id150");
        String isEmpty = JSONReader.readByKey(pathToDataTestJSON,"emptyJsonObject");
        RequestCreator builder = new RequestCreator();
        Response response = getRequest(builder.urlMainPage().add(posts).add(id).toString());
        Assert.assertEquals(response.getStatusCode(), StatusCodes.GETERROR.code,
                String.format("Status code = %d", response.getStatusCode()));
        Assert.assertEquals(response.body().asString(),isEmpty,
                "Response body isn't empty");
    }

    @Test
    public void post101PostTest(){
        int userId = Integer.parseInt(JSONReader.readByKey(pathToConfigTestJSON, "101PostUserId"));
        int length = Integer.parseInt(JSONReader.readByKey(pathToConfigTestJSON,"randomLinesLength"));
        String posts = JSONReader.readByKey(pathToConfigTestJSON,"posts");
        String postUserId = JSONReader.readByKey(pathToDataTestJSON,"101PostUserId");
        String fieldUserId = JSONReader.readByKey(pathToDataTestJSON,"fieldUserId");
        String fieldBody = JSONReader.readByKey(pathToDataTestJSON,"fieldBody");
        String fieldTitle = JSONReader.readByKey(pathToDataTestJSON,"fieldTitle");
        String fieldId = JSONReader.readByKey(pathToDataTestJSON,"fieldId");
        String randomBody = Randomizer.generateRandomString(length);
        String randomTitle = Randomizer.generateRandomString(length);
        RequestCreator builder = new RequestCreator();
        Response response = postRequest(createPostWithoutIdAsJSONString(userId, randomBody, randomTitle),
                builder.urlMainPage().add(posts).toString());
        Assert.assertEquals(response.getStatusCode(), StatusCodes.POSTSECCESS.code,
                String.format("Status code = %d", response.getStatusCode()));
        Assert.assertEquals(response.jsonPath().getString(fieldUserId), postUserId,
                String.format("userId = %s", response.jsonPath().getString(fieldUserId)));
        Assert.assertEquals(response.jsonPath().getString(fieldBody), randomBody,
                String.format("body = %s", response.jsonPath().getString(fieldBody)));
        Assert.assertEquals(response.jsonPath().getString(fieldTitle), randomTitle,
                String.format("title = %s", response.jsonPath().getString(fieldTitle)));
        Assert.assertFalse(response.jsonPath().getString(fieldId).isEmpty(),
                "Id is empty");
    }

    @Test
    public void getUsersTest(){
        String users = JSONReader.readByKey(pathToConfigTestJSON,"users");
        int id = Integer.parseInt(JSONReader.readByKey(pathToDataTestJSON, "5UserId"));
        RequestCreator builder = new RequestCreator();
        Response response = getRequest(builder.urlMainPage().add(users).toString());
        Assert.assertEquals(response.getStatusCode(), StatusCodes.GETSUCCESS.code,
                String.format("Status code = %d", response.getStatusCode()));
        Assert.assertTrue(User.isStringParserableToUsersArray(response.body().asString()),
                "Response body isn't parserable to User Object");
        User[] usersArray = JSONParser.parseJSONToUsersArray(response.body().asString());
        Assert.assertEquals(JSONParser.getUserAsJSONString(usersArray[User.findIndexById(usersArray, id)]), JSONParser.getUserAsJSONString(JSONParser.getUserId5InfoFromFile()),
                String.format("User (id=%d) data incorrect", id));
    }

    @Test
    public void get5UserTest(){
        String users = JSONReader.readByKey(pathToConfigTestJSON,"users");
        String id = JSONReader.readByKey(pathToConfigTestJSON,"id5");
        RequestCreator builder = new RequestCreator();
        Response response = getRequest(builder.urlMainPage().add(users).add(id).toString());
        Assert.assertEquals(response.getStatusCode(), StatusCodes.GETSUCCESS.code,
                String.format("Status code = %d", response.getStatusCode()));
        Assert.assertEquals(JSONParser.getUserAsJSONString(JSONParser.getUserId5InfoFromFile()), User.lineAdjustment(response.body().asString()),
                "User (id=5) data incorrect");
    }
}