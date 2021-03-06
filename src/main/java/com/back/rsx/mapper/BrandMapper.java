package com.back.rsx.mapper;

import com.back.rsx.pojo.Brand;
import com.back.rsx.vo.BrandVo;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    List<Brand> getAllBrand();
    List<Brand> getBrandPageBy(BrandVo brandVo);
    int getCount(BrandVo brandVo);
    int deleteBrandById(Brand brand);
    int deleteBySel(Map map);
    int addBrand(Brand brand);
    Brand getBrandById(Brand brand);
    int updateBrandById(Brand brand);
}