package com.back.yxy.service.Impl;

import com.back.yxy.dto.ArticleDto;
import com.back.yxy.mapper.ArticleLabelMapper;
import com.back.yxy.mapper.BlogArticleMapper;
import com.back.yxy.mapper.BlogLabelMapper;
import com.back.yxy.pojo.ArticleLabel;
import com.back.yxy.pojo.BlogArticle;
import com.back.yxy.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    BlogArticleMapper blogArticleMapper;
    @Autowired
    ArticleLabelMapper articleLabelMapper;

    public int getCountByLabelId(ArticleLabel articleLabel) {
        return articleLabelMapper.getCountByLabelId(articleLabel);
    }

    public List<ArticleDto> initArticlePage(BlogArticle blogArticle) {
        return null;
    }
}
