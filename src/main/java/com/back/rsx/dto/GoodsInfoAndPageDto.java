package com.back.rsx.dto;

import com.back.rsx.tools.SplitePageBean;

import java.util.List;

public class GoodsInfoAndPageDto {
    List<GoodsInfoDto> goodsInfoDtos;
    SplitePageBean splitePageBean;

    public List<GoodsInfoDto> getGoodsInfoDtos() {
        return goodsInfoDtos;
    }

    public void setGoodsInfoDtos(List<GoodsInfoDto> goodsInfoDtos) {
        this.goodsInfoDtos = goodsInfoDtos;
    }

    public SplitePageBean getSplitePageBean() {
        return splitePageBean;
    }

    public void setSplitePageBean(SplitePageBean splitePageBean) {
        this.splitePageBean = splitePageBean;
    }

    @Override
    public String toString() {
        return "GoodsInfoAndPageDto{" +
                "goodsInfoDtos=" + goodsInfoDtos +
                ", splitePageBean=" + splitePageBean +
                '}';
    }
}
