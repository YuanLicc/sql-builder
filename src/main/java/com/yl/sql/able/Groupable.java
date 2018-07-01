package com.yl.sql.able;

@FunctionalInterface
public interface Groupable<R> {
    R groupBy(String[]... tablesAndColumns);
}
