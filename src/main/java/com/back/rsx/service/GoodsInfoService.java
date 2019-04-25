package com.back.rsx.service;

import com.back.rsx.dto.GoodsInfoAndPageDto;
import com.back.rsx.dto.GoodsInfoDto;
import com.back.rsx.pojo.GoodsInfo;
import com.back.rsx.vo.GoodsInfoVo;

import java.util.List;
import java.util.Map;

public interface GoodsInfoService {
    GoodsInfoAndPageDto getGoodsInfoBy(GoodsInfoVo goodsInfoVo);
    int addGoodsInfo(GoodsInfo goodsInfo);
    int deleteGoodsById(GoodsInfo goodsInfo);
    int deleteBySel(Map map);
}
