package com.yl.sql;

import java.lang.reflect.Field;
import java.util.function.Function;

public interface ClassToColumns extends Function<Class, String[]> {

    static String[] defaultImp(Class beanClass) {
        if(beanClass == null) {
            return null;
        }
        Field[] fields = beanClass.getDeclaredFields();

        if(fields.length == 0) {
            return null;
        }
        String[] columns = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            columns[i] = fields[i].getName();
        }

        return columns;
    }

}
