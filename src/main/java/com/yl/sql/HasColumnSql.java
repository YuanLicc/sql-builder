package com.yl.sql;

/**
 * SELECT columns [alias] | from [table]
 * 1. 为前面通过的columns 进行别名操作 - 转换为{@link AliasColumnSql}
 * 2. 指定查询表名 - 转换为{@link FromTablesSql}
 * 3. 指定INTO表名 - 转换为{@link IntoSql}
 */
public interface HasColumnSql extends SQL {

}
