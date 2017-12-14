package com.safefire.webapp.controller;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.safefire.common.vo.powermax.ChuiHuiQi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//炉膛吹灰器
public class ThingworxConnection {

    private static Logger logger = LoggerFactory.getLogger(ThingworxConnection.class);

    public static final ArrayNode requestChuiHuiQiHistory(String thingName, long startTime) {
        return OKHttp.getChuiHuiQiHistory(thingName, startTime);
    }

    public static ArrayList<ChuiHuiQi> requestLutangWallData(String name) {
        ArrayList<String> requestThings = new ArrayList<String>();
        if ("right".equalsIgnoreCase(name)) {
            requestThings.add("Right_A1_Thing");
            requestThings.add("Right_A2_Thing");
            requestThings.add("Right_A3_Thing");
            requestThings.add("Right_A4_Thing");

            requestThings.add("Right_B1_Thing");
            requestThings.add("Right_B2_Thing");
            requestThings.add("Right_B3_Thing");
            requestThings.add("Right_B4_Thing");

            requestThings.add("Right_C1_Thing");
            requestThings.add("Right_C2_Thing");
            requestThings.add("Right_C3_Thing");
            requestThings.add("Right_C4_Thing");

            requestThings.add("Right_D1_Thing");
            requestThings.add("Right_D2_Thing");
            requestThings.add("Right_D3_Thing");
            requestThings.add("Right_D4_Thing");

            requestThings.add("Right_E1_Thing");
            requestThings.add("Right_E2_Thing");
            requestThings.add("Right_E3_Thing");
            requestThings.add("Right_E4_Thing");

            requestThings.add("Right_F1_Thing");
            requestThings.add("Right_F2_Thing");
            requestThings.add("Right_F3_Thing");
            requestThings.add("Right_F4_Thing");

            requestThings.add("Right_G1_Thing");
            requestThings.add("Right_G2_Thing");
            requestThings.add("Right_G3_Thing");
            requestThings.add("Right_G4_Thing");

            requestThings.add("Right_H1_Thing");
            requestThings.add("Right_H2_Thing");
            requestThings.add("Right_H3_Thing");
            requestThings.add("Right_H4_Thing");

            requestThings.add("Right_I1_Thing");
            requestThings.add("Right_I2_Thing");
            requestThings.add("Right_I3_Thing");
            requestThings.add("Right_I4_Thing");
        } else if ("back".equalsIgnoreCase(name)) {
            requestThings.add("Back_A5_Thing");
            requestThings.add("Back_A6_Thing");
            requestThings.add("Back_A7_Thing");
            requestThings.add("Back_A8_Thing");

            requestThings.add("Back_B5_Thing");
            requestThings.add("Back_B6_Thing");
            requestThings.add("Back_B7_Thing");
            requestThings.add("Back_B8_Thing");

            requestThings.add("Back_C5_Thing");
            requestThings.add("Back_C6_Thing");
            requestThings.add("Back_C7_Thing");
            requestThings.add("Back_C8_Thing");

            requestThings.add("Back_D5_Thing");
            requestThings.add("Back_D6_Thing");
            requestThings.add("Back_D7_Thing");
            requestThings.add("Back_D8_Thing");

            requestThings.add("Back_E5_Thing");
            requestThings.add("Back_E6_Thing");
            requestThings.add("Back_E7_Thing");
            requestThings.add("Back_E8_Thing");

            requestThings.add("Back_F5_Thing");
            requestThings.add("Back_F6_Thing");
            requestThings.add("Back_F7_Thing");
            requestThings.add("Back_F8_Thing");

            requestThings.add("Back_G5_Thing");
            requestThings.add("Back_G6_Thing");
            requestThings.add("Back_G7_Thing");
            requestThings.add("Back_G8_Thing");

            requestThings.add("Back_H5_Thing");
            requestThings.add("Back_H6_Thing");
            requestThings.add("Back_H7_Thing");
            requestThings.add("Back_H8_Thing");

            requestThings.add("Back_I5_Thing");
            requestThings.add("Back_I6_Thing");
            requestThings.add("Back_I7_Thing");
            requestThings.add("Back_I8_Thing");
        } else if ("left".equalsIgnoreCase(name)) {
            requestThings.add("Left_A9_Thing");
            requestThings.add("Left_A10_Thing");
            requestThings.add("Left_A11_Thing");
            requestThings.add("Left_A12_Thing");

            requestThings.add("Left_B9_Thing");
            requestThings.add("Left_B10_Thing");
            requestThings.add("Left_B11_Thing");
            requestThings.add("Left_B12_Thing");

            requestThings.add("Left_C9_Thing");
            requestThings.add("Left_C10_Thing");
            requestThings.add("Left_C11_Thing");
            requestThings.add("Left_C12_Thing");

            requestThings.add("Left_D9_Thing");
            requestThings.add("Left_D10_Thing");
            requestThings.add("Left_D11_Thing");
            requestThings.add("Left_D12_Thing");

            requestThings.add("Left_E9_Thing");
            requestThings.add("Left_E10_Thing");
            requestThings.add("Left_E11_Thing");
            requestThings.add("Left_E12_Thing");

            requestThings.add("Left_F9_Thing");
            requestThings.add("Left_F10_Thing");
            requestThings.add("Left_F11_Thing");
            requestThings.add("Left_F12_Thing");

            requestThings.add("Left_G9_Thing");
            requestThings.add("Left_G10_Thing");
            requestThings.add("Left_G11_Thing");
            requestThings.add("Left_G12_Thing");

            requestThings.add("Left_H9_Thing");
            requestThings.add("Left_H10_Thing");
            requestThings.add("Left_H11_Thing");
            requestThings.add("Left_H12_Thing");

            requestThings.add("Left_I9_Thing");
            requestThings.add("Left_I10_Thing");
            requestThings.add("Left_I11_Thing");
            requestThings.add("Left_I12_Thing");
        } else if ("front".equalsIgnoreCase(name)) {
            requestThings.add("Front_A13_Thing");
            requestThings.add("Front_A14_Thing");
            requestThings.add("Front_A15_Thing");
            requestThings.add("Front_A16_Thing");

            requestThings.add("Front_B13_Thing");
            requestThings.add("Front_B14_Thing");
            requestThings.add("Front_B15_Thing");
            requestThings.add("Front_B16_Thing");

            requestThings.add("Front_C13_Thing");
            requestThings.add("Front_C14_Thing");
            requestThings.add("Front_C15_Thing");
            requestThings.add("Front_C16_Thing");

            requestThings.add("Front_D13_Thing");
            requestThings.add("Front_D14_Thing");
            requestThings.add("Front_D15_Thing");
            requestThings.add("Front_D16_Thing");

            requestThings.add("Front_E13_Thing");
            requestThings.add("Front_E14_Thing");
            requestThings.add("Front_E15_Thing");
            requestThings.add("Front_E16_Thing");

            requestThings.add("Front_F13_Thing");
            requestThings.add("Front_F14_Thing");
            requestThings.add("Front_F15_Thing");
            requestThings.add("Front_F16_Thing");

            requestThings.add("Front_G13_Thing");
            requestThings.add("Front_G14_Thing");
            requestThings.add("Front_G15_Thing");
            requestThings.add("Front_G16_Thing");

            requestThings.add("Front_H13_Thing");
            requestThings.add("Front_H14_Thing");
            requestThings.add("Front_H15_Thing");
            requestThings.add("Front_H16_Thing");

            requestThings.add("Front_I13_Thing");
            requestThings.add("Front_I14_Thing");
            requestThings.add("Front_I15_Thing");
            requestThings.add("Front_I16_Thing");
        }

        //请求吹灰器状态
        // JsonNode statusThing = OKHttp.requestThingProperty("P_SM1606302_U1_SootBoiler_MashupThing");

        ArrayList<ChuiHuiQi> rows = new ArrayList<ChuiHuiQi>();
        for (String thingName : requestThings) {
            ChuiHuiQi chuiHuiQi = OKHttp.getChuiHuiQi(thingName);

            int x1 = thingName.indexOf("_");
            int x2 = thingName.lastIndexOf("_");
            String propertName = thingName.substring(x1 + 1, x2);
            //1
            //2正在
            //3需要
            // chuiHuiQi.status = getIntValue(statusThing, propertName);

            // chuiHuiQi.status = 
            if (chuiHuiQi != null) {
                rows.add(chuiHuiQi);
            }
        }
        return rows;

    }

    public static int getIntValue(JsonNode node, String field) {
        JsonNode fieldNode = node.get(field);
        if (fieldNode == null) {
            logger.warn(node + ",field:" + field + " is null.");
            return 0;
        } else {
            return fieldNode.asInt();
        }
    }

}
