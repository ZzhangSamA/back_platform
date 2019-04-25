package com.back.hpq.vo;

import com.back.tools.SplitPage;
import com.back.yh.pojo.Customer;

public class OrderInfoVo {
    private SplitPage splitPage;
    private Customer customer;

    public SplitPage getSplitPage() {
        return splitPage;
    }

    public void setSplitPage(SplitPage splitPage) {
        this.splitPage = splitPage;
        splitPage.setPageSize(5);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
