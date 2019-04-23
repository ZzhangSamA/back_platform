package com.back.rsx.controller;


import com.back.rsx.pojo.Brand;
import com.back.rsx.service.BrandService;
import com.back.rsx.tools.UploadFileKit;
import com.back.rsx.vo.BrandVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class BrandController {
    @Autowired
    BrandService brandService;
    @RequestMapping(value = "getAllBrand",method = RequestMethod.POST)
    public Object getAllBrand(){
        return brandService.getAllBrand();
    }

    @RequestMapping(value = "getBrandPageBy",method = RequestMethod.POST)
    public Object getBrandPageBy(@RequestBody(required = false) BrandVo brandVo){
        return brandService.getBrandPageBy(brandVo);
    }
    @RequestMapping(value = "deleteBrandById",method = RequestMethod.POST)
    public Object deleteBrandById(@RequestBody(required = false) Brand brand){

        return brandService.deleteBrandById(brand);
    }

    @RequestMapping(value = "deleteBrandBySel",method = RequestMethod.POST)
    public Object deleteBySel(@RequestParam(value = "ids[]") List<Integer> ids){
        System.out.println("进入方法");
        System.out.println(ids);
        Map<String, List> map = new HashMap<String, List>();
        map.put("ids",ids);
        return brandService.deleteBySel(map);
    }
    @RequestMapping(value = "getBrandById",method = RequestMethod.POST)
    public Object getBrandById(@RequestBody(required = false) Brand brand){
        return brandService.getBrandById(brand);
    }

    @RequestMapping(value = "public/brandUpload",method = RequestMethod.POST)
    public Object addBrandBySubmit(HttpServletRequest request ,@RequestParam(value = "brandIcon",required = false) CommonsMultipartFile uploadFile){

        Brand brand = new Brand();
        brand.setSupplierId(Integer.parseInt( request.getParameter("supplierId")));
        brand.setBrandName(request.getParameter("brandName"));
        brand.setBrandNumber(request.getParameter("brandNumber"));
        UploadFileKit fileKit = new UploadFileKit();
        String fileName= fileKit.UploadFile(uploadFile,request);
        brand.setBrandIcon(fileName);
        System.out.println(brand);
//
        return brandService.addBrand(brand);


    }
    @RequestMapping(value = "public/updateBrandById",method = RequestMethod.POST)
    public Object updateBranById(HttpServletRequest request ,@RequestParam(value = "brandIcon",required = false) CommonsMultipartFile uploadFile){
        String icon = request.getParameter("oldBrandIcon");
        String brandId = request.getParameter("brandId");
        String brandName = request.getParameter("brandName");
        String brandNumber = request.getParameter("brandNumber");
        String supplierId = request.getParameter("supplierId");
        UploadFileKit fileKit = new UploadFileKit();
        if (uploadFile.getSize()!=0){
            icon= fileKit.UploadFile(uploadFile,request);
        }
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setSupplierId(Integer.parseInt(supplierId));
        brand.setBrandId(Integer.parseInt(brandId));
        brand.setBrandNumber(brandNumber);
        brand.setBrandIcon(icon);
        System.out.println(brand);
        return brandService.updateBrandById(brand);


    }


}
