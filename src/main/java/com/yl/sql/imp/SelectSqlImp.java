package com.yl.sql.imp;

import com.yl.sql.ClassToColumns;
import com.yl.sql.HasColumnSql;
import com.yl.sql.SelectSql;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SelectSqlImp implements SelectSql {
    private static final boolean DEFAULT_IS_DISTINCT = false;

    public HasColumnSql columns(String... columns) {

        return new HasColumnSqlImp(DEFAULT_IS_DISTINCT, columns);
    }

    public HasColumnSql columns(String[]...columns) {

        return new HasColumnSqlImp(DEFAULT_IS_DISTINCT, columns);
    }

    public HasColumnSql columns(Class javaBeanClass) {
        String[] columns = ClassToColumns.defaultImp(javaBeanClass);

        return new HasColumnSqlImp(DEFAULT_IS_DISTINCT, columns);
    }

    public HasColumnSql columns(Class ... classes) {
        List<String[]> columns = Arrays
                .stream(classes)
                .map(ClassToColumns::defaultImp)
                .collect(Collectors.toList());


        return new HasColumnSqlImp(DEFAULT_IS_DISTINCT, columns);
    }

    public HasColumnSql columns(Class javaBeanClass, Function<Class, String[]> classToColumns) {

        String[] columns = classToColumns.apply(javaBeanClass);

        return new HasColumnSqlImp(DEFAULT_IS_DISTINCT, columns);
    }

    public HasColumnSql columns(Class[] classes, Function<Class, String[]> classToColumns) {

        List<String[]> columns = Arrays
                .stream(classes)
                .map(classToColumns::apply)
                .collect(Collectors.toList());

        return new HasColumnSqlImp(DEFAULT_IS_DISTINCT, columns);
    }

}
