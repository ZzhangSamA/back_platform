package com.back.yh.service.impl;

import com.back.yh.mapper.CustomerMapper;
import com.back.yh.pojo.Customer;
import com.back.yh.service.CustomerService;
import com.back.yh.vo.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired(required = false)
    CustomerMapper customerMapper;
    public List<Customer> getCustomerPage(CustomerVo customerVo) {
        return this.customerMapper.getCustomerPage(customerVo);
    }

    public int getCount(CustomerVo customerVo) {
        return this.customerMapper.getCount(customerVo);
    }

    public int updateStatus(int customerId) {
        int i = this.customerMapper.updateStatus(customerId);
        return i;
    }

    public int modifyStatus(int customerId) {
        int i = this.customerMapper.modifyStatus(customerId);
//        System.out.println(customerId);
        return i;
    }


}
