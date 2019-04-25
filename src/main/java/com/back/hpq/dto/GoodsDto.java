package com.back.hpq.dto;

import java.math.BigDecimal;

public class GoodsDto {
    private String goodsName;
    private String parameterName;
    private String parameterIcon;
    private BigDecimal postage;
    private BigDecimal totalPrice;
    private  int number;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParameterIcon() {
        return parameterIcon;
    }

    public void setParameterIcon(String parameterIcon) {
        this.parameterIcon = parameterIcon;
    }

    public BigDecimal getPostage() {
        return postage;
    }

    public void setPostage(BigDecimal postage) {
        this.postage = postage;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
