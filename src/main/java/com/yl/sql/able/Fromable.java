package com.yl.sql.able;

public interface Fromable<R> {
    R from(String... tables);
}
