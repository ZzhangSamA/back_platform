package com.back.rsx.service.imp;

import com.back.rsx.dto.GoodsTypeDto;
import com.back.rsx.dto.GoodsTypeEcho;
import com.back.rsx.mapper.GoodsTypeMapper;
import com.back.rsx.pojo.GoodsInfo;
import com.back.rsx.pojo.GoodsType;
import com.back.rsx.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodsTypeServiceImp implements GoodsTypeService {
    @Autowired(required = false)
    GoodsTypeMapper goodsTypeMapper;


    public List<GoodsTypeDto> getAllGoodsType() {
        return goodsTypeMapper.getAllGoodsType();
    }

    public List<GoodsTypeEcho> getAllGoodsTypeTest(GoodsType goodsType) {
        return goodsTypeMapper.getAllGoodsTypeTest(goodsType);
    }

    public int updateGoodsTypeById(GoodsType goodsType) {
        return goodsTypeMapper.updateGoodsTypeById(goodsType);
    }

    public int deleteGoodsTypeById(GoodsType goodsType) {
        return goodsTypeMapper.deleteGoodsTypeById(goodsType);
    }

    public int addGoodsType(GoodsType goodsType) {
        return goodsTypeMapper.addGoodsType(goodsType);
    }


}


