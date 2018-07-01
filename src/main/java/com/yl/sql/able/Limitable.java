package com.yl.sql.able;

public interface Limitable<R> {
    R limit(int start, int count);
}
