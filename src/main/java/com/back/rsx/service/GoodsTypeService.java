package com.back.rsx.service;

import com.back.rsx.dto.GoodsTypeDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface GoodsTypeService {
    List<GoodsTypeDto> getAllGoodsType();
}
