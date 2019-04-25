package com.back.tools;

import java.util.Random;

public class DB {

    public static String getRandomNumbers(){
        Random random = new Random();
        Integer n =random.nextInt(899999)+100000;
        return n.toString();
    }
}
