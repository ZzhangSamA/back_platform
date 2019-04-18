package com.back.yxy.controller;

import com.back.yxy.dto.BlogLabelDto;
import com.back.yxy.pojo.BlogLabel;
import com.back.yxy.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LabelController {

    @Autowired
    LabelService labelService;

    @ResponseBody
    @RequestMapping(value = "getTotalSort",method = RequestMethod.GET)
    public int getTotalSort() {
        return labelService.getTotalSort();
    }

    @ResponseBody
    @RequestMapping(value = "initPage",method = RequestMethod.POST)
    public Object initPage(@RequestBody(required = false)BlogLabel blogLabel) {
        if(blogLabel.getPage() != null) {
            blogLabel.getPage().setTotalCount(labelService.getTotalSort());
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
    @RequestMapping(value = "updateByPrimaryKeySelective",method = RequestMethod.POST)
    public int updateByPrimaryKeySelective(@RequestBody BlogLabel blogLabel) {
        return labelService.updateByPrimaryKeySelective(blogLabel);
    }
}
