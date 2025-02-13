package logging_framework.implementation.appender;

import logging_framework.implementation.LogMessage;

public interface LogAppender {
    void log(LogMessage message);
}
