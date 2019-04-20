package com.back.yxy.dto;

public class ArticleDto {
    private int article_id;
    private String article_title;
    private String create_time;
    private String update_time;
    private String user_name;
    private String label_name;

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getLabel_name() {
        return label_name;
    }

    public void setLabel_name(String label_name) {
        this.label_name = label_name;
    }

    @Override
    public String toString() {
        return "ArticleDto{" +
                "article_id=" + article_id +
                ", article_title='" + article_title + '\'' +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                ", user_name='" + user_name + '\'' +
                ", label_name='" + label_name + '\'' +
                '}';
    }
}
