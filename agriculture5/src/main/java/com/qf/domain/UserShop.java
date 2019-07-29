package com.qf.domain;

import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
@ApiModel("用户_购物车对象")
@Table(name = "user_shop")
public class UserShop implements Serializable {


    private Integer sid;
    private Integer usid;

    @Override
    public String toString() {
        return "UserShop{" +
                "sid=" + sid +
                ", usid=" + usid +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getUsid() {
        return usid;
    }

    public void setUsid(Integer usid) {
        this.usid = usid;
    }
}
