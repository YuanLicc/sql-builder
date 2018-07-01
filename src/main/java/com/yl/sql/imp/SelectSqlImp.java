package com.yl.sql.imp;

import com.yl.sql.HasColumnSql;
import com.yl.sql.SelectSql;

import java.util.function.Function;

public class SelectSqlImp implements SelectSql {

    @Override
    public HasColumnSql columns(String... columns) {

        return new HasColumnSqlImp(false, columns);
    }

    @Override
    public HasColumnSql columns(Class javaBeanClass) {

        String[] columns = defaultClassToColumns.apply(javaBeanClass);

        return new HasColumnSqlImp(false, columns);
    }

    @Override
    public HasColumnSql columns(Class javaBeanClass, Function<Class, String[]> classToColumns) {

        String[] columns = classToColumns.apply(javaBeanClass);

        return new HasColumnSqlImp(false, columns);
    }

    @Override
    public HasColumnSql distinctColumns(String... columns) {

        return new HasColumnSqlImp(true, columns);
    }

    @Override
    public HasColumnSql distinctColumns(Class javaBeanClass) {

        String[] columns = defaultClassToColumns.apply(javaBeanClass);

        return new HasColumnSqlImp(true, columns);
    }

    @Override
    public HasColumnSql distinctColumns(Class javaBeanClass, Function<Class, String[]> classToColumns) {

        String[] columns = classToColumns.apply(javaBeanClass);

        return new HasColumnSqlImp(true, columns);
    }
}
