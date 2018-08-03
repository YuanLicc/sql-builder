package com.yl.sql.util;

import com.yl.sql.entity.Select;
import com.yl.sql.exception.ParameterNotMatchException;
import com.yl.sql.type.AndOrType;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class SqlUtil {

    public static final String SPACE = " ";
    public static final String COMMA = ",";
    public static final String EMPTY = "";
    public static final String SPOT = ".";
    public static final String SINGLE_QUOTE = "'";
    public static final String LEFT_BRACKET = "(";
    public static final String RIGHT_BRACKET = ")";

    public static final String SELECT = "SELECT";
    public static final String FROM = "FROM";
    public static final String AS = "AS";
    public static final String GROUP_BY = "GROUP BY";
    public static final String WHERE = "WHERE";
    public static final String ORDER_BY = "ORDER BY";
    public static final String LIMIT = "LIMIT";

    /**
     * get columns sql
     * @param columns [id, name, code ...]
     * @return id, name, code ...
     */
    public static String getSqlColumns(String[] columns) {
        String delimiter = COMMA + SPACE;
        return Arrays.stream(columns).collect(Collectors.joining(delimiter));
    }

    /**
     * get columns sql
     * @param columns [id, name, code ...]
     * @param tableAlias u | user
     * @return u.id, u.name, u.code ...
     */
    public static String getSqlColumnsTableOrAlias(String[] columns, String tableAlias) {

        String delimiter = COMMA + SPACE + tableAlias + SPOT;
        String prefix = tableAlias + SPOT;
        String suffix = SPACE;

        return Arrays.stream(columns).collect(Collectors.joining(delimiter, prefix, suffix));
    }

    /**
     * get columns sql
     * @param columns [id, name, code ...]
     * @param alias [ID, NAME, CODE ...]
     * @param tableAlias u | user
     * @return u.id AS ID, u.name AS NAME, u.code AS CODE ...
     */
    public static String getSqlColumnsAliasTableOrAlias(String[] columns, String[] alias, String tableAlias) {

        String sql = "";

        for (int i = 0; i < columns.length; i++) {
            sql += tableAlias + SPOT + columns[i] + SPACE + AS + SPACE + alias[i] + COMMA + SPACE;
        }
        return sql.substring(0, sql.length() - 2) + SPACE;
    }

    /**
     * get columns and tableNames sql
     * @param columns [[id, name ...]...]
     * @param tablesNames [user...]
     * @return columns from tablesNames
     */
    public static String getSqlColumnsTablesNames(Select.Columns[] columns, String[] tablesNames) {
        String columnsSql = getSqlColumns(columns);

        String delimiter = COMMA + SPACE;
        String tablesNamesSql = Arrays.stream(tablesNames).collect(Collectors.joining(delimiter));

        return columnsSql + FROM + SPACE + tablesNamesSql;
    }

    /**
     * get sql from columns and tableNames
     * @param columns [[id, name ...]...]
     * @param tablesNames [user...]
     * @return columns from tablesNames
     */
    public static String getSqlColumnsTablesNamesTablesAlias(Select.Columns[] columns, String[] tablesNames, String[] tablesAlias) {
        String columnsSql = getSqlColumns(columns);

        String tablesNamesSql = getSqlTablesNamesTablesAlias(tablesNames, tablesAlias);

        return columnsSql + FROM + SPACE + tablesNamesSql;
    }

    /**
     * get sql from columns, clauses, clausesAlias
     * @param columns [[id, name...]...]
     * @param clauses [[select * from user]...]
     * @param clausesAlias [[userAlias]...]
     * @return userAlias.id, userAlias.name ... from (select * from user) AS userAlias
     */
    public static String getSqlColumnsClausesClausesAlias(Select.Columns[] columns, Select[] clauses, String[] clausesAlias) {
        String columnsSql = getSqlColumns(columns);
        String clausesClausesAlias = getSqlClausesClausesAlias(clauses, clausesAlias);

        return columnsSql + FROM + SPACE + clausesClausesAlias + SPACE;
    }

    /**
     * get sql from columns, tablesNames, clauses, clausesAlias
     * @param columns [[id, name...], [*]]
     * @param tablesNames [user...]
     * @param clause [[select * from role]...]
     * @param clauseAlias [roleAlias]
     * @return user.id, user.name,... roleAlias.* from (select * from role) AS roleAlias, user ...
     */
    public static String getSqlColumnsTablesNameClausesAlias(Select.Columns[] columns, String[] tablesNames
            , Select[] clause, String[] clauseAlias) {
        String tableColumnsSql = getSqlColumns(columns);
        String clauseSql = getSqlClausesClausesAlias(clause, clauseAlias);
        String tablesNameSql = getSqlTablesNames(tablesNames);

        return tableColumnsSql + COMMA + SPACE + clauseSql + COMMA + SPACE + tablesNameSql;
    }

    /**
     * get sql from columns, tablesNames, tablesAlias, clauses, clausesAlias
     * @param columns [[id, name...], [*]]
     * @param tablesNames [user...]
     * @param tablesAlias [u...]
     * @param clause [[select * from role]...]
     * @param clauseAlias [roleAlias]
     * @return u.id, u.name,... roleAlias.* from (select * from role) AS roleAlias, user AS u ...
     */
    public static String getSqlColumnsTablesNameAliasClausesAlias(Select.Columns[] columns, String[] tablesNames,
                                String[] tablesAlias, Select[] clause, String[] clauseAlias) {
        String tableColumnsSql = getSqlColumns(columns);
        String clauseSql = getSqlClausesClausesAlias(clause, clauseAlias);
        String tablesNameSql = getSqlTablesNamesTablesAlias(tablesNames, tablesAlias);

        return tableColumnsSql + COMMA + SPACE + clauseSql + COMMA + SPACE + tablesNameSql;
    }

    public static String getSqlTablesNames(String[] tablesNames) {
        String delimiter = COMMA + SPACE;
        return Arrays.stream(tablesNames).collect(Collectors.joining(delimiter)) + SPACE;
    }

    public static String getSqlClausesClausesAlias(Select[] clauses, String[] clausesAlias) {
        String sql = "";

        for (int i = 0; i < clauses.length; i++) {
            sql += LEFT_BRACKET + clauses[i].get() + RIGHT_BRACKET + SPACE + AS + SPACE + clausesAlias[i] + COMMA + SPACE;
        }

        return sql.substring(0, sql.length() - 2) + SPACE;
    }

    /**
     * get sql from tablesNames and tablesAlias
     * @param tablesNames [user, role ...]
     * @param tablesAlias [u, r ...]
     * @return user AS u, role AS r ...
     */
    public static String getSqlTablesNamesTablesAlias(String[] tablesNames, String[] tablesAlias) {
        String sql = "";

        for (int i = 0; i < tablesNames.length; i++) {
            if(tablesAlias[i].trim().equals("")) {
                sql += tablesNames[i] + COMMA + SPACE;
            }
            else {
                sql += tablesNames[i] + SPACE + AS + SPACE + tablesAlias[i] + COMMA + SPACE;
            }
        }
        return sql.substring(0, sql.length() - 2);
    }

    /**
     * get columns sql
     * @param columns [[id, name ...] ...]
     * @return example : id as ID, name AS NAME ...
     */
    public static String getSqlColumns(Select.Columns[] columns) {
        String delimiter = COMMA + SPACE;

        return Arrays.stream(columns).map(column -> {
            return column.get();
        }).collect(Collectors.joining(delimiter)) + SPACE;
    }


    public static String groupByAliasSql(String[][] columns, String[][] alias, String[] fromTables, String[][] groupTablesAndColumns) {
        if(columns.length == alias.length && fromTables.length == columns.length) {
            if(groupTablesAndColumns != null && groupTablesAndColumns.length != 0) {
                String sql = simpleAliasSql(columns, alias, fromTables);
                String groupStr = tablesAndColumnsToSql(groupTablesAndColumns);

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

            String groupStr = tablesAndColumnsToSql(groupTablesAndColumns);

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

    public static String tablesAndColumnsToSql(String[][] tablesAndColumns) {
        String delimiter = COMMA + SPACE;

        return Arrays.stream(tablesAndColumns).map(tableAndColumn -> {
            String table = tableAndColumn[0];
            String column = tableAndColumn[1];

            if(table == null || column == null) {
                throw new ParameterNotMatchException(ParameterNotMatchException.BASE_MESSAGE +
                        "1. tablesAndColumns is not null\n" +
                        "2. tablesAndColumn in tablesAndColumns, tablesAndColumn.length == 2\n" +
                        "3. tablesAndColumn[0] mean table name, tablesAndColumn[1] mean column\n" +
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

    public static String judgementCombineConnector(AndOrType[] connectors, Select.Judgement[] judgements) {
        String sql = "";
        for (int i = 0; i < judgements.length; i++) {
            String judgeSql = judgements[i].get();
            if(i != judgements.length) {
                judgeSql += connectors[i] + SqlUtil.SPACE;
            }
            sql += judgeSql;
        }
        return sql;
    }

    public static String joinsToSql(Select.Join[] joins) {

        return Arrays.stream(joins).map(join -> {
            return join.get();
        }).collect(Collectors.joining(SqlUtil.SPACE));
    }

}
