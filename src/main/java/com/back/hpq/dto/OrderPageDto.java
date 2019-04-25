package com.back.hpq.dto;

import com.back.tools.SplitPage;

import java.util.List;

public class OrderPageDto {
    private SplitPage splitPage;
    private List<TOrderDto> OrderDto;

    public List<TOrderDto> getOrderDto() {
        return OrderDto;
    }

    public void setOrderDto(List<TOrderDto> orderDto) {
        OrderDto = orderDto;
    }

    public SplitPage getSplitPage() {
        return splitPage;
    }

    public void setSplitPage(SplitPage splitPage) {
        this.splitPage = splitPage;

    }
}
