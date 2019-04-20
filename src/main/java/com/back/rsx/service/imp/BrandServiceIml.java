package com.back.rsx.service.imp;

import com.back.rsx.dto.BrandDto;
import com.back.rsx.mapper.BrandMapper;
import com.back.rsx.pojo.Brand;
import com.back.rsx.service.BrandService;
import com.back.rsx.tools.SplitePageBean;
import com.back.rsx.vo.BrandVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BrandServiceIml implements BrandService {
    @Autowired(required = false)
    BrandMapper brandMapper;
    public List<Brand> getAllBrand() {
        return brandMapper.getAllBrand();
    }

    public BrandDto getBrandPageBy(BrandVo brandVo) {
        SplitePageBean splitePageBean = brandVo.getSplitePageBean();
        List<Brand> brands = brandMapper.getBrandPageBy(brandVo);
        int count = brandMapper.getCount(brandVo);

        splitePageBean.setDataCount(count);
        BrandDto brandDto = new BrandDto();
        brandDto.setSplitePageBean(splitePageBean);
        brandDto.setBrands(brands);
        return brandDto;
    }

    public int deleteBrandById(Brand brand) {

        return brandMapper.deleteBrandById(brand);
    }

    public int deleteBySel(Map map) {
        return brandMapper.deleteBySel(map);
    }

    public int addBrand(Brand brand) {
        int i = brandMapper.addBrand(brand);
        System.out.println(i);
        return i;
    }

    public Brand getBrandById(Brand brand) {
        return brandMapper.getBrandById(brand);
    }

    public int updateBrandById(Brand brand) {
        return brandMapper.updateBrandById(brand);
    }
}
