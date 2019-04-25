package com.back.hpq.service;

import com.back.hpq.dto.ReturnDetailDto;
import com.back.hpq.vo.ReturnMessageVo;

public interface ReturnSale {
    int addReturnSale(ReturnMessageVo returnMessageVo);

    ReturnDetailDto getReturnDetail(ReturnMessageVo returnMessageVo);

    int againRefuse(ReturnMessageVo returnMessageVo);
}
