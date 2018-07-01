package com.yl.sql.able;

public interface Orderable<R> {
    R orderBy(String[]... tablesColumns);
}
