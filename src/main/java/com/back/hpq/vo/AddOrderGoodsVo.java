package com.back.hpq.vo;

import com.back.hpq.dto.ShoppingCarDto;

import java.util.List;

public class AddOrderGoodsVo {
    private List<ShoppingCarDto> shoppingCarDtos;
    private int orderId;

    public List<ShoppingCarDto> getShoppingCarDtos() {
        return shoppingCarDtos;
    }

    public void setShoppingCarDtos(List<ShoppingCarDto> shoppingCarDtos) {
        this.shoppingCarDtos = shoppingCarDtos;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
