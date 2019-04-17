package com.back.rsx.dto;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class GoodsTypeDto {
    private Integer goodsTypeId;

    private String goodsTypeName;

    private Integer parentId;

    private String createTime;

    private String updateTime;

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

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        if(updateTime==null){
            this.updateTime = null;
            return;
        }
        String dateStr = "";
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dateStr = sdf.format(updateTime);
        }catch(Exception e){
            e.printStackTrace();
        }

        this.updateTime = dateStr;
    }


    public List<GoodsTypeDto> getChildren() {
        return children;
    }

    public void setChildren(List<GoodsTypeDto> children) {
        this.children = children;
    }
}
