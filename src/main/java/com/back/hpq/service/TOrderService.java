package com.back.hpq.service;

import com.back.hpq.pojo.TOrder;

public interface TOrderService {
    TOrder selectByPrimaryKey(Integer orderId);
}
