package com.back.yxy.controller;

import com.back.yxy.dto.ArticleDto;
import com.back.yxy.pojo.ArticleLabel;
import com.back.yxy.pojo.BlogArticle;
import com.back.yxy.service.ArticleService;
import com.back.yxy.vo.ArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    /**
     * 根据文章分类id获得该类文章总数
     * @param articleLabel——labelId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getCountByLabelId",method = RequestMethod.POST)
    public int getCountByLabelId(@RequestBody ArticleLabel articleLabel) {
        return articleService.getCountByLabelId(articleLabel);
    }

    /**
     * 初始化文章列表（含搜索分页）
     * @param blogArticle
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "initArticlePage",method = RequestMethod.POST)
    public Object initArticlePage(@RequestBody BlogArticle blogArticle) {
        if(blogArticle.getPage() != null) {
            blogArticle.getPage().setTotalCount(articleService.getTotalCount());
        }
        List<ArticleDto> articleDtoList = articleService.initArticlePage(blogArticle);
        ArticleVo articleVo = new ArticleVo();
        articleVo.setArticleDtoList(articleDtoList);
        articleVo.setPage(blogArticle.getPage());
        return articleVo;
    }

    /**
     * 根据文章ID删除文章（假删除 status=0）
     * @param blogArticle
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "updateArticleByPrimaryKeySelective",method = RequestMethod.POST)
    public String updateByPrimaryKeySelective(@RequestBody BlogArticle blogArticle) {
        return articleService.updateByPrimaryKeySelective(blogArticle).toString();
    }


    static String UPLOAD_PATH = "/static/upload/";

    /**
     * 富文本编辑器上传文本与图片
     * @param editorFile
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "upload1", method = RequestMethod.POST)
    public Map<String, Object> upload1(MultipartFile editorFile, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<String, Object>();

        // 获取文件后缀
        String fileName = editorFile.getOriginalFilename();
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));

        // 文件存放路径
        String filePath = request.getSession().getServletContext().getRealPath(UPLOAD_PATH);
        System.out.println(filePath);
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
            file.mkdirs();
        }

        // 将文件写入目标
        file = new File(filePath, UUID.randomUUID() + fileSuffix);
        try {
            editorFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 获取服务端路径
        String serverPath = String.format("%s://%s:%s%s%s", request.getScheme(), ia.getHostAddress(), request.getServerPort(), request.getContextPath(), UPLOAD_PATH);
        System.out.println(serverPath);
        // 返回给 wangEditor 的数据格式
        result.put("errno", 0);
        result.put("data", new String[]{serverPath + file.getName()});
        return result;
    }

    /**
     * 添加文章
     * @param blogArticle
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "addArticle",method = RequestMethod.POST)
    public String addArticle(@RequestBody BlogArticle blogArticle) {
        return articleService.insertSelective(blogArticle).toString();
    }

    /**
     * 根据文章Id获取该文章的所有分类Id
     * @param articleLabel——articleId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getLabelIdByArticleId",method = RequestMethod.POST)
    public Object getLabelIdByArticleId(@RequestBody ArticleLabel articleLabel) {
        return articleService.getLabelIdByArticleId(articleLabel);
    }

    /**
     * 根据文章Id获取文章
     * @param articleId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getArticleByArticleId",method = RequestMethod.POST)
    public Object getArticleByArticleId(@RequestBody Integer articleId) {
        return articleService.selectByPrimaryKey(articleId);
    }

    /**
     * 编辑修改原有文章
     * @param blogArticle
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "updateArticle",method = RequestMethod.POST)
    public String updateArticle(@RequestBody BlogArticle blogArticle) {
        return articleService.updateArticle(blogArticle).toString();
    }

    /**
     * 文章封面图的添加与修改
     */
    static String COVER_PATH = "/static/cover/";
    @RequestMapping("fileUpload")
    public void fileUpload (@RequestParam("uploadFile") CommonsMultipartFile CMFile, HttpServletResponse response,HttpServletRequest request) throws IOException {
        if(CMFile.getOriginalFilename()=="") {
            response.sendRedirect("article_list.html");
            return;
        }
        // 获取文件后缀
        String fileName = CMFile.getOriginalFilename();
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));

        // 文件存放路径
        String filePath = request.getSession().getServletContext().getRealPath(COVER_PATH);
        System.out.println(filePath);
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
            file.mkdirs();
        }

        // 将文件写入目标
        file = new File(filePath, UUID.randomUUID() + fileSuffix);
        try {
            CMFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 获取服务端路径
        String picPath = String.format("%s://%s:%s%s%s", request.getScheme(), ia.getHostAddress(), request.getServerPort(), request.getContextPath(), COVER_PATH);
        String pic = picPath+file.getName();
        System.out.println(pic);


        //更新数据库
        String articleId = request.getParameter("articleId");
        BlogArticle blogArticle = new BlogArticle();
        blogArticle.setArticleId(Integer.parseInt(articleId));
        blogArticle.setArticle_pic(pic);
        articleService.updatePicByArticleId(blogArticle);

        response.sendRedirect("article_list.html");
    }
}
