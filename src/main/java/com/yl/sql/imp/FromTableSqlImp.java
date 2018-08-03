package com.yl.sql.imp;

import com.yl.sql.*;
import com.yl.sql.entity.Select;

import java.util.Arrays;
import java.util.List;

public class FromTableSqlImp implements FromTablesSql {

    private List<String[]> columnsList, aliasList;
    private String[] tables;
    private List<Select> clauses;

    public FromTableSqlImp(List<String[]> columnsList, List<String[]> aliasList, String[] tables) {

        this.columnsList = columnsList;
        this.aliasList = aliasList;
        this.tables = tables;
    }

    public FromTableSqlImp(List<String[]> columnsList, List<String[]> aliasList, Select[] clauses) {
        this.columnsList = columnsList;
        this.aliasList = aliasList;
        this.clauses = Arrays.asList(clauses);
    }

    public FromTableSqlImp(List<String[]> columnsList, List<String[]> aliasList, String[] tables, Select[] clauses) {
        this.columnsList = columnsList;
        this.aliasList = aliasList;
        this.tables = tables;
        this.clauses = Arrays.asList(clauses);
    }

    public FromTableSqlImp(List<String[]> columnsList, List<String[]> aliasList, String table, Select[] clauses) {
        this.columnsList = columnsList;
        this.aliasList = aliasList;
        this.tables = new String[1];
        this.tables[0] = table;
        this.clauses = Arrays.asList(clauses);
    }

    public FromTableSqlImp(List<String[]> columnsList, List<String[]> aliasList, String[] tables, Select clause) {
        this.columnsList = columnsList;
        this.aliasList = aliasList;
        this.tables = tables;
        this.clauses = Arrays.asList(clause);
    }

    public FromTableSqlImp(List<String[]> columnsList, List<String[]> aliasList, String table, Select clause) {
        this.columnsList = columnsList;
        this.aliasList = aliasList;
        this.tables = new String[1];
        this.tables[0] = table;
        this.clauses = Arrays.asList(clause);
    }

    public FromTableAliasSql as(String... tablesAlias) {

        return new FromTableAliasSqlImp(columnsList, aliasList, tables, clauses, tablesAlias);
    }

}
