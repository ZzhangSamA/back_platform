package com.back.yz.controller;

import com.back.yxy.pojo.Page;
import com.back.yz.dto.PageDto;
import com.back.yz.dto.PayInfoDto;
import com.back.yz.pojo.PayInfo;
import com.back.yz.service.PayInfoService;
import com.back.yz.vo.PayInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PayInfoController {
    List<PayInfoDto> payInfoDtoList;
    Boolean flag;
    @Autowired
    PayInfoService payInfoService;

    /**
     * 获取分页查询数据集合
     * @param payInfoVo
     * @return
     */
    @RequestMapping(value = "getPayInfoDtoList",method = RequestMethod.POST)
    public Object getPayInfoDtoList(@RequestBody(required = false)PayInfoVo payInfoVo) {
        //获取集合
        payInfoDtoList = payInfoService.getPayInfoDtoList(payInfoVo);
        Page page = new Page();
        Integer count = payInfoService.getCount(payInfoVo);
        page.setCurrentPage(payInfoVo.getPage().getCurrentPage());
        page.setPageSize(payInfoVo.getPage().getPageSize());
        page.setTotalCount(count);
        PageDto pageDto = new PageDto();
        pageDto.setPage(page);
        pageDto.setPayInfoDtoList(payInfoDtoList);
        return pageDto;
    }


    /**
     * 伪删除记录
     * @param payId
     * @return
     */
    @RequestMapping(value = "deletePayInfo")
    public Object deletePayInfo(@RequestParam Integer payId) {
        if (payId == 0) {
            return false + "";
        }
        flag = payInfoService.deletePayInfo(payId);
        return flag;
    }
}
