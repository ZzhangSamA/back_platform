package com.back.rsx.controller;

import com.back.rsx.service.GoodsTypeService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GoodsTypeController {

    @Autowired
    GoodsTypeService goodsTypeService;


}
