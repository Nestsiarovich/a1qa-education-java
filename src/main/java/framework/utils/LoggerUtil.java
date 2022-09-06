package framework.utils;

import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggerUtil {
    private static Logger logger;

    static {
        try(FileInputStream ins = new FileInputStream("src/main/resources/log.config")){
            LogManager.getLogManager().readConfiguration(ins);
            logger = Logger.getLogger(LoggerUtil.class.getName());
        }catch (Exception ignore){
            ignore.printStackTrace();
        }
    }

    public static void logInfo(String massage){
        logger.log(Level.INFO,massage);
    }

    public static void logWarning(String massage){
        logger.log(Level.WARNING,massage);
    }
}
