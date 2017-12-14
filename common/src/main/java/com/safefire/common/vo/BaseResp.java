package com.safefire.common.vo;

import java.io.Serializable;

public class BaseResp<V> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;
    private String msg;

    private V data;

    public BaseResp() {
        this.code = "000000";
        this.msg = "ok";
    }

    public BaseResp(V data) {
        this();
        this.data = data;
    }

    public BaseResp(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public V getData() {
        return data;
    }

    public void setData(V data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "BaseResp[" + code + "," + msg + "]";
    }

}