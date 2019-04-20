package com.back.rsx.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Supplier {
    private Integer supplierId;

    private String supplierName;

    private String address;

    private String createTime;

    private String updateTime;

    private Boolean status;

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName == null ? null : supplierName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}