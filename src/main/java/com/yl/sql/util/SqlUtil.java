package com.yl.sql.util;

import com.yl.sql.exception.ParameterNotMatchException;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class SqlUtil {

    public static final String SPACE = " ";
    public static final String COMMA = ",";
    public static final String EMPTY = "";
    public static final String SPOT = ".";

    public static final String SELECT = "SELECT";
    public static final String FROM = "FROM";
    public static final String AS = "AS";
    public static final String GROUP_BY = "GROUP BY";

    public static String limitAliasSql(String[][] columns, String[][] alias, String[] fromTables, String[][] groupTablesAndColumns) {

    }

    public static String groupByAliasSql(String[][] columns, String[][] alias, String[] fromTables, String[][] groupTablesAndColumns) {
        if(columns.length == alias.length && fromTables.length == columns.length) {
            if(groupTablesAndColumns != null && groupTablesAndColumns.length != 0) {
                String sql = simpleAliasSql(columns, alias, fromTables);
                String groupStr = groupString(groupTablesAndColumns);

                return sql + GROUP_BY + SPACE + groupStr + SPACE;
            }
            else {
                return simpleAliasSql(columns, alias, fromTables);
            }
        }
        else {
            throw new ParameterNotMatchException(ParameterNotMatchException.BASE_MESSAGE +
                    "1. columns.length == tables.length\n" +
                    "2. columns.length == fromTables.length");
        }
    }

    public static String groupBySql(String[][] columns, String[] fromTables, String[][] groupTablesAndColumns) {

        if(columns.length == fromTables.length && groupTablesAndColumns != null) {
            String sql = simpleSql(columns, fromTables);

            String groupStr = groupString(groupTablesAndColumns);

            return sql + GROUP_BY + SPACE + groupStr + SPACE;

        }
        else if(columns.length == fromTables.length) {
            return simpleSql(columns, fromTables);
        }
        else {
            throw new ParameterNotMatchException(ParameterNotMatchException.BASE_MESSAGE +
                    "1. columns.length == tables.length");
        }
    }

    private static String groupString(String[][] groupTablesAndColumns) {
        String delimiter = COMMA + SPACE;

        return Arrays.stream(groupTablesAndColumns).map(groupTableAndColumn -> {
            String table = groupTableAndColumn[0];
            String column = groupTableAndColumn[1];

            if(table == null || column == null) {
                throw new ParameterNotMatchException(ParameterNotMatchException.BASE_MESSAGE +
                        "1. groups is not null\n" +
                        "2. group in groups, group.length == 2\n" +
                        "3. group[0] mean table name, group[1] mean column\n" +
                        "4. table name, column is not null");
            }

            return table + SPOT + column;
        }).collect(Collectors.joining(delimiter));
    }

    public static String simpleAliasSql(String[][] columns, String[][] alias, String[] tables) {
        if(columns.length == alias.length && tables.length == columns.length) {

            String sql = SELECT + SPACE;
            String tableDelimiter = COMMA + SPACE;
            String tablesStr = Arrays.stream(tables).collect(Collectors.joining(tableDelimiter, EMPTY, SPACE));

            for(int i = 0; i < tables.length; i++) {

                for(int j = 0; j < columns[i].length; j++) {
                    sql += tables[i] + SPOT + columns[i][j] + SPACE
                            + AS + SPACE + alias[i][j] + COMMA + SPACE;
                }
            }
            return sql.substring(0, sql.length() - 2) + SPACE + FROM + SPACE + tablesStr;
        }
        else {
            throw new ParameterNotMatchException(ParameterNotMatchException.BASE_MESSAGE +
                    "1. columns.length == tables.length");
        }
    }

    public static String simpleSql(String[][] columns, String[] tables) {
        if(tables.length == columns.length) {

            String sql = SELECT + SPACE;
            String tableDelimiter = COMMA + SPACE;
            String tablesStr = Arrays.stream(tables).collect(Collectors.joining(tableDelimiter, EMPTY, SPACE));

            for(int i = 0; i < tables.length; i++) {
                String delimiter = COMMA + SPACE + tables[i] + SqlUtil.SPOT;
                String prefix = tables[i] + SPOT;

                sql += Arrays.stream(columns[i])
                        .collect(Collectors.joining(delimiter, prefix, SPACE));
            }
            return sql + FROM + SPACE + tablesStr;
        }
        else {
            throw new ParameterNotMatchException(ParameterNotMatchException.BASE_MESSAGE +
                    "1. columns.length == tables.length");
        }
    }

}
