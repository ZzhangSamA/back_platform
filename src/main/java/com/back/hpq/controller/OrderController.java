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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
public class OrderController {
    Boolean flag;

    @Autowired(required = false)
    OrderService orderService;

    @RequestMapping(value = "getOrders",method = RequestMethod.POST)
    public Object getOrders(@RequestBody(required = false)SplitPage splitPage, HttpSession httpSession){

        return orderService.getOrders(splitPage);

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
     *                  orderNumber:订单id,
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
        //通过orderNumber获取Order对象
        TOrder order = orderService.getOrderByOrderNumber(tOrder.getOrderNumber());
        //修改订单状态为：待收货
        order.setStatus(3);
        //设置发货时间：获取当前时间
        order.setConsignTime(new Date());
        //设置物流属性
        order.setExpCode(tOrder.getExpCode());
        order.setExpNo(tOrder.getExpNo());
        flag = orderService.updateByPrimaryKeySelective(order);
        return flag;
    }

    /**
     * 根据订单编号获取订单对象
     * @param tOrder
     * @return
     */
    @RequestMapping(value = "getOrderByOrderNumber",method = RequestMethod.POST)
    public Object getOrderByOrderNumber(@RequestBody(required = false) TOrder tOrder) {
        TOrder order = orderService.getOrderByOrderNumber(tOrder.getOrderNumber());
        if (order == null) {
            return false + "";
        }
        return order;
    }
}
