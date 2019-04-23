package com.back.yh.dto;

import com.back.tools.SplitPage;
import com.back.yh.pojo.Customer;

import java.util.List;

public class CustomerDto {
    //当前页数据
    List<Customer> customerList;

    //分页数据
    SplitPage splitPage;

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public SplitPage getSplitPage() {
        return splitPage;
    }

    public void setSplitPage(SplitPage splitPage) {
        this.splitPage = splitPage;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "customerList=" + customerList +
                ", splitPage=" + splitPage +
                '}';
    }
}
