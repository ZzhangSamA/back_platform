package com.back.hpq.controller;

import com.back.hpq.dto.GoodsDto;
import com.back.hpq.dto.OrderDetail;
import com.back.hpq.pojo.TOrder;
import com.back.hpq.service.OrderService;
import com.back.hpq.vo.GoodsOrderVo;
import com.back.hpq.vo.OrderInfoVo;
import com.back.tools.SplitPage;
import com.back.yh.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class OrderController {
    Boolean flag;

    @Autowired(required = false)
    OrderService orderService;

    @RequestMapping(value = "getOrders",method = RequestMethod.POST)
    public Object getOrders(@RequestBody(required = false)SplitPage splitPage, HttpSession httpSession){
        OrderInfoVo orderInfoVo = new OrderInfoVo();
        Customer customer1 = new Customer();
        customer1.setCustomerId(2);
        httpSession.setAttribute("customer",customer1);
        Customer customer = (Customer)httpSession.getAttribute("customer");
        orderInfoVo.setCustomer(customer);
        orderInfoVo.setSplitPage(splitPage);
        return orderService.getOrders(orderInfoVo);

    }
    @RequestMapping(value = "delivery",method = RequestMethod.POST)
    public Object delivery(@RequestBody(required = false)TOrder tOrder){
        int delivery = orderService.delivery(tOrder);
        return delivery;
    }

    @RequestMapping(value = "refuseOrder",method = RequestMethod.POST)
    public Object refuseOrder(@RequestBody(required = false)TOrder tOrder){
        int refuseOrder = orderService.refuseOrder(tOrder);
        return refuseOrder;
    }
    @RequestMapping(value = "getOrderDetail",method = RequestMethod.POST)
    public Object getOrderDetail(@RequestBody(required = false)TOrder tOrder, HttpSession httpSession){
        Customer customer1 = new Customer();
        customer1.setCustomerId(2);
        httpSession.setAttribute("customer",customer1);
        Customer customer = (Customer)httpSession.getAttribute("customer");
        Integer customerId = customer.getCustomerId();
        tOrder.setCustomerId(customerId);
        OrderDetail orderDetail = orderService.getOrderDetail(tOrder);
        return orderDetail;

    }

    @RequestMapping(value = "checkedDeliver",method = RequestMethod.POST)
    public Object checkedDeliver(@RequestBody(required = false)TOrder tOrder, HttpSession httpSession){
        int i = orderService.checkedDeliver(tOrder);
        return i;
    }
    @RequestMapping(value = "getGoodsInfo",method = RequestMethod.POST)
    public Object getGoodsInfo(@RequestBody(required = false)GoodsOrderVo goodsOrderVo, HttpSession httpSession){
        GoodsDto goodsInfoDto = orderService.getGoodsInfo(goodsOrderVo);
        return goodsInfoDto;
    }
    @RequestMapping(value = "getRefuseGoods",method = RequestMethod.POST)
    public Object getRefuseGoods(@RequestBody(required = false)GoodsOrderVo goodsOrderVo, HttpSession httpSession){
        GoodsDto refuseGoods = orderService.getRefuseGoods(goodsOrderVo);
        return refuseGoods;
    }

    /**
     * 发货
     * @param tOrder{
     *                  orderId:订单id,
     *                  expCode:物流公司编号,
     *                  expNo:物流单号
     *              }
     * @return
     */
    @RequestMapping(value = "setExpress",method = RequestMethod.POST)
    public Object setExpress(@RequestBody(required = false)TOrder tOrder) {
        if (tOrder == null) {
            return false + "";
        }
        flag = orderService.updateByPrimaryKeySelective(tOrder);
        return flag;
    }

}
