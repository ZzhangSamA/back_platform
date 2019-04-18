package com.back.yxy.service;

import com.back.yxy.pojo.BlogLabel;

import java.util.List;

public interface LabelService {

    public int getTotalSort();

    public List<BlogLabel> getAllLabel(BlogLabel blogLabel);

    public int insertSelective(BlogLabel blogLabel);

    public int updateByPrimaryKeySelective(BlogLabel blogLabel);

}
