package com.yl.sql.able;

import com.yl.sql.type.WhereType;

/**
 * 可紧跟 where 的
 * @param <R> 返回类型
 * @author YuanLi
 */
public interface Whereable<R> {
    R where(String table, String column, WhereType type);
}
