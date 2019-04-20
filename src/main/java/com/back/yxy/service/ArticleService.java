package com.back.yxy.service;

import com.back.yxy.dto.ArticleDto;
import com.back.yxy.pojo.ArticleLabel;
import com.back.yxy.pojo.BlogArticle;

import java.util.List;

public interface ArticleService {

    public int getCountByLabelId(ArticleLabel articleLabel);

    public List<ArticleDto> initArticlePage(BlogArticle blogArticle);

    public int getTotalCount();

    public Boolean updateByPrimaryKeySelective(BlogArticle blogArticle);

    public Boolean insertSelective(BlogArticle blogArticle);

    public List<ArticleLabel> getLabelIdByArticleId(ArticleLabel articleLabel);

    public BlogArticle selectByPrimaryKey(Integer articleId);

    public Boolean updateArticle(BlogArticle blogArticle);

}
