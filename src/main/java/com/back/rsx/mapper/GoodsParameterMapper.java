package com.back.rsx.mapper;

import com.back.rsx.pojo.GoodsParameter;

public interface GoodsParameterMapper {
    int deleteByPrimaryKey(Integer parameterId);

    int insert(GoodsParameter record);

    int insertSelective(GoodsParameter record);

    GoodsParameter selectByPrimaryKey(Integer parameterId);

    int updateByPrimaryKeySelective(GoodsParameter record);

    int updateByPrimaryKey(GoodsParameter record);
}