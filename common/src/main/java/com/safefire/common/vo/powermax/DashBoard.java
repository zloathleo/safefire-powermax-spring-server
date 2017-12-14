package com.safefire.common.vo.powermax;

import java.util.ArrayList;
import java.util.HashMap;

import com.safefire.common.vo.BaseVo;

public class DashBoard extends BaseVo {

    public ArrayList<Value> summary = new ArrayList<Value>();

    public HashMap<String, Object> kongyuqiA = new HashMap<String, Object>();
    public HashMap<String, Object> kongyuqiB = new HashMap<String, Object>();

    public HashMap<String, Object> erjizai = new HashMap<String, Object>();
    public HashMap<String, Object> shenmeiqi = new HashMap<String, Object>();
    public HashMap<String, Object> sanjiguo = new HashMap<String, Object>();
    public HashMap<String, Object> yijizai = new HashMap<String, Object>();
    public HashMap<String, Object> yijiguo = new HashMap<String, Object>();

    public HashMap<String, Object> erjiguo = new HashMap<String, Object>();
    public HashMap<String, Object> lutang = new HashMap<String, Object>();

}