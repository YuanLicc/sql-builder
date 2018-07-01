package com.yl.sql;

import java.util.function.Supplier;

public interface IntoSql {
    Supplier<String> from(String table);
    Supplier<String> inFrom(String database, String table);
}
