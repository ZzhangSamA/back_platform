package com.back.yxy.service.Impl;

import com.back.yxy.mapper.BlogLabelMapper;
import com.back.yxy.pojo.BlogLabel;
import com.back.yxy.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    BlogLabelMapper blogLabelMapper;

    public int getTotalSort() {
        return blogLabelMapper.getTotalSort();
    }

    public List<BlogLabel> getAllLabel(BlogLabel blogLabel) {
        if(blogLabel == null) {
            blogLabel.setCreateTime("%%");
            blogLabel.setLabelDesc("%%");
            blogLabel.setLabelName("%%");
        }else {
            blogLabel.setCreateTime("%" + blogLabel.getCreateTime() + "%");
            blogLabel.setLabelDesc("%" + blogLabel.getLabelDesc() + "%");
            blogLabel.setLabelName("%" + blogLabel.getLabelName() + "%");
        }
        return blogLabelMapper.getAllLabel(blogLabel);
    }

    public int insertSelective(BlogLabel blogLabel) {

        return blogLabelMapper.insertSelective(blogLabel);
    }

    public int updateByPrimaryKeySelective(BlogLabel blogLabel) {
        return blogLabelMapper.updateByPrimaryKeySelective(blogLabel);
    }

    public int batchDel(String[] ids) {
        return blogLabelMapper.batchDel(ids);
    }

    public List<BlogLabel> getLabelList() {
        return blogLabelMapper.getLabelList();
    }


}
