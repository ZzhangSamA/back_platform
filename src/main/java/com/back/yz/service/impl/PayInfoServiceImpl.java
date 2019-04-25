package com.back.yz.service.impl;

import com.back.yz.dto.PayInfoDto;
import com.back.yz.mapper.PayInfoMapper;
import com.back.yz.pojo.PayInfo;
import com.back.yz.service.PayInfoService;
import com.back.yz.vo.PayInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayInfoServiceImpl implements PayInfoService {
    @Autowired
    PayInfoMapper payInfoMapper;

    /**
     * 新增
     * @param payInfo
     * @return
     */
    public Boolean insertSelective(PayInfo payInfo) {
        if (payInfoMapper.insertSelective(payInfo) > 0) {
            return true;
        }else {
            return false;
        }
    }

    /**
     * 伪删除
     * @param payId
     * @return
     */
    public Boolean deletePayInfo(Integer payId) {
        if (payInfoMapper.deletePayInfo(payId) > 0) {
            return true;
        }else {
            return false;
        }
    }

    /**
     * 根据id获取PayInfo对象
     * @param payId
     * @return
     */
    public PayInfo selectByPrimaryKey(Integer payId) {
        return null;
    }

    /**
     * 获取PayInfoDto对象集合
     * @return
     */
    public List<PayInfoDto> getPayInfoDtoList(PayInfoVo payInfoVo) {
        return payInfoMapper.getPayInfoDtoList(payInfoVo);
    }

    /**
     * 查询总行数
     * @param payInfoVo
     * @return
     */
    public Integer getCount(PayInfoVo payInfoVo) {
        return payInfoMapper.getCount(payInfoVo);
    }
}
