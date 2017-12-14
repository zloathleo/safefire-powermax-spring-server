package com.safefire.webapp.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.databind.JsonNode;
import com.safefire.common.vo.powermax.DashBoard;
import com.safefire.common.vo.powermax.Value;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThingworxIndexConnection {

    private static Logger logger = LoggerFactory.getLogger(ThingworxIndexConnection.class);

    public static float getFloatValue(JsonNode node, String field) {
        if (node == null) {
            return Float.NaN;
        }
        JsonNode fieldNode = node.get(field);
        if (fieldNode == null) {
            return Float.NaN;
        } else {
            return (float) fieldNode.asDouble();
        }
    }

    public static final DashBoard requestOverviewData() {
        DashBoard dashBoard = new DashBoard();
        ArrayList<Value> summary = dashBoard.summary;

        JsonNode node = OKHttp.requestThingProperty("P_SM1606302_U1_Overview_Mashup_LocalThing");
        summary.add(new Value("机组负荷", getFloatValue(node, "PM_MWOUT")));
        summary.add(new Value("锅炉负荷", getFloatValue(node, "PM_AMCCS66")));
        summary.add(new Value("再热器出口工质压力", getFloatValue(node, "PM_10LBB11CP101")));
        summary.add(new Value("排烟温度", getFloatValue(node, "PM_J0CKS01GH5CE23")));

        JsonNode jisuan7 = OKHttp.requestThingProperty("P_SM1606302_U1_DCS_RemoteThing_jisuan7");
        JsonNode jisuan9 = OKHttp.requestThingProperty("P_SM1606302_U1_DCS_RemoteThing_jisuan9");

        summary.add(new Value("主汽压力", getFloatValue(jisuan7, "PM_AMCCS18")));
        summary.add(new Value("总给煤量", getFloatValue(jisuan9, "PM_AMCCS06")));
        summary.add(new Value("三过出口蒸汽温度", getFloatValue(node, "PM_AM10LBA10CT60M")));

        //徐江新建
        JsonNode algorithmTimerThing = OKHttp.requestThingProperty("DCS_Algorithm_Thing");
        //空预器A
        HashMap<String, Object> kongyuqiA = dashBoard.kongyuqiA;
        kongyuqiA.put("name", "空预器A");
        ArrayList<Value> values = new ArrayList<Value>();
        values.add(new Value("烟气A进", getFloatValue(node, "PM_C1")));
        values.add(new Value("烟气A出", getFloatValue(node, "PM_C2")));
        values.add(new Value("差压", getFloatValue(algorithmTimerThing, "kongyuqiAyc"))); 
        values.add(new Value("换热", getFloatValue(algorithmTimerThing, "kongyuqiAhr"))); 
        values.add(new Value("-", "")); 
        kongyuqiA.put("values", values);

        //空预器B
        HashMap<String, Object> kongyuqiB = dashBoard.kongyuqiB;
        kongyuqiB.put("name", "空预器B");
        values = new ArrayList<Value>();  
        values.add(new Value("烟气B进", getFloatValue(node, "PM_C3")));
        values.add(new Value("烟气B出", getFloatValue(node, "PM_C4")));
        values.add(new Value("差压", getFloatValue(algorithmTimerThing, "kongyuqiByc")));
        values.add(new Value("换热", getFloatValue(algorithmTimerThing, "kongyuqiBhr")));
        values.add(new Value("-", "")); 
        kongyuqiB.put("values", values);

        //二级再
        HashMap<String, Object> erjizai = dashBoard.erjizai;
        erjizai.put("name", "二级再");
        erjizai.put("pollutionRate", getFloatValue(algorithmTimerThing, "erjizai"));
        values = new ArrayList<Value>();
        values.add(new Value("烟气进", getFloatValue(node, "PM_C21")));
        values.add(new Value("烟气出", getFloatValue(node, "PM_C22")));
        values.add(new Value("工质进", getFloatValue(node, "PM_C19")));
        values.add(new Value("工质出", getFloatValue(node, "PM_C20")));
        values.add(new Value("污染率", getFloatValue(algorithmTimerThing, "erjizai")));
        erjizai.put("values", values);

        //省煤器
        HashMap<String, Object> shenmeiqi = dashBoard.shenmeiqi;
        shenmeiqi.put("name", "省煤器");
        shenmeiqi.put("pollutionRate", getFloatValue(algorithmTimerThing, "shenmeiqi"));
        values = new ArrayList<Value>();
        values.add(new Value("烟气进", getFloatValue(node, "PM_C10")));
        values.add(new Value("烟气出", getFloatValue(node, "PM_C10")));
        values.add(new Value("工质进", getFloatValue(node, "PM_C8")));
        values.add(new Value("工质出", getFloatValue(node, "PM_C9")));
        values.add(new Value("污染率", getFloatValue(algorithmTimerThing, "shenmeiqi")));
        shenmeiqi.put("values", values);

        //三级过热器
        HashMap<String, Object> sanjiguo = dashBoard.sanjiguo;
        sanjiguo.put("name", "三级过热器");
        sanjiguo.put("pollutionRate", getFloatValue(algorithmTimerThing, "sanjiguo"));
        values = new ArrayList<Value>();
        values.add(new Value("烟气进", getFloatValue(node, "PM_C25")));
        values.add(new Value("烟气出", getFloatValue(node, "PM_C26")));
        values.add(new Value("工质进", getFloatValue(node, "PM_C23")));
        values.add(new Value("工质出", getFloatValue(node, "PM_C24")));
        values.add(new Value("污染率", getFloatValue(algorithmTimerThing, "sanjiguo")));
        sanjiguo.put("values", values);

        //一级再热器
        HashMap<String, Object> yijizai = dashBoard.yijizai;
        yijizai.put("name", "一级再热器");
        yijizai.put("pollutionRate", getFloatValue(algorithmTimerThing, "yijizai"));
        values = new ArrayList<Value>();
        values.add(new Value("烟气进", getFloatValue(node, "PM_C13")));
        values.add(new Value("烟气出", getFloatValue(node, "PM_C14")));
        values.add(new Value("工质进", getFloatValue(node, "PM_C12")));
        values.add(new Value("工质出", getFloatValue(node, "PM_C11")));
        values.add(new Value("污染率", getFloatValue(algorithmTimerThing, "yijizai")));
        yijizai.put("values", values);

        //一级过热器
        HashMap<String, Object> yijiguo = dashBoard.yijiguo;
        yijiguo.put("name", "一级过热器");
        yijiguo.put("pollutionRate", getFloatValue(algorithmTimerThing, "yijiguo"));
        values = new ArrayList<Value>();
        values.add(new Value("烟气进", getFloatValue(node, "PM_C29")));
        values.add(new Value("烟气出", getFloatValue(node, "PM_C30")));
        values.add(new Value("工质进", getFloatValue(node, "PM_C28")));
        values.add(new Value("工质出", getFloatValue(node, "PM_C27")));
        values.add(new Value("污染率", getFloatValue(algorithmTimerThing, "yijiguo")));
        yijiguo.put("values", values);

        //二级过热器
        HashMap<String, Object> erjiguo = dashBoard.erjiguo;
        erjiguo.put("name", "二级过热器");
        erjiguo.put("pollutionRate", getFloatValue(algorithmTimerThing, "erjiguo"));
        values = new ArrayList<Value>();
        values.add(new Value("烟气进", getFloatValue(node, "PM_C17")));
        values.add(new Value("烟气出", getFloatValue(node, "PM_C18")));
        values.add(new Value("工质进", getFloatValue(node, "PM_C16")));
        values.add(new Value("工质出", getFloatValue(node, "PM_C15")));
        values.add(new Value("污染率", getFloatValue(algorithmTimerThing, "erjiguo")));
        erjiguo.put("values", values);

        //炉膛
        HashMap<String, Object> lutang = dashBoard.lutang;
        lutang.put("name", "炉膛");
        lutang.put("pollutionRate", getFloatValue(algorithmTimerThing, "guolu"));
        values = new ArrayList<Value>();
        values.add(new Value("炉膛出口烟温", getFloatValue(node, "PM_C31")));
        values.add(new Value("炉膛出口氧量", getFloatValue(node, "PM_10HSY21AI002")));
        values.add(new Value("污染率", getFloatValue(algorithmTimerThing, "guolu")));
        lutang.put("values", values);

        return dashBoard;
    }

}