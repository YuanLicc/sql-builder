package com.yl.sql.able;

/**
 * 表示可插入 between 子句
 * @param <R>
 * @author YuanLi
 */
public interface Betweenable<R> {

    R whereBetween(String table, String column);
    R whereNotBetween(String table, String column);
}
