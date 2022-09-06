package classes;

import utils.JSONParser;
import utils.JSONReader;
import static utils.JSONReader.pathToDataTestJSON;

public class Post{
    private int userId;
    private int id;
    private String title;
    private String body;

    public int getUserId(){
        return this.userId;
    }

    public int getId(){
        return this.id;
    }

    public static boolean isStringParserableToPostsArray(String string){
        try {
            JSONParser.parseJSONToPostsArray(string);
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean isPostArraySortedAscendingById(Post[] posts){
        for (int i = 1; i < posts.length; i++) {
            if (posts[i - 1].getId() > posts[i].getId())
                return false;
        }
        return true;
    }

    public boolean isCorrectInformationIn99Post(){
        if ((userId == Integer.parseInt(JSONReader.readByKey(pathToDataTestJSON, "99PostUserId")))
                && (id == Integer.parseInt(JSONReader.readByKey(pathToDataTestJSON, "99PostId")))
                && (!title.isEmpty()) && (!body.isEmpty()))
            return true;
        return false;
    }
}
