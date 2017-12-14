package com.safefire.webapp;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.safefire.utils.StringUtils; 
 

/**
 * Hello world!
 *
 */
public class API {
    private static Logger logger = LoggerFactory.getLogger(API.class);

    public static void api() {
        System.out.println("api!");
    }

    public static void main(String[] args) {  
        StringUtils.test001();
        
        
        // com.shitou.utils.encoding.Base64.encode("aaa");
        // System.out.println("Hello API!"); 
        // StringUtils.test();
        // api();
    }
}
