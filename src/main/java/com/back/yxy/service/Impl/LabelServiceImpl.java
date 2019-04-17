package com.back.yxy.service.Impl;

import com.back.yxy.mapper.BlogLabelMapper;
import com.back.yxy.pojo.BlogLabel;
import com.back.yxy.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelServiceImpl implements LabelService {

    @Autowired(required = false)
    BlogLabelMapper blogLabelMapper;

    public int getTotalSort() {
        return blogLabelMapper.getTotalSort();
    }

    public List<BlogLabel> getAllLabel() {
        return blogLabelMapper.getAllLabel();
    }

    public int insertSelective(BlogLabel blogLabel) {
        return blogLabelMapper.insertSelective(blogLabel);
    }
}
