package com.back.rsx.mapper;

import com.back.rsx.dto.GoodsInfoDto;
import com.back.rsx.pojo.GoodsInfo;
import com.back.rsx.vo.GoodsInfoVo;

import java.util.List;
import java.util.Map;

public interface GoodsInfoMapper {
    List<GoodsInfoDto> getGoodsInfoBy(GoodsInfoVo goodsInfoVo);
    int getGoodsCount(GoodsInfoVo goodsInfoVo);
    int addGoodsInfo(GoodsInfo goodsInfo);
    int deleteGoodsById(GoodsInfo goodsInfo);
    int deleteBySel(Map map);
    GoodsInfo getGoodsById(Integer goodsId);
    int updateGoodsInfo(GoodsInfo goodsInfo);
}