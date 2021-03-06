package com.back.rsx.mapper;

import com.back.rsx.pojo.GoodsParameter;

import java.util.List;

public interface GoodsParameterMapper {

    public List<GoodsParameter> getParameterByGoodsId(Integer goodsId);

    public int deleteParameterByGoodsId(Integer goodsId);

    public int insertGoodsParameter(GoodsParameter goodsParameter);
}