package com.back.hpq.service.impl;

import com.back.hpq.mapper.TOrderMapper;
import com.back.hpq.pojo.TOrder;
import com.back.hpq.service.TOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TOrderServiceImpl implements TOrderService {

    @Autowired
    TOrderMapper tOrderMapper;

    /**
     * 根据主键id获取Order对象
     * @param orderId
     * @return
     */
    public TOrder selectByPrimaryKey(Integer orderId) {
        return tOrderMapper.selectByPrimaryKey(orderId);
    }
}
