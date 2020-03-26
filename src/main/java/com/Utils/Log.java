package com.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;

public class Log {

    private static Logger logger = LogManager.getLogger(Log.class.getName());

    public static void info (String message) {
        logger.info(message);
        System.out.println(new Date() + " : " + message);
    }

    public static void warn (String message) {
        logger.warn(message);
        System.out.println(new Date() + " : " + message);
    }

    public static void error (String message) {
        logger.error(message);
        System.out.println(new Date() + " : " + message);
    }

    public static void fatal (String message) {
        logger.fatal(message);
        System.out.println(new Date() + " : " + message);
    }

    public static void debug (String message) {
        logger.debug(message);
        System.out.println(new Date() + " : " + message);
    }
}