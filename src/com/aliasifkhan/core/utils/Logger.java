package com.aliasifkhan.core.utils;

public class Logger {

    private static final Logger INSTANCE = new Logger();
    private LogLevel level;

    private Logger() {
        setLevel(LogLevel.DEBUG);
    }

    public static Logger getLogger() {
        return INSTANCE;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public void log(Object... msg) {
        log(level, msg);
    }

    private static final transient StringBuilder logMessage = new StringBuilder();
    public void log(LogLevel logLevel, Object... msg) {
        if (this.level == LogLevel.NONE) {
            return;
        }

        if (logLevel.ordinal() >= this.level.ordinal()) {
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
