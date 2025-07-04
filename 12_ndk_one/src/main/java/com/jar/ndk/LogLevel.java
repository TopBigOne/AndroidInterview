package com.jar.ndk;

/**
 * @author : 周广亚
 * @version :
 * @Date :  2024/7/23 19:55
 * @Desc :
 */
public enum LogLevel {
    DEBUG(0, "DEBUG"),
    INFO(1, "INFO"),
    WARN(2, "WARN"),
    ERROR(3, "ERROR")
    ;

    private int level;
    private String name;

    LogLevel(int level, String name) {
        this.level = level;
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }
}