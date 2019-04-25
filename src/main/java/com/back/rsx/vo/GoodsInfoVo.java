package com.back.rsx.vo;

import com.back.rsx.tools.SplitePageBean;

public class GoodsInfoVo {
    private Integer goodsId;
    private String createTime;
    private String goodsName;
    private SplitePageBean splitePageBean;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }


    public void setBrandName(String goodsName) {
        this.goodsName = goodsName;
    }

    public SplitePageBean getSplitePageBean() {
        return splitePageBean;
    }

    public void setSplitePageBean(SplitePageBean splitePageBean) {
        this.splitePageBean = splitePageBean;
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

    @Override
    public String toString() {
        return "BrandVo{" +
                "createTime='" + createTime + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", splitePageBean=" + splitePageBean +
                '}';
    }
}
