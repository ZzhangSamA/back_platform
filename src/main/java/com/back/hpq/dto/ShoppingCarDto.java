package com.back.hpq.dto;

import java.math.BigDecimal;

public class ShoppingCarDto {
    private int cartId;
    private int goodsId;
    private String goodsName;
    private String parameterIcon;
    private String parameterName;
    private BigDecimal price;
    private int number;
    private BigDecimal totalPrice;
    private int parameterId;

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getParameterIcon() {
        return parameterIcon;
    }

    public void setParameterIcon(String parameterIcon) {
        this.parameterIcon = parameterIcon;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }


    public int getParameterId() {
        return parameterId;
    }

    public void setParameterId(int parameterId) {
        this.parameterId = parameterId;
    }

    @Override
    public String toString() {
        return "ShoppingCarDto{" +
                "cartId=" + cartId +
                ", goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", parameterIcon='" + parameterIcon + '\'' +
                ", parameterName='" + parameterName + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", totalPrice=" + totalPrice +
                ", parameterId=" + parameterId +
                '}';
    }
}
