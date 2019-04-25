package com.back.hpq.vo;

public class OrderPayVo {
    //订单编号
    private String orderNumber;
    //支付平台id
    private Integer platformId;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
    }

    @Override
    public String toString() {
        return "OrderPayVo{" +
                "orderNumber='" + orderNumber + '\'' +
                ", platformId=" + platformId +
                '}';
    }
}
