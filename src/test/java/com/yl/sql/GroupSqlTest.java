package com.yl.sql;

import com.yl.sql.exception.ParameterNotMatchException;
import junit.framework.TestCase;

public class GroupSqlTest extends TestCase {

    public void testGroupSql() {
        System.out.println(SqlBuilder.buildSelectSql()
                .columns(ParametersUtil.columns)
                .from(ParametersUtil.tables)
                .groupBy(ParametersUtil.groups)
                .get());
    }

    public void testGroupAliasSql() {
        System.out.println(SqlBuilder.buildSelectSql()
                .columns(ParametersUtil.columns)
                .aliasColumns(ParametersUtil.alias)
                .from(ParametersUtil.tables)
                .groupBy(ParametersUtil.groups)
                .get());
    }

    public void testWrongColumnsGroupSql() {
        try {
            System.out.println(SqlBuilder.buildSelectSql()
                    .columns(ParametersUtil.wrongColumns)
                    .from(ParametersUtil.tables)
                    .groupBy(ParametersUtil.groups)
                    .get());
        }
        catch (ParameterNotMatchException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testWrongAliasGroupAliasSql() {
        try {
            System.out.println(SqlBuilder.buildSelectSql()
                    .columns(ParametersUtil.columns)
                    .aliasColumns(ParametersUtil.wrongAlias)
                    .from(ParametersUtil.tables)
                    .groupBy(ParametersUtil.groups)
                    .get());
        }
        catch (ParameterNotMatchException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testNullGroupSql() {
        try {
            System.out.println(SqlBuilder.buildSelectSql()
                    .columns(ParametersUtil.columns)
                    .from(ParametersUtil.tables)
                    .groupBy(new String[2][2])
                    .get());
        }
        catch (ParameterNotMatchException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testNullGroupAliasSql() {
        try {
            System.out.println(SqlBuilder.buildSelectSql()
                    .columns(ParametersUtil.columns)
                    .aliasColumns(ParametersUtil.alias)
                    .from(ParametersUtil.tables)
                    .groupBy(new String[1][2])
                    .get());
        }
        catch (ParameterNotMatchException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testWrongTableGroupSql() {
        try {
            System.out.println(SqlBuilder.buildSelectSql()
                    .columns(ParametersUtil.columns)
                    .from(ParametersUtil.wrongTables)
                    .groupBy(ParametersUtil.groups)
                    .get());
        }
        catch (ParameterNotMatchException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testWrongTableGroupAliasSql() {
        try {
            System.out.println(SqlBuilder.buildSelectSql()
                    .columns(ParametersUtil.columns)
                    .aliasColumns(ParametersUtil.alias)
                    .from(ParametersUtil.wrongTables)
                    .groupBy(ParametersUtil.groups)
                    .get());
        }
        catch (ParameterNotMatchException e) {
            System.out.println(e.getMessage());
        }
    }
}
