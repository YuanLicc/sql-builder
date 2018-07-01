package com.yl.sql;

import com.yl.sql.able.Columnable;

import java.lang.reflect.Field;
import java.util.function.Function;

/**
 * SELECT [columns] | distinct [columns]
 * 1. 查找列 - 转换为{@link HasColumnSql}
 * 2. distinct 查找列 - 转换为{@link HasColumnSql}
 * @author YuanLi
 */
public interface SelectSql extends SQL, Columnable<HasColumnSql> {

    public static final Function<Class, String[]> defaultClassToColumns = (Class javaBeanClass) -> {
        if(javaBeanClass == null) {
            return null;
        }
        Field[] fields = javaBeanClass.getDeclaredFields();

        if(fields.length == 0) {
            return null;
        }
        String[] columns = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            columns[i] = fields[i].getName();
        }

        return columns;
    };
}
