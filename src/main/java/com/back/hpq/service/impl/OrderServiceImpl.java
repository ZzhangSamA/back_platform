package com.back.hpq.service.impl;

import com.back.hpq.dto.*;
import com.back.hpq.mapper.TOrderMapper;
import com.back.hpq.pojo.TOrder;
import com.back.hpq.service.OrderService;
import com.back.hpq.vo.GoodsOrderVo;
import com.back.hpq.vo.OrderInfoVo;
import com.back.hpq.vo.ReturnMessageVo;
import com.back.tools.SplitPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired(required = false)
    TOrderMapper tOrderMapper;
    public OrderPageDto getOrders(OrderInfoVo orderInfoVo) {
        List<TOrderDto> orders=null;
        if (orderInfoVo.getCustomer()!=null){
             orders = tOrderMapper.getOrdersByCustomId(orderInfoVo);
        }
        OrderPageDto orderPageDto = new OrderPageDto();
        SplitPage splitPage = orderInfoVo.getSplitPage();
        splitPage.setTotalLine(this.getOrderCount(orderInfoVo.getCustomer().getCustomerId()));
        orderPageDto.setSplitPage(splitPage);
        orderPageDto.setOrderDto(orders);
        return orderPageDto;
    }

    public TOrder getOrderById(int orderId) {
        return tOrderMapper.selectByPrimaryKey(orderId);
    }

    public int getOrderCount(int customerId) {
        return tOrderMapper.getOrderCount(customerId);
    }

    public int delivery(TOrder tOrder) {
        int status = tOrderMapper.getStatus(tOrder.getOrderNumber());
        if (status==3) {
            return tOrderMapper.delivery(tOrder);
        }
        return 0;
    }

    public int refuseOrder(TOrder tOrder) {
        int status = tOrderMapper.getStatus(tOrder.getOrderNumber());
        if (status==1||status==2){
           return tOrderMapper.refuseOrder(tOrder);
        }
        return 0;
    }

    public OrderDetail getOrderDetail(TOrder tOrder) {
        return tOrderMapper.getOrderDetail(tOrder);
    }

    public int checkedDeliver(TOrder tOrder) {
        TOrder nTOrder = tOrderMapper.getCreatTime(tOrder);
        if (nTOrder==null){
            return 0;
        }
        long creatTime = nTOrder.getCreateTime().getTime();
        int status = nTOrder.getStatus();
        long nowTime = new Date().getTime();
        if ((nowTime-creatTime)>1296000000||status==1){
            return 0;
        }
        return 1;
    }

    public GoodsDto getGoodsInfo(GoodsOrderVo goodsOrderVo) {
        GoodsDto goodsInfoDto = tOrderMapper.getGoodsInfo(goodsOrderVo);
        return goodsInfoDto;
    }

    public GoodsDto getRefuseGoods(GoodsOrderVo goodsOrderVo) {
        GoodsDto refuseGoods = tOrderMapper.getRefuseGoods(goodsOrderVo);
        return refuseGoods;
    }

    public int setStatus(ReturnMessageVo returnMessageVo) {
        return 0;
    }

    /**
     * 根据订单id获取对象
     * @param orderId
     * @return
     */
    public TOrder selectByPrimaryKey(Integer orderId) {
        return tOrderMapper.selectByPrimaryKey(orderId);
    }

    /**
     * 根据条件属性修改对象属性
     * @param tOrder
     * @return
     */
    public Boolean updateByPrimaryKeySelective(TOrder tOrder) {
        if (tOrderMapper.updateByPrimaryKeySelective(tOrder) > 0) {
            return true;
        }else {
            return false;
        }
    }

    /**
     * 根据订单编号获取TOrder对象
     * @param orderNumber
     * @return
     */
    public TOrder getOrderByOrderNumber(String orderNumber) {
        return tOrderMapper.getOrderByOrderNumber(orderNumber);
    }
}
