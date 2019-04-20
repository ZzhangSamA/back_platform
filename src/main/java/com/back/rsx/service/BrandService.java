package com.back.rsx.service;

import com.back.rsx.dto.BrandDto;
import com.back.rsx.pojo.Brand;
import com.back.rsx.vo.BrandVo;

import java.util.List;
import java.util.Map;

public interface BrandService {
    List<Brand> getAllBrand();
    BrandDto  getBrandPageBy(BrandVo brandVo);
    int deleteBrandById(Brand brand);
    int deleteBySel(Map map);
    int addBrand(Brand brand);
    Brand getBrandById(Brand brand);
    int updateBrandById(Brand brand);
}
