package com.yl.sql;

import com.yl.sql.exception.ParameterNotMatchException;
import junit.framework.TestCase;

public class SimpleTest extends TestCase {

    public void testSimpleSql() {
        System.out.println(SqlBuilder.buildSelectSql()
                .columns(ParametersUtil.columns)
                .from(ParametersUtil.tables)
                .get());
    }

    public void testSimpleAliasSql() {
        System.out.println(SqlBuilder.buildSelectSql()
                .columns(ParametersUtil.columns)
                .aliasColumns(ParametersUtil.alias)
                .from(ParametersUtil.tables)
                .get());
    }

    public void testWrongColumnsSimpleSql() {
        try {
            System.out.println(SqlBuilder.buildSelectSql()
                    .columns(ParametersUtil.wrongColumns)
                    .from(ParametersUtil.tables)
                    .get());
        }
        catch (ParameterNotMatchException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testWrongAliasSimpleAliasSql() {
        try {
            System.out.println(SqlBuilder.buildSelectSql()
                    .columns(ParametersUtil.columns)
                    .aliasColumns(ParametersUtil.wrongAlias)
                    .from(ParametersUtil.tables)
                    .get());
        }
        catch (ParameterNotMatchException e) {
            System.out.println(e.getMessage());
        }
    }


    public void testWrongTableSimpleSql() {
        try {
            System.out.println(SqlBuilder.buildSelectSql()
                    .columns(ParametersUtil.columns)
                    .from(ParametersUtil.wrongTables)
                    .get());
        }
        catch (ParameterNotMatchException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testWrongTableSimpleAliasSql() {
        try {
            System.out.println(SqlBuilder.buildSelectSql()
                    .columns(ParametersUtil.columns)
                    .aliasColumns(ParametersUtil.alias)
                    .from(ParametersUtil.wrongTables)
                    .get());
        }
        catch (ParameterNotMatchException e) {
            System.out.println(e.getMessage());
        }
    }

}
