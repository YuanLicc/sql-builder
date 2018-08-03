package com.yl.sql.able;

import com.yl.sql.HasColumnSql;

import java.util.function.Function;

/**
 * 表示可插入 column 列的，如 select [columns]
 * @param <R>
 * @author YuanLi
 */
public interface Columnable<R> {

    HasColumnSql columns(String[][] columns);

    HasColumnSql columns(Class javaBeanClass);

    HasColumnSql columns(Class javaBeanClass, Function<Class, String[]> classToColumns);

    HasColumnSql distinctColumns(String[][] columns);

    HasColumnSql distinctColumns(Class javaBeanClass);

    HasColumnSql distinctColumns(Class javaBeanClass, Function<Class, String[]> classToColumns);
}
