package com.safefire.webapp.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.databind.JsonNode;
import com.safefire.common.vo.powermax.Value;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//受热面吹灰器状态
public class ThingworxShouremianConnection {

    private static Logger logger = LoggerFactory.getLogger(ThingworxShouremianConnection.class);

    public static int getIntValue(JsonNode node, String field) {
        JsonNode fieldNode = node.get(field);
        if (fieldNode == null) {
            return 0;
        } else {
            return fieldNode.asInt();
        }
    }

    public static final HashMap<String, Object> requestShouremianData() {
        JsonNode node = OKHttp.requestThingProperty("P_SM1606302_U1_SootHeatedSurface_MashupThing");

        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("name", "受热面吹灰器");

        ArrayList<HashMap<String, Object>> rows = new ArrayList<HashMap<String, Object>>();

        HashMap<String, Object> row = new HashMap<String, Object>();
        ArrayList<Value> items = new ArrayList<Value>();
        items.add(new Value("PSA1", getIntValue(node, "PSA1")));
        items.add(new Value("PSA2", getIntValue(node, "PSA2")));
        items.add(new Value("PSA3", getIntValue(node, "PSA3")));
        items.add(new Value("PSA4", getIntValue(node, "PSA4")));  
        row.put("name", "空气预热器");
        row.put("items", items);
        rows.add(row);

        row = new HashMap<String, Object>();
        items = new ArrayList<Value>();
        items.add(new Value("L21", getIntValue(node, "L21")));
        items.add(new Value("L22", getIntValue(node, "L22")));
        items.add(new Value("L23", getIntValue(node, "L23")));
        items.add(new Value("L24", getIntValue(node, "L24")));
        items.add(new Value("L25", getIntValue(node, "L25")));

        items.add(new Value("R21", getIntValue(node, "R21")));
        items.add(new Value("R22", getIntValue(node, "R22")));
        items.add(new Value("R23", getIntValue(node, "R23")));
        items.add(new Value("R24", getIntValue(node, "R24")));
        items.add(new Value("R25", getIntValue(node, "R25")));
        row.put("name", "省煤器");
        row.put("items", items);
        rows.add(row);

        row = new HashMap<String, Object>();
        items = new ArrayList<Value>();
        items.add(new Value("L16", getIntValue(node, "L16")));
        items.add(new Value("L17", getIntValue(node, "L17")));
        items.add(new Value("L18", getIntValue(node, "L18")));
        items.add(new Value("L19", getIntValue(node, "L19")));
        items.add(new Value("L20", getIntValue(node, "L20")));

        items.add(new Value("R16", getIntValue(node, "R16")));
        items.add(new Value("R17", getIntValue(node, "R17")));
        items.add(new Value("R18", getIntValue(node, "R18")));
        items.add(new Value("R19", getIntValue(node, "R19")));
        items.add(new Value("R20", getIntValue(node, "R20")));
        row.put("name", "一级再");
        row.put("items", items);
        rows.add(row);

        row = new HashMap<String, Object>();
        items = new ArrayList<Value>();
        items.add(new Value("L11", getIntValue(node, "L11")));
        items.add(new Value("L12", getIntValue(node, "L12")));
        items.add(new Value("L13", getIntValue(node, "L13")));
        items.add(new Value("L14", getIntValue(node, "L14")));
        items.add(new Value("L15", getIntValue(node, "L15")));

        items.add(new Value("R11", getIntValue(node, "R11")));
        items.add(new Value("R12", getIntValue(node, "R12")));
        items.add(new Value("R13", getIntValue(node, "R13")));
        items.add(new Value("R14", getIntValue(node, "R14")));
        items.add(new Value("R15", getIntValue(node, "R15")));
        row.put("name", "二级过");
        row.put("items", items);
        rows.add(row);

        row = new HashMap<String, Object>();
        items = new ArrayList<Value>();
        items.add(new Value("L6", getIntValue(node, "L6")));
        items.add(new Value("L7", getIntValue(node, "L7")));
        items.add(new Value("L8", getIntValue(node, "L8")));
        items.add(new Value("L9", getIntValue(node, "L9")));
        items.add(new Value("L10", getIntValue(node, "L10")));

        items.add(new Value("R6", getIntValue(node, "R6")));
        items.add(new Value("R7", getIntValue(node, "R7")));
        items.add(new Value("R8", getIntValue(node, "R8")));
        items.add(new Value("R9", getIntValue(node, "R9")));
        items.add(new Value("R10", getIntValue(node, "R10")));
        row.put("name", "二级再");
        row.put("items", items);
        rows.add(row);

        row = new HashMap<String, Object>();
        items = new ArrayList<Value>();
        items.add(new Value("L1", getIntValue(node, "L1")));
        items.add(new Value("L2", getIntValue(node, "L2")));
        items.add(new Value("L3", getIntValue(node, "L3")));
        items.add(new Value("L4", getIntValue(node, "L4")));
        items.add(new Value("L5", getIntValue(node, "L5")));

        items.add(new Value("R1", getIntValue(node, "R1")));
        items.add(new Value("R2", getIntValue(node, "R2")));
        items.add(new Value("R3", getIntValue(node, "R3")));
        items.add(new Value("R4", getIntValue(node, "R4")));
        items.add(new Value("R5", getIntValue(node, "R5")));
        row.put("name", "三级过");
        row.put("items", items);
        rows.add(row);

        row = new HashMap<String, Object>();
          items = new ArrayList<Value>();
        items.add(new Value("HL1", getIntValue(node, "HL1")));
        items.add(new Value("HL2", getIntValue(node, "HL2")));
        items.add(new Value("HL3", getIntValue(node, "HL3")));
        items.add(new Value("HL4", getIntValue(node, "HL4")));
        items.add(new Value("HL5", getIntValue(node, "HL5")));

        items.add(new Value("HR1", getIntValue(node, "HR1")));
        items.add(new Value("HR2", getIntValue(node, "HR2")));
        items.add(new Value("HR3", getIntValue(node, "HR3")));
        items.add(new Value("HR4", getIntValue(node, "HR4")));
        items.add(new Value("HR5", getIntValue(node, "HR5")));
        row.put("name", "一级过");
        row.put("items", items);
        rows.add(row);

        data.put("rows", rows);

        return data;
    }
}