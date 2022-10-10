package fr.lernejo.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger {

    private final String className;
    private final Logger logger;

    public ContextualLogger (String className, Logger logger){
        this.className = className;
        this.logger = logger;
    }
    @Override
    public void log(String message) {
        logger.log(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + " " + className + " -- " + message);
    }
}
