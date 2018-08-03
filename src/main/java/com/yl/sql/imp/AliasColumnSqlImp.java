package com.yl.sql.imp;

import com.yl.sql.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class AliasColumnSqlImp implements AliasColumnSql {

    private List<String[]> columnsList, aliasList;

    public AliasColumnSqlImp(List<String[]> columnsList, String[] alias) {
        this.columnsList = columnsList;

        if(aliasList == null) {
            aliasList = new ArrayList<>();
        }
        this.aliasList.add(alias);
    }

    public AliasColumnSqlImp(List<String[]> columnsList, String[][] alias) {
        this.columnsList = columnsList;
        this.aliasList = Arrays.asList(alias);
    }

    public AliasColumnSqlImp(List<String[]> columnsList, List<String[]> alias) {
        this.columnsList = columnsList;
        this.aliasList = alias;
    }

    public HasColumnSql columns(String[] columns) {
        columnsList.add(columns);
        return new HasColumnSqlImp(columnsList, aliasList);
    }

    public HasColumnSql columns(Class javaBeanClass) {

        String[] columns = ClassToColumns.defaultImp(javaBeanClass);
        columnsList.add(columns);
        return new HasColumnSqlImp(this.columnsList, aliasList);
    }

    public HasColumnSql columns(Class javaBeanClass, Function<Class, String[]> classToColumns) {
        String[] alias = classToColumns.apply(javaBeanClass);
        columnsList.add(alias);
        return new HasColumnSqlImp(this.columnsList, aliasList);
    }

    public FromTablesSql from(String[] tables) {

        return new FromTableSqlImp(this.columnsList, this.aliasList, tables);
    }

}
