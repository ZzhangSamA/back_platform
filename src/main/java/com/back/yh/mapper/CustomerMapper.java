package com.back.yh.mapper;

import com.back.yh.pojo.Customer;
import com.back.yh.vo.CustomerVo;

import java.util.List;

public interface CustomerMapper {
    //获取所有用户及分页
    List<Customer> getCustomerPage(CustomerVo customerVo);
//获取数据条数
    int getCount(CustomerVo customerVo);
//会员状态修改
    int updateStatus(int customerId);
//会员状态修改
    int modifyStatus(int customerId);

}
