package com.back.hpq.pojo;

public class ShoppingCart {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shopping_cart.cart_id
     *
     * @mbggenerated
     */
    private Integer cartId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shopping_cart.customer_id
     *
     * @mbggenerated
     */
    private Integer customerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shopping_cart.goods_id
     *
     * @mbggenerated
     */
    private Integer goodsId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shopping_cart.number
     *
     * @mbggenerated
     */
    private Integer number;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shopping_cart.price
     *
     * @mbggenerated
     */
    private Double price;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shopping_cart.cart_id
     *
     * @return the value of shopping_cart.cart_id
     *
     * @mbggenerated
     */
    public Integer getCartId() {
        return cartId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shopping_cart.cart_id
     *
     * @param cartId the value for shopping_cart.cart_id
     *
     * @mbggenerated
     */
    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shopping_cart.customer_id
     *
     * @return the value of shopping_cart.customer_id
     *
     * @mbggenerated
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shopping_cart.customer_id
     *
     * @param customerId the value for shopping_cart.customer_id
     *
     * @mbggenerated
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shopping_cart.goods_id
     *
     * @return the value of shopping_cart.goods_id
     *
     * @mbggenerated
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shopping_cart.goods_id
     *
     * @param goodsId the value for shopping_cart.goods_id
     *
     * @mbggenerated
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shopping_cart.number
     *
     * @return the value of shopping_cart.number
     *
     * @mbggenerated
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shopping_cart.number
     *
     * @param number the value for shopping_cart.number
     *
     * @mbggenerated
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shopping_cart.price
     *
     * @return the value of shopping_cart.price
     *
     * @mbggenerated
     */
    public Double getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shopping_cart.price
     *
     * @param price the value for shopping_cart.price
     *
     * @mbggenerated
     */
    public void setPrice(Double price) {
        this.price = price;
    }
}