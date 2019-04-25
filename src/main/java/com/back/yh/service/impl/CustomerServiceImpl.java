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
    //获取会员信息与分页
    public List<Customer> getCustomerPage(CustomerVo customerVo) {
        return this.customerMapper.getCustomerPage(customerVo);
    }
    //获取数据条数
    public int getCount(CustomerVo customerVo) {
        return this.customerMapper.getCount(customerVo);
    }
    //更新会员状态(禁用)
    public int updateStatus(int customerId) {
        int i = this.customerMapper.updateStatus(customerId);
        return i;
    }
    //更新会员状态(启用)
    public int modifyStatus(int customerId) {
        int i = this.customerMapper.modifyStatus(customerId);
//        System.out.println(customerId);
        return i;
    }


}
