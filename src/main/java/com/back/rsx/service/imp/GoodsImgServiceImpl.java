package com.back.rsx.service.imp;

import com.back.rsx.mapper.GoodsImgMapper;
import com.back.rsx.pojo.GoodsImg;
import com.back.rsx.service.GoodsImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class GoodsImgServiceImpl implements GoodsImgService {
    @Autowired(required = false)
    GoodsImgMapper goodsImgMapper;
    public int addImgByGoodsId(Map map) {
        return goodsImgMapper.addImgByGoodsId(map);
    }

    public List<GoodsImg> getImageById(int goodsId) {
        return goodsImgMapper.getImageById(goodsId);
    }

    public int updateImgBy(GoodsImg goodsImg) {
        return goodsImgMapper.updateImgBy(goodsImg);
    }

    public int addImgByGoodsIdGetImgId(GoodsImg goodsImg) {
        return goodsImgMapper.addImgByGoodsIdGetImgId(goodsImg);
    }
}
