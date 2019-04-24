package com.back.rsx.controller;

import com.back.rsx.pojo.GoodsParameter;
import com.back.rsx.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParameterController {

    @Autowired
    ParameterService parameterServiceService;

    @ResponseBody
    @RequestMapping(value = "getParameterByGoodsId",method = RequestMethod.POST)
    public Object getParameterByGoodsId(@RequestBody Integer goodsId) {
        return parameterServiceService.getParameterByGoodsId(goodsId);
    }

    @ResponseBody
    @RequestMapping(value = "deleteParameterByGoodsId",method = RequestMethod.POST)
    public int deleteParameterByGoodsId(@RequestBody Integer goodsId) {
        return parameterServiceService.deleteParameterByGoodsId(goodsId);
    }

    @ResponseBody
    @RequestMapping(value = "insertGoodsParameter",method = RequestMethod.POST)
    public int insertGoodsParameter(@RequestBody GoodsParameter goodsParameter) {
        return parameterServiceService.insertGoodsParameter(goodsParameter);
    }

}
