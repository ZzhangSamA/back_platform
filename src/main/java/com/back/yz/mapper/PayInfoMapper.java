package com.back.yz.mapper;

import com.back.yz.dto.PayInfoDto;
import com.back.yz.pojo.PayInfo;
import com.back.yz.vo.PayInfoVo;

import java.util.List;

public interface PayInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_info
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer payId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_info
     *
     * @mbggenerated
     */
    int insert(PayInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_info
     *
     * @mbggenerated
     */
    int insertSelective(PayInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_info
     *
     * @mbggenerated
     */
    PayInfo selectByPrimaryKey(Integer payId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PayInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PayInfo record);

    Integer deletePayInfo(Integer payId);

    List<PayInfoDto> getPayInfoDtoList(PayInfoVo payInfoVo);

    Integer getCount(PayInfoVo payInfoVo);
}