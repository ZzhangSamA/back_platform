package com.back.rsx.service.imp;

import com.back.rsx.dto.GoodsTypeDto;
import com.back.rsx.mapper.GoodsTypeMapper;
import com.back.rsx.pojo.GoodsInfo;
import com.back.rsx.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsTypeServiceImp implements GoodsTypeService {
    @Autowired(required = false)
    GoodsTypeMapper goodsTypeMapper;


    public List<GoodsTypeDto> getAllGoodsType() {
        return null;
    }

    public List<GoodsInfo> getAllGoodsTypeTest() {
        return null;
    }
}


