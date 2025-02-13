package logging_framework.implementation;

import logging_framework.implementation.appender.LogAppender;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private List<LogAppender> appenders;
    private LogLevel level;

    public Logger(LogLevel level) {
        this.level = level;
        this.appenders = new ArrayList<LogAppender>();
    }

    public void addAppender(LogAppender appender) {
        appenders.add(appender);
    }

    public void log(String message, LogLevel level) {
        if(level.ordinal() >= this.level.ordinal()) {
            LogMessage logMessage = new LogMessage(level, message);
            for(LogAppender appender : appenders) {
                appender.log(logMessage);
            }
        }
    }

    public void info(String message){
        log(message, LogLevel.INFO);
    }

    public void error(String message){
        log(message, LogLevel.ERROR);
    }

    public void warn(String message){
        log(message, LogLevel.WARN);
    }

    public void debug(String message){
        log(message, LogLevel.DEBUG);
    }
}
