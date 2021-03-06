package com.back.hpq.service;

import com.back.hpq.dto.GoodsDto;
import com.back.hpq.dto.OrderDetail;
import com.back.hpq.dto.OrderPageDto;
import com.back.hpq.dto.TOrderDto;
import com.back.hpq.pojo.TOrder;
import com.back.hpq.vo.GoodsOrderVo;
import com.back.hpq.vo.OrderInfoVo;
import com.back.hpq.vo.ReturnMessageVo;
import com.back.tools.SplitPage;


public interface OrderService {
     OrderPageDto getOrders(SplitPage splitPage);
    TOrder getOrderById(int orderId);
    int getOrderCount();
    int delivery(TOrder tOrder);
    int refuseOrder(TOrder tOrder);
    TOrderDto getOrderDetail(TOrder tOrder);
    int checkedDeliver(TOrder tOrder);
    GoodsDto getGoodsInfo(GoodsOrderVo goodsOrderVo);
    GoodsDto getRefuseGoods(GoodsOrderVo goodsOrderVo);
    int setStatus(ReturnMessageVo returnMessageVo);

    /**
     * 根据订单id获取对象
     * @param orderId
     * @return
     */
    TOrder selectByPrimaryKey(Integer orderId);

    /**
     * 根据条件属性修改对象属性
     * @param tOrder
     * @return
     */
    Boolean updateByPrimaryKeySelective(TOrder tOrder);

    /**
     * 根据订单编号获取TOrder对象
     * @param orderNumber
     * @return
     */
    TOrder getOrderByOrderNumber(String orderNumber);
}
