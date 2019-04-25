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

    /**
     * 获取分类标签总数
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getTotalSort",method = RequestMethod.GET)
    public int getTotalSort() {
        return labelService.getTotalSort(new BlogLabel());
    }

    /**
     * 初始化分类标签列表
     * @param blogLabel
     * @return
     */
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

    /**
     * 添加分类标签
     * @param blogLabel
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "addLabel",method = RequestMethod.POST)
    public int insertSelective(@RequestBody BlogLabel blogLabel) {
        return labelService.insertSelective(blogLabel);
    }

    /**
     * 根据主键Id删除或修改分类标签（删除：即把status的值修改为0）
     * @param blogLabel
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "updateLabelByPrimaryKeySelective",method = RequestMethod.POST)
    public int updateByPrimaryKeySelective(@RequestBody BlogLabel blogLabel) {
        return labelService.updateByPrimaryKeySelective(blogLabel);
    }

    /**
     * 批量删除分类标签
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "batchDelLabel",method = RequestMethod.POST)
    public int batchDel(@RequestBody String[] ids) {
        return labelService.batchDel(ids);
    }

    /**
     * 获得所有分类标签（用于显示在文章页面）
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getLabelList",method = RequestMethod.GET)
    public Object getAllLabel() {
        return labelService.getLabelList();
    }
}
