package logging_framework.implementation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationManager {
    public static Properties loadConfig(String filePath) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(filePath);
        prop.load(fis);
        return prop;
    }
}
