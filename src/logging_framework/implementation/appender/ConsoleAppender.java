package logging_framework.implementation.appender;

import logging_framework.implementation.LogMessage;

public class ConsoleAppender implements LogAppender {
    @Override
    public void log(LogMessage message) {
        System.out.println(message);
    }
}
