package utils.managers;

import aquality.selenium.core.utilities.*;

public class ConfigManager {
    private static final ISettingsFile config = new JsonSettingsFile("config.json");
    public enum ConfigKeys{
        LOGIN("/credentials/login"),
        PASSWORD("/credentials/password"),
        MACHINE_ADDRESS("/credentials/machineAddress"),
        PORT("/ports/forTest"),
        VARIANT("/config/variant"),
        HOME_PAGE_INDICATOR("/config/homePageIndicator"),
        VERSION_TEXT("/config/versionTextOnSite"),
        PROJECT_ID_TEXT("/config/projectIdTextInHref"),
        PROJECT_NAME("/config/projectNameForTest"),
        SORT_COLUMN_NAME("/config/columnForSortName"),
        SEARCH_COLUMN_NAME("/config/columnSearchName"),
        LENGTH_RANDOM_STRING("/config/randomStringLength");

        public String key;
        ConfigKeys(String key) {
            this.key = key;
        }
    }

    public static String getConfigValue(ConfigKeys key) {
        return config.getValue(key.key).toString();
    }

    public static int getConfigValueAsInt(ConfigKeys key) {
        return Integer.parseInt(config.getValue(key.key).toString());
    }
}
