package com.back.rsx.controller;

import com.back.rsx.pojo.GoodsType;
import com.back.rsx.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

    /**
     * 根据goodsTypeId更新goodsType
     * @param goodsType {
     *        goodsTypeId; 主键
     *
     *        goodsTypeName; 类型名
     *
     *      parentId; 父类id
     *
     *      createTime; 创建时间
     *
     *      updateTime;更新时间
     *
     *      Boolean status;  是否删除
     * }
     * @return
     */
    @RequestMapping(value = "updateGoodsTypeById",method = RequestMethod.POST)
    public Object updateGoodsTypeByid(@RequestBody(required = false) GoodsType goodsType){
        return goodsTypeService.updateGoodsTypeById(goodsType);
    }

    /**
     * 根据id删除商品类型
     * @param goodsType
     * @return
     */
    @RequestMapping(value = "deleteGoodsTypeById",method = RequestMethod.POST)
    public Object deleteGoodsTypeById(@RequestBody(required = false) GoodsType goodsType){
        return goodsTypeService.deleteGoodsTypeById(goodsType);
    }

    /**
     * 添加商品类型
     * @param goodsType
     * @return
     */
    @RequestMapping(value = "addGoodsType",method = RequestMethod.POST)
    public Object addGoodsType(@RequestBody(required = false) GoodsType goodsType){
        return goodsTypeService.addGoodsType(goodsType);

    }

    /**
     * 获取父类id
     * @param goodsTypeId
     * @return
     */
    @RequestMapping(value = "getParentId",method = RequestMethod.POST)
    public Object getParentId(@RequestParam(value = "goodsTypeId") int goodsTypeId){
        return goodsTypeService.getParentId(goodsTypeId);

    }

}
