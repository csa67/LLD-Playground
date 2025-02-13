package logging_framework.implementation.appender;

import logging_framework.implementation.LogMessage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements LogAppender{
    private BufferedWriter fileWriter;

    public FileAppender(String filePath) throws IOException {
        fileWriter = new BufferedWriter(new FileWriter(filePath,true));
    }

    @Override
    public void log(LogMessage message) {
        try{
            fileWriter.write(message.toString()+"\n");
            fileWriter.flush();
        } catch (IOException e) {
            System.err.println("Logging to file failed" +e.getMessage());
        }
    }
}
