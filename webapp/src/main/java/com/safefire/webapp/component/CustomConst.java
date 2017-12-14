package com.safefire.webapp.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("CustomConst")
@Scope("singleton")
public class CustomConst {

    @Value("${custom.thingworx.server}")
    public String thingworxServer;

    @Value("${custom.thingworx.key}")
    public String thingworxKey;
  
}