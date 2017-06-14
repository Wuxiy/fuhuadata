package com.fuhuadata.domain;

import javax.validation.constraints.NotNull;

/**
 * 企业性质
 * Created by intanswer on 2017/3/23.
 */
public class CustomerEnterpriceNature {

    private Integer id;//编号

    @NotNull
    private String customerId;//客户id

    @NotNull
    private Integer nature;//企业性质 1：工厂 2：分销商 3：经销商 4：终端客户 5：其他


    private Integer type;//企业类型 1：客户 2：子公司


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Integer getNature() {
        return nature;
    }

    public void setNature(Integer nature) {
        this.nature = nature;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
