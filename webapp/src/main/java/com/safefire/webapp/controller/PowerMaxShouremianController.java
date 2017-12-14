package com.safefire.webapp.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.safefire.common.vo.BaseResp;
import com.safefire.common.vo.powermax.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PowerMaxShouremianController {

    private static Logger logger = LoggerFactory.getLogger(PowerMaxShouremianController.class);

    @RequestMapping(value = "/shouremian", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public BaseResp<HashMap<String, Object>> getShouremian() {
        HashMap<String, Object> data = ThingworxShouremianConnection.requestShouremianData();
        return new BaseResp<HashMap<String, Object>>(data);
    }

}
