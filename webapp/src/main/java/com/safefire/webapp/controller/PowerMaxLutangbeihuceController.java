package com.safefire.webapp.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.databind.JsonNode;
import com.safefire.common.vo.BaseResp;
import com.safefire.common.vo.powermax.Value;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PowerMaxLutangbeihuceController {

    private static Logger logger = LoggerFactory.getLogger(PowerMaxLutangbeihuceController.class);

    public static float getFloatValue(JsonNode node, String field) {
        JsonNode fieldNode = node.get(field);
        if (fieldNode == null) {
            return Float.NaN;
        } else {
            return (float) fieldNode.asDouble();
        }
    }

    @RequestMapping(value = "/lutangbeihuce/{name}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public BaseResp<HashMap<String, Object>> getLutangbeihuce(@PathVariable(value = "name") final String name) { 
        HashMap<String, Object> data = ThingworxLutangbeihuceConnection.requestBeihuceData(name);
        return new BaseResp<HashMap<String, Object>>(data);
    }

}
