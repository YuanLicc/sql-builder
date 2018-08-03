package com.yl.sql.able;

/**
 * 可紧跟 union
 * @param <R> 返回类型
 * @author YuanLi
 */
public interface Unionable<R> {
    R union();
}
