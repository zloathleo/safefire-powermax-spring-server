package com.safefire.webapp.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.databind.JsonNode;
import com.safefire.common.vo.powermax.Value;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThingworxLutangbeihuceConnection {

    private static Logger logger = LoggerFactory.getLogger(ThingworxLutangbeihuceConnection.class);

    public static float getFloatValue(JsonNode node, String field) {
        JsonNode fieldNode = node.get(field);
        if (fieldNode == null) {
            logger.warn(node + ",field:" + field + " is null.");
            return Float.NaN;
        } else {
            return (float) fieldNode.asDouble();
        }
    }


    //炉膛背火侧温度
    //name front
    public static final HashMap<String, Object> requestBeihuceData(String name) {
        JsonNode com3 = OKHttp.requestThingProperty("P_SM1606302_U1_Modbus_COM3");
        JsonNode com4 = OKHttp.requestThingProperty("P_SM1606302_U1_Modbus_COM4");
        JsonNode com5 = OKHttp.requestThingProperty("P_SM1606302_U1_Modbus_COM5");
        JsonNode com6 = OKHttp.requestThingProperty("P_SM1606302_U1_Modbus_COM6");

        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("name", name);

        ArrayList<HashMap<String, Object>> rows = new ArrayList<HashMap<String, Object>>();

        if ("right".equalsIgnoreCase(name)) {
            HashMap<String, Object> row = new HashMap<String, Object>();
            ArrayList<Value> items = new ArrayList<Value>();
            items.add(new Value("Thing1.AA1", getFloatValue(com4, "slave_55_address_40004")));
            items.add(new Value("Thing1.AA2", getFloatValue(com4, "slave_55_address_40005")));
            items.add(new Value("Thing1.AA3", getFloatValue(com4, "slave_55_address_40006")));
            items.add(new Value("Thing1.AA4", getFloatValue(com4, "slave_53_address_40004")));
    
            items.add(new Value("Thing1.AA1", getFloatValue(com4, "slave_53_address_40003")));
            items.add(new Value("Thing1.AA2", getFloatValue(com4, "slave_54_address_40001")));
            items.add(new Value("Thing1.AA3", getFloatValue(com4, "slave_54_address_40005")));
            items.add(new Value("Thing1.AA4", getFloatValue(com4, "slave_55_address_40002")));
    
            items.add(new Value("Thing1.AA1", getFloatValue(com4, "slave_53_address_40002")));
            items.add(new Value("Thing1.AA2", getFloatValue(com4, "slave_54_address_40002")));
            items.add(new Value("Thing1.AA3", getFloatValue(com4, "slave_53_address_40005")));
            items.add(new Value("Thing1.AA4", getFloatValue(com4, "slave_56_address_40003")));
            row.put("name", "上");
            row.put("items", items); 
            rows.add(row);
    
            row = new HashMap<String, Object>();
            items = new ArrayList<Value>();
            items.add(new Value("Thing1.AA1", getFloatValue(com4, "slave_50_address_40003")));
            items.add(new Value("Thing1.AA2", getFloatValue(com4, "slave_49_address_40006")));
            items.add(new Value("Thing1.AA3", getFloatValue(com4, "slave_50_address_40001")));
            items.add(new Value("Thing1.AA4", getFloatValue(com4, "slave_50_address_40005")));
    
            items.add(new Value("Thing1.AA1", getFloatValue(com4, "slave_49_address_40003")));
            items.add(new Value("Thing1.AA2", getFloatValue(com4, "slave_52_address_40004")));
            items.add(new Value("Thing1.AA3", getFloatValue(com4, "slave_51_address_40003")));
            items.add(new Value("Thing1.AA4", getFloatValue(com4, "slave_51_address_40006")));
    
            items.add(new Value("Thing1.AA1", getFloatValue(com4, "slave_52_address_40001")));
            items.add(new Value("Thing1.AA2", getFloatValue(com4, "slave_52_address_40005")));
            items.add(new Value("Thing1.AA3", getFloatValue(com4, "slave_50_address_40006")));
            items.add(new Value("Thing1.AA4", getFloatValue(com4, "slave_51_address_40005")));
            row.put("name", "中");
            row.put("items", items); 
            rows.add(row);
    
            row = new HashMap<String, Object>();
            items = new ArrayList<Value>();
            items.add(new Value("Thing1.AA1", getFloatValue(com4, "slave_33_address_40001")));
            items.add(new Value("Thing1.AA2", getFloatValue(com4, "slave_34_address_40002")));
            items.add(new Value("Thing1.AA3", getFloatValue(com4, "slave_35_address_40004")));
            items.add(new Value("Thing1.AA4", getFloatValue(com5, "slave_17_address_40003")));
    
            items.add(new Value("Thing1.AA1", getFloatValue(com4, "slave_34_address_40004")));
            items.add(new Value("Thing1.AA2", getFloatValue(com4, "slave_34_address_40005")));
            items.add(new Value("Thing1.AA3", getFloatValue(com4, "slave_35_address_40006")));
            items.add(new Value("Thing1.AA4", getFloatValue(com5, "slave_18_address_40002")));
    
            items.add(new Value("Thing1.AA1", getFloatValue(com4, "slave_33_address_40006")));
            items.add(new Value("Thing1.AA2", getFloatValue(com4, "slave_33_address_40002")));
            items.add(new Value("Thing1.AA3", getFloatValue(com4, "slave_35_address_40003")));
            items.add(new Value("Thing1.AA4", getFloatValue(com5, "slave_17_address_40004")));
            row.put("name", "下");
            row.put("items", items); 
            rows.add(row);
        } else if ("back".equalsIgnoreCase(name)) {
            HashMap<String, Object> row = new HashMap<String, Object>();
            ArrayList<Value> items = new ArrayList<Value>();
            items.add(new Value("Thing1.AA1", getFloatValue(com5, "slave_13_address_40004")));
            items.add(new Value("Thing1.AA2", getFloatValue(com5, "slave_14_address_40003")));
            items.add(new Value("Thing1.AA3", getFloatValue(com5, "slave_15_address_40003")));
            items.add(new Value("Thing1.AA4", getFloatValue(com5, "slave_16_address_40002")));
    
            items.add(new Value("Thing1.AA1", getFloatValue(com5, "slave_15_address_40006")));
            items.add(new Value("Thing1.AA2", getFloatValue(com5, "slave_13_address_40005")));
            items.add(new Value("Thing1.AA3", getFloatValue(com5, "slave_16_address_40004")));
            items.add(new Value("Thing1.AA4", getFloatValue(com5, "slave_15_address_40002")));
    
            items.add(new Value("Thing1.AA1", getFloatValue(com5, "slave_13_address_40001")));
            items.add(new Value("Thing1.AA2", getFloatValue(com5, "slave_14_address_40002")));
            items.add(new Value("Thing1.AA3", getFloatValue(com5, "slave_16_address_40001")));
            items.add(new Value("Thing1.AA4", getFloatValue(com5, "slave_14_address_40006")));
            row.put("name", "上");
            row.put("items", items); 
            rows.add(row);
    
            row = new HashMap<String, Object>();
            items = new ArrayList<Value>();
            items.add(new Value("Thing1.AA1", getFloatValue(com5, "slave_9_address_40004")));
            items.add(new Value("Thing1.AA2", getFloatValue(com5, "slave_10_address_40004")));
            items.add(new Value("Thing1.AA3", getFloatValue(com5, "slave_11_address_40003")));
            items.add(new Value("Thing1.AA4", getFloatValue(com5, "slave_11_address_40005")));
    
            items.add(new Value("Thing1.AA1", getFloatValue(com5, "slave_10_address_40001")));
            items.add(new Value("Thing1.AA2", getFloatValue(com5, "slave_11_address_40001")));
            items.add(new Value("Thing1.AA3", getFloatValue(com5, "slave_12_address_40001")));
            items.add(new Value("Thing1.AA4", getFloatValue(com5, "slave_9_address_40006")));
    
            items.add(new Value("Thing1.AA1", getFloatValue(com5, "slave_9_address_40001")));
            items.add(new Value("Thing1.AA2", getFloatValue(com5, "slave_12_address_40004")));
            items.add(new Value("Thing1.AA3", getFloatValue(com5, "slave_12_address_40005")));
            items.add(new Value("Thing1.AA4", getFloatValue(com5, "slave_10_address_40002")));
            row.put("name", "中");
            row.put("items", items); 
            rows.add(row);
    
            row = new HashMap<String, Object>();
            items = new ArrayList<Value>();
            items.add(new Value("Thing1.AA1", getFloatValue(com5, "slave_19_address_40006")));
            items.add(new Value("Thing1.AA2", getFloatValue(com5, "slave_18_address_40006")));
            items.add(new Value("Thing1.AA3", getFloatValue(com5, "slave_5_address_40002")));
            items.add(new Value("Thing1.AA4", getFloatValue(com5, "slave_6_address_40002")));
    
            items.add(new Value("Thing1.AA1", getFloatValue(com5, "slave_18_address_40005")));
            items.add(new Value("Thing1.AA2", getFloatValue(com5, "slave_19_address_40002")));
            items.add(new Value("Thing1.AA3", getFloatValue(com5, "slave_6_address_40006")));
            items.add(new Value("Thing1.AA4", getFloatValue(com5, "slave_7_address_40006")));
    
            items.add(new Value("Thing1.AA1", getFloatValue(com5, "slave_18_address_40001")));
            items.add(new Value("Thing1.AA2", getFloatValue(com5, "slave_19_address_40001")));
            items.add(new Value("Thing1.AA3", getFloatValue(com5, "slave_5_address_40006")));
            items.add(new Value("Thing1.AA4", getFloatValue(com5, "slave_7_address_40003")));
            row.put("name", "下");
            row.put("items", items); 
            rows.add(row);
        } else if ("left".equalsIgnoreCase(name)) {
            HashMap<String, Object> row = new HashMap<String, Object>();
            ArrayList<Value> items = new ArrayList<Value>();
            items.add(new Value("Thing1.AA1", getFloatValue(com6, "slave_25_address_40003")));
            items.add(new Value("Thing1.AA2", getFloatValue(com6, "slave_26_address_40005")));
            items.add(new Value("Thing1.AA3", getFloatValue(com6, "slave_28_address_40003")));
            items.add(new Value("Thing1.AA4", getFloatValue(com6, "slave_28_address_40004")));
    
            items.add(new Value("Thing1.AA1", getFloatValue(com6, "slave_26_address_40003")));
            items.add(new Value("Thing1.AA2", getFloatValue(com6, "slave_27_address_40006")));
            items.add(new Value("Thing1.AA3", getFloatValue(com6, "slave_25_address_40006")));
            items.add(new Value("Thing1.AA4", getFloatValue(com6, "slave_26_address_40002")));
    
            items.add(new Value("Thing1.AA1", getFloatValue(com6, "slave_25_address_40001")));
            items.add(new Value("Thing1.AA2", getFloatValue(com6, "slave_27_address_40001")));
            items.add(new Value("Thing1.AA3", getFloatValue(com6, "slave_27_address_40004")));
            items.add(new Value("Thing1.AA4", getFloatValue(com6, "slave_28_address_40001")));
            row.put("name", "上");
            row.put("items", items); 
            rows.add(row);
    
            row = new HashMap<String, Object>();
            items = new ArrayList<Value>();
            items.add(new Value("Thing1.AA1", getFloatValue(com6, "slave_23_address_40001")));
            items.add(new Value("Thing1.AA2", getFloatValue(com6, "slave_21_address_40006")));
            items.add(new Value("Thing1.AA3", getFloatValue(com6, "slave_24_address_40005")));
            items.add(new Value("Thing1.AA4", getFloatValue(com6, "slave_23_address_40002")));
    
            items.add(new Value("Thing1.AA1", getFloatValue(com6, "slave_21_address_40005")));
            items.add(new Value("Thing1.AA2", getFloatValue(com6, "slave_24_address_40001")));
            items.add(new Value("Thing1.AA3", getFloatValue(com6, "slave_24_address_40004")));
            items.add(new Value("Thing1.AA4", getFloatValue(com6, "slave_23_address_40004")));
    
            items.add(new Value("Thing1.AA1", getFloatValue(com6, "slave_21_address_40003")));
            items.add(new Value("Thing1.AA2", getFloatValue(com6, "slave_21_address_40004")));
            items.add(new Value("Thing1.AA3", getFloatValue(com6, "slave_22_address_40001")));
            items.add(new Value("Thing1.AA4", getFloatValue(com6, "slave_24_address_40006")));
            row.put("name", "中");
            row.put("items", items); 
            rows.add(row);
    
            row = new HashMap<String, Object>();
            items = new ArrayList<Value>();
            items.add(new Value("Thing1.AA1", getFloatValue(com6, "slave_46_address_40002")));
            items.add(new Value("Thing1.AA2", getFloatValue(com6, "slave_47_address_40002")));
            items.add(new Value("Thing1.AA3", getFloatValue(com6, "slave_47_address_40004")));
            items.add(new Value("Thing1.AA4", getFloatValue(com5, "slave_5_address_40004")));
    
            items.add(new Value("Thing1.AA1", getFloatValue(com6, "slave_46_address_40003")));
            items.add(new Value("Thing1.AA2", getFloatValue(com6, "slave_46_address_40005")));
            items.add(new Value("Thing1.AA3", getFloatValue(com6, "slave_47_address_40003")));
            items.add(new Value("Thing1.AA4", getFloatValue(com5, "slave_6_address_40005")));
    
            items.add(new Value("Thing1.AA1", getFloatValue(com6, "slave_45_address_40001")));
            items.add(new Value("Thing1.AA2", getFloatValue(com6, "slave_45_address_40002")));
            items.add(new Value("Thing1.AA3", getFloatValue(com6, "slave_46_address_40004")));
            items.add(new Value("Thing1.AA4", getFloatValue(com5, "slave_5_address_40005")));
            row.put("name", "下");
            row.put("items", items); 
            rows.add(row);
        } else if ("front".equalsIgnoreCase(name)) {
            HashMap<String, Object> row = new HashMap<String, Object>();
            ArrayList<Value> items = new ArrayList<Value>();
            items.add(new Value("Thing1.AA1", getFloatValue(com3, "slave_41_address_40002")));
            items.add(new Value("Thing1.AA2", getFloatValue(com3, "slave_42_address_40002")));
            items.add(new Value("Thing1.AA3", getFloatValue(com3, "slave_42_address_40003")));
            items.add(new Value("Thing1.AA4", getFloatValue(com3, "slave_43_address_40006")));
    
            items.add(new Value("Thing1.AA1", getFloatValue(com3, "slave_44_address_40002")));
            items.add(new Value("Thing1.AA2", getFloatValue(com3, "slave_41_address_40005")));
            items.add(new Value("Thing1.AA3", getFloatValue(com3, "slave_43_address_40003")));
            items.add(new Value("Thing1.AA4", getFloatValue(com3, "slave_42_address_40005")));
    
            items.add(new Value("Thing1.AA1", getFloatValue(com3, "slave_43_address_40004")));
            items.add(new Value("Thing1.AA2", getFloatValue(com3, "slave_44_address_40003")));
            items.add(new Value("Thing1.AA3", getFloatValue(com3, "slave_44_address_40001")));
            items.add(new Value("Thing1.AA4", getFloatValue(com3, "slave_41_address_40003")));
            row.put("name", "上");
            row.put("items", items); 
            rows.add(row);
    
            row = new HashMap<String, Object>();
            items = new ArrayList<Value>();
            items.add(new Value("Thing1.AA1", getFloatValue(com3, "slave_38_address_40001")));
            items.add(new Value("Thing1.AA2", getFloatValue(com3, "slave_38_address_40002")));
            items.add(new Value("Thing1.AA3", getFloatValue(com3, "slave_38_address_40004")));
            items.add(new Value("Thing1.AA4", getFloatValue(com3, "slave_39_address_40006")));
    
            items.add(new Value("Thing1.AA1", getFloatValue(com3, "slave_39_address_40001")));
            items.add(new Value("Thing1.AA2", getFloatValue(com3, "slave_40_address_40001")));
            items.add(new Value("Thing1.AA3", getFloatValue(com3, "slave_39_address_40005")));
            items.add(new Value("Thing1.AA4", getFloatValue(com3, "slave_37_address_40005")));
    
            items.add(new Value("Thing1.AA1", getFloatValue(com3, "slave_37_address_40001")));
            items.add(new Value("Thing1.AA2", getFloatValue(com3, "slave_37_address_40003")));
            items.add(new Value("Thing1.AA3", getFloatValue(com3, "slave_40_address_40002")));
            items.add(new Value("Thing1.AA4", getFloatValue(com3, "slave_40_address_40004")));
            row.put("name", "中");
            row.put("items", items); 
            rows.add(row);
    
            row = new HashMap<String, Object>();
            items = new ArrayList<Value>();
            items.add(new Value("Thing1.AA1", getFloatValue(com3, "slave_31_address_40004")));
            items.add(new Value("Thing1.AA2", getFloatValue(com3, "slave_31_address_40005")));
            items.add(new Value("Thing1.AA3", getFloatValue(com3, "slave_30_address_40002")));
            items.add(new Value("Thing1.AA4", getFloatValue(com3, "slave_30_address_40008")));
    
            items.add(new Value("Thing1.AA1", getFloatValue(com3, "slave_31_address_40001")));
            items.add(new Value("Thing1.AA2", getFloatValue(com3, "slave_29_address_40006")));
            items.add(new Value("Thing1.AA3", getFloatValue(com3, "slave_29_address_40004")));
            items.add(new Value("Thing1.AA4", getFloatValue(com3, "slave_31_address_40003")));
    
            items.add(new Value("Thing1.AA1", getFloatValue(com3, "slave_30_address_40003")));
            items.add(new Value("Thing1.AA2", getFloatValue(com3, "slave_29_address_40001")));
            items.add(new Value("Thing1.AA3", getFloatValue(com3, "slave_29_address_40007")));
            items.add(new Value("Thing1.AA4", getFloatValue(com3, "slave_30_address_40006")));
            row.put("name", "下");
            row.put("items", items); 
            rows.add(row);
        } 
 
        data.put("rows", rows);

        return data;
    }
}
    