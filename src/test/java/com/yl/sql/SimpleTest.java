package com.yl.sql;

import junit.framework.TestCase;

public class SimpleTest extends TestCase {

    public void testSimpleSql() {
        String[][] columns = {
                {"a", "b", "c", "d"},
                {"a1", "a2"},
                {"c1"}
        };

        String[][] alias = {
                {"A", "B", "C", "D"},
                {"A1", "A2"},
                {"C1"}
        };
        System.out.println(SqlBuilder.buildSelectSql().columns(columns).aliasColumns(alias).from("T1", "T2", "T3").get());
    }
}
