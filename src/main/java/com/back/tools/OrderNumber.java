package com.back.tools;

import java.util.Date;
import java.util.Random;

/**
 * 订单编号
 */
public class OrderNumber {
    /**
     * 获取由当前时间和2组随机数拼接生成的随机字符串
     * @return
     */
    public static String getOrderNumber() {
        Date date = new Date();
        String orderNumber = null;
        long time = date.getTime();
        orderNumber = random(3) + String.valueOf(time) + random(2);
        return orderNumber;
    }

    public static String random(int n) {
        int x = 9;
        int y = 1;
        for (int i = 1; i < n; i++) {
            x *= 10;
            y *= 10;
        }
        int random = new Random().nextInt(x) + y;
        return String.valueOf(random);
    }
}
