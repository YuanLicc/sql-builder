package com.yl.sql.imp;

import com.yl.sql.*;
import com.yl.sql.exception.ParameterNotMatchException;
import com.yl.sql.util.ArrayUtil;

import java.util.function.Function;

public class HasColumnSqlImp implements HasColumnSql {

    private String[][] columns;
    private boolean isDistinct = false;

    public HasColumnSqlImp(boolean isDistinct, String[]... columns) {
        validateColumns(columns);
        this.columns = columns;
        this.isDistinct = isDistinct;
    }

    private void validateColumns(String[]... columns) {
        if(ArrayUtil.isExistEmpty(columns)) {
            throw new ParameterNotMatchException(ParameterNotMatchException.BASE_MESSAGE +
                    "1. columns != null && columns.length != 0\n" +
                    "2. column in columns, column != null && column.length != 0");
        }
    }

    @Override
    public AliasColumnSql aliasColumns(String[]... alias) {

        return new AliasColumnSqlImp(this.columns, alias);
    }

    @Override
    public AliasColumnSql aliasColumns(Class javaBeanClass) {

        String[] alias = SelectSql.defaultClassToColumns.apply(javaBeanClass);

        String[][] aliasArr = new String[1][];
        aliasArr[0] = alias;

        return new AliasColumnSqlImp(this.columns, aliasArr);
    }

    @Override
    public AliasColumnSql aliasColumns(Class javaBeanClass, Function<Class, String[]> classToColumns) {

        String[] alias = classToColumns.apply(javaBeanClass);

        String[][] aliasArr = new String[1][];
        aliasArr[0] = alias;

        return new AliasColumnSqlImp(this.columns, aliasArr);
    }

    @Override
    public FromTablesSql from(String... tables) {

        return new FromTableSqlImp(this.columns, tables);
    }

}
