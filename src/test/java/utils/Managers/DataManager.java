package utils.Managers;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class DataManager {
    private static final ISettingsFile data = new JsonSettingsFile("data.json");

    public static String getVkUrl(){
        return data.getValue("/urls/VkMainPage").toString();
    }

    public static String getVkApiUrl(){
        return data.getValue("/urls/VkApi").toString();
    }

    public static String getMethodWallPost(){
        return data.getValue("/apiMethods/wallPost").toString();
    }

    public static String getMethodWallEdit(){
        return data.getValue("/apiMethods/wallEdit").toString();
    }

    public static String getMethodWallCreateComment(){
        return data.getValue("/apiMethods/wallCreateComment").toString();
    }

    public static String getMethodWallDelete(){
        return data.getValue("/apiMethods/wallDelete").toString();
    }

    public static String getMethodDocsGetWallUploadServer(){
        return data.getValue("/apiMethods/docsGetWallUploadServer").toString();
    }

    public static String getMethodDocsSave(){
        return data.getValue("/apiMethods/docsSave").toString();
    }

    public static String getMethodLikesIsLiked(){
        return data.getValue("/apiMethods/likesIsLiked").toString();
    }

    public static String getMethodUsersGet(){
        return data.getValue("/apiMethods/usersGet").toString();
    }

    public static String getParamKeyMassage(){
        return data.getValue("/apiParamKeys/massage").toString();
    }

    public static String getParamKeyFile(){
        return data.getValue("/apiParamKeys/file").toString();
    }

    public static String getParamKeyPostId(){
        return data.getValue("/apiParamKeys/postId").toString();
    }

    public static String getParamKeyAttachments(){
        return data.getValue("/apiParamKeys/attachments").toString();
    }

    public static String getParamKeyType(){
        return data.getValue("/apiParamKeys/type").toString();
    }

    public static String getParamKeyItemId(){
        return data.getValue("/apiParamKeys/itemId").toString();
    }

    public static String getParamKeyAccessToken(){
        return data.getValue("/apiParamKeys/accessToken").toString();
    }

    public static String getParamKeyVersion(){
        return data.getValue("/apiParamKeys/version").toString();
    }

    public static String getParamValueType(){
        return data.getValue("/apiParamValues/post").toString();
    }

}
