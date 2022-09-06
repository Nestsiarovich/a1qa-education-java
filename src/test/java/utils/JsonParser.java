package utils;

import classes.*;
import com.google.gson.Gson;

public class JsonParser {
    private static Gson gson = new Gson();

    public static ResponsePostId parseJsonToResponsePostId(String stringJSON){
        return gson.fromJson(stringJSON, ResponsePostId.class);
    }

    public static ResponseLike parseJsonToResponseLike(String stringJSON){
        return gson.fromJson(stringJSON, ResponseLike.class);
    }

    public static ResponseDocUploadServer parseJsonToResponseDocUploadServer(String stringJSON){
        return gson.fromJson(stringJSON, ResponseDocUploadServer.class);
    }

    public static ResponseFile parseJsonToResponseFile(String stringJSON){
        return gson.fromJson(stringJSON, ResponseFile.class);
    }

    public static ResponseDoc parseJsonToResponseDoc(String stringJSON){
        return gson.fromJson(stringJSON, ResponseDoc.class);
    }

    public static ResponseUser parseJsonToResponseUser(String stringJSON) {
        return gson.fromJson(stringJSON, ResponseUser.class);
    }
}
