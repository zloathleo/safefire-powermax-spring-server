package com.safefire.webapp.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.safefire.common.vo.BaseResp;
import com.safefire.common.vo.powermax.ChuiHuiQi;
import com.safefire.common.vo.powermax.DashBoard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//首页
@RestController
public class PowerMaxController {

    private static Logger logger = LoggerFactory.getLogger(PowerMaxController.class);

    //index
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public BaseResp<DashBoard> getDashboard() { 
        DashBoard dashBoard = ThingworxIndexConnection.requestOverviewData();
        return new BaseResp<DashBoard>(dashBoard); 
    }

    //炉膛吹灰器
    @RequestMapping(value = "/lutangwall/{name}", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE })
    public BaseResp<HashMap<String, Object>> getLutangwall(@PathVariable(value = "name") final String name) {
        HashMap<String, Object> lutangChuihuiqi = new HashMap<String, Object>();
        lutangChuihuiqi.put("name", name);
        renderWallData(name, lutangChuihuiqi);
        return new BaseResp<HashMap<String, Object>>(lutangChuihuiqi);
    }

    private void renderWallData(String name, HashMap<String, Object> lutangChuihuiqi) {
        ArrayList<ChuiHuiQi> rows = ThingworxConnection.requestLutangWallData(name);
        lutangChuihuiqi.put("rows", rows);
    }

}
