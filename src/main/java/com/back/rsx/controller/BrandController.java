package com.back.rsx.controller;


import com.back.rsx.pojo.Brand;
import com.back.rsx.service.BrandService;
import com.back.rsx.tools.UploadFileKit;
import com.back.rsx.vo.BrandVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class BrandController {
    @Autowired
    BrandService brandService;

    /**
     *          获取所有的品牌对象
     * @return  List<Brand>
     */
    @RequestMapping(value = "getAllBrand",method = RequestMethod.POST)
    public Object getAllBrand(){
        return brandService.getAllBrand();
    }

    /**
     * 根据提供注入的参数来返回带分页信息和Brand对象集合的对象
     * @param brandVo   {
     *                 createTime:插入品牌的时间,如果为空则不查找
     *                 brandName:品牌名称
     *                 splitePageBean:分页信息{
     *                         pageCount:总页数
     *                         currentPage: 当前第几页默认第一页
     *                         pageSize = 10:一页多少行 默认10行
     *                         start:从第几行开始查找
     *                         dataCount:总共有多少行数据
     *                 }}
     *
     * @return
     */
    @RequestMapping(value = "getBrandPageBy",method = RequestMethod.POST)
    public Object getBrandPageBy(@RequestBody(required = false) BrandVo brandVo){
        return brandService.getBrandPageBy(brandVo);
    }

    /**
     * 根据brandId来删除brand表中的数据
     * @param brand {
     *              brandId:自增主键
     * }
     * @return 删除数据数
     */
    @RequestMapping(value = "deleteBrandById",method = RequestMethod.POST)
    public Object deleteBrandById(@RequestBody(required = false) Brand brand){
        return brandService.deleteBrandById(brand);
    }

    /**
     * 根据BrandId数组来删除
     * @param ids Brand的Id数组
     * @return 删除行数
     */
    @RequestMapping(value = "deleteBrandBySel",method = RequestMethod.POST)
    public Object deleteBySel(@RequestParam(value = "ids[]") List<Integer> ids){
        Map<String, List> map = new HashMap<String, List>();
        map.put("ids",ids);
        return brandService.deleteBySel(map);
    }

    /**
     * 根据id获取brand
     * @param brand {
     *              brandId 主键id
     *              }
     * @return brand对象 用于修改信息回显
     */
    @RequestMapping(value = "getBrandById",method = RequestMethod.POST)
    public Object getBrandById(@RequestBody(required = false) Brand brand){
        return brandService.getBrandById(brand);
    }

    /**
     * 添加平拍
     * @param request 用于获取信息
     * @param uploadFile 图片上传,返回图片名
     * @return 插入数据数
     */
    @RequestMapping(value = "public/brandUpload",method = RequestMethod.POST)
    public Object addBrandBySubmit(HttpServletRequest request ,@RequestParam(value = "brandIcon",required = false) CommonsMultipartFile uploadFile){

        Brand brand = new Brand();
        brand.setSupplierId(Integer.parseInt( request.getParameter("supplierId")));
        brand.setBrandName(request.getParameter("brandName"));
        brand.setBrandNumber(request.getParameter("brandNumber"));
        UploadFileKit fileKit = new UploadFileKit();
        String fileName= fileKit.UploadFile(uploadFile,request);
        InetAddress ia=null;
        try {
            ia = ia.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        // 获取服务端路径
        String serverPath = String.format("%s://%s:%s%s/%s", request.getScheme(), ia.getHostAddress(), request.getServerPort(), request.getContextPath(), "products/logo");
        brand.setBrandIcon(serverPath + "/"+fileName);
//
        return brandService.addBrand(brand);


    }

    /**
     * 更新信息
     * @param request 获取信息
     * @param uploadFile    上传图片 存储图片名
     * @return  前端判断是否为一
     */
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
            InetAddress ia=null;
            try {
                ia = ia.getLocalHost();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            // 获取服务端路径
            String serverPath = String.format("%s://%s:%s%s/%s", request.getScheme(), ia.getHostAddress(), request.getServerPort(), request.getContextPath(), "products/logo");

             icon = serverPath + "/"+icon;

        }
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setSupplierId(Integer.parseInt(supplierId));
        brand.setBrandId(Integer.parseInt(brandId));
        brand.setBrandNumber(brandNumber);
        brand.setBrandIcon(icon);
        return brandService.updateBrandById(brand);


    }


}
