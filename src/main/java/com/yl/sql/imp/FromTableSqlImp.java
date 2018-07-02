package com.yl.sql.imp;

import com.yl.sql.*;
import com.yl.sql.exception.ParameterNotMatchException;
import com.yl.sql.type.JoinType;
import com.yl.sql.type.WhereType;
import com.yl.sql.util.ArrayUtil;
import com.yl.sql.util.SqlUtil;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FromTableSqlImp implements FromTablesSql {

    private String[][] columns, alias;
    private String[] tables;

    public FromTableSqlImp(String[][] columns, String[][] alias, String[] tables) {

        if(ArrayUtil.isEmpty(tables)) {
            throw new ParameterNotMatchException(ParameterNotMatchException.BASE_MESSAGE +
                "1. tables != null && tables.length != 0");
        }

        this.columns = columns;
        this.alias = alias;
        this.tables = tables;
    }

    public FromTableSqlImp(String[][] columns, String[] tables) {

        if(ArrayUtil.isEmpty(tables)) {
            throw new ParameterNotMatchException(ParameterNotMatchException.BASE_MESSAGE +
                    "1. tables != null && tables.length != 0");
        }

        this.columns = columns;
        this.tables = tables;
    }

    @Override
    public GroupBySql groupBy(String[]... tablesAndColumns) {

        return new GroupBySqlImp(this.columns, this.alias, this.tables, tablesAndColumns);
    }

    @Override
    public JoinTableSql joinType(JoinType joinType) {
        return null;
    }

    @Override
    public SelectSql union() {
        return null;
    }

    @Override
    public WhereSql where(String table, String column, WhereType type) {
        return null;
    }

    @Override
    public String get() {
        if(this.columns != null && this.alias != null && this.tables != null) {
            return SqlUtil.simpleAliasSql(columns, alias, tables);
        }
        else if(this.columns != null && this.tables != null) {
            return SqlUtil.simpleSql(columns, tables);
        }
        return null;
    }

    @Override
    public WhereBetweenSql whereBetween(String table, String column) {
        return null;
    }

    @Override
    public WhereBetweenSql whereNotBetween(String table, String column) {
        return null;
    }

}
