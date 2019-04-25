package com.back.hpq.dto;

public class StatusDto {
    private int tOderStatus;
    private int goodsStatus;

    public int gettOderStatus() {
        return tOderStatus;
    }

    public void settOderStatus(int tOderStatus) {
        this.tOderStatus = tOderStatus;
    }

    public int getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(int goodsStatus) {
        this.goodsStatus = goodsStatus;
    }
}
