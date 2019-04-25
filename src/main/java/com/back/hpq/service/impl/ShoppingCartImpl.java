package com.back.hpq.service.impl;

import com.back.hpq.dto.ShoppingCarDto;
import com.back.hpq.mapper.ShoppingCartMapper;
import com.back.hpq.mapper.TOrderMapper;
import com.back.hpq.service.ShoppingCart;
import com.back.hpq.vo.AddOrderGoodsVo;
import com.back.hpq.vo.AddOrderVo;
import com.back.hpq.vo.ShoppingCarVo;
import com.back.tools.RandomNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartImpl implements ShoppingCart {

    @Autowired(required = false)
    ShoppingCartMapper shoppingCartMapper;
    @Autowired(required = false)
    TOrderMapper tOrderMapper;

    public List<ShoppingCarDto> getCart(int customerId) {
        return shoppingCartMapper.getCart(customerId);
    }

    public int removeCart(ShoppingCarVo shoppingCarVo) {
        return shoppingCartMapper.removeCart(shoppingCarVo);
    }

    @Transactional
    public int addOrder (ShoppingCarVo shoppingCarVo) {
        String[] cartMessage = shoppingCarVo.getCartMessage();
        if (cartMessage!=null){
            ArrayList<ShoppingCarDto> shoppingCarDtos = new ArrayList<ShoppingCarDto>();
            BigDecimal allPrice=new BigDecimal(0);
            for (String s:cartMessage){
                int cartId = Integer.parseInt(s.split("&")[0].split("cartId=")[1]);
                int goodsId = Integer.parseInt(s.split("&")[1].split("goodsId=")[1]);
                int parameterId = Integer.parseInt(s.split("&")[2].split("parameterId=")[1]);
                int number = Integer.parseInt(s.split("&")[3].split("number=")[1]);
                ShoppingCarDto shoppingCarDto = new ShoppingCarDto();
                shoppingCarDto.setCartId(cartId);
                shoppingCarDto.setGoodsId(goodsId);
                shoppingCarDto.setParameterId(parameterId);
                shoppingCarDto.setNumber(number);
                BigDecimal num = new BigDecimal(number);
                BigDecimal totalPrice ;
                BigDecimal price = shoppingCartMapper.getPrice(parameterId);
                totalPrice=price.multiply(num);
                allPrice= allPrice.add(totalPrice);
                shoppingCarDto.setPrice(price);
                shoppingCarDto.setTotalPrice(totalPrice);
                shoppingCarDtos.add(shoppingCarDto);
            }
            shoppingCartMapper.removeAllCart(shoppingCarVo.getCustomerId());
            int addressId = shoppingCartMapper.getAddressId(shoppingCarVo.getCustomerId());
            AddOrderVo addOrderVo = new AddOrderVo();
            addOrderVo.setCustomerId(shoppingCarVo.getCustomerId());
            addOrderVo.setAddressId(addressId);
            addOrderVo.setTotalPrice(allPrice);
            String format = RandomNumber.getFormat();
            addOrderVo.setOrderNumber(format);
            shoppingCartMapper.addOrder(addOrderVo);
            AddOrderGoodsVo addOrderGoodsVo = new AddOrderGoodsVo();
            addOrderGoodsVo.setOrderId(addOrderVo.getOrderId());
            addOrderGoodsVo.setShoppingCarDtos(shoppingCarDtos);
            int i = shoppingCartMapper.addOrderGoods(addOrderGoodsVo);
            return i;
        }
        return 0;
    }

    public int addShoppingCart(ShoppingCarVo shoppingCarVo) {
        BigDecimal totalPrice ;
        BigDecimal num = new BigDecimal(shoppingCarVo.getNumber());
        BigDecimal price = shoppingCartMapper.getPrice(shoppingCarVo.getParameterId());
        totalPrice=num.multiply(price);
        shoppingCarVo.setPrice(price);
        shoppingCarVo.setTotalPrice(totalPrice);
        return shoppingCartMapper.addShoppingCart(shoppingCarVo);
    }


    @Transactional
    public int addOneOrder(ShoppingCarVo shoppingCarVo) {
        BigDecimal totalPrice ;
        BigDecimal num = new BigDecimal(shoppingCarVo.getNumber());
        BigDecimal price = shoppingCartMapper.getPrice(shoppingCarVo.getParameterId());
        totalPrice=num.multiply(price);
        int addressId = shoppingCartMapper.getAddressId(shoppingCarVo.getCustomerId());
        AddOrderVo addOrderVo = new AddOrderVo();
        addOrderVo.setCustomerId(shoppingCarVo.getCustomerId());
        addOrderVo.setAddressId(addressId);
        addOrderVo.setTotalPrice(totalPrice);
        String format = RandomNumber.getFormat();
        addOrderVo.setOrderNumber(format);
        shoppingCartMapper.addOrder(addOrderVo);
        shoppingCarVo.setPrice(price);
        shoppingCarVo.setTotalPrice(totalPrice);
        shoppingCarVo.setOrderId(addOrderVo.getOrderId());
        return shoppingCartMapper.addOneOrderGoods(shoppingCarVo);
    }


}
