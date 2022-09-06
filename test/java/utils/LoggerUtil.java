package utils;

import java.io.FileInputStream;
import java.util.logging.*;
import static utils.JsonReader.getConfig;

public class LoggerUtil {
    private static Logger logger;

    static {
        try(FileInputStream ins = new FileInputStream(getConfig("pathToLogConfig"))){
            LogManager.getLogManager().readConfiguration(ins);
            logger = Logger.getLogger(LoggerUtil.class.getName());
        }catch (Exception exception){
            throw new RuntimeException("Error reading logger config file");
        }
    }

    public static void logInfo(String massage){
        logger.log(Level.INFO,massage);
    }
}
