package com.back.tools;

import java.util.Date;
import java.util.Random;

public class SerialNumber {
    /**
     * 获取由当前时间和2组随机数拼接生成的随机字符串
     * @return
     */
    public static String getSerialNumber() {
        Date date = new Date();
        String serialNumber = null;
        long time = date.getTime();
        serialNumber = random(4) + String.valueOf(time) + random(4);
        return serialNumber;
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
