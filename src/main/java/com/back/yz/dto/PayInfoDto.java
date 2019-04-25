package com.back.yz.dto;

import java.math.BigDecimal;
import java.util.Date;

public class PayInfoDto {
    private Integer payId;
    private String platformName;
    private String customerName;
    private String orderNumber;
    private String serialNumber;
    private BigDecimal money;
    private String createTime;

    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "PayInfoDto{" +
                "payId=" + payId +
                ", platformName='" + platformName + '\'' +
                ", customerName='" + customerName + '\'' +
                ", orderNumber='" + orderNumber + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", money=" + money +
                ", createTime=" + createTime +
                '}';
    }
}
