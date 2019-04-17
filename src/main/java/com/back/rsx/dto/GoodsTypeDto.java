package com.back.rsx.dto;


import java.util.Date;
import java.util.List;

public class GoodsTypeDto {
    private Integer goodsTypeId;

    private String goodsTypeName;

    private Integer parentId;

    private Date createTime;

    private Date updateTime;

    private List<GoodsTypeDto> children ;

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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    public List<GoodsTypeDto> getChildren() {
        return children;
    }

    public void setChildren(List<GoodsTypeDto> children) {
        this.children = children;
    }
}
