package util;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerUtil {
    private static final Logger logger = Logger.getLogger(LoggerUtil.class.getName());

    public static void logInfo(String message) {
        logger.log(Level.INFO, message);
    }

    public static void logError(String message, Exception e) {
        logger.log(Level.SEVERE, message, e);
    }
}

//This utility class handles all logging operations using java.util.logging. It provides a consistent way to log info and error messages across the application.

