package com.back.rsx.mapper;

import com.itheima.mybatis.pojo.GoodsType;

public interface GoodsTypeMapper {
    int deleteByPrimaryKey(Integer goodsTypeId);

    int insert(GoodsType record);

    int insertSelective(GoodsType record);

    GoodsType selectByPrimaryKey(Integer goodsTypeId);

    int updateByPrimaryKeySelective(GoodsType record);

    int updateByPrimaryKey(GoodsType record);
}