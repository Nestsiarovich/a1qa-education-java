package utils;

import static utils.JSONReader.pathToDataTestJSON;

public class RequestCreator {
    static String request;

    public RequestCreator urlMainPage(){
        request = JSONReader.readByKey(pathToDataTestJSON, "mainPageURL");
        return this;
    }

    public RequestCreator add(String KeyOrValue){
        request = request + '/' + KeyOrValue;
        return this;
    }

    public static String createPostWithoutIdAsJSONString(int userId, String body, String title){
        return  "{\n"+
                "\"userId\": " + userId +",\n" +
                "\"body\": \"" + body +"\",\n" +
                "\"title\": \"" + title +"\"\n" +
                "}";
    }

    public String toString(){
        return request;
    }
}
