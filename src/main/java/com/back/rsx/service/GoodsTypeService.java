package com.back.rsx.service;

import com.back.rsx.dto.GoodsTypeDto;
import com.back.rsx.pojo.GoodsInfo;

import java.util.List;

public interface GoodsTypeService {
    List<GoodsTypeDto> getAllGoodsType();
    List<GoodsInfo> getAllGoodsTypeTest();
}
