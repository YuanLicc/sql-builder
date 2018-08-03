package com.yl.sql.imp;

import com.yl.sql.*;
import com.yl.sql.entity.Select;
import com.yl.sql.exception.ParameterNotMatchException;
import com.yl.sql.util.ArrayUtil;
import com.yl.sql.util.SqlUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HasColumnSqlImp implements HasColumnSql {

    private List<String[]> columnsList, aliasList;
    private boolean isDistinct = false;

    public HasColumnSqlImp(boolean isDistinct, String[] columns) {
        this.isDistinct = isDistinct;
        columnsList = new ArrayList<>();
        columnsList.add(columns);
    }

    public HasColumnSqlImp(List<String[]> columnsList, List<String[]> aliasList) {
        this.columnsList = columnsList;
        this.aliasList = aliasList;
    }

    public HasColumnSqlImp(boolean isDistinct, String[][] columns) {
        this.isDistinct = isDistinct;
        this.columnsList = Arrays.asList(columns);
    }

    public HasColumnSqlImp(boolean isDistinct, List<String[]> columns) {
        this.isDistinct = isDistinct;
        this.columnsList = columns;
    }

    public AliasColumnSql aliasColumns(String... alias) {

        return new AliasColumnSqlImp(this.columnsList, alias);
    }

    public AliasColumnSql aliasColumns(String[]... alias) {

        return new AliasColumnSqlImp(this.columnsList, alias);
    }

    public AliasColumnSql aliasColumns(Class javaBeanClass) {

        String[] alias = ClassToColumns.defaultImp(javaBeanClass);

        return new AliasColumnSqlImp(this.columnsList, alias);
    }

    public AliasColumnSql aliasColumns(Class... classes) {

        List<String[]> alias = Arrays
                .stream(classes)
                .map(ClassToColumns::defaultImp)
                .collect(Collectors.toList());

        return new AliasColumnSqlImp(this.columnsList, alias);
    }

    public AliasColumnSql aliasColumns(Class javaBeanClass, Function<Class, String[]> classToColumns) {
        String[] alias = classToColumns.apply(javaBeanClass);

        return new AliasColumnSqlImp(this.columnsList, alias);
    }

    public AliasColumnSql aliasColumns(Class[] classes, Function<Class, String[]> classToColumns) {

        List<String[]> alias = Arrays
                .stream(classes)
                .map(classToColumns::apply)
                .collect(Collectors.toList());

        return new AliasColumnSqlImp(this.columnsList, alias);
    }

    public FromTablesSql from(String... tables) {
       return new FromTableSqlImp(this.columnsList, this.aliasList, tables);
    }

    public FromTablesSql from(Select... clauses) {
        return new FromTableSqlImp(this.columnsList, this.aliasList, clauses);
    }

    public FromTablesSql from(String[] tables, Select[] clauses) {
        return new FromTableSqlImp(this.columnsList, this.aliasList, tables, clauses);
    }

    public FromTablesSql from(String table, Select[] clauses) {
        return new FromTableSqlImp(this.columnsList, this.aliasList, table, clauses);
    }

    public FromTablesSql from(String[] tables, Select clause) {
        return new FromTableSqlImp(this.columnsList, this.aliasList, tables, clause);
    }

    public FromTablesSql from(String table, Select clause) {
        return new FromTableSqlImp(this.columnsList, this.aliasList, table, clause);
    }

}
