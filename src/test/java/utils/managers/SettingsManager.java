package utils.managers;

import aquality.selenium.core.utilities.*;

public class SettingsManager {
    private static final ISettingsFile settings = new JsonSettingsFile("settings.json");

    public static String getTimeoutCondition() {
            return settings.getValue("/timeouts/timeoutCondition").toString();
    }
}
