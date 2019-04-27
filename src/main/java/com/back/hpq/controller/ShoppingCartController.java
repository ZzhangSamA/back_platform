package com.back.hpq.controller;

import com.back.hpq.service.ShoppingCart;
import com.back.hpq.vo.ShoppingCarVo;
import com.back.yh.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class ShoppingCartController {
    @Autowired(required = false)
    ShoppingCart shoppingCart;

    @RequestMapping(value = "getCart",method = RequestMethod.POST)
    public Object getOrders(HttpSession httpSession){
        Customer customer = (Customer)httpSession.getAttribute("customer");
        return shoppingCart.getCart(customer.getCustomerId());
    }

    @RequestMapping(value = "removeCart",method = RequestMethod.POST)
    public Object removeCart(@RequestBody ShoppingCarVo shoppingCarVo, HttpSession httpSession){
        Customer customer = (Customer)httpSession.getAttribute("customer");
        shoppingCarVo.setCustomerId(customer.getCustomerId());
        int i = shoppingCart.removeCart(shoppingCarVo);
        return i;
    }

    @RequestMapping(value = "addOrder",method = RequestMethod.POST)
    public Object addOrder(@RequestBody ShoppingCarVo shoppingCarVo, HttpSession httpSession){
        Customer customer = (Customer)httpSession.getAttribute("customer");
        shoppingCarVo.setCustomerId(customer.getCustomerId());
        return shoppingCart.addOrder(shoppingCarVo);
    }


    @RequestMapping(value = "addShoppingCart",method = RequestMethod.POST)
    public Object addShoppingCart(@RequestBody ShoppingCarVo shoppingCarVo, HttpSession httpSession){
        Customer customer = (Customer)httpSession.getAttribute("customer");
        shoppingCarVo.setCustomerId(customer.getCustomerId());
        return shoppingCart.addShoppingCart(shoppingCarVo);
    }
    @RequestMapping(value = "addOneOrder",method = RequestMethod.POST)
    public Object addOneOrder(@RequestBody ShoppingCarVo shoppingCarVo, HttpSession httpSession){
        Customer customer = (Customer)httpSession.getAttribute("customer");
        if(customer==null){
            return 0;
        }
        shoppingCarVo.setCustomerId(customer.getCustomerId());
        return shoppingCart.addOneOrder(shoppingCarVo);
    }
}
