package com.back.rsx.controller;

import com.back.rsx.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GoodsTypeController {

    @Autowired
    GoodsTypeService goodsTypeService;

    /**
     * 获取所有的商品类别
     * @return
     */
    @RequestMapping(value = "getAllGoodsType",method = RequestMethod.POST)
    public Object getAllGoodsType(){
        return goodsTypeService.getAllGoodsType();
    }

    /**
     * 查询所有商品类别未分类
     * @return
     */
    @RequestMapping(value = "getAllGoodsTypeByStatus",method = RequestMethod.POST)
    public Object getAllGoodsTypeByStatus(){
        return goodsTypeService.getAllGoodsTypeTest();
    }

}
