package com.back.rsx.vo;

import com.back.rsx.tools.SplitePageBean;

public class GoodsInfoVo {
    private String createTime;
    private String goodsName;
    private SplitePageBean splitePageBean;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getBrandName() {
        return goodsName;
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

    @Override
    public String toString() {
        return "BrandVo{" +
                "createTime='" + createTime + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", splitePageBean=" + splitePageBean +
                '}';
    }
}
