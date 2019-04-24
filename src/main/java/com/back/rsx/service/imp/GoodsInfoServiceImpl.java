package com.back.rsx.service.imp;

import com.back.rsx.dto.GoodsInfoAndPageDto;
import com.back.rsx.dto.GoodsInfoDto;
import com.back.rsx.mapper.GoodsInfoMapper;
import com.back.rsx.pojo.GoodsInfo;
import com.back.rsx.service.GoodsInfoService;
import com.back.rsx.tools.SplitePageBean;
import com.back.rsx.vo.GoodsInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;

@Service
public class GoodsInfoServiceImpl implements GoodsInfoService {
    @Autowired(required = false)
    GoodsInfoMapper goodsInfoMapper;

    public GoodsInfoAndPageDto getGoodsInfoBy(GoodsInfoVo goodsInfoVo) {
        SplitePageBean splitePageBean = goodsInfoVo.getSplitePageBean();
        List<GoodsInfoDto> brands = goodsInfoMapper.getGoodsInfoBy(goodsInfoVo);
        int count = goodsInfoMapper.getGoodsCount(goodsInfoVo);

        splitePageBean.setDataCount(count);
        GoodsInfoAndPageDto brandDto = new GoodsInfoAndPageDto();
        brandDto.setSplitePageBean(splitePageBean);
        brandDto.setGoodsInfoDtos(brands);
        return brandDto;
    }

    public int addGoodsInfo(GoodsInfo goodsInfo) {
        return goodsInfoMapper.addGoodsInfo(goodsInfo);
    }

    public int deleteGoodsById(GoodsInfo goodsInfo) {
        return goodsInfoMapper.deleteGoodsById(goodsInfo);
    }

    public int deleteBySel(Map map) {
        return goodsInfoMapper.deleteBySel(map);
    }
}
