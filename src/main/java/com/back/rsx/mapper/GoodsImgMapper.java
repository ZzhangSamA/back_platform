package com.back.rsx.mapper;

import com.back.rsx.pojo.GoodsImg;

import java.util.List;
import java.util.Map;

public interface GoodsImgMapper {
    int addImgByGoodsId(Map map);
    List<GoodsImg> getImageById(int goodsId);
    int updateImgBy(GoodsImg goodsImg);
    int addImgByGoodsIdGetImgId(GoodsImg goodsImg);
}