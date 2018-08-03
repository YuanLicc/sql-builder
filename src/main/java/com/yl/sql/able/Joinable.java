package com.yl.sql.able;

import com.yl.sql.type.JoinType;

/**
 * 可紧跟 join 的
 * @param <R> 返回类型
 * @author YuanLi
 */
public interface Joinable<R> {
    R joinType(JoinType joinType);
}
