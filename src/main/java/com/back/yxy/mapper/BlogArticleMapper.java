package com.back.yxy.mapper;

import com.back.yxy.pojo.BlogArticle;

public interface BlogArticleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_article
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer articleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_article
     *
     * @mbggenerated
     */
    int insert(BlogArticle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_article
     *
     * @mbggenerated
     */
    int insertSelective(BlogArticle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_article
     *
     * @mbggenerated
     */
    BlogArticle selectByPrimaryKey(Integer articleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_article
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(BlogArticle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_article
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(BlogArticle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_article
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(BlogArticle record);
}