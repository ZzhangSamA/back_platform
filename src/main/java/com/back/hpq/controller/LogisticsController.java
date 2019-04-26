package com.back.hpq.controller;

import com.back.hpq.service.ReturnSale;
import com.back.hpq.vo.ReturnMessageVo;
import com.back.yh.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class LogisticsController {
    @Autowired(required = false)
    ReturnSale returnSale;

    @RequestMapping(value = "getReturnMessage",method = RequestMethod.POST)
    public Object getReturnMessage(@RequestBody(required = false)ReturnMessageVo returnMessageVo, HttpSession httpSession){
        Customer customer = (Customer)httpSession.getAttribute("customer");
        returnMessageVo.setCustomerId(customer.getCustomerId());
        int i = returnSale.addReturnSale(returnMessageVo);
        return i;

    }
    @RequestMapping(value = "getReturnDetail",method = RequestMethod.POST)
    public Object getReturnDetail(@RequestBody(required = false)ReturnMessageVo returnMessageVo, HttpSession httpSession){

        return returnSale.getReturnDetail(returnMessageVo);
    }
    @RequestMapping(value = "againRefuse",method = RequestMethod.POST)
    public Object againRefuse(@RequestBody(required = false)ReturnMessageVo returnMessageVo, HttpSession httpSession){

        return returnSale.againRefuse(returnMessageVo);
    }

}
