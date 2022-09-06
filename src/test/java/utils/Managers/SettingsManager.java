package utils.Managers;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class SettingsManager {
    private static final ISettingsFile settings = new JsonSettingsFile("settings.json");

    public static String getTimeoutCondition(){
        return settings.getValue("/timeouts/timeoutCondition").toString();
    }
}
