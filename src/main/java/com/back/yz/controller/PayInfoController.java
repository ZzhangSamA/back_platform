package com.back.yz.controller;

import com.back.hpq.pojo.TOrder;
import com.back.hpq.service.TOrderService;
import com.back.tools.SerialNumber;
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

    @Autowired
    TOrderService tOrderService;



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
     * 新增支付记录
     * @param payInfo{
     *                  customerId:会员id,
     *                  orderId:订单id,
     *                  platformId:支付平台id
     *               }
     * @return
     */
    @RequestMapping(value = "insertSelective",method = RequestMethod.POST)
    public Object insertSelective(@RequestBody(required = false)PayInfo payInfo) {
        //根据支付平台id随机生成支付流水号
        if (payInfo.getPlatformId() == 1) {               //支付宝
            payInfo.setSerialNumber("zfb" + SerialNumber.getSerialNumber());
        }else if (payInfo.getPlatformId() == 2) {         //微信
            payInfo.setSerialNumber("wx" + SerialNumber.getSerialNumber());
        }
        //根据orderId获取TOrder对象（何大大尚未完成）
        TOrder order = new TOrder();
        //获取TOrder对象的totalPrice属性

        //修改payInfo的money属性值为totalPrice值

        if (payInfo == null) {
            return false + "";
        }
        flag = payInfoService.insertSelective(payInfo);
        return flag;
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
