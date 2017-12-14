package com.safefire.webapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.safefire.common.vo.BaseResp;
import com.safefire.common.vo.powermax.TrendData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PowerMaxTrendController {

    private static Logger logger = LoggerFactory.getLogger(PowerMaxTrendController.class);

    @RequestMapping(value = "/chuihuiqi/trend/{name}/{start}", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE })
    public BaseResp<HashMap<String, Object>> getTrend(@PathVariable(value = "name") final String name,
            @PathVariable(value = "start") final long startTime) {

        ArrayList<Long> labels = new ArrayList<Long>();

        ArrayList<TrendData> datas = new ArrayList<TrendData>();
        TrendData rt_temp_td = new TrendData("实时值");
        rt_temp_td.yAxisID = "y-axis-value";

        TrendData poll_rate_td = new TrendData("污染率");
        poll_rate_td.yAxisID = "y-axis-percent";

        TrendData max_temp_td = new TrendData("最大值");
        max_temp_td.yAxisID = "y-axis-value";

        TrendData min_temp_td = new TrendData("最小值");
        min_temp_td.yAxisID = "y-axis-value";

        TrendData status_td = new TrendData("吹灰器状态");
        status_td.yAxisID = "y-axis-status";
        status_td.steppedLine = "before";

        datas.add(rt_temp_td);
        datas.add(poll_rate_td);
        datas.add(max_temp_td);
        datas.add(min_temp_td);
        datas.add(status_td);

        ArrayNode array = ThingworxConnection.requestChuiHuiQiHistory(name, startTime);
        Iterator<JsonNode> it = array.elements();
        while (it.hasNext()) {
            JsonNode nnode = it.next();
            long timestamp = nnode.get("timestamp").asLong();

            JsonNode child_node = nnode.get("poll_rate");
            if (child_node != null) {
                double poll_rate = child_node.asDouble();
                poll_rate_td.data.add(poll_rate);
            }
            child_node = nnode.get("max_temp");
            if (child_node != null) {
                double max_temp = child_node.asDouble();
                max_temp_td.data.add(max_temp);
            }
            child_node = nnode.get("min_temp");
            if (child_node != null) {
                double min_temp = child_node.asDouble();
                min_temp_td.data.add(min_temp);
            }

            JsonNode rt_temp_node = nnode.get("rt_temp");
            if (rt_temp_node != null) {
                double rt_temp = rt_temp_node.asDouble();
                rt_temp_td.data.add(rt_temp);
            }

            int status = OKHttp.calcHisStatus(nnode);
            status_td.data.add(status);

            labels.add(timestamp);
        }

        

        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("name", name);

        HashMap<String, Object> trneds = new HashMap<String, Object>();
        trneds.put("labels", labels);
        trneds.put("datas", datas);

        data.put("trneds", trneds);

        return new BaseResp<HashMap<String, Object>>(data);
    }

}
