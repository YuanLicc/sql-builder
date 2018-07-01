package com.yl.sql.util;

public class ArrayUtil {

    public static <T> boolean isExistEmpty(T[]... arrays) {
        if(arrays == null || arrays.length == 0) {
            return true;
        }
        else {
            boolean is = true;
            for (T[] array : arrays) {
                if(array == null || array.length == 0) {
                    return true;
                }
            }
            return false;
        }
    }

    public static <T> boolean isEmpty(T... array) {
        if(array == null || array.length == 0) {
            return true;
        }
        return false;
    }
}
