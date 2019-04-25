package com.back.rsx.controller;

import com.back.rsx.pojo.GoodsParameter;
import com.back.rsx.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParameterController {

    @Autowired
    ParameterService parameterServiceService;

    /**
     * 根据goodsId获取所有参数以显示在参数编辑页面
     * @param goodsId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getParameterByGoodsId",method = RequestMethod.POST)
    public Object getParameterByGoodsId(@RequestBody Integer goodsId) {
        return parameterServiceService.getParameterByGoodsId(goodsId);
    }

    /**
     * 根据goodsId删除所有这个货物的字段
     * @param goodsId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "deleteParameterByGoodsId",method = RequestMethod.POST)
    public int deleteParameterByGoodsId(@RequestBody Integer goodsId) {
        return parameterServiceService.deleteParameterByGoodsId(goodsId);
    }

    /**
     * 根据goodsId添加这个货物的所有字段
     * @param goodsParameter
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "insertGoodsParameter",method = RequestMethod.POST)
    public int insertGoodsParameter(@RequestBody GoodsParameter goodsParameter) {
        return parameterServiceService.insertGoodsParameter(goodsParameter);
    }

}
