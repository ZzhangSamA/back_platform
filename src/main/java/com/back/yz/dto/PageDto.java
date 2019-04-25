package com.back.yz.dto;

import com.back.yxy.pojo.Page;

import java.util.List;

public class PageDto {
    private List<PayInfoDto> payInfoDtoList;
    private Page page;

    public List<PayInfoDto> getPayInfoDtoList() {
        return payInfoDtoList;
    }

    public void setPayInfoDtoList(List<PayInfoDto> payInfoDtoList) {
        this.payInfoDtoList = payInfoDtoList;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "PageDto{" +
                "payInfoDtoList=" + payInfoDtoList +
                ", page=" + page +
                '}';
    }
}
