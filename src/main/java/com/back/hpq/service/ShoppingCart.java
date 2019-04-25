package com.back.hpq.service;

import com.back.hpq.dto.ShoppingCarDto;
import com.back.hpq.vo.ShoppingCarVo;

import java.util.List;

public interface ShoppingCart {

    List<ShoppingCarDto> getCart(int customerId);

    int removeCart(ShoppingCarVo shoppingCarVo);

    int addOrder(ShoppingCarVo shoppingCarVo);

    int addShoppingCart(ShoppingCarVo shoppingCarVo);

    int addOneOrder(ShoppingCarVo shoppingCarVo);
}
