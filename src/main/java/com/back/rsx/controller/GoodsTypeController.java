package com.back.rsx.controller;

import com.back.rsx.pojo.GoodsType;
import com.back.rsx.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    @RequestMapping(value = "getAllGoodsTypeBy",method = RequestMethod.POST)
    public Object getAllGoodsTypeByStatus(@RequestBody(required = false) GoodsType goodsType){
        return goodsTypeService.getAllGoodsTypeTest(goodsType);
    }

    @RequestMapping(value = "updateGoodsTypeById",method = RequestMethod.POST)
    public Object updateGoodsTypeByid(@RequestBody(required = false) GoodsType goodsType){
        return goodsTypeService.updateGoodsTypeById(goodsType);
    }
    @RequestMapping(value = "deleteGoodsTypeById",method = RequestMethod.POST)
    public Object deleteGoodsTypeById(@RequestBody(required = false) GoodsType goodsType){
        return goodsTypeService.deleteGoodsTypeById(goodsType);
    }
    @RequestMapping(value = "addGoodsType",method = RequestMethod.POST)
    public Object addGoodsType(@RequestBody(required = false) GoodsType goodsType){
        return goodsTypeService.addGoodsType(goodsType);
    }

}
