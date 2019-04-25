package com.back.hpq.pojo;

import java.math.BigDecimal;

public class ShoppingCart {

    private Integer cartId;


    private Integer customerId;


    private Integer goodsId;

    private Integer number;


    private BigDecimal price;


    private BigDecimal totalPrice;


    public Integer getCartId() {
        return cartId;
    }


    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }


    public Integer getCustomerId() {
        return customerId;
    }


    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }


    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }


    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}