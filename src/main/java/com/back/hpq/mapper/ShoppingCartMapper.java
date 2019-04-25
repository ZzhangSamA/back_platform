package com.back.hpq.mapper;

import com.back.hpq.dto.ShoppingCarDto;
import com.back.hpq.pojo.ShoppingCart;
import com.back.hpq.vo.AddOrderGoodsVo;
import com.back.hpq.vo.AddOrderVo;
import com.back.hpq.vo.ShoppingCarVo;

import java.math.BigDecimal;
import java.util.List;

public interface ShoppingCartMapper {
    int deleteByPrimaryKey(Integer cartId);

    int insert(ShoppingCart record);

    int insertSelective(ShoppingCart record);

    ShoppingCart selectByPrimaryKey(Integer cartId);

    int updateByPrimaryKeySelective(ShoppingCart record);

    int updateByPrimaryKey(ShoppingCart record);

    List<ShoppingCarDto> getCart(int customerId);

    int removeCart(ShoppingCarVo shoppingCarVo);

    int removeAllCart(int customerId);

    BigDecimal getPrice(int ParameterId);

    int getAddressId(int customerId);

    int addOrder(AddOrderVo addOrderVo);

    int addOrderGoods(AddOrderGoodsVo addOrderGoodsVo);

    int getOrderId(int OrderNumber);

    int addShoppingCart(ShoppingCarVo shoppingCarVo);

    int addOneOrderGoods(ShoppingCarVo shoppingCarVo);
}