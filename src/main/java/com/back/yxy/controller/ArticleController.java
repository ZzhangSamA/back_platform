package com.back.yxy.controller;

import com.back.yxy.pojo.ArticleLabel;
import com.back.yxy.pojo.BlogArticle;
import com.back.yxy.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return articleService.initArticlePage(blogArticle);
    }
}
