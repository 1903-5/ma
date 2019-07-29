package com.qf.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;

@ApiModel("商品_购物车对象")
@Table(name = "shop_product")
@Data
public class ProductShop implements Serializable {

    private Integer sid;
    private Integer proid;


    @Override
    public String toString() {
        return "ProductShop{" +
                "sid=" + sid +
                ", proid=" + proid +
                '}';
    }

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
}