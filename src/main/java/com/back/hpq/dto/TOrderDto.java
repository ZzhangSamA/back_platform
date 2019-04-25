package com.back.hpq.dto;

import java.math.BigDecimal;
import java.util.List;


public class TOrderDto {

    private String orderNumber;
    private String createTime;
    private int Status;
    private BigDecimal totalPrice;
    private List<GoodsInfoDto> goodsInfoDtos;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<GoodsInfoDto> getGoodsInfoDtos() {
        return goodsInfoDtos;
    }

    public void setGoodsInfoDtos(List<GoodsInfoDto> goodsInfoDtos) {
        this.goodsInfoDtos = goodsInfoDtos;
    }
}
