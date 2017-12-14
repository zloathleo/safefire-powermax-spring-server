package com.safefire.common.vo.powermax;

import com.safefire.common.vo.BaseVo;

public class Value extends BaseVo {

    public String field;
    public Object value;

    public Value() {

    }

    public Value(String f, Object v) {
        this.field = f;
        this.value = v;
    }

}