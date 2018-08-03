package com.yl.sql.imp;

import com.yl.sql.JoinOnTableSql;
import com.yl.sql.JoinTableSql;
import com.yl.sql.entity.Select;
import com.yl.sql.type.JoinType;

import java.util.List;

public class JoinTableSqlImp implements JoinTableSql {

    private List<String[]> columnsList, aliasList;
    private String[] tables;
    private List<Select> clauses;
    private String[] tableAlias;
    JoinType[] joinTypes;

    public JoinTableSqlImp(List<String[]> columnsList, List<String[]> aliasList, String[] tables
            , List<Select> clauses, String[] tableAlias, JoinType[] joinTypes) {
        this.columnsList = columnsList;
        this.aliasList = aliasList;

        this.tables = tables;
        this.clauses = clauses;

        this.tableAlias = tableAlias;

        this.joinTypes = joinTypes;
    }

    public JoinOnTableSql on(Select... clauses) {
        return new JoinOnTableSqlImp();
    }

    public JoinOnTableSql on(String... joinTables) {
        return new JoinOnTableSqlImp();
    }

    public JoinOnTableSql on(String[] joinTables, Select[] clauses) {
        return new JoinOnTableSqlImp();
    }

    public JoinOnTableSql on(Select clause, String... tables) {
        return new JoinOnTableSqlImp();
    }

    public JoinOnTableSql on(String table, Select... clauses) {
        return new JoinOnTableSqlImp();
    }
}
