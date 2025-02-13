package logging_framework.implementation;

import java.time.LocalDateTime;

public class LogMessage {
    private LogLevel level;
    private String message;
    private LocalDateTime timestamp;
    private String threadName;

    public LogMessage(LogLevel level, String message){
        this.level = level;
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.threadName = Thread.currentThread().getName();
    }

    @Override
    public String toString(){
        return "[ " + timestamp + "] [ " + threadName + " ] [ " + level + " ] : " + message;
    }
}
