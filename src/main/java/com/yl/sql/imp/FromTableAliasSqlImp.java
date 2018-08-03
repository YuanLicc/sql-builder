package com.yl.sql.imp;

import com.yl.sql.*;
import com.yl.sql.entity.Select;
import com.yl.sql.type.JoinType;
import com.yl.sql.type.WhereType;

import java.util.List;

public class FromTableAliasSqlImp implements FromTableAliasSql {

    private List<String[]> columnsList, aliasList;
    private String[] tables;
    private List<Select> clauses;
    private String[] tableAlias;

    public FromTableAliasSqlImp(List<String[]> columnsList, List<String[]> aliasList
            , String[] tables, List<Select> clauses, String[] tablesAlias) {
        this.columnsList = columnsList;
        this.aliasList = aliasList;
        this.tables = tables;
        this.clauses = clauses;
        this.tableAlias = tablesAlias;
    }

    public JoinTableSql join(JoinType... joinTypes) {
        return new JoinTableSqlImp(this.columnsList, this.aliasList, tables, clauses, tableAlias, joinTypes);
    }

    public GroupBySql groupBy(String[]... tablesAndColumns) {
        return new GroupBySqlImp(this.columnsList, this.aliasList
                , this.tables, clauses, tablesAndColumns);
    }

    public SelectSql union() {
        return null;
    }

    public WhereSql where(String table, String column, WhereType type) {
        return null;
    }

    public WhereBetweenSql whereBetween(String table, String column) {
        return null;
    }

    public WhereBetweenSql whereNotBetween(String table, String column) {
        return null;
    }

}
