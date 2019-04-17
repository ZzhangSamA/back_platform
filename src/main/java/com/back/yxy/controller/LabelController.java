package com.back.yxy.controller;

import com.back.yxy.pojo.BlogLabel;
import com.back.yxy.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return null;
    }

}
