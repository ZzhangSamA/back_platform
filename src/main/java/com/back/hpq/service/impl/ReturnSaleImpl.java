package com.back.hpq.service.impl;

import com.back.hpq.dto.ReturnDetailDto;
import com.back.hpq.dto.StatusDto;
import com.back.hpq.mapper.SalesReturnMapper;
import com.back.hpq.mapper.TOrderMapper;
import com.back.hpq.service.ReturnSale;
import com.back.hpq.vo.ChangeGoodsStatusVo;
import com.back.hpq.vo.ReturnMessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ReturnSaleImpl implements ReturnSale {

    @Autowired(required = false)
    SalesReturnMapper salesReturnMapper;
    @Autowired(required = false)
    TOrderMapper tOrderMapper;

    @Transactional
    public int addReturnSale(ReturnMessageVo returnMessageVo) {
        int returnStatus = returnMessageVo.getStatus();
        if (returnStatus==1||returnStatus==2){
            StatusDto statusDto = tOrderMapper.checkStatus(returnMessageVo);
            int count = salesReturnMapper.checkCount(returnMessageVo);
            System.out.println(count);
            if (count!=0){
                return 0;
            }
            int orderStatus = statusDto.gettOderStatus();
            int goodsStatus = statusDto.getGoodsStatus();
            System.out.println(goodsStatus);
            if (goodsStatus!=1&&goodsStatus!=2) {
                System.out.println(12345);
                System.out.println(orderStatus);
                if (orderStatus == 1) {
                    return 0;
                }
                if ((orderStatus == 2 || orderStatus == 3 && returnStatus == 1)||(orderStatus == 4 || orderStatus == 5 || orderStatus == 6 && returnStatus == 2)) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMwwDDkkmmss");
                    Date date =new Date();
                    String format = dateFormat.format(date);
                    format+=returnMessageVo.getOgId();
                    returnMessageVo.setReturnNumber(format);
                    salesReturnMapper.insertSelective(returnMessageVo);
                    ChangeGoodsStatusVo changeGoodsStatusVo = new ChangeGoodsStatusVo();
                    changeGoodsStatusVo.setOgId(returnMessageVo.getOgId());
                    changeGoodsStatusVo.setStatus(1);
                    return  tOrderMapper.setStatus(changeGoodsStatusVo);

                }
            }
        }
        return 0;
    }

    public ReturnDetailDto getReturnDetail(ReturnMessageVo returnMessageVo) {
        return salesReturnMapper.getReturnDetail(returnMessageVo);
    }

    public int againRefuse(ReturnMessageVo returnMessageVo) {

        int i = salesReturnMapper.checkStatus(returnMessageVo);
        if (i==0){
            ChangeGoodsStatusVo changeGoodsStatusVo = new ChangeGoodsStatusVo();
            changeGoodsStatusVo.setStatus(0);
            changeGoodsStatusVo.setOgId(returnMessageVo.getOgId());
            tOrderMapper.setStatus(changeGoodsStatusVo);
            int changeStatus = salesReturnMapper.changeStatus(returnMessageVo);
            return changeStatus;
        }

        return 0;
    }
}
