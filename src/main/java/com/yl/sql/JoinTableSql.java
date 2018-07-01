package com.yl.sql;

/**
 * Select * from table [join type] [table] | [clause]
 */
public interface JoinTableSql extends SQL {

    void clause();
    void on(String joinTable);

}
