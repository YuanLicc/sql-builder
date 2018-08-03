package com.yl.sql.able;

/**
 * 可紧跟 limit 的
 * @param <R> 返回类型
 * @author YuanLi
 */
public interface Limitable<R> {
    R limit(int start, int count);
}
