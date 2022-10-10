package fr.lernejo.logger;

import fr.lernejo.logger.ContextualLogger;
import fr.lernejo.logger.Logger;

public class LoggerFactory {

    public static Logger getLogger(String name) {
        //Logger fileLogger = new FileLogger("C:\\Users\\mrsou\\decoupling_java_training\\FileLogger");
        return new ConsoleLogger();
    }
}
