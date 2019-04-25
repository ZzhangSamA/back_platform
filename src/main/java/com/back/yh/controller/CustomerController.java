package com.back.yh.controller;

import com.back.tools.SplitPage;
import com.back.yh.dto.CustomerDto;
import com.back.yh.pojo.Customer;
import com.back.yh.service.CustomerService;
import com.back.yh.vo.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "getCustomerPage" ,method = RequestMethod.POST)
    public Object getCustomerPage(@RequestBody(required = false)CustomerVo customerVo){
        //获取分页类对象
        SplitPage splitPage = customerVo.getSplitPage();

        //每行条数
        splitPage.setPageSize(customerVo.getSplitPage().getPageSize());
        //当前页，同时设置了start
        splitPage.setCurrentPage(customerVo.getSplitPage().getCurrentPage());


//        System.out.println(splitPage);

        customerVo.setSplitPage(splitPage);
        List<Customer> list = customerService.getCustomerPage(customerVo);
        //获取数据条数
        int count = customerService.getCount(customerVo);
        //总条数，同时设置了总页数
        splitPage.setTotalLine(count);
//        System.out.println(count);
//        System.out.println(list);

        CustomerDto customerDto = new CustomerDto();
        customerDto.setSplitPage(splitPage);
        customerDto.setCustomerList(list);
//        System.out.println(customerDto);
        return customerDto;
    }
    //更新会员状态(禁用)
    @RequestMapping(value = "updateStatus" ,method = RequestMethod.POST)
    public Object updateStatus(@RequestBody Customer customer){
        int i = this.customerService.updateStatus(customer.getCustomerId());
//        System.out.println(i);
        return i;
    }
    //更新会员状态(启用)
    @RequestMapping(value = "modifyStatus" ,method = RequestMethod.POST)
    public Object modifyStatus(@RequestBody Customer customer){
        int i = this.customerService.modifyStatus(customer.getCustomerId());
//        System.out.println(i);
        return i;
    }
}
