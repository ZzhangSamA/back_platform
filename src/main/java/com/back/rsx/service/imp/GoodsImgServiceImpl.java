package com.back.rsx.service.imp;

import com.back.rsx.mapper.GoodsImgMapper;
import com.back.rsx.service.GoodsImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class GoodsImgServiceImpl implements GoodsImgService {
    @Autowired(required = false)
    GoodsImgMapper goodsImgMapper;
    public int addImgByGoodsId(Map map) {
        return goodsImgMapper.addImgByGoodsId(map);
    }
}
