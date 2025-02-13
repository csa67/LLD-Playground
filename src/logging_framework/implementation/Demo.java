package logging_framework.implementation;

public class Demo {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger();
        logger.info("Application started");
        logger.debug("Debugging mode enabled");
        logger.error("An error occurred!");
    }
}
