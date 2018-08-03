package com.yl.sql.able;

/**
 * 可紧跟 order
 * @param <R> 返回类型
 * @author YuanLi
 */
public interface Orderable<R> {
    R orderBy(String[]... tablesColumns);
}
