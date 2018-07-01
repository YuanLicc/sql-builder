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
            return simpleAliasSql(columns, alias, tables);
        }
        else if(this.columns != null && this.tables != null) {
            return simpleSql(columns, tables);
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

    public String simpleAliasSql(String[][] columns, String[][] alias, String[] tables) {
        if(columns.length == alias.length && tables.length == columns.length) {

            String sql = SqlUtil.SELECT + SqlUtil.SPACE;
            String tableDelimiter = SqlUtil.COMMA + SqlUtil.SPACE;
            String tablesStr = Arrays.stream(tables).collect(Collectors.joining(tableDelimiter, SqlUtil.EMPTY, SqlUtil.SPACE));

            for(int i = 0; i < tables.length; i++) {

                for(int j = 0; j < columns[i].length; j++) {
                    sql += tables[i] + SqlUtil.SPOT + columns[i][j] + SqlUtil.SPACE
                            + SqlUtil.AS + SqlUtil.SPACE + alias[i][j] + SqlUtil.COMMA + SqlUtil.SPACE;
                }
            }
            return sql.substring(0, sql.length() - 2) + SqlUtil.SPACE + SqlUtil.FROM + SqlUtil.SPACE + tablesStr;
        }
        else {
            throw new ParameterNotMatchException(ParameterNotMatchException.BASE_MESSAGE +
                    "1. columns.length == tables.length");
        }
    }

    private String simpleSql(String[][] columns, String[] tables) {
        if(tables.length == columns.length) {

            String sql = SqlUtil.SELECT + SqlUtil.SPACE;
            String tableDelimiter = SqlUtil.COMMA + SqlUtil.SPACE;
            String tablesStr = Arrays.stream(tables).collect(Collectors.joining(tableDelimiter, SqlUtil.EMPTY, SqlUtil.SPACE));

            for(int i = 0; i < tables.length; i++) {
                String delimiter = SqlUtil.COMMA + SqlUtil.SPACE + tables[i] + SqlUtil.SPOT;
                String prefix = tables[i] + SqlUtil.SPOT;

                sql += Arrays.stream(columns[i])
                        .collect(Collectors.joining(delimiter, prefix, SqlUtil.SPACE));
            }
            return sql + SqlUtil.FROM + SqlUtil.SPACE + tablesStr;
        }
        else {
            throw new ParameterNotMatchException(ParameterNotMatchException.BASE_MESSAGE +
                    "1. columns.length == tables.length");
        }
    }
}
