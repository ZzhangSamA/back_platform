package com.back.yxy.controller;

import com.back.yxy.dto.ArticleDto;
import com.back.yxy.pojo.ArticleLabel;
import com.back.yxy.pojo.BlogArticle;
import com.back.yxy.service.ArticleService;
import com.back.yxy.vo.ArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @ResponseBody
    @RequestMapping(value = "getCountByLabelId",method = RequestMethod.POST)
    public int getCountByLabelId(@RequestBody ArticleLabel articleLabel) {
        return articleService.getCountByLabelId(articleLabel);
    }

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

    @ResponseBody
    @RequestMapping(value = "updateArticleByPrimaryKeySelective",method = RequestMethod.POST)
    public String updateByPrimaryKeySelective(@RequestBody BlogArticle blogArticle) {
        return articleService.updateByPrimaryKeySelective(blogArticle).toString();
    }

    static String UPLOAD_PATH = "/static/upload/";
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

    @ResponseBody
    @RequestMapping(value = "addArticle",method = RequestMethod.POST)
    public String addArticle(@RequestBody BlogArticle blogArticle) {
        return articleService.insertSelective(blogArticle).toString();
    }

    @ResponseBody
    @RequestMapping(value = "getLabelIdByArticleId",method = RequestMethod.POST)
    public Object getLabelIdByArticleId(@RequestBody ArticleLabel articleLabel) {
        return articleService.getLabelIdByArticleId(articleLabel);
    }
    @ResponseBody
    @RequestMapping(value = "getArticleByArticleId",method = RequestMethod.POST)
    public Object getArticleByArticleId(@RequestBody Integer articleId) {
        return articleService.selectByPrimaryKey(articleId);
    }

    @ResponseBody
    @RequestMapping(value = "updateArticle",method = RequestMethod.POST)
    public String updateArticle(@RequestBody BlogArticle blogArticle) {
        return articleService.updateArticle(blogArticle).toString();
    }
}
