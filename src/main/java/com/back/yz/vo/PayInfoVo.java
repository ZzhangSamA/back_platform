package com.back.yz.vo;

import com.back.yxy.pojo.Page;

public class PayInfoVo {
    private String customerName;
    private String serialNumber;
    private Page page;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "PayInfoVo{" +
                "customerName='" + customerName + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", page=" + page +
                '}';
    }
}
