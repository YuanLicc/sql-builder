package com.yl.sql.able;

import com.yl.sql.HasColumnSql;

import java.util.function.Function;

public interface Columnable<R> {

    HasColumnSql columns(String... columns);

    HasColumnSql columns(Class javaBeanClass);

    HasColumnSql columns(Class javaBeanClass, Function<Class, String[]> classToColumns);

    HasColumnSql distinctColumns(String ... columns);

    HasColumnSql distinctColumns(Class javaBeanClass);

    HasColumnSql distinctColumns(Class javaBeanClass, Function<Class, String[]> classToColumns);
}
