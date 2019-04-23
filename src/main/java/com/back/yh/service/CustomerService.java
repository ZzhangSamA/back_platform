package com.back.yh.service;

import com.back.yh.pojo.Customer;
import com.back.yh.vo.CustomerVo;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomerPage(CustomerVo customerVo);

    int getCount(CustomerVo customerVo);

    int updateStatus(int customerId);

    int modifyStatus(int customerId);
}
