package com.back.rsx.dto;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

//商品信息后台展示
public class GoodsInfoDto {
    private Integer goodsId;
    private String  goodsName;
    private String  goodsNumber;
    private BigDecimal showPrice;
    private Integer goodsTypeId;
    private String goodsTypeName;
    private Integer brandId;
    private String brandName;
    private String createTime;
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        if(createTime==null){
            this.createTime = null;
            return;
        }
        String dateStr = "";
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dateStr = sdf.format(createTime);
        }catch(Exception e){
            e.printStackTrace();
        }

        this.createTime = dateStr;
    }
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

    public String getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(String goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public BigDecimal getShowPrice() {
        return showPrice;
    }

    public void setShowPrice(BigDecimal showPrice) {
        this.showPrice = showPrice;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(Integer goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    public String getGoodsTypeName() {
        return goodsTypeName;
    }

    public void setGoodsTypeName(String goodsTypeName) {
        this.goodsTypeName = goodsTypeName;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "GoodsInfoDto{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsNumber='" + goodsNumber + '\'' +
                ", showPrice=" + showPrice +
                ", goodsTypeId=" + goodsTypeId +
                ", goodsTypeName='" + goodsTypeName + '\'' +
                ", brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}
