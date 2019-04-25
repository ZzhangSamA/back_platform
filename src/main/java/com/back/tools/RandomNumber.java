package com.back.tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RandomNumber {

    private RandomNumber(){}

    public static String getFormat(){
        Random random = new Random();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMwwDDkkmmSSSS");
        Date date =new Date();
        String format = dateFormat.format(date);
        format += (random.nextInt(999)+1);
        return format;
    }
}
