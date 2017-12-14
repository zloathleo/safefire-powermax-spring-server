package com.safefire.common.vo.user;

import java.util.Date;

import com.safefire.common.vo.BaseVo;

public class User extends BaseVo{

    private Date createTime;

    /**
     * @return the createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}