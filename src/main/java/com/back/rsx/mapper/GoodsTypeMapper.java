package com.back.rsx.mapper;



import com.back.rsx.dto.GoodsTypeDto;
import com.back.rsx.dto.GoodsTypeEcho;
import com.back.rsx.pojo.GoodsInfo;
import com.back.rsx.pojo.GoodsType;

import java.util.List;

public interface GoodsTypeMapper {
    List<GoodsTypeDto>  getAllGoodsType();
    List<GoodsTypeEcho> getAllGoodsTypeTest(GoodsType goodsType);
    int updateGoodsTypeById(GoodsType goodsType);
    int deleteGoodsTypeById(GoodsType goodsType);
    int addGoodsType(GoodsType goodsType);
    int getParentId(int goodsTypeId);

}