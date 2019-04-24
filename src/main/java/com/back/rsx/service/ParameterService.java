package com.back.rsx.service;

import com.back.rsx.pojo.GoodsParameter;

import java.util.List;

public interface ParameterService {

    public List<GoodsParameter> getParameterByGoodsId(Integer goodsId);

    public int deleteParameterByGoodsId(Integer goodsId);

    public int insertGoodsParameter(GoodsParameter goodsParameter);

}
