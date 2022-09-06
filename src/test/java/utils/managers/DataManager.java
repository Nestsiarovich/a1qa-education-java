package utils.managers;

import aquality.selenium.core.utilities.*;

public class DataManager {
    private static final ISettingsFile data = new JsonSettingsFile("data.json");
    public enum DataKeys{
        METHOD_TOKEN_GET("/apiMethods/tokenGet"),
        METHOD_TEST_GET_JSON("/apiMethods/testGetJson"),
        METHOD_TEST_PUT("/apiMethods/testPut"),
        METHOD_TEST_PUT_LOG("/apiMethods/testPutLog"),
        METHOD_TEST_PUT_ATTACHMENT("/apiMethods/testPutAttachment"),
        PARAM_VARIANT("/apiParams/variant"),
        PARAM_TOKEN("/apiParams/token"),
        PARAM_PROJECT_ID("/apiParams/projectId"),
        PARAM_SID("/apiParams/sid"),
        PARAM_PROJECT_NAME("/apiParams/projectName"),
        PARAM_TEST_NAME("/apiParams/testName"),
        PARAM_TEST_ID("/apiParams/testId"),
        PARAM_CONTENT("/apiParams/content"),
        PARAM_CONTENT_TYPE("/apiParams/contentType"),
        PARAM_METHOD_NAME("/apiParams/methodName"),
        PARAM_ENV("/apiParams/env"),
        CONTENT_TYPE("/contentType/imagePng");

        public String key;
        DataKeys(String key) {
            this.key = key;
        }
    }

    public static String getDataValue(DataKeys key) {
        return data.getValue(key.key).toString();
    }

    public static String getWebUrl(String login, String password, String machineAddress, String port){
        return String.format(data.getValue("/patterns/urlLocalhostWeb").toString(), login, password, machineAddress, port);
    }

    public static String getApiUrl(String machineAddress, String port) {
        return String.format(data.getValue("/patterns/urlLocalhostApi").toString(), machineAddress, port);
    }
}