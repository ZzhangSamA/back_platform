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
    @RequestMapping(value = "getAllGoodsType",method = RequestMethod.POST)
    public Object getAllGoodsType(){
        return goodsTypeService.getAllGoodsType();
    }

}
