package com.safefire.common.vo.powermax;

import com.safefire.common.vo.BaseVo;

public class ChuiHuiQi extends BaseVo {

    public String name;
    //DCS状态
    public int status;
    //是否需要吹灰
    public boolean ns;
    public float min;
    public float max;
    public float value;
    public float pollutionRate;

    public ChuiHuiQi() {

    }

    public ChuiHuiQi(String n, int s, float min, float max, float v, float p) {
        this.name = n;
        this.status = s;
        this.min = min;
        this.max = max;
        this.value = v;
        this.pollutionRate = p;
    }

}