package com.yl.sql.able;

import com.yl.sql.type.WhereType;

public interface Whereable<R> {
    R where(String table, String column, WhereType type);
}
