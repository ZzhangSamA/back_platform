package com.back.yxy.dto;

import com.back.yxy.pojo.BlogLabel;
import com.back.yxy.pojo.Page;

import java.util.List;

public class BlogLabelDto {
    private List<BlogLabel> blogLabelList;
    private Page page;

    public List<BlogLabel> getBlogLabelList() {
        return blogLabelList;
    }

    public void setBlogLabelList(List<BlogLabel> blogLabelList) {
        this.blogLabelList = blogLabelList;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "BlogLabelDto{" +
                "blogLabelList=" + blogLabelList +
                ", page=" + page +
                '}';
    }
}
