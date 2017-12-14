package com.safefire.webapp.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.safefire.common.vo.powermax.ChuiHuiQi;
import com.safefire.webapp.component.ApplicationContextRegister;
import com.safefire.webapp.component.CustomConst;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OKHttp {

    static {
        customConst = (CustomConst) ApplicationContextRegister.getBean("CustomConst");
        // ServerUrl = customConst.thingworxServer;
        // UrlEnd = "/Properties?appKey=0a6bd0ed-7317-4c52-8513-47aafbe33b41&Accept=application/json";
    }

    static CustomConst customConst;

    static String UrlParamString = "appKey=" + customConst.thingworxKey + "&Accept=application/json";

    private static Logger logger = LoggerFactory.getLogger(OKHttp.class);

    // private static String ServerUrl;

    // private static String UrlEnd = "/Properties?appKey=0a6bd0ed-7317-4c52-8513-47aafbe33b41&Accept=application/json";

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static ArrayNode getChuiHuiQiHistory(String thingName, long startTime) {
        String url = customConst.thingworxServer + "Things/" + thingName + "/Services/QueryPropertyHistory?"
                + UrlParamString;
        logger.info("getChuiHuiQiHistory url:" + url + ":startTime-" + startTime);
        HashMap<String, Object> params = new HashMap<String, Object>();

        if (startTime == 0) {
            startTime = new Date().getTime() - 1000 * 60 * 10;
        }
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, -10);//取当前日期的前一天.

        params.put("startDate", startTime / 1000 * 1000);
        params.put("endDate", startTime / 1000 * 1000 + 1000 * 60 * 10);

        ObjectMapper mapper = new ObjectMapper();

        try {
            String json = mapper.writeValueAsString(params);

            OkHttpClient mHttpClient = new OkHttpClient();
            RequestBody body = RequestBody.create(JSON, json);
            Request request = new Request.Builder().url(url).post(body).build();
            Response response = mHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                InputStream byteStream = response.body().byteStream();
                ObjectMapper readerMapper = new ObjectMapper();
                JsonNode jsonNode = readerMapper.readTree(byteStream);

                JsonNode rowsNode = jsonNode.get("rows");
                if (rowsNode instanceof ArrayNode) {
                    ArrayNode rows = (ArrayNode) rowsNode;
                    return rows;
                }
            } else {
                throw new IOException("Unexpected code " + response);
            }
        } catch (Exception e) {
            logger.error("请求失败-" + thingName);
        }

        return null;

    }

    public static ChuiHuiQi getChuiHuiQi(String thingName) {
        OkHttpClient mHttpClient = new OkHttpClient();
        String url = customConst.thingworxServer + "Things/" + thingName + "/Properties?" + UrlParamString;
        logger.info("getChuiHuiQi url:" + url);
        Request request = new Request.Builder().url(url).build();
        try {
            okhttp3.Response response = mHttpClient.newCall(request).execute();
            InputStream byteStream = response.body().byteStream();

            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(byteStream);
            if (jsonNode != null) {
                ArrayNode rows = (ArrayNode) jsonNode.get("rows");
                JsonNode valuesNode = rows.get(0);

                ChuiHuiQi chuiHuiQi = new ChuiHuiQi();
                chuiHuiQi.value = getFloatValue(valuesNode, "rt_temp");
                chuiHuiQi.max = getFloatValue(valuesNode, "max_temp");
                chuiHuiQi.min = getFloatValue(valuesNode, "min_temp");
                chuiHuiQi.pollutionRate = getFloatValue(valuesNode, "poll_rate");

                chuiHuiQi.status = calcStatus(valuesNode);
                chuiHuiQi.ns = getIntValue(valuesNode, "soot_sig") > 0 ? true : false;
                chuiHuiQi.name = thingName;
                return chuiHuiQi;
            }

        } catch (IOException e) {
            logger.error("请求失败-" + thingName);
        }
        return null;
    }

    //1=待续
    //2=正在吹
    public static int calcStatus(JsonNode valuesNode) {
        int for_sig = getIntValue(valuesNode, "for_sig");
        int back_sig = getIntValue(valuesNode, "back_sig");
        if (for_sig == 0) {
            if (back_sig == 1) {
                return 1;
            } else {
                return 2;
            }
        } else {
            if (back_sig == 0) {
                return 2;
            } else {
                return 1;
            }
        }
    }

    //0=待续
    //1=正在吹
    public static int calcHisStatus(JsonNode valuesNode) {
        int for_sig = getIntValue(valuesNode, "for_sig");
        int back_sig = getIntValue(valuesNode, "back_sig");
        logger.debug("for_sig:" + for_sig + ",back_sig:" + back_sig);
        if (for_sig == 0) {
            if (back_sig == 1) {
                return 0;
            } else {
                return 1;
            }
        } else {
            if (back_sig == 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    ////////////////////////////////////
    public static JsonNode requestThingProperty(String thingName) {
        OkHttpClient mHttpClient = new OkHttpClient();
        String url = customConst.thingworxServer + "Things/" + thingName + "/Properties?" + UrlParamString;
        logger.info("requestThingProperty url:" + url);
        Request request = new Request.Builder().url(url).build();
        try {
            okhttp3.Response response = mHttpClient.newCall(request).execute();
            InputStream byteStream = response.body().byteStream();

            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(byteStream);
            if (jsonNode != null) {
                ArrayNode rows = (ArrayNode) jsonNode.get("rows");
                JsonNode valuesNode = rows.get(0);
                return valuesNode;
            }
        } catch (IOException e) {
            logger.error("请求失败-" + thingName);
            return null;
        }
        logger.warn("请求不存在-" + thingName);
        return null;
    }

    public static int getIntValue(JsonNode node, String field) {
        JsonNode fieldNode = node.get(field);
        if (fieldNode == null) {
            return 0;
        } else {
            return fieldNode.asInt();
        }
    }

    public static float getFloatValue(JsonNode node, String field) {
        JsonNode fieldNode = node.get(field);
        if (fieldNode == null) {
            return Float.NaN;
        } else {
            return (float) fieldNode.asDouble();
        }
    }

}