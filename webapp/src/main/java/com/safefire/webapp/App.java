package com.safefire.webapp;

import com.safefire.webapp.component.ApplicationContextRegister;
import com.safefire.webapp.component.CustomConst;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    private static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        try {
            logger.info("start boot server ...");
            SpringApplication.run(App.class, args);

            CustomConst customConst = (CustomConst) ApplicationContextRegister.getBean("CustomConst"); 
            logger.info("Const thingworxServer:" + customConst.thingworxServer);

            logger.info("boot server success ...");
        } catch (Exception ex) {
            logger.error("acsi server exception", ex);
        }

    }

}
