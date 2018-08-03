package com.yl.sql.able;

/**
 * 表示可插入 form 的
 * @param <R>
 * @author YuanLi
 */
public interface Fromable<R> {
    R from(String... tables);
}
