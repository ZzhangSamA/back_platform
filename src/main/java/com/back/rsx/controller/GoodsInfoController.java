package com.back.rsx.controller;

import com.back.rsx.pojo.GoodsImg;
import com.back.rsx.pojo.GoodsInfo;
import com.back.rsx.service.GoodsImgService;
import com.back.rsx.service.GoodsInfoService;
import com.back.rsx.tools.UploadFileKit;
import com.back.rsx.vo.GoodsInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

@RestController
public class GoodsInfoController {
    @Autowired
    GoodsInfoService goodsInfoService;
    @Autowired
    GoodsImgService goodsImgService;

    /**
     * 根据前端传的数据获取数据
     * @param goodsInfoVo {
     *                    Integer goodsId;
     *     createTime;创建时间
     *     goodsName; 商品名
     *     splitePageBean;分页信息
     * }
     * @return
     */
    @RequestMapping(value = "getGoodsInfoBy",method = RequestMethod.POST)
    public Object getGoodsInfoBy(@RequestBody(required = false) GoodsInfoVo goodsInfoVo){
        return goodsInfoService.getGoodsInfoBy(goodsInfoVo);
    }
    static String UPLOAD_PATH = "images";

    /**
     *
     * 富文本上传图片至images内
     * @param editorFile 上传文件
     * @param request
     * @return 图片地址
     */
    @RequestMapping(value = "uploadByRsx", method = RequestMethod.POST)
    public Map<String, Object> upload1(MultipartFile editorFile, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<String, Object>();

        // 获取文件后缀
        String fileName = editorFile.getOriginalFilename();
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));

        // 文件存放路径
        String filePath = request.getSession().getServletContext().getRealPath(UPLOAD_PATH);
        // 网络地址
        InetAddress ia=null;
        try {
            ia = ia.getLocalHost();
            System.out.println(ia.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        // 判断路径是否存在，不存在则创建文件夹
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdir();
        }

        // 将文件写入目标
        file = new File(filePath, UUID.randomUUID() + fileSuffix);
        try {
            editorFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 获取服务端路径
        String serverPath = String.format("%s://%s:%s%s/%s", request.getScheme(), ia.getHostAddress(), request.getServerPort(), request.getContextPath(), UPLOAD_PATH);
        // 返回给 wangEditor 的数据格式
        result.put("errno", 0);
        result.put("data", new String[]{serverPath + "/"+file.getName()});
        return result;
    }

    /**
     * 添加商品并返回id
     * @param goodsInfo
     * @return
     */
    @RequestMapping(value = "addGoodsInfo")
    public Object addGoodsInfo(@RequestBody(required = false)GoodsInfo goodsInfo){

        goodsInfoService.addGoodsInfo(goodsInfo);

        return goodsInfo.getGoodsId();
    }

    /**
     * 根据对象更新数据
     * @param goodsInfo
     * @return
     */
    @RequestMapping(value = "updateGoodsInfo")
    public Object updateGoodsInfo(@RequestBody(required = false)GoodsInfo goodsInfo){
        System.out.println(goodsInfo);


        return goodsInfoService.updateGoodsInfo(goodsInfo);
    }

    /**
     * 根据商品id上传图片
     * @param request
     * @param uploadFile    主图
     * @param files 副图集合
     * @return
     */
    @Transactional
    @RequestMapping(value = "public/goodsUpload",method = RequestMethod.POST)
    public Object updateBranById(HttpServletRequest request ,@RequestParam(value = "uploadFile",required = false) CommonsMultipartFile uploadFile,@RequestParam(value = "file", required = false) MultipartFile[] files){
        Map<String, Object> map = new HashMap<String, Object>();
        Integer id = Integer.parseInt(request.getParameter("goodsId"));
        map.put("goodsId",id);
        map.put("isCover",1);
        InetAddress ia=null;
        String s;
        int reSet=0 ;
        UploadFileKit fileKit = new UploadFileKit();

        try {
            ia = ia.getLocalHost();
            System.out.println(ia.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        // 获取服务端路径
        String serverPath = String.format("%s://%s:%s%s/%s", request.getScheme(), ia.getHostAddress(), request.getServerPort(), request.getContextPath(), "products/logo");
        System.out.println(serverPath);
        s = fileKit.UploadFile(uploadFile,request);
        map.put("imgName",serverPath + "/"+s);
        goodsImgService.addImgByGoodsId(map);
        map.put("isCover",0);
        String originalFilename = uploadFile.getOriginalFilename();
        for(int i=0; i<files.length; i++){
            s = fileKit.UploadFile(files[i],request);
            map.put("imgName",serverPath + "/"+s);
           reSet = goodsImgService.addImgByGoodsId(map);
        }
        return reSet;}

    /**
     * 根据商品id更新图片
     * @param request
     * @param uploadFile 上传的图片
     * @return
     */
    @RequestMapping(value = "public/goodsImgUpload",method = RequestMethod.POST)
    public Object updateImgById(HttpServletRequest request , @RequestParam(value = "uploadFile",required = false) CommonsMultipartFile uploadFile){
        GoodsImg goodsImg = new GoodsImg();
        Map<String, Object> map = new HashMap<String, Object>();
        Integer id = Integer.parseInt(request.getParameter("goodsId"));
            goodsImg.setGoodsId(id);
        Integer isCover = Integer.parseInt(request.getParameter("isCover"));
        Integer imgId = Integer.parseInt(request.getParameter("imgId"));
            goodsImg.setImgId(imgId);
        goodsImg.setIsCover(isCover!=0);
  InetAddress ia=null;
        String s;

        UploadFileKit fileKit = new UploadFileKit();

        try {
            ia = ia.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        // 获取服务端路径
        String serverPath = String.format("%s://%s:%s%s/%s", request.getScheme(), ia.getHostAddress(), request.getServerPort(), request.getContextPath(), "products/logo");
        s = fileKit.UploadFile(uploadFile,request);
        s = serverPath + "/"+s;
        goodsImg.setGoodsImage(s);
        if (imgId!=0){
            goodsImgService.updateImgBy(goodsImg);
        }else {
            goodsImgService.addImgByGoodsIdGetImgId(goodsImg);
        }


        System.out.println(goodsImg);
        return goodsImg;


    }

    /**
     * 根据id删除商品
     * @param goodsInfo
     * @return
     */
    @RequestMapping(value = "deleteGoodsById",method = RequestMethod.POST)
    public Object deleteGoodsById(@RequestBody(required = false) GoodsInfo goodsInfo){
        return goodsInfoService.deleteGoodsById(goodsInfo);
    }

    @RequestMapping(value = "deleteGoodsBySel")
    public Object deleteBySel(@RequestParam(value = "ids[]") List<Integer> ids){
        Map<String, List> map = new HashMap<String, List>();
        map.put("ids",ids);
        return goodsInfoService.deleteBySel(map);
    }

    /**
     * 根据商品id获取商品信息
     * @param goodsInfo
     * @return
     */
    @RequestMapping(value = "getGoodsById",method = RequestMethod.POST)
    public Object getGoodsById(@RequestBody(required = false) GoodsInfo goodsInfo){

        return goodsInfoService.getGoodsById(goodsInfo.getGoodsId());
    }

    /**
     * 根据商品id获取图片
     * @param goodsId
     * @return
     */
    @RequestMapping(value = "getImageById",method = RequestMethod.POST)
    public Object getImageById(@RequestParam(value = "goodsId")int goodsId){

        return goodsImgService.getImageById(goodsId);
    }
    @RequestMapping(value = "setShowPrice",method = RequestMethod.POST)
    public Object setShowPrice(@RequestBody(required = false)GoodsInfo goodsInfo){

        return goodsInfoService.setShowPrice(goodsInfo);
    }

    }
