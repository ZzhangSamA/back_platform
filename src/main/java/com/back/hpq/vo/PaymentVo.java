package com.back.hpq.vo;

import java.util.Date;

public class PaymentVo {
    //订单id
    private Integer orderId;
    //支付时间
    private Date paymentTime;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    @Override
    public String toString() {
        return "PaymentVo{" +
                "orderId=" + orderId +
                ", paymentTime=" + paymentTime +
                '}';
    }
}
