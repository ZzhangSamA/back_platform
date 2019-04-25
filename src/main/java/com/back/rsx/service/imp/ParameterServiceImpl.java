package com.back.rsx.service.imp;

import com.back.rsx.mapper.GoodsParameterMapper;
import com.back.rsx.pojo.GoodsParameter;
import com.back.rsx.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParameterServiceImpl implements ParameterService {

    @Autowired
    GoodsParameterMapper goodsParameterMapper;


    public List<GoodsParameter> getParameterByGoodsId(Integer goodsId) {
        return goodsParameterMapper.getParameterByGoodsId(goodsId);
    }

    public int deleteParameterByGoodsId(Integer goodsId) {
        return goodsParameterMapper.deleteParameterByGoodsId(goodsId);
    }

    public int insertGoodsParameter(GoodsParameter goodsParameter) {
        return goodsParameterMapper.insertGoodsParameter(goodsParameter);
    }
}
