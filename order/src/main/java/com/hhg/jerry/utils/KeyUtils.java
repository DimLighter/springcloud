package com.hhg.jerry.utils;

import java.util.Random;

/**
 * Created by lina on 2018/10/12.
 */
public class KeyUtils {

    public synchronized static String getUniqueId(){
        Random random = new Random();
        return System.currentTimeMillis() + (random.nextInt(100000) + 100000) + "";
    }
}
