package com.aliasifkhan.core.utils;

public class Logger {

    private static final Logger INSTANCE = new Logger();
    private LogLevel level;

    private Logger() {
        setLevel(LogLevel.INFO);
    }

    public static Logger getLogger() {
        return INSTANCE;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public void log(Object... msg) {
        log("", msg);
    }

    public void log(String tag, Object... msg) {
        log(LogLevel.DEBUG, tag, msg);
    }


    private static final transient StringBuilder logMessage = new StringBuilder();
    public void log(LogLevel logLevel, String tag, Object... msg) {
        if (this.level == LogLevel.NONE) {
            return;
        }

        if (logLevel.ordinal() >= this.level.ordinal()) {
            if(tag != null && !tag.isEmpty()){
                logMessage.append(tag);
                logMessage.append(":");
            }

            for (Object item : msg) {
                logMessage.append(item).append(" ");
            }
            System.out.println(logMessage);
            logMessage.setLength(0);
        }
    }

    public enum LogLevel {
        NONE, INFO, ERROR, DEBUG
    }
}
