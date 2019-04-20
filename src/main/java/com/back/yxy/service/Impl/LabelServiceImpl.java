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

    public int getTotalSort(BlogLabel blogLabel) {
        if(blogLabel.getCreateTime() == null) {
            blogLabel.setCreateTime("%%");
        }else {
            blogLabel.setCreateTime("%" + blogLabel.getCreateTime() + "%");
        }
        if(blogLabel.getLabelDesc() == null) {
            blogLabel.setLabelDesc("%%");
        } else{
            blogLabel.setLabelDesc("%" + blogLabel.getLabelDesc() + "%");
        }
        if(blogLabel.getLabelName() == null) {
            blogLabel.setLabelName("%%");
        } else {
            blogLabel.setLabelName("%" + blogLabel.getLabelName() + "%");
        }
        return blogLabelMapper.getTotalSort(blogLabel);
    }

    public List<BlogLabel> getAllLabel(BlogLabel blogLabel) {
        if(blogLabel.getCreateTime() == null) {
            blogLabel.setCreateTime("%%");
        }else {
            blogLabel.setCreateTime("%" + blogLabel.getCreateTime() + "%");
        }
        if(blogLabel.getLabelDesc() == null) {
            blogLabel.setLabelDesc("%%");
        } else{
            blogLabel.setLabelDesc("%" + blogLabel.getLabelDesc() + "%");
        }
        if(blogLabel.getLabelName() == null) {
            blogLabel.setLabelName("%%");
        } else {
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
