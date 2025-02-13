package logging_framework.implementation;

import logging_framework.implementation.appender.ConsoleAppender;
import logging_framework.implementation.appender.FileAppender;

import java.io.IOException;
import java.util.Properties;


//Singleton LogManager
public class LogManager {
    private static Logger logger = new Logger(LogLevel.INFO);

    static {
        try{
            Properties config = ConfigurationManager.loadConfig("log-config.properties");
            if("FILE".equalsIgnoreCase(config.getProperty("log-destination"))){
                logger.addAppender(new FileAppender("app.log"));
            }else{
                logger.addAppender(new ConsoleAppender());
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static Logger getLogger() {
        return logger;
    }
}
