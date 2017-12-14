package com.safefire.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class StringUtils {

    private static Logger logger = LoggerFactory.getLogger(StringUtils.class);

    public static void test001() {
        System.out.println("Hello StringUtils! test001");
        logger.info("test logger");
    } 

    public static void main(String[] args) {
        test001();
    }
}
