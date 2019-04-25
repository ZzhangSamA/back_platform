package com.back.yz.service;

import com.back.yz.dto.PayInfoDto;
import com.back.yz.pojo.PayInfo;
import com.back.yz.vo.PayInfoVo;

import java.util.List;

public interface PayInfoService {

    /**
     * 新增
     * @param payInfo
     * @return
     */
    Boolean insertSelective(PayInfo payInfo);

    /**
     * 伪删除
     * @param payId
     * @return
     */
    Boolean deletePayInfo(Integer payId);

    /**
     * 通过支付id获取PayInfo对象
     * @param payId
     * @return
     */
    PayInfo selectByPrimaryKey(Integer payId);

    /**
     * 获取分页及条件查询数据集合
     */
    List<PayInfoDto> getPayInfoDtoList(PayInfoVo payInfoVo);

    /**
     * 查询总行数
     * @param payInfoVo
     * @return
     */
    Integer getCount(PayInfoVo payInfoVo);
}
