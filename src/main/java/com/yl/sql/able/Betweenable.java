package com.yl.sql.able;

public interface Betweenable<R> {
    R whereBetween(String table, String column);
    R whereNotBetween(String table, String column);
}
