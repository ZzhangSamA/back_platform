package com.back.rsx.service;

import com.back.rsx.dto.GoodsTypeDto;
import com.back.rsx.dto.GoodsTypeEcho;
import com.back.rsx.pojo.GoodsInfo;
import com.back.rsx.pojo.GoodsType;

import java.util.List;

public interface GoodsTypeService {
    List<GoodsTypeDto> getAllGoodsType();
    List<GoodsTypeEcho> getAllGoodsTypeTest(GoodsType goodsType);
    int updateGoodsTypeById(GoodsType goodsType);
    int deleteGoodsTypeById(GoodsType goodsType);
    int addGoodsType(GoodsType goodsType);

}
