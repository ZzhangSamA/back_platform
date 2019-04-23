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
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
        if(blogArticle.getCreateTime() == null) {
            blogArticle.setCreateTime("%%");
        }else {
            blogArticle.setCreateTime("%" + blogArticle.getCreateTime() + "%");
        }
        if(blogArticle.getArticleTitle() == null) {
            blogArticle.setArticleTitle("%%");
        }else {
            blogArticle.setArticleTitle("%" + blogArticle.getArticleTitle() + "%");
        }
        if(blogArticle.getLabelName() == null) {
            blogArticle.setLabelName("%%");
        }

        List<ArticleDto> articleDtos = blogArticleMapper.initArticlePage(blogArticle);

        List<ArticleDto> articleList = new ArrayList<ArticleDto>();
        AAA:for(ArticleDto i : articleDtos) {
            for(ArticleDto j : articleList) {
                if(i.getArticle_id() == j.getArticle_id()) {
                    j.setLabel_name(j.getLabel_name()+","+i.getLabel_name());
                    continue AAA;
                }
            }
            articleList.add(i);
        }

        return articleList;
    }

    public int getTotalCount() {
        return blogArticleMapper.getTotalCount();
    }

    @Transactional
    public Boolean updateByPrimaryKeySelective(BlogArticle blogArticle) {
        int i = blogArticleMapper.updateByPrimaryKeySelective(blogArticle);
        if(!(i>0)) {
            return false;
        }
        i = articleLabelMapper.deleteArticleLabel(blogArticle);
        if(!(i>0)) {
            return false;
        }
        return true;
    }

    @Transactional
    public Boolean insertSelective(BlogArticle blogArticle) {
        int i = blogArticleMapper.insertSelective(blogArticle);
        if(!(i>0)) {
            return false;
        }
        int articleId = blogArticleMapper.getIdByArticleTitle(blogArticle);
        ArticleLabel articleLabel = new ArticleLabel();
        articleLabel.setArticleId(articleId);
        for(String id : blogArticle.getIds()) {
            articleLabel.setLabelId(Integer.parseInt(id));
            i = articleLabelMapper.insertSelective(articleLabel);
            if(!(i>0)) {
                return false;
            }
        }
        return true;
    }

    public List<ArticleLabel> getLabelIdByArticleId(ArticleLabel articleLabel) {
        return articleLabelMapper.getLabelIdByArticleId(articleLabel);
    }

    public BlogArticle selectByPrimaryKey(Integer articleId) {
        return blogArticleMapper.selectByPrimaryKey(articleId);
    }

    @Transactional
    public Boolean updateArticle(BlogArticle blogArticle) {
        blogArticle.setUpdateTime(new Date());
        int i = blogArticleMapper.updateByPrimaryKeySelective(blogArticle);
        if(!(i>0)) {
            return false;
        }
//        int articleId = blogArticleMapper.getIdByArticleTitle(blogArticle);
        //先删除这篇文章所有的label
        i = articleLabelMapper.deleteArticleLabel(blogArticle);
        if(!(i>0)) {
            return false;
        }

        //再添加新的label
        ArticleLabel articleLabel = new ArticleLabel();
        articleLabel.setArticleId(blogArticle.getArticleId());
        for(String id : blogArticle.getIds()) {
            articleLabel.setLabelId(Integer.parseInt(id));
            i = articleLabelMapper.insertSelective(articleLabel);
            if(!(i>0)) {
                return false;
            }
        }
        return true;
    }

    public void updatePicByArticleId(BlogArticle blogArticle) {
        blogArticleMapper.updateByPrimaryKeySelective(blogArticle);
    }
}
