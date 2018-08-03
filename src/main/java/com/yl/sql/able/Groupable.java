package com.yl.sql.able;

/**
 * 可紧跟 group 的
 * @param <R> 返回类型
 * @author YuanLi
 */
public interface Groupable<R> {
    R groupBy(String[]... tablesAndColumns);
}
