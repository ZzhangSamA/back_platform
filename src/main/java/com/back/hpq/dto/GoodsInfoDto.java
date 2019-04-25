package com.back.hpq.dto;

import java.math.BigDecimal;

public class GoodsInfoDto {
    private Integer ogId;
    private Integer goodsId;
    private String goodsName;
    private String parameterName;
    private BigDecimal parameterPrice;
    private String parameterIcon;
    private BigDecimal PreferentialPrice;
    private int number;
    private int goodsStatus;
    private BigDecimal goodsTotalPrice;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

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

    public BigDecimal getParameterPrice() {
        return parameterPrice;
    }

    public void setParameterPrice(BigDecimal parameterPrice) {
        this.parameterPrice = parameterPrice;
    }

    public String getParameterIcon() {
        return parameterIcon;
    }

    public void setParameterIcon(String parameterIcon) {
        this.parameterIcon = parameterIcon;
    }

    public BigDecimal getPreferentialPrice() {
        return PreferentialPrice;
    }

    public void setPreferentialPrice(BigDecimal preferentialPrice) {
        PreferentialPrice = preferentialPrice;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BigDecimal getGoodsTotalPrice() {
        return goodsTotalPrice;
    }

    public void setGoodsTotalPrice(BigDecimal goodsTotalPrice) {
        this.goodsTotalPrice = goodsTotalPrice;
    }

    public Integer getOgId() {
        return ogId;
    }

    public void setOgId(Integer ogId) {
        this.ogId = ogId;
    }

    public int getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(int goodsStatus) {
        this.goodsStatus = goodsStatus;
    }
}
