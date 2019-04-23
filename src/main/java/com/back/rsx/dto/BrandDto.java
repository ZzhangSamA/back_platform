package com.back.rsx.dto;

import com.back.rsx.pojo.Brand;
import com.back.rsx.tools.SplitePageBean;

import java.util.List;

public class BrandDto {
   private List<Brand> brands;
   private SplitePageBean splitePageBean;

    public List<Brand> getBrands() {
        return brands;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }

    public SplitePageBean getSplitePageBean() {
        return splitePageBean;
    }

    public void setSplitePageBean(SplitePageBean splitePageBean) {
        this.splitePageBean = splitePageBean;
    }

    @Override
    public String toString() {
        return "BrandDto{" +
                "brands=" + brands +
                ", splitePageBean=" + splitePageBean +
                '}';
    }
}
