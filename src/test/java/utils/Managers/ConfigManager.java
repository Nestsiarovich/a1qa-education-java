package utils.Managers;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class ConfigManager {
    private static final ISettingsFile config = new JsonSettingsFile("config.json");

    public static String getLogin(){
        return config.getValue("/personalData/login").toString();
    }

    public static String getPassword(){
        return config.getValue("/personalData/password").toString();
    }

    public static String getToken(){
        return config.getValue("/personalData/token").toString();
    }

    public static String getPathToUploadDoc(){
        return config.getValue("/paths/UploadDoc").toString();
    }

    public static int getLengthRandomString(){
        return Integer.parseInt(config.getValue("/config/lengthRandomString").toString());
    }

    public static String getVersion(){
        return config.getValue("/config/apiVersion").toString();
    }

    public static int getUserIndex() {
        return Integer.parseInt(config.getValue("/config/userIndex").toString());
    }
}
