package com.safefire.common.vo.powermax;

import java.util.ArrayList;

import com.safefire.common.vo.BaseVo;

public class TrendData extends BaseVo {

    public String name;
    public String steppedLine;
    public String yAxisID;
    public ArrayList<Number> data = new ArrayList<Number>();

    public TrendData() {

    }

    public TrendData(String n) {
        this.name = n;
    }

}