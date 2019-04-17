package com.back.rsx.mapper;



import com.back.rsx.dto.GoodsTypeDto;
import com.back.rsx.pojo.GoodsInfo;

import java.util.List;

public interface GoodsTypeMapper {
    List<GoodsTypeDto>  getAllGoodsType();
    List<GoodsInfo> getAllGoodsTypeTest();

}