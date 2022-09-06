package utils;

import classes.Post;
import classes.User;
import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JSONParser {
    private static Gson gson = new Gson();

    public static Post parseJSONToPost(String stringJSON){
        return gson.fromJson(stringJSON, Post.class);
    }

    public static Post[] parseJSONToPostsArray(String stringJSON){
        return gson.fromJson(stringJSON, Post[].class);
    }

    public static User parseJSONToUser(String stringJSON){
        return gson.fromJson(stringJSON, User.class);
    }

    public static User[] parseJSONToUsersArray(String stringJSON){
        return gson.fromJson(stringJSON, User[].class);
    }

    public static User getUserId5InfoFromFile()
    {
        try {
            return gson.fromJson(new FileReader("src/test/resources/UserId5Info.json"), User.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getUserAsJSONString(User user){
        return gson.toJson(user);
    }
}
