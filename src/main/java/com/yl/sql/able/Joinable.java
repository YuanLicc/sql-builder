package com.yl.sql.able;

import com.yl.sql.type.JoinType;

public interface Joinable<R> {
    R joinType(JoinType joinType);
}
