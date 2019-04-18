package com.back.yxy.service;

import com.back.yxy.dto.ArticleDto;
import com.back.yxy.pojo.ArticleLabel;
import com.back.yxy.pojo.BlogArticle;

import java.util.List;

public interface ArticleService {

    public int getCountByLabelId(ArticleLabel articleLabel);

    public List<ArticleDto> initArticlePage(BlogArticle blogArticle);

}
