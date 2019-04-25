package com.back.yxy.controller;

import com.back.yxy.dto.BlogLabelDto;
import com.back.yxy.pojo.BlogLabel;
import com.back.yxy.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class LabelController {

    @Autowired
    LabelService labelService;

    @ResponseBody
    @RequestMapping(value = "getTotalSort",method = RequestMethod.GET)
    public int getTotalSort() {
        return labelService.getTotalSort(new BlogLabel());
    }
    @ResponseBody
    @RequestMapping(value = "initLabelPage",method = RequestMethod.POST)
    public Object initPage(@RequestBody(required = false)BlogLabel blogLabel) {
        if(blogLabel.getPage() != null) {
            blogLabel.getPage().setTotalCount(labelService.getTotalSort(blogLabel));
        }
        BlogLabelDto blogLabelDto = new BlogLabelDto();
        List<BlogLabel> allLabel = labelService.getAllLabel(blogLabel);
        blogLabelDto.setBlogLabelList(allLabel);
        blogLabelDto.setPage(blogLabel.getPage());
        return blogLabelDto;
    }

    @ResponseBody
    @RequestMapping(value = "addLabel",method = RequestMethod.POST)
    public int insertSelective(@RequestBody BlogLabel blogLabel) {
        return labelService.insertSelective(blogLabel);
    }

    @ResponseBody
    @RequestMapping(value = "updateLabelByPrimaryKeySelective",method = RequestMethod.POST)
    public int updateByPrimaryKeySelective(@RequestBody BlogLabel blogLabel) {
        return labelService.updateByPrimaryKeySelective(blogLabel);
    }

    @ResponseBody
    @RequestMapping(value = "batchDelLabel",method = RequestMethod.POST)
    public int batchDel(@RequestBody String[] ids) {
        return labelService.batchDel(ids);
    }

    @ResponseBody
    @RequestMapping(value = "getLabelList",method = RequestMethod.GET)
    public Object getAllLabel() {
        return labelService.getLabelList();
    }
}
