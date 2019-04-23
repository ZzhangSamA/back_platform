package com.back.rsx.vo;

import com.back.rsx.tools.SplitePageBean;

public class BrandVo {
    private String createTime;
    private String brandName;
    private SplitePageBean splitePageBean;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
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
                ", brandName='" + brandName + '\'' +
                ", splitePageBean=" + splitePageBean +
                '}';
    }
}
