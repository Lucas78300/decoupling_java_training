package fr.lernejo.logger;

public class CompositeLogger implements Logger{

    private Logger contextualLogger;
    private Logger fileLogger;

    public CompositeLogger(Logger contextualLogger, Logger fileLogger){
        this.contextualLogger = contextualLogger;
        this.fileLogger = fileLogger;
    }
    @Override
    public void log(String message) {
        contextualLogger.log(message);
        fileLogger.log(message);
    }
}
